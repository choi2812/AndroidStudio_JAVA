package com.example.sai.android106test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public  void onClickAction(View view){
        WebView webView=(WebView)findViewById(R.id.wView);
        webView.setWebViewClient(new WebViewClient() {});
        webView.loadUrl("https://www.facebook.com/");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(menu.NONE,0,Menu.NONE,"yahoo");
        menu.add(menu.NONE,1,Menu.NONE,"google");
        menu.add(menu.NONE,2,Menu.NONE,"終了");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        WebView webView=(WebView)findViewById(R.id.wView);
        webView.setWebViewClient(new WebViewClient() {
        });
        switch (item.getItemId()) {
            case 0:
                Toast.makeText(this, "yahooを表示する？", Toast.LENGTH_LONG).show();
                webView.loadUrl("http://www.yahoo.co.jp/");
                return true;
            case 1:
                Toast.makeText(this, "googleを表示する？", Toast.LENGTH_LONG).show();
                webView.loadUrl("https://www.google.co.jp/?hl=ko");
                return true;
            case 2:
                finish();
                return true;
        }
        return false;
    }
}
