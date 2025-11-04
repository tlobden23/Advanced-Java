package edu.bhcc;

import java.sql.*;
import java.util.Scanner;

/**
 * This class queries SQL database.
 */
public class Query {
    /**
     * This method retrieves condition and column for SQL statement from user.
     *
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        // create connection to database using driver (creates music.db)
        Connection connection = DriverManager.getConnection("jdbc:sqlite:music.db");
        
        // create scanner object
        Scanner scanner = new Scanner(System.in);

        // infinite loop to enter entries to db
        while (true) {
            System.out.println("Enter condition for SQL statement: ");
            String inputCondition = scanner.nextLine();

            // break while loop if user inputs 'quit', 'Quit', 'q', 'Q'
            if (inputCondition.equalsIgnoreCase("quit") || inputCondition.equals("q")) {
                break;
            }
            // if user wanted to know how many rows of data in ("MUSIC") table.
            if (inputCondition.equalsIgnoreCase("count")) {
                countData(connection);
                // next iteration of the while loop
                continue;
            }

            System.out.println("Enter column you would like to parse data for: ");
            String inputColumn = scanner.nextLine();

            // query SQL table
            selectData(connection, inputCondition, inputColumn);
        }

        // close scanner and connection with jdbc
        scanner.close();
        connection.close();
    }

    /**
     * This static method queries SQL Table ("MUSIC") and outputs result via Result Set.
     *
     * @param connection
     * @param condition
     * @param column
     * @throws SQLException
     */
    public static void selectData(Connection connection, String condition, String column) throws SQLException {
        // create prepared statement for SQL statement
        PreparedStatement preparedStatement = connection.prepareStatement(String.format("SELECT * FROM MUSIC WHERE %s = '%s';", column, condition));

        // execute the SQL statement and return back the data
        ResultSet resultSet = preparedStatement.executeQuery();

        // iterate through the result set
        while (resultSet.next()) {

            // retrieve each column data
            String name = resultSet.getString("name");
            String artist = resultSet.getString("artist");
            String album = resultSet.getString("album");
            int releaseYear = resultSet.getInt("release_year");

            // output data
            System.out.printf("name = %s\nartist = %s\nalbum = %s\nrelease year = %s\n\n", name, artist, album, releaseYear);
        }
    }

    /**
     * This static method counts the number of records in the ("MUSIC") table.
     *
     * @param connection
     * @throws SQLException
     */
    public static void countData(Connection connection) throws SQLException {
        // create prepared statement for SQL statement
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS total FROM MUSIC");

        // execute the SQL statement and return back the data
        ResultSet resultSet = preparedStatement.executeQuery();

        // retrieve the int (count of data row)
        if (resultSet.next()) {
                int total = resultSet.getInt("total");
                System.out.printf("Total records in MUSIC table: %d\n", total);
            }

    }
}
