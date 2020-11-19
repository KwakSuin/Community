package kwaksuin.portfolio.community;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import kwaksuin.portfolio.community.board.free.FreeList;
import kwaksuin.portfolio.community.board.photo.PhotoList;
import kwaksuin.portfolio.community.board.quest.QuestList;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_home,container,false);


        /** 게시판 이름 누르면 해당 게시판으로 이동 **/


        return rootView;

    }

}