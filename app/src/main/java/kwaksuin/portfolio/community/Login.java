package kwaksuin.portfolio.community;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kwaksuin.portfolio.community.R;

public class Login extends AppCompatActivity {
    public static final int LOGIN_CODE_MAIN = 10;
    public static final int SIGNUP_CODE_MAIN = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.login);    // 로그인 버튼
        Button signup = findViewById(R.id.singup);  // 회원가입 버튼

        final EditText email = (EditText)findViewById(R.id.userEmail);  // 이메일
        final EditText pwd = (EditText)findViewById(R.id.password);     // 비밀번호


        // 로그인 버튼
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                String userEmail = email.getText().toString();
                String userPassword = pwd.getText().toString();

                // 이메일과 비밀번호의 길이가 0이면 로그인 X
                if(userEmail.length() == 0){
                    if (userPassword.length() == 0){
                        Toast.makeText(getApplicationContext(),"이메일/비밀번호를 입력하세요.",Toast.LENGTH_LONG).show();
                    }
                }else {

                    /* email 입력 값 전송 - 전송 안됨
                    Bundle bundle = new Bundle();
                    ProfileFragment profileFragment = new ProfileFragment();
                    bundle.putString("email",userEmail);
                    profileFragment.setArguments(bundle)

                     */

                    // 로그인 버튼 누르면 카테고리로 이동
                    Intent intent = new Intent(getApplicationContext(),Category.class);
                    startActivityForResult(intent,LOGIN_CODE_MAIN);
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                // 회원가입 버튼 누르면 회원가입 이동
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivityForResult(intent,SIGNUP_CODE_MAIN);
            }
        });
    }
}