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

    // Find all
    public List<Partner> findAll() {
        return jdbc.query("SELECT * from PARTNER", new PartnerMapper());
    }

    // Find by id
    public Partner findById(Long id) {
        return jdbc.queryForObject("SELECT id, img, name, description from PARTNER where id=?",
                new PartnerMapper(),
                id);
    }

    // Save all
    public void saveAll(Iterable<Partner> list) {
        for (Partner partner : list) {
            save(partner);
        }
    }

    // Save one
    public long save(Partner partner) {
        // Statement
        PreparedStatementCreatorFactory pscFactory = new PreparedStatementCreatorFactory(
                "INSERT into PARTNER (img, name, description) values (?, ?, ?)",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR);
        pscFactory.setReturnGeneratedKeys(true);
        PreparedStatementCreator psc = pscFactory.newPreparedStatementCreator(
                Arrays.asList(
                        partner.getImg(),
                        partner.getName(),
                        partner.getDescription()));

        // Generating ID
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Save to database and return ID
        jdbc.update(psc, keyHolder);
        return keyHolder.getKey().longValue();
    }
}
