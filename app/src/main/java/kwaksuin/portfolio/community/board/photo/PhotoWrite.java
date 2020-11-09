package kwaksuin.portfolio.community.board.photo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import kwaksuin.portfolio.community.R;

public class PhotoWrite extends Fragment {
    Photolist photolist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.photo_write,container,false);

        photolist = new Photolist();
        
        // 올리기 버튼 누르면 게시글 목록으로 이동
        Button button = rootView.findViewById(R.id.photoWrite_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"게시글을 등록하였습니다.",Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.photo_container, photolist).commit();

            }
        });

        return rootView;
    }
}