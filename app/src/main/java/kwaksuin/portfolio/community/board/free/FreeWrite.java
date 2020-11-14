package kwaksuin.portfolio.community.board.free;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import kwaksuin.portfolio.community.R;


public class FreeWrite extends Fragment {
    FreeList list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.free_write, container, false);

        list = new FreeList();

        // 게시글 올리기 버튼
        Button freeWrite = rootView.findViewById(R.id.freeWrite_button);
        freeWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 게시글 작성 후, 목록으로 이동
                Toast.makeText(getContext(),"게시글을 등록하였습니다.",Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.free_container, list).commit();
            }
        });

        return rootView;
    }
}