package edu.bhcc;


import java.io.File;
import java.io.FileNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

/**
 * Reads the file and then keep count of each type of different passenger class
 * keep track of total passenger count no matter passenger class
 */
public class TitanicReader{

    // instance variables
    private int totalPassengers;
    private int firstClassPassengers;
    private int secondClassPassengers;
    private int thirdClassPassengers;

    /**
     * Reads each line in the file and counts passengers by class.
     */
    // constructor
    public TitanicReader(File file) {
        // logger object to log
        Logger logger = LoggerFactory.getLogger(TitanicReader.class);

        // try to read each row in the file
        try {
            // scanner to read each row in the file
            Scanner scanner = new Scanner(file);

            // loop through all the rows in the file while there is a next row
            while (scanner.hasNextLine()) {
                // retrieve the row
                String line = scanner.nextLine();

                // split the .csv as the ',' being the delimiter and put all the values in an array
                String[] parts = line.split(",");

                // check if the line's passenger class is equal to 1
                if (parts[2].equals("1")) {
                    // increment firstClass by 1
                    this.firstClassPassengers++;
                    // add totalPassenger inside if statement because if it's outside then the first row with the header
                    // gets incremented
                    this.totalPassengers++;
                }
                // check if the line's passenger class is equal to 2
                else if (parts[2].equals("2")) {
                    // increment secondClass by 1
                    this.secondClassPassengers++;
                    // add totalPassenger inside if statement because if it's outside then the first row with the header
                    // gets incremented
                    this.totalPassengers++;
                }
                // check if the line's passenger class is equal to 3
                else if (parts[2].equals("3")) {
                    // increment thirdClass by 1
                    this.thirdClassPassengers++;
                    // add totalPassenger inside if statement because if it's outside then the first row with the header
                    // gets incremented
                    this.totalPassengers++;
                }
            }

            // log all the information
            logger.info("Total Passengers = " + this.getNumPassengers());
            logger.info("Total First Class Passengers = " + this.getNumFirstClassPassengers());
            logger.info("Total Second Class Passengers = " + this.getNumSecondClassPassengers());
            logger.info("Total Third Class Passengers = " + this.getNumThirdClassPassengers() + "\n");


        }
        // if the file isn't valid then log it
        catch (FileNotFoundException e) {
            logger.error("File wasn't found (double check file directory).");
            logger.error("File directory = " + file);
        }
    }

    // getters

    /**
     * return total passenger count
     * @return totalPassenger
     */
    public int getNumPassengers(){
        return this.totalPassengers;
    }

    /**
     * return total first class passenger
     * @return firstClassPassengers
     */
    public int getNumFirstClassPassengers(){
        return this.firstClassPassengers;
    }

    /**
     * return total second class passenger
     * @return secondClassPassengers
     */
    public int getNumSecondClassPassengers(){
        return this.secondClassPassengers;
    }

    /**
     * return total third class passenger
     * @return thirdClassPassenger
     */
    public int getNumThirdClassPassengers(){
        return this.thirdClassPassengers;
    }
}

