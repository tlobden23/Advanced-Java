/**
 * Truck class mimics Amazon trucks at Amazon warehouse.
 * A truck's name is unique ("T1") and then tries to take 20 packages from the loading dock.
 */
public class Truck implements Runnable {

    // instance variables
    private String name;
    private static int count;
    private LoadingDock loadingDock;

    /**
     * increases the count which is the suffix of the name
     *
     * @return count
     */
    private static synchronized int nameIncrement() {
        return ++count;
    }

    /**
     * constructor to construct the name for the truck
     */
    public Truck(LoadingDock dock) {
        this.name = "T" + nameIncrement();
        this.loadingDock = dock;
    }

    /**
     * returns the name for the truck
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * tries to take 20 packages from the loading dock and then sleeps for a second
     */
    @Override
    public void run() {
        // run forever (mimic real life Amazon warehouse)
        while (true) {
            // take 20 packages from the loading dock
            loadingDock.takePackages(getName(), 20);

            // try to sleep the Thread for a second
            try {
                // sleep the thread for a second
                Thread.sleep(1000);
            }
            // catch any exception thrown by Thread.sleep()
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
