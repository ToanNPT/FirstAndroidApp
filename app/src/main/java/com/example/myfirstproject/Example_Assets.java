package com.example.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Example_Assets extends AppCompatActivity {
    private ImageView imageView;
    private AssetManager assetManager;
    private int index;
    private String[] listImgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_assets);
        index = 0;
        imageView = findViewById(R.id.asset_example);
        assetManager = getAssets();
        imageView.setVisibility(View.VISIBLE);
        try {
            listImgs = assetManager.list("images");
            InputStream s = assetManager.open("images/" + listImgs[index]);

            Bitmap bm = BitmapFactory.decodeStream(s);
            imageView.setImageBitmap(bm);
        } catch (IOException e) {
            Log.e("this is an error", e.getMessage());
        }

    }
}