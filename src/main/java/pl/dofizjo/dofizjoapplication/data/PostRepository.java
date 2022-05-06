package pl.dofizjo.dofizjoapplication.data;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.dofizjo.dofizjoapplication.data.mapper.PostMapper;
import pl.dofizjo.dofizjoapplication.model.Post;

import java.util.*;

@Repository
public class PostRepository {

    private JdbcTemplate jdbc;

    public PostRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Find by id
    @Cacheable(value = "postCache")
    public Post findById(int id) {
        return jdbc.queryForObject(
                "SELECT id, author, title, content, createdAt from POST where id=?",
                new PostMapper(),
                id); // vararg
    }

    // Find recent
    @Cacheable(value = "postCache")
    public List<Post> findRecent(int number) {
        return jdbc.query("SELECT * from POST ORDER BY createdAt DESC LIMIT ?",
                new PostMapper(), number);
    }

    // Find older
    public Post findOlder(Date date) {
        List<Post> result = jdbc.query("SELECT * from POST where createdAt < ? ORDER BY createdAt DESC LIMIT 1", new PostMapper(), date);
        return parseList(result);
    }

    // Find newer
    public Post findNewer(Date date) {
        List<Post> result = jdbc.query("SELECT * from POST where createdAt > ? ORDER BY createdAt ASC LIMIT 1", new PostMapper(), date);
        return parseList(result);
    }

    private Post parseList(List<Post> list) {
        if (list.isEmpty()) {
            return null;
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            throw new IncorrectResultSizeDataAccessException(1, list.size());
        }
    }

    // Find latest one
    @Cacheable(value = "postCache")
    public Post findLatestOne() {
        return jdbc.queryForObject("SELECT * FROM POST ORDER BY createdAt DESC LIMIT 1", new PostMapper());
    }

    // Find all
    @Cacheable(value = "postCache")
    public List<Post> findAll() {
        return jdbc.query(
                "SELECT * from POST",
                new PostMapper()
        );
    }

    // Add one
    public void add(Post post) {
        post.setCreatedAt(new Date());

        jdbc.update("INSERT into POST (author, title, content, createdAt) values (?, ?, ?, ?)",
                post.getAuthor(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt());
    }

    // Add all
    public void addAll(Iterable<Post> list) {
        for (Post post : list) {
            add(post);
        }
    }

    // Overwrite one
    public void overwrite(Post post) {
        // Removing post of the same ID
        deleteById(post.getId());

        // Replacing removed post with new post of the same ID
        post.setCreatedAt(new Date());
        jdbc.update("INSERT into POST (id, author, title, content, createdAt) values (?, ?, ?, ?, ?)",
                post.getId(),
                post.getAuthor(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt());
    }

    // Overwrite all
    public void overwriteAll(Iterable<Post> list) {
        for (Post post : list) {
            overwrite(post);
        }
    }

    // Delete by id
    public void deleteById(int id) {
        jdbc.update("DELETE from POST where id=?", id);
    }
}
