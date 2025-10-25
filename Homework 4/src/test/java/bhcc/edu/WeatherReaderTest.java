package bhcc.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests if the values being returned from the weatherReader are the same as the one we are expecting
 */
public class WeatherReaderTest {
    // file variable
    private File file;

    // create WeatherReader object to have the HashMap
    private WeatherReader weatherReader;


    /**
     * Before each test, file and weatherReader is initialized
     */
    @BeforeEach
    public void setup() {
        // initialize the file path
        this.file = new File("src/main/resources/seattle-weather.csv");
        // initialize the WeatherReader object
        this.weatherReader = new WeatherReader(this.file);
    }

    /**
     * Test if the Weather Object being returned from WeatherReader has the same values as the Weather Object that is initialized
     */
    // ALL TRUE TEST (THEY ARE CORRECT VALUES)
    @Test
    public void test2014_08_02(){
        // date that we are testing
        String date = "2014-08-02";

        // create Weather object with values we expect
        Weather weather = new Weather(0.5, 29.4,15.6,1.7,"rain");

        // retrieve the value pair of date from Map
        Weather returnedWeatherObject = weatherReader.getWeather(date);

        // check if all the variables match each other
        assertEquals(weather.getPrecipitation(), returnedWeatherObject.getPrecipitation());
        assertEquals(weather.getTempMax(), returnedWeatherObject.getTempMax());
        assertEquals(weather.getTempMin(), returnedWeatherObject.getTempMin());
        assertEquals(weather.getWind(), returnedWeatherObject.getWind());
        assertEquals(weather.getWeather(), returnedWeatherObject.getWeather());

    }

    /**
     * Test if the Weather Object being returned from WeatherReader has the same values as the Weather Object that is initialized
     */
    @Test
    public void test2012_12_18(){
        // date that we are testing
        String date = "2012-12-18";

        // create Weather object with values we expect
        Weather weather = new Weather(3.3, 3.9,0.6,5.3,"snow");

        // retrieve the value pair of date from Map
        Weather returnedWeatherObject = weatherReader.getWeather(date);

        // check if all the variables match each other
        assertEquals(weather.getPrecipitation(), returnedWeatherObject.getPrecipitation());
        assertEquals(weather.getTempMax(), returnedWeatherObject.getTempMax());
        assertEquals(weather.getTempMin(), returnedWeatherObject.getTempMin());
        assertEquals(weather.getWind(), returnedWeatherObject.getWind());
        assertEquals(weather.getWeather(), returnedWeatherObject.getWeather());
    }

    /**
     * Test if the Weather Object being returned from WeatherReader has the same values as the Weather Object that is initialized
     */
    @Test
    public void test2012_01_26(){
        // date that we are testing
        String date = "2012-01-26";

        // create Weather object with values we expect
        Weather weather = new Weather(4.8, 8.9,1.1,4.8,"rain");

        // retrieve the value pair of date from Map
        Weather returnedWeatherObject = weatherReader.getWeather(date);

        // check if all the variables match each other
        assertEquals(weather.getPrecipitation(), returnedWeatherObject.getPrecipitation());
        assertEquals(weather.getTempMax(), returnedWeatherObject.getTempMax());
        assertEquals(weather.getTempMin(), returnedWeatherObject.getTempMin());
        assertEquals(weather.getWind(), returnedWeatherObject.getWind());
        assertEquals(weather.getWeather(), returnedWeatherObject.getWeather());
    }

    /**
     * This is a test with wrong values, the test will pass, but the values are false.
     * This test is made, so if I changed the code and this doesn't work, then I know then the code is wrong because this should never fail.
     * The values will always be negative number (-6.7) and the csv file doesn't contain -6.7.
     */
    // ALL FALSE TESTS (VALUES ARE INCORRECT)
    @Test
    public void testFail2020_08_24(){
        String date = "2020-08-24";

        // retrieve the value pair of date from Map
        Weather returnedWeatherObject = weatherReader.getWeather(date);

        // hardcode values that I know will fail
        assertEquals(-6.7, returnedWeatherObject.getPrecipitation());
        assertEquals(-6.7, returnedWeatherObject.getTempMax());
        assertEquals(-6.7, returnedWeatherObject.getTempMin());
        assertEquals(-6.7, returnedWeatherObject.getWind());
        assertEquals("No Weather", returnedWeatherObject.getWeather());
    }
}
