package pl.dofizjo.dofizjoapplication.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import pl.dofizjo.dofizjoapplication.data.mapper.CommentMapper;
import pl.dofizjo.dofizjoapplication.model.Comment;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class CommentRepository {

    private JdbcTemplate jdbc;

    public CommentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Find by id
    public Comment findById(int id) {
        return jdbc.queryForObject("SELECT * from COMMENT where id=?", new CommentMapper(), id);
    }

    // Find all
    public List<Comment> findAll() {
        return jdbc.query("SELECT * from COMMENT", new CommentMapper());
    }

    // Find all by post id
    public List<Comment> findAllByPostId(int id) {
        return jdbc.query("SELECT * from COMMENT where postid=?", new CommentMapper(), id);
    }

    // Add one
    public void add(Comment comment) {
        comment.setCreatedAt(new Date());
        PreparedStatementCreatorFactory pscFactory = new PreparedStatementCreatorFactory(
                "INSERT into COMMENT (postid, author, content, createdAt) values (?, ?, ?, ?)",
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR,
                Types.TIMESTAMP);

        pscFactory.setReturnGeneratedKeys(true);
        PreparedStatementCreator psc = pscFactory.newPreparedStatementCreator(
                Arrays.asList(
                        comment.getPostId(),
                        comment.getAuthor(),
                        comment.getContent(),
                        comment.getCreatedAt()));

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc, keyHolder);
        int generatedId = keyHolder.getKey().intValue();

        // Save to POST_COMMENTS
        saveToPost(comment.getPostId(), generatedId);
    }

    // Save to POST_COMMENTS
    public void saveToPost(int postId, int generatedId) {
        jdbc.update("INSERT into POST_COMMENTS (postid, commentid) values (?, ?)", postId, generatedId);
    }

    // Delete by id
    public void deleteById(int id) {
        jdbc.update("DELETE from COMMENT where id=?", id);
    }
}
