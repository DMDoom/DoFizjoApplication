package pl.dofizjo.dofizjoapplication.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import pl.dofizjo.dofizjoapplication.data.mapper.PartnerMapper;
import pl.dofizjo.dofizjoapplication.model.Partner;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;

@Repository
public class PartnerRepository {

    private JdbcTemplate jdbc;

    public PartnerRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Find by id
    public Partner findById(Long id) {
        return jdbc.queryForObject("SELECT id, img, name, description from PARTNER where id=?",
                new PartnerMapper(),
                id);
    }

    // Find all
    public List<Partner> findAll() {
        return jdbc.query("SELECT * from PARTNER", new PartnerMapper());
    }

    // Save one
    public void save(Partner partner) {
        jdbc.update("INSERT into PARTNER (img, name, description) values (?, ?, ?)",
                partner.getImg(),
                partner.getName(),
                partner.getDescription());
    }

    // Save all
    public void saveAll(Iterable<Partner> list) {
        for (Partner partner : list) {
            save(partner);
        }
    }

    // Overwrite one
    public void overwrite(Partner partner) {
        deleteById(partner.getId());

        jdbc.update("INSERT into PARTNER (img, name, description) values (?, ?, ?)",
                partner.getImg(),
                partner.getName(),
                partner.getDescription());
    }

    // Overwrite all
    public void overwriteAll(Iterable<Partner> list) {
        for (Partner partner : list) {
            overwrite(partner);
        }
    }

    // Delete by id
    public void deleteById(int id) {
        jdbc.update("DELETE from PARTNER where id=?", id);
    }
}
