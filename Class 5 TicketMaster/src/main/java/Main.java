import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(100);

        TicketMaster totalTickets = new TicketMaster(100);

        for (int i = 0; i < 100; i++) {
            BuyATicket buyTicket = new BuyATicket(totalTickets);
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
