/**
 * Drink class that extends Product and overrides consume abstract method
 */
public class Drink extends Product {

    /**
     * calls Product's constructor and names the drink
     *
     * @param drink example: Diet Coke
     */
    public Drink(String drink) {
        // call Product constructor
        super(drink);
    }

    /**
     * consumes the drink
     */
    @Override
    public void consume() {
        // output to terminal
        System.out.println("Yum, you drink the " + this.getProductName() + ".");
    }
}
