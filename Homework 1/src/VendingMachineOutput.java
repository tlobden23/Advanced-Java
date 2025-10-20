/**
 * keeps the product object and the change to be outputted when called by variables
 * result of successful transaction
 */
public class VendingMachineOutput {

    // instance variables
    // public because the main method calls VendingMachineOutput variables example: output.change
    public Product product;
    public double change;

    /**
     * constructor for VendingMachineOutput
     *
     * @param product object of Product
     * @param change  change returned
     */
    public VendingMachineOutput(Product product, double change) {
        this.product = product;
        this.change = change;
    }
}

