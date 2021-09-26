package com.example.tech_dynamosstresliv.Reading;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class BlogView extends AppCompatActivity {
    private android.webkit.WebView mywebView;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_blog_view );

        Intent intent = getIntent ();
        String urls=intent.getStringExtra ( "link" );

        mywebView= ( android.webkit.WebView ) findViewById(R.id.webview);
        mywebView.setWebViewClient(new WebViewClient ());
        mywebView.loadUrl(urls);
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public boolean onOptionsItemSelected( MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), BlogView.class);
        startActivityForResult(myIntent, 0);

        return true;
    }
    private android.webkit.WebView myWebView;


    public class mywebClient extends WebViewClient {
        @Override
        public void onPageStarted( android.webkit.WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading( android.webkit.WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if (mywebView.canGoBack()) {
            mywebView.canGoBack();
        } else {
            Intent intent = new Intent (BlogView.this,MotivationalBlogs.class);
            startActivity ( intent );
           // super.onBackPressed();
        }
    }
}