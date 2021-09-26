package com.example.tech_dynamosstresliv.Reading;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MotivationalBlogs extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] restArray = {"3 Reasons Why I Finally Stopped Being A Cynic","LIFEHow You’re Destroying Your Growth and What to Do Instead","What Is Dark Motivation and How Can I Use It to My Advantage?","5 Steps to Go From Breakdown to Breakthrough"};


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_motivationalblogs );

        ArrayAdapter<String> adpter = new ArrayAdapter<String> (this,R.layout.layout,restArray );
        ListView lv = (ListView)findViewById ( R.id.lview );
        lv.setAdapter ( adpter );
        lv.setOnItemClickListener (MotivationalBlogs.this);


    }

    @Override
    public void onItemClick ( AdapterView<?> adapterView , View view , int i , long l ) {
        // Toast.makeText ( this, restArray[i], Toast.LENGTH_SHORT ).show ();
        if (i==0){
            Toast.makeText ( this, restArray[i], Toast.LENGTH_SHORT ).show ();
            Intent intent = new Intent ( MotivationalBlogs.this, com.technopratik.readforrelaxation.BlogView.class);
            intent.putExtra ( "link","https://www.pickthebrain.com/blog/3-reasons-why-i-finally-stopped-being-a-cynic/" );
            startActivity ( intent );

        }
        if (i==1){
            Toast.makeText ( this, restArray[i], Toast.LENGTH_SHORT ).show ();
            Toast.makeText ( this, restArray[i], Toast.LENGTH_SHORT ).show ();
            Intent intent = new Intent ( MotivationalBlogs.this, com.technopratik.readforrelaxation.BlogView.class);
            intent.putExtra ( "link","https://addicted2success.com/life/how-youre-destroying-your-growth-and-what-to-do-instead/" );
            startActivity ( intent );
        }
        if (i==2){
            Toast.makeText ( this, restArray[i], Toast.LENGTH_SHORT ).show ();
            Toast.makeText ( this, restArray[i], Toast.LENGTH_SHORT ).show ();
            Intent intent = new Intent ( MotivationalBlogs.this, com.technopratik.readforrelaxation.BlogView.class);
            intent.putExtra ( "link","https://addicted2success.com/motivation/what-is-dark-motivation-and-how-can-i-use-it-to-my-advantage/" );
            startActivity ( intent );
        }
        if (i==3){
            Toast.makeText ( this, restArray[i], Toast.LENGTH_SHORT ).show ();
            Toast.makeText ( this, restArray[i], Toast.LENGTH_SHORT ).show ();
            Intent intent = new Intent ( MotivationalBlogs.this, com.technopratik.readforrelaxation.BlogView.class);
            intent.putExtra ( "link","https://addicted2success.com/life/5-steps-to-go-from-breakdown-to-breakthrough/" );
            startActivity ( intent );
        }
    }
}