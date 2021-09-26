package com.example.tech_dynamosstresliv.Ps_to_ps.Activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tech_dynamosstresliv.Ps_to_ps.Models.User;
import com.example.tech_dynamosstresliv.Ps_to_ps.Adapters.UsersAdapter;
import com.example.tech_dynamosstresliv.databinding.ActivityPsChatBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PsChatActivity extends AppCompatActivity {
    ActivityPsChatBinding binding;
    FirebaseDatabase database;
    ArrayList<User> users;
    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPsChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = FirebaseDatabase.getInstance();
        users = new ArrayList<>();
        usersAdapter = new UsersAdapter(this,users);
        binding.recyclerView.setAdapter(usersAdapter);

        database.getReference().child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                users.clear();

                for (DataSnapshot sp : snapshot.getChildren()){
                    User u = sp.getValue(User.class);
                    if (!u.getUid().equals(FirebaseAuth.getInstance().getUid()))
                        users.add(u);
                }
                usersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
