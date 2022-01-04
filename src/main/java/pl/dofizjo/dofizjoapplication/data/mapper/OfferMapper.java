package pl.dofizjo.dofizjoapplication.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import pl.dofizjo.dofizjoapplication.model.Offer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferMapper implements RowMapper<Offer> {


    @Override
    public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Offer offer = new Offer();
        offer.setId(rs.getInt("id"));
        offer.setName(rs.getString("name"));
        offer.setDescription(rs.getString("description"));

        return offer;
    }
}
