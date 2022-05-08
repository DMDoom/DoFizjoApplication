package pl.dofizjo.dofizjoapplication.data;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(value = "methodCache")
    public Method findById(int id) {
        return jdbc.queryForObject("SELECT id, name, description from METHOD where id=?",
                new MethodMapper(),
                id);
    }

    // Find all
    @Cacheable(value = "methodCache")
    public List<Method> findAll() {
        return jdbc.query("SELECT * from METHOD",
                new MethodMapper());
    }

    // Add one
    @CacheEvict(value="methodCache", allEntries = true)
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
    @CacheEvict(value="methodCache", allEntries = true)
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
    @CacheEvict(value="methodCache", allEntries = true)
    public void deleteById(int id) {
        jdbc.update("DELETE from METHOD where id=?", id);
    }


}
