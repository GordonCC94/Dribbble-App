package com.example.chenc.ccdrible.view.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.chenc.ccdrible.R;
import com.example.chenc.ccdrible.view.dribbble.Auth.Auth;
import com.example.chenc.ccdrible.view.dribbble.Auth.AuthActivity;
import com.example.chenc.ccdrible.view.dribbble.Dribbble;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.activity_login_btn) TextView loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        Dribbble.init(this);//load users

        if(!Dribbble.isLoggedIn()){
            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Auth.openAuthActivity(LoginActivity.this);
                }//得到auth code,用于下一新线程内换取access token
            });
        }else{
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode==Auth.REQ_CODE&&resultCode==RESULT_OK){
            final String authCode = data.getStringExtra(AuthActivity.KEY_CODE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        String token=Auth.fetchAccessToken(authCode);//得到access token
                        Dribbble.login(LoginActivity.this,token);

                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }catch(IOException|JsonSyntaxException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
