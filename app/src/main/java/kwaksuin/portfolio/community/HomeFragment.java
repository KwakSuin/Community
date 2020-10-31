package kwaksuin.portfolio.community;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kwaksuin.portfolio.community.board.FreeFragment;
import kwaksuin.portfolio.community.board.MarketFragment;
import kwaksuin.portfolio.community.board.photo.PhotoFragment;
import kwaksuin.portfolio.community.board.quest.QuestFragment;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_home,container,false);


        /** 게시판 이름 누르면 해당 게시판으로 이동 **/


        return rootView;

    }

}