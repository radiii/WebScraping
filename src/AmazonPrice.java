import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * AmazonPrice object
 */
public class AmazonPrice {
    private double price;
    private String url;
    private String product;

    public AmazonPrice(String url) {
        this.url = url;
        update();
    }

    private void update() {

        Document doc = null;
        try {
            doc = Jsoup.connect(url).timeout(30000).userAgent("Mozilla/5.0").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element priceElement = doc.getElementById("priceblock_ourprice");
        Element titleElement = doc.getElementById("productTitle");

        price = Double.parseDouble(priceElement.text().replace("$", "\0"));
        product = titleElement.text();
    }

    public double getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public String getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Product: " + product + " || Price: " + price + " || URL: " + url;
    }
}
