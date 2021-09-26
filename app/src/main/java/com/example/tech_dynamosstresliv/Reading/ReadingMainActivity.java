package com.example.tech_dynamosstresliv.Reading;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ReadingMainActivity extends AppCompatActivity {
//Button books,blogs;
CardView books,blogs;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

   books = (CardView ) findViewById ( R.id.books );
   books.setOnClickListener ( new View.OnClickListener () {
       @Override
       public void onClick ( View view ) {
           Intent int1 = new Intent (MainActivity.this,MotivitionalBooks.class);
           startActivity ( int1 );
       }
   } );

        blogs = (CardView ) findViewById ( R.id.blogs );
        blogs.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                Intent int2 = new Intent (MainActivity.this,MotivationalBlogs.class);
                startActivity ( int2);
            }
        } );




    }
}