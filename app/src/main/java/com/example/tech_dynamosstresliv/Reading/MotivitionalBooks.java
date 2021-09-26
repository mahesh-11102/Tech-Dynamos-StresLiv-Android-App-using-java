package com.example.tech_dynamosstresliv.Reading;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MotivitionalBooks extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] restArray2 = {"Go Motivate Yourself","Getting Motivated to Change ","Motivating Skills","Five Key Ingredients for Improving Student Motivation"};


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_motivitional_books );

        ArrayAdapter<String> adpter = new ArrayAdapter<String> (this,R.layout.layout,restArray2 );
        ListView lv = (ListView)findViewById ( R.id.lview2 );
        lv.setAdapter ( adpter);
        lv.setOnItemClickListener (this);


    }

    @Override
    public void onItemClick ( AdapterView<?> adapterView , View view , int i , long l ) {
        // Toast.makeText ( this, restArray[i], Toast.LENGTH_SHORT ).show ();
        if (i==0){
            Toast.makeText ( this, restArray2[i], Toast.LENGTH_SHORT ).show ();
            Intent intent1 = new Intent ( MotivitionalBooks.this, com.technopratik.readforrelaxation.BlogView.class);
            intent1.putExtra ( "link","https://drive.google.com/viewerng/viewer?embedded=true&url=https://www.dri.org/docs/default-source/committee/0240/go-motivate-yourself_ramos_201713e638570102663cbed7ff00009eb89a.pdf?sfvrsn=4" );
            startActivity ( intent1 );

        }
        if (i==1){
            Toast.makeText ( this, restArray2[i], Toast.LENGTH_SHORT ).show ();

            Intent intent = new Intent ( MotivitionalBooks.this, com.technopratik.readforrelaxation.BlogView.class);
            intent.putExtra ( "link","https://drive.google.com/viewerng/viewer?embedded=true&url=https://ibr.tcu.edu/wp-content/uploads/2013/09/TMA06Sept-mot.pdf" );
            startActivity ( intent );
        }
        if (i==2){
            Toast.makeText ( this, restArray2[i], Toast.LENGTH_SHORT ).show ();

            Intent intent = new Intent ( MotivitionalBooks.this, com.technopratik.readforrelaxation.BlogView.class);
            intent.putExtra ( "link","https://drive.google.com/viewerng/viewer?embedded=true&url=https://www.tutorialspoint.com/motivating_skills/motivating_skills_tutorial.pdf" );
            startActivity ( intent );
        }
        if (i==3){
            Toast.makeText ( this, restArray2[i], Toast.LENGTH_SHORT ).show ();

            Intent intent = new Intent ( MotivitionalBooks.this, com.technopratik.readforrelaxation.BlogView.class);
            intent.putExtra ( "link","https://drive.google.com/viewerng/viewer?embedded=true&url=https://www.aabri.com/manuscripts/11834.pdf" );
            startActivity ( intent );
        }
    }
}