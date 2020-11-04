package kwaksuin.portfolio.community;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUp extends AppCompatActivity {
    public static final int SIGNUP_CODE_MAIN = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText email = (EditText)findViewById(R.id.email);        // 이메일
        final EditText pwd = (EditText)findViewById(R.id.password);       // 비밀번호
        final EditText repwd = (EditText)findViewById(R.id.Repassword);   // 비밀번호 재입력
        final EditText name = (EditText)findViewById(R.id.nickname);      // 닉네임

        Button signup = findViewById(R.id.signupButton);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                String userEmail = email.getText().toString();
                String userPwd = pwd.getText().toString();
                String userRePwd = repwd.getText().toString();
                String userName = name.getText().toString();

                if(userPwd.equals(userRePwd) && userEmail.length()!=0 && userName.length()!=0 && userPwd.length() != 0 && userRePwd.length() != 0){
                    // 정보가 입력되어있고, 비밀번호가 일치할 때
                    Intent intent = new Intent(getApplicationContext(),Category.class);
                    startActivityForResult(intent,SIGNUP_CODE_MAIN);
                    Toast.makeText(getApplicationContext(),"가입이 완료되었습니다.",Toast.LENGTH_LONG).show();
                    // DB연동

                 }else{
                    // 비밀번호가가불일치 함
                    Toast.makeText(getApplicationContext(),"비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show();

               }
            }
        });
    }
}