package kwaksuin.portfolio.community;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_profile,container,false);

        TextView myEmail = rootView.findViewById(R.id.profile_myEmail);
        TextView myName = rootView.findViewById(R.id.profile_myName);
        TextView myEmailData = rootView.findViewById(R.id.profile_Email_Data);

        // Login.java에서 입력된 email 정보를 profile_Email_Data에 받기 - 받기 실패
        Bundle bundle = getArguments();
        if(bundle != null){
            String email = bundle.getString("email");
            myEmailData.setText(email);
        }

        // SignUp.java에서 입력된 name 정보를 profile_Name_Data에 getText()

        Button photoChange = rootView.findViewById(R.id.change_photo);

        return rootView;
    }
}