package com.example.Firebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.example.myfirstproject.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DemoFirebase extends AppCompatActivity {

    private ListView userListView;
    ArrayList<User> usersArrayList;
    DatabaseReference reference;
    DatabaseReference userRef;
    String connectionString = "https://examplefirebase-d8bfd-default-rtdb.firebaseio.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_firebase);
        userListView = findViewById(R.id.listUsers);
        usersArrayList = new ArrayList<User>();

        reference = FirebaseDatabase.getInstance(connectionString).getReference();
        userRef = reference.child("Users");

        init();
        System.out.print(usersArrayList);
    }

    public void init(){
        final UserAdapter userAdapter = new UserAdapter(this, R.layout.activity_user_item);
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String name = ds.child("name").getValue(String.class);
                    String phoneNumber = ds.child("phoneNumber").getValue(String.class);
                    User user = new User(name, phoneNumber);
                    usersArrayList.add(user);
                }
                userAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        userRef.addListenerForSingleValueEvent(eventListener);
        userAdapter.addAll(usersArrayList);
        userListView.setAdapter(userAdapter);
        System.out.print(usersArrayList);

    }
}