package com.example.tech_dynamosstresliv.MoodMusic;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.example.tech_dynamosstresliv.R;

import androidx.appcompat.app.AppCompatActivity;


public class MusicMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        FragmentManager fm = getFragmentManager ();
        FragmentTransaction tx = fm.beginTransaction ();
        tx.replace( R.id.fl,new Happy());
        tx.commit ();






    }
    public void selectFrag( View view){
        android.app.Fragment fr;

        if(view == findViewById ( R.id.fb1 )){
            fr = new Relax();
        }else{
            fr = new Happy();
        }

        FragmentManager fm = getFragmentManager ();
        FragmentTransaction tx = fm.beginTransaction ();
        tx.replace(R.id.fl , fr);
        tx.commit ();

    }
}