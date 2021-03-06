package kwaksuin.portfolio.community.board.free;

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

public class FreeList extends Fragment {
    
    private FreeWrite write;
    private RecyclerView recyclerView;

    private FreeAdapter adapter;
    private List<FreeBoard> boardList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.free_list, container, false);

        write = new FreeWrite();

        recyclerView = rootView.findViewById(R.id.recyclerView);
        boardList = new ArrayList<>();
        // 제목, 이름, 내용, 댓글 수
        boardList.add(new FreeBoard("안녕하세요!","천사","반갑습니당","0"));
        boardList.add(new FreeBoard("가입했어용!","여자","친하게 지내요!","6"));
        boardList.add(new FreeBoard("다들 강아지 이름 뭔가용?","장군이엄마","제 강아지 이름은 장군이에요","2"));
        boardList.add(new FreeBoard("심심해요","소년","심심하네요","1"));

        adapter = new FreeAdapter(boardList);
        recyclerView.setAdapter(adapter);

        FloatingActionButton floatingActionButton = rootView.findViewById(R.id.floatingButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.free_container, write).commit();
            }
        });
        return rootView;
    }
}