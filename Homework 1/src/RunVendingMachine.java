import java.util.*;

/**
 * Run the Vending Machine.
 */
public class RunVendingMachine {

    /**
     * Illustrates the Vending Machine.
     */
    public static void main(String[] args) {
        // Create a Vending Machine.
        VendingMachine machine = new VendingMachine();

        // Stock up of Diet Cokes
        Stack<Product> dietCokeStack = new Stack<>();
        // Stock up of Cliff Bars
        Stack<Product> cliffBarStack = new Stack<>();

        // try to stock Products into Vending Machine
        try {
            // add 5 Diet Coke to dietCokeStack
            for (int i = 0; i < 5; i++) {
                // drink extends Product so a Drink object can be stored as Product
                // creating Drink object
                Drink dietCoke = new Drink("Diet Coke");
                // adding to dietCokeStack
                dietCokeStack.push(dietCoke);
            }

            // add 3 Cliff Bar to cliffBarStack
            for (int i = 0; i < 3; i++) {
                // creating Snack object
                // calls .createSnack() which returns Snack object
                Snack cliffBar = Snack.createSnack("Cliff Bar");
                // adding to cliffBarStack
                cliffBarStack.push(cliffBar);
            }

            // try to stock the product into the VendingMachine
            // call stockItems method in VendingMachine class
            machine.stockItems("A1", dietCokeStack, 1.25);
            machine.stockItems("B1", cliffBarStack, 4.00);
        }
        // catch IllegalArgumentException thrown when trying to create new Drink object with blank name
        catch (IllegalArgumentException iae) {
            System.out.println("Error: " + iae.getMessage());
        }

        // output what is available in the Vending Machine
        machine.printInventory();

        //  try to purchase a Product and consume Product
        try {
            // return a VendingMachineOutput type that holds change and Product object that has the productName
            VendingMachineOutput output = machine.purchase("A1", 2.00);
            // output(VendingMachineOutput) holds Product object that holds productName
            System.out.println("Got:  " + output.product.getProductName());
            // retrieve change variable
            System.out.println("Received change:  " + output.change);
            // output consume method
            output.product.consume();
            // output total sales done so far
            System.out.println("Total Sales:  " + machine.getTotalSales());


            //  try to purchase and eat a cliff bar
            // return a VendingMachineOutput type that holds change and Product object that has the productName
            output = machine.purchase("B1", 5.00);
            // output(VendingMachineOutput) holds product object that holds productName
            System.out.println("Got:  " + output.product.getProductName());
            // retrieve change variable
            System.out.println("Received change:  " + output.change);
            // output consume method
            output.product.consume();
            // output total sales done so far
            System.out.println("Total Sales:  " + machine.getTotalSales());

        }
        // catch error if the location doesn't have no more Products
        catch (EmptyStackException ese) {
            System.out.println("Error: out of stock.");
        }
        // catch error if location is empty or null or if the location isn't valid or
        // if the amount is less than the price of product
        catch (IllegalArgumentException iae) {
            System.out.println("Error: " + iae.getMessage());
        }
    }
}



