package pl.dofizjo.dofizjoapplication.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import pl.dofizjo.dofizjoapplication.model.Partner;
import pl.dofizjo.dofizjoapplication.model.Post;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PartnerMapper implements RowMapper<Partner> {

    @Override
    public Partner mapRow(ResultSet rs, int rowNum) throws SQLException {
        Partner partner = new Partner();
        partner.setId(rs.getInt("id"));
        partner.setImg(rs.getString("img"));
        partner.setName(rs.getString("name"));
        partner.setDescription(rs.getString("description"));

        return partner;
    }
}
