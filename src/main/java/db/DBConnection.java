package db;

import com.mysql.cj.jdbc.MysqlDataSource;
import selenium.ui.config.ConfigReader;

import java.sql.*;

public class DBConnection {
    private static Connection connection;
    private static Statement statement;

    private DBConnection() {

    }

    public static void open(String db) {
        try {
            if (connection == null) {
                connection = getMysqlDataSource(db).getConnection();
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query, Object... params) throws SQLException {
        if (params.length == 0) {
            return statement.executeQuery(query);
        } else {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement.executeQuery();
        }
    }

    public static boolean execute(String query, Object... params) throws SQLException {
        if (params.length == 0) {
            return statement.execute(query);
        } else {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement.execute();
        }
    }




    public static void close() {
        try {
            if (statement == null) {
                statement.close();
                statement = null;
            }
            if (connection == null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    private static MysqlDataSource getMysqlDataSource(String database) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(ConfigReader.getProperty("server"));
        dataSource.setPortNumber(Integer.parseInt(ConfigReader.getProperty("port")));
        dataSource.setUser(ConfigReader.getProperty("DBuser"));
        dataSource.setPassword(ConfigReader.getProperty("DBpassword"));
        dataSource.setDatabaseName(database);
        return dataSource;

    }
}
