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
    FreeList freeList;
    PhotoList photoList;
    QuestList questList;
    // 장터게시판

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_home,container,false);


        freeList = new FreeList();
        photoList = new PhotoList();
        questList = new QuestList();

        /** 게시판 이름 누르면 해당 게시판으로 이동 **/

        // 자유게시판
        TextView freeButton = rootView.findViewById(R.id.freeButton);
        freeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"자유게시판",Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.free_container, freeList).commit();
            }
        });

        // 사진게시판
        TextView photoButton = rootView.findViewById(R.id.photoButton);
        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"사진게시판",Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.photo_container, photoList).commit();
            }
        });

        TextView questButton = rootView.findViewById(R.id.questButton);
        questButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"질문게시판",Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.quest_container, questList).commit();
            }
        });

        return rootView;

    }

}