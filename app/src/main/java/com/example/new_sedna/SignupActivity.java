package com.example.new_sedna;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class SignupActivity extends AppCompatActivity {

    // Signup layout 변수 지정
    private EditText usernumber, password, confirmPassword; // 회원가입 아이디, 비번, 비번 확인
    private EditText program; // 전공 확인


    // Signup layout Spinner
    private ArrayAdapter adapter; // 내가 지정한 array를 spinner에 추가
    private Spinner spinner; // 화면상에서 원하는 것 선택할 수 있는 이벤트 중 하나

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup); // layout 연결

        // 각 변수들 layout 연결
        usernumber = findViewById(R.id.userid);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm);
        program = findViewById(R.id.yourProgram);

        // spinner
        spinner = (Spinner) findViewById(R.id.majorSpinner); // signup layout 연결
        adapter = ArrayAdapter.createFromResource(this, R.array.Level, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // register 버튼 정의 및 이벤트 호출
        TextView registerButton = (TextView) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {

            // resigster 버튼 이벤트 핸들러
            @Override
            public void onClick(View view) {
                Intent registerButton = new Intent(SignupActivity.this, MainActivity.class); // 회원가입 후 메인페이지로 이동
                SignupActivity.this.startActivity(registerButton);
            }
        });
    }

}

