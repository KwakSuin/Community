package kwaksuin.portfolio.community.board.free;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kwaksuin.portfolio.community.R;

public class FreeFragment extends Fragment {
    Free_list list;
    Free_write write;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_free, container, false);

        write = new Free_write();
        list = new Free_list();

        // 자유게시판 누르면, Free_list 화면 출력
        getFragmentManager().beginTransaction().replace(R.id.free_container, list).commit();


        return rootView;
    }
}