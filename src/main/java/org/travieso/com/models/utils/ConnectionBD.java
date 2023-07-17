package org.travieso.com.models.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
    private static final String url = "jdbc:mysql://localhost:3306/java_curso?serverTimeZone=UTC";
    private static final String username = "root";
    private static final String password = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
