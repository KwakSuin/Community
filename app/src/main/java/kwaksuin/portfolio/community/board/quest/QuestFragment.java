package kwaksuin.portfolio.community.board.quest;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

import java.util.ArrayList;

import kwaksuin.portfolio.community.R;

public class QuestFragment extends Fragment implements OnDatabaseCallback, AutoPermissionsListener {
    private static final String TAG ="QuestFragment";

    public static Object board;
    
    Quest_write write;
    Quest_list list;

    QuestDataBase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_quest,container,false);

        write = new Quest_write();
        list = new Quest_list();

        // 질문게시판 누르면, quest_write 화면 출력
        getFragmentManager().beginTransaction().replace(R.id.quest_container,write).commit();

        TabLayout tabs = rootView.findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("입력"));
        tabs.addTab(tabs.newTab().setText("목록"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("QuestFragment", "선택된 탭 : " + position);

                // 첫 번째 tab 클릭하면 게시글 입력 화면 출력
                Fragment selected = null;
                if (position == 0) {
                    selected = write;

                    // 두 번째 tab 클릭하면 게시글 목록 화면 출력
                } else if (position == 1) {
                    selected = list;
                }

                // tab화면 누를 시 전환
                getFragmentManager().beginTransaction().replace(R.id.quest_container, selected).commit();
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }

        });

        // open database
        if (database != null) {
            database.close();
            database = null;
        }

        database = QuestDataBase.getInstance(getContext());
        boolean isOpen = database.open();
        if (isOpen) {
            Log.d(TAG, "Quest database is open.");
        } else {
            Log.d(TAG, "Quest database is not open.");
        }

        AutoPermissions.Companion.loadAllPermissions(getActivity(), 101);

        return rootView;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[],
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AutoPermissions.Companion.parsePermissions(getActivity(), requestCode, permissions, this);
    }

    //@Override
    public void onDenied(int requestCode, String[] permissions) {
        Toast.makeText(getContext(), "permissions denied : " + permissions.length,
                Toast.LENGTH_LONG).show();
    }

    // @Override
    public void onGranted(int requestCode, String[] permissions) {
        Toast.makeText(getContext(), "permissions granted : " + permissions.length, Toast.LENGTH_LONG).show();
    }


    public void onDestroy() {
        // close database
        if (database != null) {
            database.close();
            database = null;
        }

        super.onDestroy();
    }

    // 게시글 입력 
    @Override
    public void insert(String title, String name, String contents) {
        database.insertRecord(title, name, contents);
        Toast.makeText(getContext(), "게시글을 추가했습니다.", Toast.LENGTH_LONG).show();
    }

    // 게시글 조회
    @Override
    public ArrayList<QuestInfo> selectAll() {
        ArrayList<QuestInfo> result = database.selectAll();
        Toast.makeText(getContext(), "게시글 목록입니다.", Toast.LENGTH_LONG).show();

        return result;
    }

    public Object getData()
    {
        return board;
    }
}