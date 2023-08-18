package db;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBDemo {
    public static void main(String[] args) throws SQLException {
        DBConnection.open("employees");
        ResultSet rs = DBConnection.executeQuery("Select * from employees where first_name = ?;", "Abdulla");
        rs.next();
        System.out.println(new User(rs));
        DBConnection.close();
    }

    @Test (dataProvider = "nameProvider")
    public void hasAksel(String name, boolean exist) throws SQLException {
        DBConnection.open("employees");
        ResultSet rs = DBConnection.executeQuery("Select * from employees where first_name = ?;", name);
        User user = null;
        if(rs.next() ){
            user = new User(rs);
        }
        Assert.assertEquals(user != null, exist);
    }

    @Test
    public void addAndCheck() throws SQLException {
        DBConnection.open("employees");
        boolean b = DBConnection.execute("insert into employees(emp_no, birth_date, first_name, last_name, gender, hire_date) values ('21', '1999-06-11', 'asan', 'dani', 'M', '1986-08-28');");
        Assert.assertTrue(b, "not added");
    }

    @DataProvider
    public Object[][] nameProvider(){
        return new Object[][]{
                {"Aksel", true},
                {"Asan", false},
                {"Yrysbek", true}
        };
    }
}
