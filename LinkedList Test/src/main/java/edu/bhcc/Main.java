package edu.bhcc;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File("C:/Users/tlobd/Downloads/Accounts_History.csv");

        double total = 0;
        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();

                String[] parts  = line.split(",");

                if (parts[3].equals("Electronic Funds Transfer Received (Cash)")) {
                    total += Double.parseDouble(parts[12]);
                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Total amount invested for the year is: " + total);
    }
}