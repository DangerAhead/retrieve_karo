package com.hfad.retrievekaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseUser;
    ListView listViewUser;
    List<stuff> stuffList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseUser = FirebaseDatabase.getInstance().getReference("user");

        listViewUser = findViewById(R.id.lv1);
        stuffList = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                stuffList.clear();
                for(DataSnapshot usersnapshot : dataSnapshot.getChildren()){
                    stuff stf = usersnapshot.getValue(stuff.class);
                    stuffList.add(stf);
                }
                UserList adapter = new UserList(MainActivity.this,stuffList);
                listViewUser.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
