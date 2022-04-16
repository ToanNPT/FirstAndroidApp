package com.example.Firebase;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myfirstproject.R;
import com.example.sqlite.Constant;
import com.example.sqlite.Detail;


public class UserAdapter  extends ArrayAdapter<User> {
    Activity context;
    int resource;

    public UserAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(resource,null);

        User user = getItem(position);
        TextView textView = v.findViewById(R.id.fb_item_name);
        TextView textView2 = v.findViewById(R.id.fb_item_phone);
        Button btn = v.findViewById(R.id.fb_item_call);

        textView.setText(String.valueOf(user.getName()));
        textView2.setText(String.valueOf(user.getPhoneNumber()));


        return v;
    }
}
