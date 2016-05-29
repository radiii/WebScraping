import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 18melan on 5/11/16.
 */
public class AmazonSearch {
    private String url;
    private ArrayList<DataEntry> data;

    public AmazonSearch(String search) {
        data = new ArrayList<DataEntry>();


        this.url = "http://www.amazon.com/s/?url=search-alias%3Daps&field-keywords=";

        String [] words = search.split(" ");
        for(String e : words)
            url+=(e+"+");

        update();
    }

    private void update() {
        data.clear();
        Document doc = null;

        try {
            doc = Jsoup.connect(url).timeout(30000).userAgent("Mozilla/5.0").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements partsDataTable = doc.getElementsByClass("s-result-item celwidget s-hidden-sponsored-item");

        System.out.println(partsDataTable.get(0));
        for(Element e : partsDataTable) {

        }







        //Elements rows = partsDataTable.select("tr");



        /*
        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");

        }
        */







    }




}
