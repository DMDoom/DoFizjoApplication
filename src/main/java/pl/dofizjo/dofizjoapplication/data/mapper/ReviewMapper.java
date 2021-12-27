package pl.dofizjo.dofizjoapplication.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import pl.dofizjo.dofizjoapplication.model.Review;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewMapper implements RowMapper<Review> {

    @Override
    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
        Review review = new Review();
        review.setId(rs.getLong("id"));
        review.setAuthor(rs.getString("author"));
        review.setDiscipline(rs.getString("discipline"));
        review.setOpinion(rs.getString("opinion"));

        return review;
    }
}
