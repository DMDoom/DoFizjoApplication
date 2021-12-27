package pl.dofizjo.dofizjoapplication.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import pl.dofizjo.dofizjoapplication.data.mapper.BlockMapper;
import pl.dofizjo.dofizjoapplication.model.Block;

import java.sql.Types;
import java.util.Arrays;
import java.util.List;

@Repository
public class BlockRepository {

    private JdbcTemplate jdbc;

    public BlockRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Find all
    public List<Block> findAll() {
        return jdbc.query("SELECT * from BLOCK", new BlockMapper());
    }

    // Find by id
    public Block findById(Long id) {
        return jdbc.queryForObject("SELECT id, title, content from BLOCK where id=?",
                new BlockMapper(),
                id);
    }

    // Save one
    public long save(Block block) {
        // Statement
        PreparedStatementCreatorFactory pscFactory = new PreparedStatementCreatorFactory(
                "INSERT into BLOCK (title, content) values (?, ?)",
                Types.VARCHAR, Types.VARCHAR);
        pscFactory.setReturnGeneratedKeys(true);
        PreparedStatementCreator psc = pscFactory.newPreparedStatementCreator(
                Arrays.asList(
                        block.getTitle(),
                        block.getContent()));

        // Generating ID
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Save Block to database and return ID
        jdbc.update(psc, keyHolder);
        return keyHolder.getKey().longValue();
    }
}
