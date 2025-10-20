import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LoadingDock class mimics Amazon loading docks.
 * Add packages and then signals the truck to try to take packages if it's more than or equal to 20.
 */
public class LoadingDock {
    // instance variables
    private int total;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * returns the total packages
     *
     * @return total
     */
    public int getTotal() {
        return total;
    }

    /**
     * add the packages from each robot and then signal the Threads waiting in takePackages().
     *
     * @param robotName
     * @param numPackagesToAdd
     */
    public void addPackages(String robotName, int numPackagesToAdd) {
        // lock the method
        lock.lock();

        // try to add packages and signal the Threads to wakeup in takePackages()
        try {
            // add the packages to the total
            this.total += numPackagesToAdd;

            System.out.printf("[Robot %s] Added %d packages. Total = %d%n", robotName, numPackagesToAdd, getTotal());

            // wake up Threads in takePackages()
            condition.signalAll();
        } finally {
            // unlock the lock so the next Thread can access this method
            lock.unlock();
        }
    }

    /**
     * tries to take packages
     * Threads wait if total is less than numPackagesToTake for the robots to add more packages
     *
     * @param truckName
     * @param numPackagesToTake
     */
    public void takePackages(String truckName, int numPackagesToTake) {
        // lock the method
        lock.lock();

        // try to take numPackagesToTake from total
        try {
            // run forever until numPackagesToTake is more than total
            while (getTotal() < numPackagesToTake) {
                System.out.printf("[Truck %s] is waiting for %d packages, but there are only: %d%n",
                        truckName, numPackagesToTake, getTotal());
                // Threads wait until robots signal to wakeup and then check again if numPackagesToTake is greater than total
                condition.await();
            }

            // subtract numPackagesToTake (20) from the total
            total -= numPackagesToTake;
            System.out.printf("[Truck %s] is departing with %d packages.%n", truckName, numPackagesToTake);
        }
        // catch any exceptions when threads are await
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // unlock the lock so the next Thread can access this method
            lock.unlock();
        }
    }
}
