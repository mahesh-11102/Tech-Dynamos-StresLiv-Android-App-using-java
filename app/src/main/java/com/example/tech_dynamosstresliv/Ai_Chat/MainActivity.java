package com.example.tech_dynamosstresliv.Ai_Chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tech_dynamosstresliv.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView chatRV;
    private EditText userMsgEdt;
    private ImageButton sendMsgFAB;
    private final String BOT_KEY = "bot";
    private final String USER_KEY = "user";

    private RequestQueue mRequestQueue;
    private ArrayList<ChatsModal> chatsModalArrayList;
    private ChatRVAdapter chatRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatRV = findViewById(R.id.idRVChats);
        userMsgEdt = findViewById(R.id.idEdtMessage);
        sendMsgFAB = findViewById(R.id.idIBSend);
        chatsModalArrayList =new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(MainActivity.this);
        mRequestQueue.getCache().clear();


        sendMsgFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userMsgEdt.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter your message", Toast.LENGTH_SHORT).show();
                    return;
                }
                getResponse(userMsgEdt.getText().toString());
                userMsgEdt.setText("");
            }
        });

        chatRVAdapter = new ChatRVAdapter(chatsModalArrayList,this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);

        chatRV.setLayoutManager(linearLayoutManager);

        chatRV.setAdapter(chatRVAdapter);
    }

    private void getResponse(String message){
        chatsModalArrayList.add(new ChatsModal(message,USER_KEY));
        chatRVAdapter.notifyDataSetChanged();
        String url = "http://api.brainshop.ai/get?bid=158851&key=FzZDdzr2rhE1BK8n&uid=[uid]&msg= "+message;
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String botResponse = response.getString("cnt");
                    chatsModalArrayList.add(new ChatsModal(botResponse, BOT_KEY));
                    chatRVAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();

                    chatsModalArrayList.add(new ChatsModal("No response", BOT_KEY));
                    chatRVAdapter.notifyDataSetChanged();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // error handling.
                chatsModalArrayList.add(new ChatsModal("Sorry no response found", BOT_KEY));
                Toast.makeText(MainActivity.this, "No response from the bot..", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);

    }

}