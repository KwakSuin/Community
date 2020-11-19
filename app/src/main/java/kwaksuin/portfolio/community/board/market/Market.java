package kwaksuin.portfolio.community.board.market;

public class Market {
    String title;
    String contents;
    String local;
    int count;
    int images;

    public Market() {

    }
    public Market(String title, String contents, String local, int count, int images) {
        this.title = title;
        this.contents = contents;
        this.local = local;
        this.count = count;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
