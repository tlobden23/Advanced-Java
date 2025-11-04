package edu.bhcc;

import java.sql.*;
import java.util.Scanner;

/**
 * This class creates a table and inserts values into the table.
 *
 */
public class CreateInsert{
    /**
     * This method creates a connection and calls createTable() and insertValues().
     *
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        // create connection to database using driver (creates music.db)
        Connection connection = DriverManager.getConnection("jdbc:sqlite:music.db");

        // create MUSIC table
        createTable(connection);

        // add entries to db and return back how many entries have been added
        insertValues(connection);

        connection.close();
    }

    /**
     * This static method creates a table called "MUSIC" if it doesn't exist.
     *
     * @param connection
     */
    public static void createTable(Connection connection){
        // use try and catch if there was a problem creating a table
        try {
            // create the statement for SQL execution
            Statement statement = connection.createStatement();

            // execute SQL statement
            statement.execute("""
                            CREATE TABLE IF NOT EXISTS MUSIC (
                            id INTEGER PRIMARY KEY AUTOINCREMENT,
                            name TEXT NOT NULL,
                            artist TEXT NOT NULL,
                            album TEXT NOT NULL,
                            release_year INTEGER NOT NULL);
                            """);

            System.out.println("Table \"MUSIC\" created");
        }
        catch (SQLException sqlException) {
            // print error message
            System.out.println("Message: " + sqlException.getMessage());
        }
    }

    /**
     * This static method inserts values into the db through an infinite while loop.
     *
     * @param connection
     * @throws SQLException
     */
    public static void insertValues(Connection connection) throws SQLException {
        int entries = 0;

        // scanner object to read values from the user
        Scanner scanner = new Scanner(System.in);

        // infinite loop to enter entries to db
        while (true) {
            // retrieve song name
            System.out.print("Enter song name (q to quit): ");
            String nameInput = scanner.nextLine().trim();
            if (nameInput.equalsIgnoreCase("q") || nameInput.equalsIgnoreCase("quit"))
                break;
            if (nameInput.isEmpty()) {
                System.out.println("Name required.");
                continue;
            }

            // retrieve artist name
            System.out.print("Enter artist: ");
            String artistInput = scanner.nextLine().trim();
            if (artistInput.isEmpty()) {
                System.out.println("Artist required.");
                continue;
            }

            // retrieve album name
            System.out.print("Enter album: ");
            String albumInput = scanner.nextLine().trim();
            if (albumInput.isEmpty()) {
                System.out.println("Album required.");
                continue;
            }

            // retrieve release year
            System.out.print("Enter release year (e.g., 2020): ");
            int yearInput = Integer.parseInt(scanner.nextLine().trim());

            // create prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement("""
                    INSERT INTO MUSIC
                    (name, artist, album, release_year) VALUES
                    (?, ?, ?, ?);
                    """);

            // insert values for prepared statements
            preparedStatement.setString(1, nameInput);
            preparedStatement.setString(2, artistInput);
            preparedStatement.setString(3, albumInput);
            preparedStatement.setInt(4, yearInput);

            // execute SQL statements
            preparedStatement.executeUpdate();

            // add one to entries
            entries++;
        }
        System.out.printf("%d records have been added to \"MUSIC\" table\n", entries);

        // close scanner
        scanner.close();
    }
}