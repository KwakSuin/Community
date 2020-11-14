package kwaksuin.portfolio.community.board.quest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import kwaksuin.portfolio.community.R;

public class Quest_list extends Fragment {
    Quest_write write;
    private RecyclerView recyclerView;

    private QuestAdapter adapter;
    private List<Quest_board> boardList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.quest_list, container, false);

        write = new Quest_write();

        recyclerView = rootView.findViewById(R.id.recyclerView);
        boardList = new ArrayList<>();
        boardList.add(new Quest_board("3","중성화 수술은 언제하나요?","언제하나요?","모모주인"));
        boardList.add(new Quest_board("0","치와와 간식 추천해주세요!","추천해주세요!","복희"));
        boardList.add(new Quest_board("5","다들 옷은 어디서 구매하세요?","1살된 강아지 옷이요!","장군"));
        boardList.add(new Quest_board("8","수도권 애견카페 추천 해주실 수 있나요?","서울, 경기 쪽이요!","소녀"));

        adapter = new QuestAdapter(boardList);
        recyclerView.setAdapter(adapter);

        FloatingActionButton floatingActionButton = rootView.findViewById(R.id.floatingButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.quest_container, write).commit();
            }
        });

        return rootView;
    }
}