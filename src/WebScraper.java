import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class WebScraper {
    private static List<Update> updates = new ArrayList<>();

    public static void main(String[] args) {

        final String url = "https://www.healthlinkbc.ca/public-health-alerts/most-recent-alerts";

        try {
            final Document document = Jsoup.connect(url).get();

            Elements body = document.select("div.view-content");

            for (Element element: body.select("div div")) {
                if (element.select("a").text().contains("COVID-19")) {
                    final String date = element.select("span").text();
                    final String title = element.select("a").text();
                    final String link = element.select("a").attr("href");

                    updates.add(new Update(title, date, link));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TODO: send text message when a new update is made
    // TODO: have program run everyday at a specific time
    // TODO: parse for updates that happened on the same day
}
