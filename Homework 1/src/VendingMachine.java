import java.util.*;

/**
 * represents a vending machine that manages stocking, purchasing, retrieving the items in stock, and
 * outputting total sales done.
 */
public class VendingMachine {

    // productMap which maps the location to stack of Product type
    private Map<String, Stack<Product>> productMap = new HashMap<>();

    // priceMap which maps the location to price of each stack
    private Map<String, Double> priceMap = new HashMap<>();

    // totalSales which is static and holds how much money have been made by the vending machine
    private static double totalSales;

    /**
     * checks if any of the arguments are invalid and then adds to two hash maps (productMap, priceMap),
     * the key being the location and value being the Product stack or unit price
     *
     * @param location    example: 'A1'
     * @param productList stack of Product type, it's a collection
     * @param unitPrice   example: '1.75'
     */
    public void stockItems(String location, Stack<Product> productList, double unitPrice) {
        // check if location is valid
        if (location == null || location.isEmpty()) {
            // throw exception if location is empty
            throw new IllegalArgumentException("Location (string) is empty.");
            // check if location is already in productMap or priceMap
        } else if (productMap.containsKey(location) && priceMap.containsKey(location)) {
            // throw exception if location in hash map already
            throw new IllegalArgumentException("Location " + location + " is already taken by " + productMap.get(location).getFirst().getProductName());
            // check if stack is empty or null from the parameter
        } else if (productList.isEmpty()) {
            // throw exception if parameter stack from main method is empty
            throw new IllegalArgumentException("Product (stack) is empty.");
            // check if unitPrice is valid
        } else if (unitPrice <= 0) {
            // throw exception if unit price is lower or equal to 0
            throw new IllegalArgumentException("Unit Price (double) has to be greater than 0.");
        } else {
            // if all the parameters are valid then add to hash maps
            // productMap mapping is location to productList stack
            productMap.put(location, productList);
            // priceMap mapping is location to unitPrice
            priceMap.put(location, unitPrice);
        }
    }

    /**
     * print inventory inside vending machine
     */
    public void printInventory() {
        // go through each key in productMap
        for (String i : this.productMap.keySet()) {
            // print the key, example = 'A1'
            System.out.println(i);
            // use the key (location) to get the value in productMap and output every value (Product) in the stack
            for (Product j : this.productMap.get(i)) {
                // j every Product type in the stack
                System.out.println(" - " + j.getProductName());
            }
        }
    }

    /**
     * returns the total sales done by the vending machine
     *
     * @return totalSales total money made
     */
    public double getTotalSales() {
        // return static totalSales variable
        return totalSales;
    }

    /**
     * tries to purchase a product by passing in location and then how much money
     * output what was purchased and also the change returned if all the parameters were valid
     *
     * @param location example: 'A1'
     * @param amount   example: '1.75'
     */
    public VendingMachineOutput purchase(String location, double amount) {
        // check if location is valid
        if (location == null || location.isEmpty()) {
            // throw exception if location isn't valid
            throw new IllegalArgumentException("Location (" + location + ") is invalid.");
        }

        // retrieve the price and stack from hash map using location as the key
        Double price = priceMap.get(location);
        Stack<Product> stack = productMap.get(location);

        // double check if price and stack are empty
        // just to double check that when stocking the items, the price wasn't stock empty
        if (price == null || stack == null) {
            // throw exception if the price or stack was empty
            throw new IllegalArgumentException("Invalid slot location: " + location);
        }
        // check if the price of the product is more than what was used to purchase
        else if (amount < price) {
            // throw exception if amount wasn't enough to purchase
            throw new IllegalArgumentException(amount + " is less than product price (" + price + ").");
        }
        // double check if stack is empty
        // just to double check that when stocking the items, the stack wasn't stocked empty
        else if (stack.isEmpty()) {
            // throw exception if no more product in stack
            throw new EmptyStackException();
        }

        // pop and save value and store it in variable of Product type to later pass into VendingMachineOutput
        Product product = stack.pop();
        // add price of the product to totalSales static variable
        totalSales += price;
        // calculate the change
        double change = amount - price;

        // create VendingMachineOutput object which will display what was retrieved from the vending machine and change
        return new VendingMachineOutput(product, change);
    }
}
