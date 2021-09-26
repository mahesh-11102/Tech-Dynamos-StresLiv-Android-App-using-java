package com.example.tech_dynamosstresliv.Ps_to_ps.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tech_dynamosstresliv.Ps_to_ps.Activities.ChatActivity;
import com.example.tech_dynamosstresliv.R;
import com.example.tech_dynamosstresliv.Ps_to_ps.Models.User;
import com.example.tech_dynamosstresliv.databinding.RowConversationBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    Context context;
    ArrayList<User> users;

    public UsersAdapter(    Context context,ArrayList<User> users){
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_conversation,parent,false);
        return new UsersViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  UsersAdapter.UsersViewHolder holder, int position) {
        User user = users.get(position);
        String senderid = FirebaseAuth.getInstance().getUid();
        String senderRoom = senderid + user.getUid();
        FirebaseDatabase.getInstance().getReference()
                .child("chats")
                .child(senderRoom)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()) {
                            String lastMsg = snapshot.child("lastMsg").getValue(String.class);
                            //long time = snapshot.child("lastMsgtime").getValue(Long.class);

                            holder.binding.lastMsg.setText(lastMsg);
                        }
                        else
                            holder.binding.lastMsg.setText("Tap to Chat");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        holder.binding.username.setText(user.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ChatActivity.class );
                i.putExtra("name",user.getName());
                i.putExtra("uid",user.getUid());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder{
        RowConversationBinding binding;

        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = RowConversationBinding.bind(itemView);
        }
    }
}
