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

    // Find by id
    public Block findById(Long id) {
        return jdbc.queryForObject("SELECT id, title, content from BLOCK where id=?",
                new BlockMapper(),
                id);
    }

    // Find all
    public List<Block> findAll() {
        return jdbc.query("SELECT * from BLOCK", new BlockMapper());
    }

    // Add one
    public void add(Block block) {
        jdbc.update("INSERT into BLOCK (title, content) values (?, ?)",
                block.getTitle(),
                block.getContent());
    }

    // Add all
    public void addAll(Iterable<Block> list) {
        for (Block block : list) {
            add(block);
        }
    }

    // Overwrite one
    public void overwrite(Block block) {
        deleteById(block.getId());

        jdbc.update("INSERT into BLOCK (title, content) values (?, ?)",
                block.getTitle(),
                block.getContent());
    }

    // Overwrite all
    public void overwriteAll(Iterable<Block> list) {
        for (Block block : list) {
            overwrite(block);
        }
    }

    // Delete by id
    public void deleteById(int id) {
        jdbc.update("DELETE from BLOCK where id=?", id);
    }
}
