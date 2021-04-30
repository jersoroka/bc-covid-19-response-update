import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {

    public static void main(String[] args) {

        final String url = "https://www.healthlinkbc.ca/public-health-alerts/most-recent-alerts";

        try {
            final Document document = Jsoup.connect(url).get();

            Elements body = document.select("div.view-content");

            System.out.println("Size: " + body.select("div div").size());
            for (Element element: body.select("div div")) {
                final String date = element.select("span").text();
                final String title = element.select("a").text();
                final String link = element.select("a").attr("href");

                System.out.println(date + ": " + title);
                System.out.println(link);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
