import java.io.Serializable;

public class Stocks implements Serializable {
    String ticker, valuePercentChange;
    double currentValue, valueChange;


    public Stocks(String ticker, double currentValue, double valueChange,String valuePercentChange){
        this.ticker = ticker;
        this.currentValue = currentValue;
        this.valueChange = valueChange;
        this.valuePercentChange = valuePercentChange;
    }
}
