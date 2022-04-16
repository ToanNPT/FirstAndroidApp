package com.example.Firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseManager {
    private DatabaseReference database;

    public FirebaseManager(){

    }

    public void getUsers(){
        database = FirebaseDatabase.getInstance().getReference("Users");
        // Read from the database
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                User user = dataSnapshot.getValue(User.class);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.out.print("Failed to read value: "+ error.toException());
            }
        });
    }
}
