package pl.dofizjo.dofizjoapplication.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import pl.dofizjo.dofizjoapplication.data.mapper.ReviewMapper;
import pl.dofizjo.dofizjoapplication.model.Review;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;

@Repository
public class ReviewRepository {

    private JdbcTemplate jdbc;

    public ReviewRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Find all
    public List<Review> findAll() {
        return jdbc.query("SELECT * from REVIEW", new ReviewMapper());
    }

    // Find by id
    public Review findById(Long id) {
        return jdbc.queryForObject("SELECT id, author, discipline, opinion from REVIEW where id=?",
                new ReviewMapper(),
                id);
    }

    // Save one
    public long save(Review review) {
        // Statement
        PreparedStatementCreatorFactory pscFactory = new PreparedStatementCreatorFactory(
                "INSERT into REVIEW (author, discipline, opinion) values (?, ?, ?)",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR);
        pscFactory.setReturnGeneratedKeys(true);
        PreparedStatementCreator psc = pscFactory.newPreparedStatementCreator(
                Arrays.asList(
                        review.getAuthor(),
                        review.getDiscipline(),
                        review.getOpinion()));

        // Generating ID
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Save to database and return ID
        jdbc.update(psc, keyHolder);
        return keyHolder.getKey().longValue();
    }

}
