// libraries needed for thread pool
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        // create a fixed thread pool of only 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 1000; i++) {
            // random int value
            int randomVal = (int) (Math.random() * 100 + 1);

            // create bounce runnable object
            Runnable bounce = new Bounce(randomVal);

            // pass in bounce object into thread pool
            executor.execute(bounce);
        }

        // shutdown the thread pool
        executor.shutdown();

        // catch any lurking threads and then wait 1 minute and then after shutdown
        try{
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
