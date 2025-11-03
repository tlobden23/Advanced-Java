package edu.bhcc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    public Insert(Connection connection) throws SQLException {
        // allows us to make a new sql statement
        Statement statement = connection.createStatement();

        statement.executeUpdate("""
                INSERT INTO CREDIT_CARD_TRANSACTION (PAYEE, BUDGET_CATEGORY, AMOUNT)
                VALUES ("amazon.com", "Consumer Spending", 2399.99);
            """);

        statement.executeUpdate("""
                INSERT INTO CREDIT_CARD_TRANSACTION (PAYEE, BUDGET_CATEGORY, AMOUNT)
                VALUES ("Zelle to Deacon Kumar", "Misc.", 10.99);
            """);
    }
}
