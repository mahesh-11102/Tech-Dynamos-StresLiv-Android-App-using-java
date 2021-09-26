package com.example.tech_dynamosstresliv.Breath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tech_dynamosstresliv.R;

public class MainBreath extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main_breath );
        btn = (Button)findViewById ( R.id.button );
        btn.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                Intent intent = new Intent (MainBreath.this,startBreathing.class);
                startActivity ( intent );
            }
        } );
    }
}