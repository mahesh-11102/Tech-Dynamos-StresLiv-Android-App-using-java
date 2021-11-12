package com.example.tech_dynamosstresliv;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tech_dynamosstresliv.Ai_Chat.MainActivity;
import com.example.tech_dynamosstresliv.Breath.MainBreath;
import com.example.tech_dynamosstresliv.Ps_to_ps.Activities.PhoneNumberActivity;
import com.example.tech_dynamosstresliv.Reading.MotivationalBlogs;
import com.example.tech_dynamosstresliv.Reading.MotivitionalBooks;

public class MainPageActivity extends AppCompatActivity {
    CardView c1,c2,c3,c4,c5,c6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        getSupportActionBar().hide();

        c1 = findViewById(R.id.AiCard);
        c2 = findViewById(R.id.SupportCard);
        c3 = findViewById(R.id.breathcard);
        c4 = findViewById(R.id.MusicCard);
        c5 = findViewById(R.id.BooksCard);
        c6 = findViewById(R.id.BlogCard);


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

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


try {


    Intent i = new Intent(Intent.ACTION_MAIN);
    PackageManager managerclock = getPackageManager();
    i = managerclock.getLaunchIntentForPackage("com.technopratik.moodmusic");
    i.addCategory(Intent.CATEGORY_LAUNCHER);
    startActivity(i);
    }catch(Exception e) {
                    Toast.makeText(MainPageActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainPageActivity.this, MotivitionalBooks.class);
                startActivity(i);
            }
        });

        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainPageActivity.this, MotivationalBlogs.class);
                startActivity(i);
            }
        });

    }
}