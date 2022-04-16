package com.example.myfirstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Iphone", 2000, R.drawable.iphonexsmax));
        products.add(new Product(2, "Samsung", 3000, R.drawable.iphonexsmax));
        products.add(new Product(3, "Nokia", 4000, R.drawable.iphonexsmax));
        products.add(new Product(4,"Sony", 5000, R.drawable.iphonexsmax));
        products.add(new Product(5, "HTC", 6000, R.drawable.iphonexsmax));

        ListView listView = findViewById(R.id.lvCustomListView);
//        3. create adapter
        ProductAdapter adapter = new ProductAdapter(this, R.layout.activity_product_item);
//        4. set adapter to listview
        // add data
        adapter.addAll(products);
        listView.setAdapter(adapter);
    }

}