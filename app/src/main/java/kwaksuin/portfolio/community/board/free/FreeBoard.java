package kwaksuin.portfolio.community.board.free;

class FreeBoard {
    private String title;
    private String name;
    private String contents;
    private String review;

    public FreeBoard(){

    }

    public FreeBoard(String title, String name, String contents, String review) {
        this.title = title;
        this.name = name;
        this.contents = contents;
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }


    @Override
    public String toString() {
        return "Free_board{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", contents='" + contents + '\'' +
                ", review='" + review + '\'' +
                '}';
    }
}
