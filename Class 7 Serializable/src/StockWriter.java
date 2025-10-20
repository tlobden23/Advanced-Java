import java.io.*;

public class StockWriter {
    // instance variable
    private File file;
    private Stocks stock;

    public StockWriter(File file, Stocks stock){
        this.file = file;
        this.stock = stock;
    }

    public void write() throws IOException {
        // those two objects throw IOException
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutputStream);

        objectOutStream.writeObject(stock);

        objectOutStream.close();
    }
}
