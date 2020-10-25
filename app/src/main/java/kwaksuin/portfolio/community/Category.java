package kwaksuin.portfolio.community;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Category extends AppCompatActivity {
    HomeFragment category01;    // 홈화면
    BoardFragment category02;   // 게시판
    ProfileFragment category03; // 프로필
    SettingFragment category04; // 설정


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        category01 = new HomeFragment();
        category02 = new BoardFragment();
        category03 = new ProfileFragment();
        category04 = new SettingFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,category01).commit();

        BottomNavigationView categoryNavigation = findViewById(R.id.category_navigation);   // 하단바
        categoryNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home: // 홈 아이콘
                        Toast.makeText(getApplicationContext(),"홈 화면입니다.",Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,category01).commit();

                        return true;
                    case R.id.board:    // 게시판 아이콘
                        Toast.makeText(getApplicationContext(),"게시판입니다.",Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,category02).commit();

                        return true;
                    case R.id.profile:  // 프로필 아이콘
                        Toast.makeText(getApplicationContext(),"프로필입니다.",Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,category03).commit();

                        return true;
                    case R.id.setting:  // 설정 아이콘
                        Toast.makeText(getApplicationContext(),"설정입니다.",Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,category04).commit();

                        return true;
                }
                return false;
            }

        });

    }


}