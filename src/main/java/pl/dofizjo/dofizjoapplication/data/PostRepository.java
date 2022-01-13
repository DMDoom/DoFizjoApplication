package pl.dofizjo.dofizjoapplication.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import pl.dofizjo.dofizjoapplication.data.mapper.PostMapper;
import pl.dofizjo.dofizjoapplication.model.Post;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.*;

@Repository
public class PostRepository {

    private JdbcTemplate jdbc;

    public PostRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Find by id
    public Post findById(int id) {
        return jdbc.queryForObject(
                "SELECT id, author, title, content, createdAt from POST where id=?",
                new PostMapper(),
                id); // vararg
    }

    // Find recent
    public List<Post> findRecent(int number) {
        return jdbc.query("SELECT * from POST ORDER BY createdAt DESC LIMIT ?",
                new PostMapper(), number);
    }

    // Find latest one
    public Post findLatestOne() {
        return jdbc.queryForObject("SELECT TOP 1 * FROM POST ORDER BY createdAt DESC", new PostMapper());
    }

    // Find all
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

        // Statement
        // This is actually not necessary as JdbcTemplate does this under the hood by itself
        // This is only necessary if we want to obtain the ID of the generated entry back and use it elsewhere
        // as KeyHolder requires PreparedStatement
        /*
        PreparedStatementCreatorFactory pscFactory = new PreparedStatementCreatorFactory(
              "INSERT into POST (author, title, content, createdAt) values (?, ?, ?, ?)",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP);
        pscFactory.setReturnGeneratedKeys(true);
        PreparedStatementCreator psc = pscFactory.newPreparedStatementCreator(
                Arrays.asList(
                        post.getAuthor(),
                        post.getTitle(),
                        post.getContent(),
                        new Timestamp(post.getCreatedAt().getTime())));

        // Generating ID
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Save to database and return ID
        jdbc.update(psc, keyHolder);
        return keyHolder.getKey().intValue();
        */
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
