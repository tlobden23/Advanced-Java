/**
 * Snack class that extends Product and overrides consume abstract method and creates a Snack object
 */
public class Snack extends Product {

    /**
     * @param snack example: Cliff Bar
     */
    public Snack(String snack) {
        // call Product constructor
        super(snack);
    }

    /**
     * consumes the snack
     */
    @Override
    public void consume() {
        // output to terminal
        System.out.println("Yum, you eat the " + this.getProductName() + ".");
    }

    /**
     * creates a snack object
     *
     * @param name name of the snack
     * @return Snack object
     */
    public static Snack createSnack(String name) {
        // return a Snack object
        // called by main (.createSnack())
        return new Snack(name);
    }
}
