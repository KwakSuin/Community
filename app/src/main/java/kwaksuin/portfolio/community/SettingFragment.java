package kwaksuin.portfolio.community;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SettingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingFragment() {
        // Required empty public constructor
    }

    public static SettingFragment newInstance(String param1, String param2) {
        SettingFragment fragment = new SettingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_setting, container, false);

        TextView logout = rootView.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Login.class);
                Toast.makeText(getContext(),"로그아웃 했습니다.",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        TextView dropId = rootView.findViewById(R.id.drop_Id);
        dropId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });
        return rootView;
    }

    // 탈퇴 확인 박스 띄우기
    private void request(){
        String title = "주의";
        String message = "탈퇴 하시겠습니까?";
        String buttonYES = "예";
        String buttonNO = "돌아가기";

        AlertDialog dialog = makeRequestDialog(title, message, buttonYES, buttonNO);
        dialog.show();
    }

    private AlertDialog makeRequestDialog(CharSequence title, CharSequence message, CharSequence buttonYES, CharSequence buttonNO){
        AlertDialog.Builder requestDialog = new AlertDialog.Builder(getContext());
        requestDialog.setTitle(title);
        requestDialog.setMessage(message);
        requestDialog.setPositiveButton(buttonYES, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getActivity(),Login.class);
                Toast.makeText(getContext(),"탈퇴가 완료되었습니다.",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        
        requestDialog.setNegativeButton(buttonNO, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        return requestDialog.create();
    }
}