package com.example.tech_dynamosstresliv;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td = new Thread(){
            public void run(){
                try{
                    sleep(5100);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                finally {
                    Intent intent = new Intent( loading.this, MainPageActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        td.start();
    }
}