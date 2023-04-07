package com.example.new_sedna;

import static com.example.new_sedna.LoginActivity.loginStatus;
import static com.example.new_sedna.LoginActivity.loginId;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.new_sedna.connection.AbstractDAO;

public class MainActivity extends AppCompatActivity {

    Button main_login_button, main_logout_button;
//    TextView loginText;

    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AbstractDAO db = new AbstractDAO();

        onBackPressed();

//        main_reading_room_select_button = findViewById(R.id.mainReadingRoomSelectButton);
//        main_my_room_button = findViewById(R.id.mainMyReadingRoomButton);
        main_login_button = findViewById(R.id.mainLoginButton);
        main_logout_button = findViewById(R.id.mainLogoutButton);
//        loginText = (TextView) findViewById(R.id.loginText);
//        img = findViewById(R.id.imageView1);
//        v_flipper = findViewById(R.id.image_slide);

//        if (loginStatus) {
//            loginText.setText("Log Out");
//
//
//        }

        // 로그인 클릭했을 때
        main_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginStatus) { // 로그인이 되어있으면
                    loginStatus = false;
                    loginId = "";
//                    loginText.setText("Log In");
                    Toast.makeText(getApplicationContext(),"로그아웃되었습니다.", Toast.LENGTH_SHORT).show();

                } else {
                    intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    // 뒤로가기 방지
    public void onBackPressed() {  }
}