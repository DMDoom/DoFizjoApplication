package pl.dofizjo.dofizjoapplication.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import pl.dofizjo.dofizjoapplication.model.Block;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BlockMapper implements RowMapper<Block> {

    @Override
    public Block mapRow(ResultSet rs, int rowNum) throws SQLException {
        Block block = new Block();
        block.setId(rs.getInt("id"));
        block.setTitle(rs.getString("title"));
        block.setContent(rs.getString("content"));

        return block;
    }
}
