package bhcc.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class creates a thread pool and then assigns a task for each thread.
 * Kind of like load balancer, where it assigns tasks for each thread, but not the same as load balancer.
 *
 */
public class WeatherServerPool{

    // create static final variable for number of threads
    private static final int DEFAULT_NUM_THREADS = 4;

    /**
     * This main method controls creating thread pool and assigning a task to thread to retrieve data from Server.
     * Kind of like load balancer concept, but not the same as load balancer.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // create Logger variable
        Logger logger = LoggerFactory.getLogger(WeatherServerPool.class);

        // show when the server is starting
        logger.info("Starting server at: " + new Date());

        // create ServerSocket
        ServerSocket serverSocket = new ServerSocket(8000);

        // Create thread pool of 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(DEFAULT_NUM_THREADS);

        // hold file path
        File file = new File("src/main/resources/seattle-weather.csv");

        // Create WeatherReader object one time to hold the hashMap for the dates
        // instead of just recalling WeatherReader in HandleWeatherRequest whenever a new Object is made
        WeatherReader weatherReader = new WeatherReader(file);

        // run Server forever
        while (true) {
            // wait for socket to receive something
            Socket socket = serverSocket.accept();

            // once serverSocket receives something then pass the socket and also weatherReader object
            HandleWeatherRequest weatherRequest = new HandleWeatherRequest(socket, weatherReader);

            // start the thread
            executor.execute(weatherRequest);
        }
    }
}
