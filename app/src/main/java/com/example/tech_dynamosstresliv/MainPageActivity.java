package com.example.tech_dynamosstresliv;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tech_dynamosstresliv.Ai_Chat.MainActivity;
import com.example.tech_dynamosstresliv.Breath.MainBreath;
import com.example.tech_dynamosstresliv.Ps_to_ps.Activities.PhoneNumberActivity;

public class MainPageActivity extends AppCompatActivity {
    CardView c1,c2,c3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        getSupportActionBar().hide();

        c1 = findViewById(R.id.AiCard);
        c2 = findViewById(R.id.SupportCard);
        c3 = findViewById(R.id.breathcard);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainPageActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainPageActivity.this, PhoneNumberActivity.class);
                startActivity(i);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainPageActivity.this, MainBreath.class);
                startActivity(i);
            }
        });

    }
}