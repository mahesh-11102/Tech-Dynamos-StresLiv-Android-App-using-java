package com.example.tech_dynamosstresliv.Breath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tech_dynamosstresliv.R;

import java.util.Timer;
import java.util.TimerTask;

public class startBreathing extends AppCompatActivity {
    TextView tv,infoTV;
    public int seconds = 60;
    public int minutes = 0;
    int count;
    Button stop;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_start_breathing );
        infoTV=(TextView )findViewById ( R.id.infoTV ) ;

        MediaPlayer mp1 = MediaPlayer.create(this, R.raw.breathin);
        MediaPlayer mp2 = MediaPlayer.create(this, R.raw.breathout);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        stop = (Button )findViewById ( R.id.stop ) ;

        stop.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                mp1.stop ();
                mp2.stop ();
                Intent intent = new Intent (startBreathing.this,MainBreath.class);
                startActivity ( intent );
            }
        } );


        Timer t = new Timer ();
       count=1;
        //Set the schedule function and rate
        t.scheduleAtFixedRate ( new TimerTask () {

            @Override
            public void run () {
                runOnUiThread ( new Runnable () {

                    @Override
                    public void run () {
                        TextView tv = ( TextView ) findViewById ( R.id.timerV );
                        tv.setText ( String.valueOf ( minutes ) + ":" + String.valueOf ( seconds ) );
                        seconds -= 1;

                        if ( seconds == 0 ) {
                            tv.setText ( String.valueOf ( minutes ) + ":" + String.valueOf ( seconds ) );

                            seconds = 60;
                            minutes = minutes - 1;

                        }

                        if(seconds%6==0){
                            if(count%2==0) {
                                infoTV.setText ( "Breath In" );
                                mp1.start ();
                                count++;
                            }else {
                                infoTV.setText ( "Breath Out" );
                                mp2.start ();
                                count++;


                            }

                        }
                        if(minutes<0){
                            Intent intent = new Intent (startBreathing.this,MainBreath.class);
                            startActivity ( intent );
                            t.cancel ();
                            mp1.stop ();
                            mp2.stop ();
                        }


                        }






                } );
            }

        } , 0 , 1000 );
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();

                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu( Menu menu) {
        return true;
    }
}