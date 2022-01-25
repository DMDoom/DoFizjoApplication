package pl.dofizjo.dofizjoapplication.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import pl.dofizjo.dofizjoapplication.model.Method;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MethodMapper implements RowMapper<Method> {


    @Override
    public Method mapRow(ResultSet rs, int rowNum) throws SQLException {
        Method method = new Method();
        method.setId(rs.getInt("id"));
        method.setName(rs.getString("name"));
        method.setDescription(rs.getString("description"));

        return method;
    }
}
