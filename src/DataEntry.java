/**
 * Created by 18melan on 5/11/16.
 */
public class DataEntry {
    private double price;
    private String amazonURL;

    public DataEntry(double price, String amazonURL) {
        this.price = price;
        this.amazonURL = amazonURL;
    }

    public double getPrice() {
        return price;
    }

    public String getAmazonURL() {
        return amazonURL;
    }
}
