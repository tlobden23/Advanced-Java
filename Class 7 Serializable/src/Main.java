import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Create file object
        File file = new File("Stock.txt");

        // Create Stock object
        Stocks apple = new Stocks("AAPL", 170.12, -4.98, "2.84%");

        // create StockWriter object
        StockWriter write = new StockWriter(file, apple);

        // write to actual file
        write.write();

        System.out.println("Stock is written to " + file);
        System.out.println();

        StockReader read = new StockReader(file);

        Stocks stocks = read.getStock();

        System.out.println("Reading file now...");

        System.out.println(stocks.ticker);
        System.out.println(stocks.currentValue);
        System.out.println(stocks.valueChange);
        System.out.println(stocks.valuePercentChange);
        System.out.println("--------------------");
    }
}

