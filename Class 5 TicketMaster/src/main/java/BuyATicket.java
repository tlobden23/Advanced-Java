public class BuyATicket implements Runnable{
    // instance variable
    private TicketMaster ticketMaster;

    // constructor
    public BuyATicket(TicketMaster ticketMaster){
        this.ticketMaster = ticketMaster;
    }

    @Override
    public void run() {
        System.out.println("Buying a ticket!");
        this.ticketMaster.buyTicket();
    }
}
