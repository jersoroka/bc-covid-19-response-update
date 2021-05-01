import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {
    private static List<Update> updates = new ArrayList<>();
    private static final String DATE = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));

    public static void main(String[] args) {

        final String url = "https://www.healthlinkbc.ca/public-health-alerts/most-recent-alerts";

        try {
            final Document document = Jsoup.connect(url).get();

            Elements body = document.select("div.view-content");

            for (Element element: body.select("div div")) {

                // only scrapes alerts that are for COVID-19 and were posted on the current date
                if (element.select("a").text().contains("COVID-19") &&
                        element.select("span").text().equals(DATE)) {
                    final String date = element.select("span").text();
                    final String title = element.select("a").text();
                    final String link = element.select("a").attr("href");

                    updates.add(new Update(title, date, link));
                }
            }

            // prints out to system the updates that meet the criteria for the above conditional
            String updateText = "";
            for (Update update: updates) {
                updateText += (update + "\n");
            }

            EmailSender.sendEmail(updateText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TODO: send text message when a new update is made
    // TODO: have program run everyday at a specific time
}
