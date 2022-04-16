package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myfirstproject.R;

public class ProductModel_Item extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_model_item);
    }

    public void redirectToDetail(View view){
        Toast.makeText(this," Fail to lgoin", Toast.LENGTH_SHORT).show();

    }
}