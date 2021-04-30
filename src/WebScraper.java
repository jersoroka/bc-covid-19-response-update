import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
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
            // System.out.println("Size: " + body.select("a").size());

            System.out.println("Size: " + body.select("div div").size());
            for (Element element: body.select("div div")) {
                final String date = element.select("span").text();
                final String title = element.select("a").text();
                final String link = element.select("a").attr("href");

                System.out.println(date + ": " + title);
                System.out.println(link);
            }

//            for (Element element: body.select("span")) {
//                System.out.println(element.text());
//            }

//            for (Element element: body.select("a")) {
//                if (element.text().contains("COVID-19")) {
//                    System.out.println(element.text());
//                }
//            }


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
