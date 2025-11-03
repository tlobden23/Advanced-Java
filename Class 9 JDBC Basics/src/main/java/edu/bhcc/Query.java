package edu.bhcc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {

    private ResultSet rs;
    
    public Query(Connection connection) throws SQLException {
        // allows us to make a new sql statement
        Statement statement = connection.createStatement();

        // returns back an iterator object
        this.rs  = statement.executeQuery("SELECT * FROM CREDIT_CARD_TRANSACTION;");

        while (rs.next()){
            String payee = rs.getString("PAYEE");
            String budgetCategory = rs.getString("BUDGET_CATEGORY");
            Double amountNumeric = rs.getDouble("AMOUNT");
            System.out.printf("Payee = %s, Budget Category = %s, Amount = %.2f\n", payee, budgetCategory, amountNumeric);
        }
    }
}
