import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Mimics Amazon warehouse with 5 workers (2 Trucks and 3 Robots)
 */
public class Main {
    public static void main(String[] args) {
        // LoadingDock object to mimic a loading dock
        // shared resource between Robot and Truck
        LoadingDock loading = new LoadingDock();

        // creates thread pool of 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        System.out.println("Welcome to Amazon.com!");

        // 3 threads mimicking Robots
        executor.execute(new Robot(loading));
        executor.execute(new Robot(loading));
        executor.execute(new Robot(loading));

        // 2 threads mimicking Truck
        executor.execute(new Truck(loading));
        executor.execute(new Truck(loading));

        // shut down the thread pool
        executor.shutdown();
    }
}