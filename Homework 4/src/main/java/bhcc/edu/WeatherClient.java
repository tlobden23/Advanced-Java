package bhcc.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 *
 * This class represent the client that connects to the WeatherServerPool,
 * sends a date request, and receives weather information for that date.
 *
 */
public class WeatherClient {

    /**
     * This method takes an argument (date) from Client (terminal) and then passes that argument to the Server as bytes.
     * Receives Weather details for that specific date, if the date isn't valid, then an error would be logged in terminal.
     *
     *
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // create Logger object
        Logger log = LoggerFactory.getLogger(WeatherClient.class);

        // Create socket at port 8000
        Socket socket = new Socket("localhost", 8000);

        // date from terminal
        String date = args[0];

        // send bytes to socket
        OutputStreamWriter toServer = new OutputStreamWriter(socket.getOutputStream());

        // retrieve bytes of Weather object
        ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());

        // send date (String) as bytes through socket
        // add \n because BufferedReader stops reading at \n char
        toServer.write(date + "\n");

        // send the bytes
        toServer.flush();

        Weather weather = (Weather) fromServer.readObject();

        // if the weather data is negative number (-6.7) then end program
        if (weather.getPrecipitation() == -6.7 &&
            weather.getTempMax() == -6.7 &&
            weather.getTempMin() == -6.7 &&
            weather.getWind() == -6.7 &&
            weather.getWeather().equals("No Weather")) {

            // output that the date isn't valid
            log.error("The date \"" + date + "\" isn't a valid date.");

            // end the program
            System.exit(0);
        }

        log.info("Received details for " + date + " from Server at: " + new Date());

        // precipitation
        log.info("Precipitation = " + weather.getPrecipitation());

        // temp_max
        log.info("Max Temperature (Celsius) = " + weather.getTempMax());

        // temp_min
        log.info("Min Temperature (Celsius) = " + weather.getTempMin());

        // wind
        log.info("Wind = " + weather.getWind());

        // weather
        log.info("Weather = " +weather.getWeather());

        // closes all objects tied with socket from Client side
        socket.close();
    }
}
