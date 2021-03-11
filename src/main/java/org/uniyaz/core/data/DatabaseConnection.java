package org.uniyaz.core.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class DatabaseConnection {
    static final String driverName = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://10.0.1.50:3306/deneme";
    static final String userName = "deneme";
    static final String password = "1Qaz2wsx!!";
    static Connection connection = null;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driverName);
        connection= DriverManager.getConnection(url, userName, password);
        return connection;
    }

    public static void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
