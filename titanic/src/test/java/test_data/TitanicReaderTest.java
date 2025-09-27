package test_data;

import java.io.File;
import edu.bhcc.TitanicReader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * unit test for TitanicReader class
 */
public class TitanicReaderTest {

    /**
     * Tests that the total passenger count equals 891.
     */
    @Test
    public void testTotalPassenger(){
        // create File object
        File file = new File("E:/Advanced Java/titanic/src/test/java/test_data/titanic.csv");
        // create TitanicReader object with file passed in
        TitanicReader titanic = new TitanicReader(file);
        // retrieve total passenger count
        int totalPass = titanic.getNumPassengers();
        // check if the totalPass equals expected number(891)
        assertEquals(891, totalPass);
    }

    /**
     * Tests that the first-class passenger count equals 216.
     */
    @Test
    public void testFirstTotalPassenger(){
        // create File object
        File file = new File("E:/Advanced Java/titanic/src/test/java/test_data/titanic.csv");
        // create TitanicReader object with file passed in
        TitanicReader titanic = new TitanicReader(file);
        // retrieve total first class passengers
        int totalFirstPass = titanic.getNumFirstClassPassengers();
        // check if the totalFirstPass equals expected number(216)
        assertEquals(216, totalFirstPass);
    }

    /**
     * Tests that the second-class passenger count equals 184.
     */
    @Test
    public void testSecondTotalPassenger(){
        // create File object
        File file = new File("E:/Advanced Java/titanic/src/test/java/test_data/titanic.csv");
        // create TitanicReader object with file passed in
        TitanicReader titanic = new TitanicReader(file);
        // retrieve total second class passengers
        int totalSecondPass = titanic.getNumSecondClassPassengers();
        // check if the totalSecondPass equals expected number(184)
        assertEquals(184, totalSecondPass);
    }

    /**
     * Tests that the third-class passenger count equals 491.
     */
    @Test
    public void testThirdTotalPassenger(){
        // create File object
        File file = new File("E:/Advanced Java/titanic/src/test/java/test_data/titanic.csv");
        // create TitanicReader object with file passed in
        TitanicReader titanic = new TitanicReader(file);
        // retrieve total third class passengers
        int totalThirdPass = titanic.getNumThirdClassPassengers();
        // check if the totalThirdPass equals expected number(491)
        assertEquals(491, totalThirdPass);
    }
}
