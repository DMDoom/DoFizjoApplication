package pl.dofizjo.dofizjoapplication.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import pl.dofizjo.dofizjoapplication.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEnabled(rs.getBoolean("enabled"));

        return user;
    }
}
