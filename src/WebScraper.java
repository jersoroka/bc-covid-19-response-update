import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {

    public static void main(String[] args) {

        final String url = "https://www.healthlinkbc.ca/public-health-alerts/most-recent-alerts";

        try {
            final Document document = Jsoup.connect(url).get();
//            System.out.println(document.outerHtml());

            Elements body = document.select("div.view-content");
            // System.out.println(body);
            System.out.println("Size: " + body.select("a").size());

            for (Element element: body.select("a")) {
                System.out.println(element.text());
            }


//            for (Element row : document.select("h4.field-content tr")) {
//                final String ticker = row.select("#text").text();
//                System.out.println("Gap");
//                System.out.println(ticker);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
