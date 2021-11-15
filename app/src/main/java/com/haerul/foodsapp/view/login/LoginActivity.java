/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 10:30, 15/11/2021                                            -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2021. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.haerul.foodsapp.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.haerul.foodsapp.R;
import com.haerul.foodsapp.view.home.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail, edtPassword;
    private TextView tvMessage, tvPassword;
    private TextView btnLogin, tvSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        tvMessage = findViewById(R.id.tv_message);
        tvSignup = findViewById(R.id.tv_signup);
//        tvPassword = findViewById(R.id.tv_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clickLogin();
            }
        });

        tvSignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clickSignup();
            }
        });


    }

    private void clickSignup() {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    private void clickLogin() {
        String strEmail = edtEmail.getText().toString().trim();
        String strPassword = edtPassword.getText().toString().trim();

        User user = new User(strEmail, strPassword);

        tvMessage.setVisibility(View.VISIBLE);
//        tvPassword.setVisibility(View.VISIBLE);

        if (user.isValidEmail() && user.isValidPassword()){
            tvMessage.setText("Login success");
            tvMessage.setTextColor(getResources().getColor(R.color.design_default_color_primary));

            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else{
            tvMessage.setText("Email or Password invalid");
            tvMessage.setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }
}
