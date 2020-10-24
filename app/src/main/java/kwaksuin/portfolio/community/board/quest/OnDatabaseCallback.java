package kwaksuin.portfolio.community.board.quest;

import java.util.ArrayList;

public interface OnDatabaseCallback {
    public void insert(String title, String name, String contents);
    public ArrayList<QuestInfo> selectAll();
}
