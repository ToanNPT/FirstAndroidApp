package com.example.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class Preference extends AppCompatActivity {
    EditText txtkey, txtvalue;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        txtkey = findViewById(R.id.preName);
        txtvalue = findViewById(R.id.prePass);

        sharedPreferences = getSharedPreferences("preferenceFile", Context.MODE_PRIVATE);
        String name = txtkey.getText().toString();

        if(sharedPreferences.contains(name)){
            txtvalue.setText(sharedPreferences.getString(name, "").toString());
        }

    }

    public void btn_write_click(View view){
        String key = txtkey.getText().toString();
        String value = txtvalue.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if( !sharedPreferences.contains(key)){
            editor.putString(key, value);
            editor.apply();
            txtkey.setText("");
            txtvalue.setText("");
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Your key was stored", Toast.LENGTH_SHORT).show();
        }

    }

    public void btn_read_click(View view){
        String key = txtkey.getText().toString();

        if(sharedPreferences.contains(key)){
            txtvalue.setText(sharedPreferences.getString(key, "").toString());
        }
        else{
            Toast.makeText(this, "Oops, try again", Toast.LENGTH_SHORT).show();
        }
    }
    
    public void btn_remove_click(View view){
        String key = txtkey.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if( sharedPreferences.contains(key)){
            editor.remove(key);
            editor.commit();
            txtkey.setText("");
            txtvalue.setText("");
            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "The key is not stored", Toast.LENGTH_SHORT).show();
        }
    }


}