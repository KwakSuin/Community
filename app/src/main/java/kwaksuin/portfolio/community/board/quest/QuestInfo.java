package kwaksuin.portfolio.community.board.quest;

class QuestInfo {
    String title;
    String name;
    String contents;

    public QuestInfo(String title, String name, String contents) {
        this.title = title;
        this.name = name;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.name = title;
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

    @Override
    public String toString() {
        return "QuestInfo{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
