package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.myfirstproject.Product;
import com.example.myfirstproject.ProductAdapter;
import com.example.myfirstproject.R;

import java.util.ArrayList;
import java.util.List;

public class sqlite extends AppCompatActivity {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String INSTOCK = "instock";
    private ProductOpenHelper productOpenHelper;
    List<ProductModel> products;
    ListView listView;
    ProductModelAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        products = new ArrayList<ProductModel>();
        productOpenHelper = new ProductOpenHelper(this);
        products = productOpenHelper.onGetAllProduct();

        listView = findViewById(R.id.listProductModel);
        adapter = new ProductModelAdapter(this, R.layout.activity_product_model_item);
        adapter.addAll(products);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        products = productOpenHelper.onGetAllProduct();
        adapter.clear();
        adapter.addAll(products);
        listView.setAdapter(adapter);
    }

    public void onRedirect(View view){
        Intent detail = new Intent(this, Detail.class);
        startActivity(detail);
    }
}