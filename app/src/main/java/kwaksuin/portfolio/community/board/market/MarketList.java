package kwaksuin.portfolio.community.board.market;

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

public class MarketList extends Fragment {

    MarketWrite marketwrite;

    RecyclerView recyclerView;
    MarketAdapter adapter;

    private int scrap = 0;
    private final long CLICK_DELAY = 250;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.market_list,container,false);

        recyclerView = rootView.findViewById(R.id.recyclerView);

        // 한 눈에 보기 좋도록 1차원 grid 사용
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MarketAdapter();

        // title, contents, local, count, images
        adapter.addItem(new Market("배변패드 판매", "탐사 베이직 배변패드","경기도 의정부시", 7,  R.drawable.dog));
        adapter.addItem(new Market("간식 팔아용", "굿데이 건강한육포 반려견간식 대용량 300g","서울시 강남구", 19,  R.drawable.dog02));
        adapter.addItem(new Market("사료 남는거 팔아요!", "탐사 6free 강아지 사료 양고기 레시피","서울시 송파구", 16,  R.drawable.dog03));
        adapter.addItem(new Market("구매했는데 안써서 팔아요ㅠㅠ", "도그아이 애견용 바베큐 봉제 장난감","강원도 강릉시", 16, R.drawable.dog04));

        // 리사이클에 adapter 기능 넣기
        recyclerView.setAdapter(adapter);

        // 찜하기 구현
        adapter.setOnItemClickListener(new OnMarketClickListener() {
            @Override
            public void onItemClick(MarketAdapter.ViewHolder holder, View view, int position) {
                scrap++;
                Handler handler = new Handler();
                Runnable clickRunnable = new Runnable() {
                    // 한 번 클릭
                    @Override
                    public void run() {
                        scrap = 0;
                    }
                };

                if(scrap == 1){
                    handler.postDelayed(clickRunnable,CLICK_DELAY);
                }else if(scrap ==2 ){
                    // 더블 클릭
                    scrap =0;
                    Market item = (Market) adapter.getItem(position);
                    Toast.makeText(getContext(),"찜",Toast.LENGTH_SHORT).show();
                }
            }
        });

        marketwrite = new MarketWrite();
        // 장터게시판 글쓰기 버튼
        FloatingActionButton floatingActionButton = rootView.findViewById(R.id.floatingButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 글쓰기 화면 이동
                getFragmentManager().beginTransaction().replace(R.id.market_container, marketwrite).commit();
            }
        });

        return rootView;
    }
}