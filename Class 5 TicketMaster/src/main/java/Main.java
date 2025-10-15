import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        // thread pool of 100 threads
        ExecutorService executor = Executors.newFixedThreadPool(100);

        // ticket object with 100 tickets avaiable
        TicketMaster totalTickets = new TicketMaster(100);

        // simulate 100 people trying to buying a ticket
        for (int i = 0; i < 100; i++) {
            // make BuyATicket object and pass in totalTickets (tickets)
            // in totalTickets try to purchase a ticket
            BuyATicket buyTicket = new BuyATicket(totalTickets);

            // send the task to the thread pool to try and purchase
            executor.execute(buyTicket);
        }

        executor.shutdown();

        //  Wait for all tasks to complete;  here we wait a max of 1 minute.
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //  We tried to add 100 pennies.
        //  Does this match the account balance?
        System.out.println("Tickets left:  " + totalTickets.getNumTicketsToSell());
    }
}
