public class Bounce implements Runnable{
    private int max;
    // constructor
    public Bounce(int max_value){
        this.max = max_value;
    }

    // run on the threads
    @Override
    public void run() {
        // increase from 0 to max value
        for (int i = 0; i < this.max; i++) {
            System.out.println(i);
        }

        // decrease from max to 0
        for (int i = max; i > 0; i--) {
            System.out.println(i);
        }
    }
}
