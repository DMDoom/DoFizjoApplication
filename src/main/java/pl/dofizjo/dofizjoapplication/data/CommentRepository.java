package pl.dofizjo.dofizjoapplication.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.dofizjo.dofizjoapplication.data.mapper.CommentMapper;
import pl.dofizjo.dofizjoapplication.model.Comment;

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

    // Add one
    public void add(Comment comment) {
        jdbc.update("INSERT into COMMENT (content) values (?)", comment.getContent());
    }

    // Delete by id
    public void deleteById(int id) {
        jdbc.update("DELETE from COMMENT where id=?", id);
    }


}
