package kwaksuin.portfolio.community.board.photo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import kwaksuin.portfolio.community.R;

public class PhotoFragment extends Fragment {

    RecyclerView recyclerView;
    PhotoAdapter adapter;

    private int doubleClick = 0;
    private final long CLICK_DELAY = 250;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_photo,container,false);

        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.photo_item,container,false);

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

                    /** 좋아요 수 같이 출력 하기
                    Toast.makeText(getContext(), "좋아요 수 : " + item.getCount(), Toast.LENGTH_LONG).show();
                     **/
                }
            }
        });

        return rootView;
    }

}