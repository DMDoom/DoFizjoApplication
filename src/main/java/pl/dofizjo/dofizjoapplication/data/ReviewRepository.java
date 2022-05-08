package pl.dofizjo.dofizjoapplication.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
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

    @Autowired
    private JdbcTemplate jdbc;

    // Find by id
    @Cacheable(value="reviewCache")
    public Review findById(Long id) {
        return jdbc.queryForObject("SELECT id, author, discipline, opinion from REVIEW where id=?",
                new ReviewMapper(),
                id);
    }

    // Find all
    @Cacheable(value="reviewCache")
    public List<Review> findAll() {
        return jdbc.query("SELECT * from REVIEW", new ReviewMapper());
    }

    // Add one
    @CacheEvict(value="reviewCache", allEntries = true)
    public void add(Review review) {
        jdbc.update("INSERT into REVIEW (author, discipline, opinion) values (?, ?, ?)",
                review.getAuthor(),
                review.getDiscipline(),
                review.getOpinion());
    }

    // Add all
    public void addAll(Iterable<Review> list) {
        for (Review review : list) {
            add(review);
        }
    }

    // Overwrite one
    @CacheEvict(value="reviewCache", allEntries = true)
    public void overwrite(Review review) {
        deleteById(review.getId());

        jdbc.update("INSERT into REVIEW (author, discipline, opinion) values (?, ?, ?)",
                review.getAuthor(),
                review.getDiscipline(),
                review.getOpinion());
    }

    // Overwrite all
    public void overwriteAll(Iterable<Review> list)  {
        for (Review review : list) {
            overwrite(review);
        }
    }

    // Delete by id
    @CacheEvict(value="reviewCache", allEntries = true)
    public void deleteById(int id) {
        jdbc.update("DELETE from REVIEW where id=?", id);
    }

}
