package pl.dofizjo.dofizjoapplication.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import pl.dofizjo.dofizjoapplication.model.Post;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setId(rs.getInt("id"));
        post.setAuthor(rs.getString("author"));
        post.setTitle(rs.getString("title"));
        post.setContent(rs.getString("content"));
        post.setCreatedAt(rs.getDate("createdAt"));

        return post;
    }
}
