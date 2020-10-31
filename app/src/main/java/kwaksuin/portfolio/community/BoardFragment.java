package kwaksuin.portfolio.community;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import kwaksuin.portfolio.community.board.FreeFragment;
import kwaksuin.portfolio.community.board.MarketFragment;
import kwaksuin.portfolio.community.board.photo.PhotoFragment;
import kwaksuin.portfolio.community.board.quest.QuestFragment;


public class BoardFragment extends Fragment  {


    FreeFragment free;      // 자유게시판
    PhotoFragment photo;    // 사진게시판
    QuestFragment quest;    // 질문게시판
    MarketFragment market;  // 장터게시판

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_board,container,false);
        communityTab(rootView);
        Category category = (Category)getActivity();

        return rootView;

    }

    public void communityTab(ViewGroup rootView){         // 각각 상단 탭 화면

        free = new FreeFragment();
        photo = new PhotoFragment();
        quest = new QuestFragment();
        market = new MarketFragment();

        TabLayout tabs = rootView.findViewById(R.id.boardTab);
        tabs.addTab(tabs.newTab().setText("자유게시판"));
        tabs.addTab(tabs.newTab().setText("사진게시판"));
        tabs.addTab(tabs.newTab().setText("질문게시판"));
        tabs.addTab(tabs.newTab().setText("장터게시판"));

        Category category = (Category)getActivity();

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                Fragment selected = null;
                if(position == 0){
                    selected = free;
                }else if(position == 1){
                    selected = photo;
                }else  if(position ==2){
                    selected = quest;
                }else if(position == 3){
                    selected = market;
                }
                category.getSupportFragmentManager().beginTransaction().replace(R.id.board_container,selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}