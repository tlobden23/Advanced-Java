import java.io.*;
import java.util.ArrayList;

public class StockReader {
    private Stocks stock;

    public StockReader(File file) throws IOException, ClassNotFoundException {
        //  Create the IO Classes
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        this.stock = (Stocks) objectInputStream.readObject();

        objectInputStream.close();
    }

    public Stocks getStock() {
        return this.stock;
    }
}
