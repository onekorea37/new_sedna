package com.example.new_sedna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    EditText usernumber, password;

    Button loginButton;

    public static boolean loginStatus = false;

    public static String loginId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernumber = findViewById(R.id.userid);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usernumber.getText().toString().equals("012345678") && password.getText().toString().equals("1234")) {
                    Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        });

        TextView signupButton = (TextView) findViewById(R.id.signupText);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupButton = new Intent(LoginActivity.this, SignupActivity.class);
                LoginActivity.this.startActivity(signupButton);
            }
        });

    }
}
