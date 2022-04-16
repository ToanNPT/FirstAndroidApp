package com.example.myfirstproject;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ProductAdapter extends ArrayAdapter<Product> {

    Activity context;
    int resource;

    public ProductAdapter(Activity context, int resource) {
        super(context,resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(resource,null);

        Product product = getItem(position);
        ImageView imageView = v.findViewById(R.id.imgAvatatr);
        TextView textView = v.findViewById(R.id.productName);
        TextView textView2 = v.findViewById(R.id.productPrice);

        imageView.setImageResource(product.getImg());
        textView.setText(product.getName());
        textView2.setText(String.valueOf(product.getPrice()));

        return v;
    }

}
