package kwaksuin.portfolio.community.board.quest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import kwaksuin.portfolio.community.R;

public class QuestWrite extends Fragment {
    private FirebaseFirestore store = FirebaseFirestore.getInstance();

    EditText questWrite_title;
    EditText questWrite_name;
    EditText questWrite_content;

    QuestList list;
    QuestWrite write;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.quest_write, container, false);

        questWrite_title = rootView.findViewById(R.id.questWrite_title);
        questWrite_content = rootView.findViewById(R.id.questWrite_contents);
        //questWrite_name = rootView.findViewById(R.id.quest_name);

        list = new QuestList();
        write = new QuestWrite();


        Button button = rootView.findViewById(R.id.questWrite_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String title = questWrite_title.getText().toString();
                //String contents = questWrite_content.getText().toString();

                Map<String, Object> post = new HashMap<>();
                post.put("title",questWrite_title.getText().toString());
                post.put("contents",questWrite_content.getText().toString());

                store.collection("QuestBoard").add(post)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference pDocumentReference) {
                                Toast.makeText(getContext(),"업로드 성공",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception pE) {
                                Toast.makeText(getContext(),"업로드 실패",Toast.LENGTH_SHORT).show();
                            }
                        });


                //Toast.makeText(getContext(), "게시글을 추가했습니다.", Toast.LENGTH_LONG).show();

                // 게시글 추가 후, 목록으로 이동
                getFragmentManager().beginTransaction().replace(R.id.quest_container, list).commit();
            }
        });

        return rootView;
    }
}