package bhcc.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * This class handles the retrieving the date from Client and retrieving the Weather object for that date.
 * Returns the Weather object as bytes to Client.
 */
public class HandleWeatherRequest implements Runnable{
    // instance variable
    // holds socket connection
    private  Socket socket;

    // retrieve bytes from Client
    private InputStreamReader readBytes;

    // retrieve string from InputStreamReader
    private BufferedReader readClient;

    // output object as bytes
    private ObjectOutputStream  objectOutput;

    // holds WeatherReader object
    private WeatherReader weatherReader;

    /**
     * Constructor to initialize all instance variables
     * 
     * @param socket
     * @param weatherReader
     * @throws IOException
     */
    public HandleWeatherRequest(Socket socket, WeatherReader weatherReader) throws IOException {
        // set socket connection
        this.socket = socket;

        // read the bytes and assign to readBytes variable
        this.readBytes = new InputStreamReader(socket.getInputStream());

        // read the String from readBytes variable
        this.readClient = new BufferedReader(this.readBytes);

        // establish connection to output Object as bytes
        this.objectOutput = new ObjectOutputStream(socket.getOutputStream());

        // assign weatherReader object
        this.weatherReader = weatherReader;
    }

    /**
     * This method is needed because of the Runnable interface.
     * It retrieves the date from Client and then returns the WeatherObject as bytes back to Client.
     */
    @Override
    public void run() {
        // set up Logger
        Logger log = LoggerFactory.getLogger(HandleWeatherRequest.class);

        try{
            // retrieve String from readClient
            // stops reading at \n
            String ClientArgs = readClient.readLine();

            // output String from readClient
            log.info("Searching details for " + ClientArgs + " at: " + new Date());

            // Retrieve Weather object passing in date as argument
            Weather weather = weatherReader.getWeather(ClientArgs);

            log.info("Sending details to Client at: " + new Date());

            // write the object in the buffer
            objectOutput.writeObject(weather);
            
            // send object as bytes back to Client
            objectOutput.flush();

            // close the socket and other connections tied to socket in this class
            this.socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
