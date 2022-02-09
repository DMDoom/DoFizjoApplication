package pl.dofizjo.dofizjoapplication.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.dofizjo.dofizjoapplication.data.mapper.UserMapper;
import pl.dofizjo.dofizjoapplication.model.User;

@Repository
public class UserRepository {

    private JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Find by id
    public User findByUsername(String username) {
        return jdbc.queryForObject("SELECT * from USERS where username=?",
                new UserMapper(),
                username);
    }

    // Save
    public void add(User user) {
        jdbc.update("INSERT into USERS (username, password, enabled) values (?, ?, ?)",
                user.getUsername(),
                user.getPassword(),
                user.isEnabled());
    }
}
