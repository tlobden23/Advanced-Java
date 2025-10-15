/**
 * parent class for Snack and Drink that sets productNames
 */
public abstract class Product {
    // instance variables
    private String productName;

    /**
     * set productName to object variable's productName
     * example: setting object Drink's productName to Diet Coke
     *
     * @param productName sets parameter productName to object's productName variable
     */
    public Product(String productName) {
        // check if productName is empty
        if (!productName.isEmpty()) {
            // set instance variable name to parameter productName
            this.productName = productName;
        } else {
            // throw illegal argument exception if productName is empty
            throw new IllegalArgumentException("Product Name can't be empty.");
        }
    }

    /**
     * abstract method for child classes like Drink and Snack to be overridden
     */
    public abstract void consume();

    /**
     * @return productName returns the productName because productName is private
     */
    public String getProductName() {
        return productName;
    }
}
