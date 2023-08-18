package db;


import lombok.Data;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Data
public class User {
    String emp_no;
    String birth_date;
    String first_name;
    String last_name;
    String gender;
    String hire_date;

    public User (ResultSet rs) throws SQLException {
        new BeanProcessor().populateBean(rs, this);
    }

    public List<User> getAll() throws SQLException {
        String query = "Select * from employees";
        try (ResultSet resultSet = DBConnection.executeQuery(query)){
            return new BeanProcessor().toBeanList(resultSet, User.class);
        }
    }

    public static User getBy(String column, String value) throws SQLException {
        String query = "Select * from employees WHERE " + column + " = ?;";
        ResultSet rs = DBConnection.executeQuery(query, value);
        if (!rs.next()) return null;
        return  new BeanProcessor().toBean(rs, User.class);
    }



}
