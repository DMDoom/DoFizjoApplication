package pl.dofizjo.dofizjoapplication.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.dofizjo.dofizjoapplication.data.mapper.BlockMapper;
import pl.dofizjo.dofizjoapplication.model.Block;

import java.util.List;

@Repository
@Slf4j
public class BlockRepository {

    private JdbcTemplate jdbc;

    public BlockRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Find by id
    @Cacheable(value = "blockCache")
    public Block findById(String id) {
        return jdbc.queryForObject("SELECT id, title, content from BLOCK where id=?",
                new BlockMapper(),
                id);
    }

    // Find all
    @Cacheable(value = "blockCache")
    public List<Block> findAll() {
        return jdbc.query("SELECT * from BLOCK", new BlockMapper());
    }

    // Add one
    // DIFFERENT FROM ALL OTHER REPOSITORY METHODS in that it also inserts id manually
    @CacheEvict(value="blockCache", allEntries=true)
    public void add(Block block) {
        jdbc.update("INSERT into BLOCK (id, title, content) values (?, ?, ?)",
                block.getId(),
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
    @CacheEvict(value="blockCache", allEntries=true)
    public void overwrite(Block block) {
        deleteById(block.getId());

        jdbc.update("INSERT into BLOCK (id, title, content) values (?, ?, ?)",
                block.getId(),
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
    @CacheEvict(value="blockCache", allEntries=true)
    public void deleteById(String id) {
        jdbc.update("DELETE from BLOCK where id=?", id);
    }
}
