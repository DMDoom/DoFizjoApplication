package pl.dofizjo.dofizjoapplication.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.dofizjo.dofizjoapplication.data.mapper.MethodMapper;
import pl.dofizjo.dofizjoapplication.model.Method;

import java.util.List;

@Repository
public class MethodRepository {

    private JdbcTemplate jdbc;

    public MethodRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Find by id
    public Method findById(int id) {
        return jdbc.queryForObject("SELECT id, name, description from METHOD where id=?",
                new MethodMapper(),
                id);
    }

    // Find all
    public List<Method> findAll() {
        return jdbc.query("SELECT * from METHOD",
                new MethodMapper());
    }

    // Add one
    public void add(Method method) {
        jdbc.update("INSERT into METHOD (name, description) values (?, ?)",
                method.getName(),
                method.getDescription());
    }

    // Add all
    public void addAll(Iterable<Method> list) {
        for (Method method : list) {
            add(method);
        }
    }

    // Overwrite one
    public void overwrite(Method method) {
        deleteById(method.getId());

        jdbc.update("INSERT into METHOD (id, name, description) values (?, ?, ?)",
                method.getId(),
                method.getName(),
                method.getDescription());
    }

    // Overwrite all
    public void overwriteAll(Iterable<Method> list) {
        for (Method method : list) {
            overwrite(method);
        }
    }

    // Delete by id
    public void deleteById(int id) {
        jdbc.update("DELETE from METHOD where id=?", id);
    }


}
