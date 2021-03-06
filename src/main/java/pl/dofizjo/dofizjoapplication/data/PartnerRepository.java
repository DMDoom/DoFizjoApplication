package pl.dofizjo.dofizjoapplication.data;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(value = "partnerCache")
    public Partner findById(Long id) {
        return jdbc.queryForObject("SELECT id, img, name, description from PARTNER where id=?",
                new PartnerMapper(),
                id);
    }

    // Find all
    @Cacheable(value = "partnerCache")
    public List<Partner> findAll() {
        return jdbc.query("SELECT * from PARTNER", new PartnerMapper());
    }

    // Add one
    @CacheEvict(value="partnerCache", allEntries = true)
    public void add(Partner partner) {
        jdbc.update("INSERT into PARTNER (img, name, description) values (?, ?, ?)",
                partner.getImg(),
                partner.getName(),
                partner.getDescription());
    }

    // Add all
    public void addAll(Iterable<Partner> list) {
        for (Partner partner : list) {
            add(partner);
        }
    }

    // Overwrite one
    @CacheEvict(value="partnerCache", allEntries = true)
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
    @CacheEvict(value="partnerCache", allEntries = true)
    public void deleteById(int id) {
        jdbc.update("DELETE from PARTNER where id=?", id);
    }
}
