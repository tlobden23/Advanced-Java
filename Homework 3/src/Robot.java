/**
 * Robot class mimics a robot at Amazon.
 * A robot's name is unique ("R1") and then adds packages to the loading dock.
 */
public class Robot implements Runnable {

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
     * constructor to construct the name for the robot
     */
    public Robot(LoadingDock dock) {
        this.name = "R" + nameIncrement();
        this.loadingDock = dock;
    }

    /**
     * returns the name for the robot
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * adds packages (1-3 packages) to the loading dock and then sleeps for a second
     */
    @Override
    public void run() {

        // run forever (mimic real life Amazon warehouse)
        while (true) {
            // create a random number from 1-3
            int randomPackages = (int) (Math.random() * 3 + 1);

            // add the packages to loading dock
            loadingDock.addPackages(getName(), randomPackages);

            // try to sleep the Thread for 1 second
            try {
                // sleep the thread for 1 second
                Thread.sleep(1000);
            }// catch any exception thrown by Thread.sleep()
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
