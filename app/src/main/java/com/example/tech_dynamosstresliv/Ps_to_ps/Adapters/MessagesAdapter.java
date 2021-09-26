package com.example.tech_dynamosstresliv.Ps_to_ps.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tech_dynamosstresliv.Ps_to_ps.Models.Message;
import com.example.tech_dynamosstresliv.R;
import com.example.tech_dynamosstresliv.databinding.ItemReceiveBinding;
import com.example.tech_dynamosstresliv.databinding.ItemSentBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MessagesAdapter extends  RecyclerView.Adapter{
    Context context;
    ArrayList<Message> messages;
    final  int ITEM_SENT = 1,ITEM_RECEIVE =2;

    public  MessagesAdapter(Context context, ArrayList<Message> messages){
        this.context = context;
        this.messages =  messages;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        if (viewType ==ITEM_SENT){
            View view = LayoutInflater.from(context).inflate(R.layout.item_sent,parent,false );
            return  new SentviewHolder(view);
        }
        else{
            View view = LayoutInflater.from(context).inflate(R.layout.item_receive,parent,false );
            return  new ReceiverViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messages.get(position);
        if (FirebaseAuth.getInstance().getUid().equals(message.getSenderId()))
            return  ITEM_SENT;
        else
            return ITEM_RECEIVE ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message message = messages.get(position);

        if (holder.getClass() == SentviewHolder.class){
            SentviewHolder viewHolder = (SentviewHolder)holder;
            viewHolder.binding.Message.setText(message.getMessage());
        }
        else {
            ReceiverViewHolder viewHolder = (ReceiverViewHolder)holder;
            viewHolder.binding.Message.setText(message.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public  class SentviewHolder extends RecyclerView.ViewHolder{

        ItemSentBinding binding;
        public SentviewHolder(@NonNull View itemView) {
            super(itemView);
             binding = ItemSentBinding.bind(itemView);
        }
    }

    public  class  ReceiverViewHolder extends  RecyclerView.ViewHolder{
        ItemReceiveBinding binding;
        public ReceiverViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemReceiveBinding.bind(itemView);
        }
    }
}
