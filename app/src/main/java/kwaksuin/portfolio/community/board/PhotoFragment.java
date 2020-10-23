package kwaksuin.portfolio.community.board;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import kwaksuin.portfolio.community.R;

public class PhotoFragment extends Fragment {

    RecyclerView recyclerView;
    PhotoAdapter adapter;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo,container,false);

        recyclerView = view.findViewById(R.id.recyclerView);

        // 한 눈에 보기 좋도록 1차원 grid 사용
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PhotoAdapter();

        adapter.addItem(new Photo("안녕하세요", "2020-01-01", 7,  R.drawable.dog));
        adapter.addItem(new Photo("모모와 코코", "2020-02-02", 19,  R.drawable.dog02));
        adapter.addItem(new Photo("우리집 강아지", "2020-03-03", 16,  R.drawable.dog03));
        adapter.addItem(new Photo("귀여워", "2020-04-04", 16, R.drawable.dog04));

        // 리사이클에 adapter 기능 넣기
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnPhotoClickListener() {
            @Override
            public void onItemClick(PhotoAdapter.ViewHolder holder, View view, int position) {
                Photo item = (Photo) adapter.getItem(position);
                Toast.makeText(getContext(), "좋아요 수 : " + item.getCount(), Toast.LENGTH_LONG).show();

            }
        });

        return view;
    }

}