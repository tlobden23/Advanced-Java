package bhcc.edu;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This class creates a HashMap and then goes through each row in the file and retrieves all data in the row.
 * Add the data to HashMap with date being the key and rest of the value being the values.
 */
public class WeatherReader {
    // hold all data with key being date and value being Weather object
    private Map<String, Weather> hashMap = new HashMap<>();

    /**
     * Constructor to parse through each row in file.
     * Add to HashMap with (key = date and value = [precipitation, temp_max, temp_min, wind, weather]
     *
     * @param file
     */
    public WeatherReader(File file) {
        // try catch to handle file errors
        try {
            // set up readFile to read file variable
            BufferedReader readFile = new BufferedReader(new FileReader(file));

            // read the header column so line variable doesn't encounter it
            String header = readFile.readLine();

            // helper variable to hold each line in the file
            String line;

            // iterate through each row in the file until null
            while ((line = readFile.readLine()) != null) {
                // split line by ',', so we can pick up each column data
                String[] parts = line.split(",");

                // retrieve data from each column and convert to Double
                double precipitation = Double.parseDouble(parts[1].trim());
                double temp_max = Double.parseDouble(parts[2].trim());
                double temp_min = Double.parseDouble(parts[3].trim());
                double wind = Double.parseDouble(parts[4].trim());

                // put key value pair in Map (key = Date, value = Weather Object)
                hashMap.put(parts[0].trim(), new Weather(precipitation, temp_max, temp_min, wind, parts[5].trim()));
            }

            // close readFile to stop reading lines
            readFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *  Returns Weather object for given date if the date is a key in hashMap else returns Weather Object that give negative values
     *
     * @param date
     * @return Weather Object
     */
    public Weather getWeather(String date) {
        // if date is one of the keys in hashMap then return Weather object
        if (hashMap.containsKey(date))
            // return Weather object with date being key
            return hashMap.get(date);
        // else return Weather object with hard coded values
        else {
            // return Weather object with random values because this method returns Weather object
            return new Weather(-6.7, -6.7, -6.7,-6.7,"No Weather");
        }
    }
}
