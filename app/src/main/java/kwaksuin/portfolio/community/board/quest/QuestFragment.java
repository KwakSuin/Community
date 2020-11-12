package kwaksuin.portfolio.community.board.quest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

import java.util.ArrayList;

import kwaksuin.portfolio.community.R;

public class QuestFragment extends Fragment {

    private static final String TAG = "QuestFragment";


    Quest_write write;
    Quest_list list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_quest, container, false);

        write = new Quest_write();
        list = new Quest_list();

        // 질문게시판 누르면, quest_list 화면 출력
        getFragmentManager().beginTransaction().replace(R.id.quest_container, list).commit();


        return rootView;
    }
}