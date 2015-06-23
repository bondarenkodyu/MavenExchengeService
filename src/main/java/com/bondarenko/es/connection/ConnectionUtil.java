package com.bondarenko.es.connection;

import java.sql.*;
import java.util.Locale;


/**
 * Created by Lil Wayne on 17.06.15.
 */
public class ConnectionUtil {

    private static ConnectionUtil instance;
    private String url;
    private String userName;
    private String password;

    private ConnectionUtil()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://localhost:3306/exchange_service";
            userName = "root";
            password = "root";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null)
            instance = new ConnectionUtil();
        return DriverManager.getConnection(instance.url, instance.userName, instance.password);
    }

    public static void close(Connection connection, Statement statement)
    {
        try {
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
