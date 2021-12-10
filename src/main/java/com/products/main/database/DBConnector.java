package com.products.main.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class to connect to a database.
 */
public class DBConnector {

    /**
     * Connect to the database with a given url
     * @param url url of the database.
     */
    public Connection connect(String url) throws SQLException {
        return DriverManager.getConnection(url,"postgres", "password");
    }

}
