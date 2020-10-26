package kwaksuin.portfolio.community.board.quest;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.Inflater;

import kwaksuin.portfolio.community.R;

public class Quest_write extends Fragment {

    EditText questWrite_title;
    EditText questWrite_name;
    EditText questWrite_content;

    OnDatabaseCallback callback;

    /** 현재 오류 부분, context가 QuestFragment로 연결되어야 하는데 Category로 연결됨
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callback = (OnDatabaseCallback)getActivity().getFragmentManager();
    }
    **/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.quest_write, container, false);

        //Context context = inflater.getContext();

        questWrite_title = rootView.findViewById(R.id.questWrite_title);
        questWrite_name =  rootView.findViewById(R.id.questWrite_name);
        questWrite_content = rootView.findViewById(R.id.questWrite_contents);

        Button button = rootView.findViewById(R.id.questWrite_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = questWrite_title.getText().toString();
                String name = questWrite_name.getText().toString();
                String contents = questWrite_content.getText().toString();

                callback.insert(title, name, contents);
                Toast.makeText(getContext(), "게시글을 추가했습니다.", Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }
}