package kwaksuin.portfolio.community.board.quest;

class Quest_board {
    private String review;
    private String title;
    private String contents;
    private String name;

    public Quest_board(){

    }

    public Quest_board(String review, String title, String contents, String name) {
        this.review = review;
        this.title = title;
        this.contents = contents;
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Quest_board{" +
                "review='" + review + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
