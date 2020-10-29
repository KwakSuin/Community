package kwaksuin.portfolio.community.board.quest;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import kwaksuin.portfolio.community.R;

public class Quest_list extends Fragment {

    RecyclerView recyclerView;
    QuestAdapter adapter;

    OnDatabaseCallback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(getActivity() != null && getActivity() instanceof OnDatabaseCallback) {
            callback = ((OnDatabaseCallback) getActivity());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.quest_list, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new QuestAdapter();
        recyclerView.setAdapter(adapter);

        ArrayList<QuestInfo> result = callback.selectAll();
        adapter.setItems(result);

        adapter.setOnItemClickListener(new OnQuestClickListener() {
            @Override
            public void onQuestClick(QuestAdapter.ViewHolder holder, View view, int position) {
                QuestInfo item = adapter.getItem(position);

                Toast.makeText(getContext(), "게시글 선택됨 : " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });

        Button button = rootView.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 현재 오류 : callback = null
                ArrayList<QuestInfo> result = callback.selectAll();
                adapter.setItems(result);
                adapter.notifyDataSetChanged();
            }
        });

        return rootView;
    }
}