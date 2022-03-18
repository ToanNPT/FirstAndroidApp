package com.example.myfirstproject;

import static com.example.myfirstproject.R.id.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn ;
    public static final String USER_NAME = "name";
    public static final String PASS_WORD = "pass";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.b1);
    }

    public void MainClicked(View view){
        Intent openLogin = new Intent(this, LoginHandler.class);
        openLogin.putExtra(USER_NAME, "toan0810");
        openLogin.putExtra(PASS_WORD, "08102001");
        startActivity(openLogin);
    }

}