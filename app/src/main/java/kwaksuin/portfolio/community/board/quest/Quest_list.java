package kwaksuin.portfolio.community.board.quest;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import kwaksuin.portfolio.community.R;

public class Quest_list extends Fragment {
    Quest_write write;
    private RecyclerView recyclerView;

    private Adapter adapter;
    private List<Quest_board> boardList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.quest_list, container, false);

        write = new Quest_write();

        recyclerView = rootView.findViewById(R.id.recyclerView);
        boardList = new ArrayList<>();
        boardList.add(new Quest_board(null,"중성화 수술은 언제하나요?",null,"android"));
        boardList.add(new Quest_board(null,"치와와 간식 추천해주세요!",null,"android"));
        boardList.add(new Quest_board(null,"다들 옷은 어디서 구매하세요?",null,"android"));
        boardList.add(new Quest_board(null,"수도권 애견카페 추천 해주실 수 있나요?",null,"android"));

        adapter = new Adapter(boardList);
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