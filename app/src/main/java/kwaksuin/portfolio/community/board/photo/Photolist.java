package kwaksuin.portfolio.community.board.photo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import kwaksuin.portfolio.community.R;
public class Photolist extends Fragment {
    PhotoWrite photowrite;

    RecyclerView recyclerView;
    PhotoAdapter adapter;

    private int doubleClick = 0;
    private final long CLICK_DELAY = 250;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.photo_list,container,false);

        recyclerView = rootView.findViewById(R.id.recyclerView);

        // 한 눈에 보기 좋도록 1차원 grid 사용
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PhotoAdapter();

        adapter.addItem(new Photo("모모와 코코", "2020-01-01", 7,  R.drawable.dog));
        adapter.addItem(new Photo("안녕하세요", "2020-02-02", 19,  R.drawable.dog02));
        adapter.addItem(new Photo("우리집 강아지", "2020-03-03", 16,  R.drawable.dog03));
        adapter.addItem(new Photo("귀엽죠", "2020-04-04", 16, R.drawable.dog04));

        // 리사이클에 adapter 기능 넣기
        recyclerView.setAdapter(adapter);

        // 인스타그램 더블 클릭 구현
        adapter.setOnItemClickListener(new OnPhotoClickListener() {
            @Override
            public void onItemClick(PhotoAdapter.ViewHolder holder, View view, int position) {
                doubleClick++;
                Handler handler = new Handler();
                Runnable clickRunnable = new Runnable() {
                    // 한 번 클릭
                    @Override
                    public void run() {
                        doubleClick = 0;
                    }
                };

                if(doubleClick == 1){
                    handler.postDelayed(clickRunnable,CLICK_DELAY);
                }else if(doubleClick ==2 ){
                    // 더블 클릭
                    doubleClick=0;
                    Photo item = (Photo) adapter.getItem(position);
                    Toast.makeText(getContext(),"좋아요!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        photowrite = new PhotoWrite();
        // 사진게시판 글쓰기 버튼
        FloatingActionButton floatingActionButton = rootView.findViewById(R.id.floatingButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 글쓰기 화면 이동
                //getFragmentManager().beginTransaction().replace(R.id.컨테이너, photowrite).commit();
            }
        });

        return rootView;
    }
}