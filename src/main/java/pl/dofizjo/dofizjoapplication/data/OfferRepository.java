package pl.dofizjo.dofizjoapplication.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.dofizjo.dofizjoapplication.data.mapper.OfferMapper;
import pl.dofizjo.dofizjoapplication.model.Offer;

import java.util.List;

@Repository
public class OfferRepository {

    private JdbcTemplate jdbc;

    public OfferRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Find by id
    public Offer findById(int id) {
        return jdbc.queryForObject("SELECT id, name, description from OFFER where id=?",
                new OfferMapper(),
                id);
    }

    // Find all
    public List<Offer> findAll() {
        return jdbc.query("SELECT * from OFFER",
                new OfferMapper());
    }

    // Add one
    public void add(Offer offer) {
        jdbc.update("INSERT into OFFER (name, description) values (?, ?)",
                offer.getName(),
                offer.getDescription());
    }

    // Add all
    public void addAll(Iterable<Offer> list) {
        for (Offer offer : list) {
            add(offer);
        }
    }

    // Overwrite one
    public void overwrite(Offer offer) {
        deleteById(offer.getId());

        jdbc.update("INSERT into OFFER (id, name, description) values (?, ?, ?)",
                offer.getId(),
                offer.getName(),
                offer.getDescription());
    }

    // Overwrite all
    public void overwriteAll(Iterable<Offer> list) {
        for (Offer offer : list) {
            overwrite(offer);
        }
    }

    // Delete by id
    public void deleteById(int id) {
        jdbc.update("DELETE from OFFER where id=?", id);
    }


}
