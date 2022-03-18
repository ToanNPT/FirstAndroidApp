package com.example.myfirstproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginHandler extends AppCompatActivity {
    Button btnOk, btnCancel, btnForgot;
    EditText txtName, txtPass;
    public static final String USERNAME= "username";
    public static final String PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btnOk = findViewById(R.id.btnOk);
        btnForgot = findViewById(R.id.btnForgot);
        btnCancel = findViewById(R.id.btnCancel);
        txtName =findViewById(R.id.txtName);
        txtPass = findViewById(R.id.txtPass);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.USER_NAME);
        String pass = intent.getStringExtra(MainActivity.PASS_WORD);
        txtName.setText(name);
        txtPass.setText(pass);
    }

    public void btn_ok_click(View view){
        if(TextUtils.isEmpty(txtName.getText()) && TextUtils.isEmpty(txtPass.getText())){
            Toast.makeText(this, "Can not empty", Toast.LENGTH_SHORT).show();
        }
        else{
            if(txtName.getText().toString().equals("toan0810") &&
                txtPass.getText().toString().equals("08102001")){
                Intent calc = new Intent(this, Calchandler.class);
                calc.putExtra(USERNAME, "toan0810");
                calc.putExtra(PASSWORD, "08102001");
                startActivity(calc);
            }
            else{
                Toast.makeText(this," Fail to lgoin", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void btn_cancel_click(View view){
        txtName.setText("");
        txtPass.setText("");
    }

    public void btn_forgot_click(View view){
        if(TextUtils.isEmpty(txtName.getText())){
            Toast.makeText(this, "Please fill out your name", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://google.com.vn"));
            startActivity(intent);
        }
    }
}
