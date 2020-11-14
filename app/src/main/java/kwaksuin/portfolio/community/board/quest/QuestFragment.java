package kwaksuin.portfolio.community.board.quest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kwaksuin.portfolio.community.R;

public class QuestFragment extends Fragment {
    QuestWrite write;
    QuestList list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_quest, container, false);

        write = new QuestWrite();
        list = new QuestList();

        // 질문게시판 누르면, quest_list 화면 출력
        getFragmentManager().beginTransaction().replace(R.id.quest_container, list).commit();


        return rootView;
    }
}