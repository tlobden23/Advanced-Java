package edu.bhcc;

import java.sql.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * This class deals with the database,
 * create table, insert data, and retrieve data from the database.
 *
 */
public class LogDatabase {
    private Connection connection;

    /**
     * Constructor to create the JDBC connection and also create Table if not exists.
     */
    public LogDatabase() {
        // try to run the sql statement and also connect to SQLite via JDBC
        try {
            // create connection
            this.connection = DriverManager.getConnection("jdbc:sqlite:logger.db");

            // create table
            PreparedStatement ps = this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS logs(id INTEGER PRIMARY KEY AUTOINCREMENT, timestamp TEXT NOT NULL, message TEXT NOT NULL)");
            // execute the SQL statement
            ps.executeUpdate();

        }
        // catch SQL exception if thrown
        catch (SQLException e) {
            System.out.println("Problem with creating table if not exists.");
        }
    }

    /**
     * Retrieve message from LoggerServlet and insert data into database.
     *
     * @param message
     */
    public void insert(String message) {
        // retrieve current time
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a"));

        // try to run SQL statement
        try {
            // insert data into SQL database
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO logs(timestamp, message) VALUES (?, ?)");
            preparedStatement.setString(1, time);
            preparedStatement.setString(2, message);

            // run SQL statement
            preparedStatement.executeUpdate();
        }
        // catch SQL exception if thrown
        catch (SQLException e) {
            System.out.println("Problem with uploading data to SQLite database.");
        }
    }

    /**
     * This builds all the HTML rows that FreeMarker will display as ${row}.
     * Also, retrieves all timestamp and message from database.
     *
     * @return
     */
    public String retrieve() {
        // create StringBuilder to hold all HTML code
        StringBuilder builder = new StringBuilder();

        // try to run SQL statement to retrieve data
        try {
            // SQL statement
            PreparedStatement ps = this.connection.prepareStatement("SELECT timestamp, message FROM logs ORDER BY id DESC");

            // execute SQL statement
            ResultSet rs = ps.executeQuery();

            // iterate through the ResultSet
            while (rs.next()) {
                // retrieve "timestamp" and "message"
                String ts = rs.getString("timestamp");
                String msg = rs.getString("message");

                // add html code to add the new messages
                builder.append("<div class=\"row mt-1\">");
                builder.append("<div class=\"col-4 pe-0\"><p class=\"text-black\">")
                        .append(ts)
                        .append("</p></div>");

                builder.append("<div class=\"col-3 ps-0\"><p class=\"text-black\">")
                        .append(msg)
                        .append("</p></div>");

                builder.append("</div>");
            }

        }
        // catch SQL exceptions if thrown
        catch (SQLException e) {
            System.out.println("Problem retrieving data from SQLite database:");
        }

        // return builder as String object
        return builder.toString();
    }
}
