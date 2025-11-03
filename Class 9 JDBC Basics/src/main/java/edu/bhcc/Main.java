package edu.bhcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

    //  Create JDBC Connection
    Connection connection = DriverManager.getConnection("jdbc:sqlite:bank.db");

    Insert insert = new Insert(connection);

    Query query = new Query(connection);

    connection.close();
    }
}