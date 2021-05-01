import java.util.Timer;

// represents a class that scrapes the HealthLinkBC "Most Recent Alerts" page for updates
public class Main {

    public static void main(String[] args) {
        WebScraper webScraper = new WebScraper();

        Timer timer = new Timer();
        timer.schedule(webScraper, 10000);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timer.cancel();
    }

    // TODO: have program run everyday at a specific time
}
