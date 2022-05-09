package pl.dofizjo.dofizjoapplication.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.dofizjo.dofizjoapplication.data.mapper.UserMapper;
import pl.dofizjo.dofizjoapplication.model.User;

import java.util.Optional;

@Repository
public class UserRepository {

    private JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Find by id
    public Optional<User> findByUsername(String username) {
        try {
            User user = jdbc.queryForObject("SELECT * from USERS where username=?",
                    new UserMapper(),
                    username);

            Optional<User> opt = Optional.ofNullable(user);
            return opt;
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    // Save
    public void add(User user) {
        jdbc.update("INSERT into USERS (username, password, enabled) values (?, ?, ?)",
                user.getUsername(),
                user.getPassword(),
                user.isEnabled());
    }
}
