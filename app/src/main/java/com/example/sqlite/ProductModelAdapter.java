package com.example.sqlite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.sqlite.Constant;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myfirstproject.Product;
import com.example.myfirstproject.R;
import com.example.sqlite.ProductModel;

public class ProductModelAdapter extends ArrayAdapter<ProductModel> {

    Activity context;
    int resource;

    public ProductModelAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(resource,null);

        ProductModel product = getItem(position);
        TextView textView = v.findViewById(R.id.productModelId);
        TextView textView2 = v.findViewById(R.id.productModelName);
        TextView textView3 = v.findViewById(R.id.productModelInStock);

        textView.setText("ID: " + String.valueOf(product.getId()));
        textView2.setText(product.getName());
        textView3.setText("In Stock: "+String.valueOf(product.getInStock()));

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(context, Detail.class);
                detail.putExtra(Constant.ID, String.valueOf(product.getId()));
                detail.putExtra(Constant.NAME, product.getName());
                detail.putExtra(Constant.INSTOCK, String.valueOf(product.getInStock()));
                context.finish();
                context.startActivity(detail);
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(context, Detail.class);
                detail.putExtra(Constant.ID, String.valueOf(product.getId()));
                detail.putExtra(Constant.NAME, product.getName());
                detail.putExtra(Constant.INSTOCK, String.valueOf(product.getInStock()));
                context.finish();
                context.startActivity(detail);
            }
        });
        return v;
    }
}
