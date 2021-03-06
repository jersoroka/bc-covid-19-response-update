// represents a class containing information about an update
public class Update {
    private String title;
    private String date;
    private String url;

    public Update(String title, String date, String url) {
        this.title = title;
        this.date = date;
        this.url = url;
    }

    @Override
    public String toString() {
        return date + ": " + title + "\n" + url;
    }
}
