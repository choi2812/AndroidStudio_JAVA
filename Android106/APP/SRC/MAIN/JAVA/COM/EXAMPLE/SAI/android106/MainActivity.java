package com.example.sai.android106;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int MENU_YAHOO=0;
    private static final int MENU_GOOGLE=1;
    private static final int MENU_FACEBOOK=2;
    private static final int MENU_END=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WebView webView=(WebView)findViewById(R.id.webView);
        webView.getSettings().setBuiltInZoomControls(true);

    }

    public  void onStartAction(View view){
        EditText edt = (EditText)findViewById(R.id.edtAddress);
        WebView webView=(WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient() {
        });
        webView.loadUrl(edt.getText().toString());
        Log.i("asd", edt.getText().toString());

    }
    public  void javaScriptAction(View view){
        CheckBox chk = (CheckBox) findViewById(R.id.chkJavaScript);
        WebView webView=(WebView)findViewById(R.id.webView);
        if (chk.isChecked()==true){
            webView.getSettings().setJavaScriptEnabled(true);
        }else{
            webView.getSettings().setJavaScriptEnabled(false);
        }

    }
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        WebView webView=(WebView)findViewById(R.id.webView);
        if(keyCode==KeyEvent.KEYCODE_BACK && webView.canGoBack()){
            webView.goBack();
            return  true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuItem item1=menu.add(Menu.NONE, MENU_YAHOO,Menu.NONE,"yahoo");
        item1.setIcon(android.R.drawable.ic_menu_call);
        item1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        MenuItem item2=menu.add(Menu.NONE, MENU_GOOGLE, Menu.NONE, "google");
        MenuItem item3=menu.add(Menu.NONE, MENU_FACEBOOK, Menu.NONE, "facebook");
        MenuItem item4=menu.add(Menu.NONE, MENU_END, Menu.NONE, "終了");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        WebView webView=(WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient() {
        });
        switch (item.getItemId()) {
            case MENU_YAHOO:
                Toast.makeText(this, "yahooを表示する？", Toast.LENGTH_SHORT).show();
                webView.loadUrl("http://www.yahoo.co.jp/");
                return true;
            case MENU_GOOGLE:
                Toast.makeText(this, "googleを表示する？", Toast.LENGTH_SHORT).show();
                webView.loadUrl("https://www.google.co.jp/?hl=ko");
                return true;
            case MENU_FACEBOOK:
                Toast.makeText(this, "facebookを表示する？", Toast.LENGTH_SHORT).show();
                webView.loadUrl("https://www.facebook.com/");
                return true;
            case MENU_END:
                finish();
                return true;
        }
        return false;

    }
    private class CustomWebView extends WebViewClient{
        //ページ読み込み開始
        @Override
        public void onPageStarted(WebView view,String url,Bitmap favicon){
           Toast.makeText(view.getContext(),"onPageStarted",Toast.LENGTH_LONG).show();
        }
        //ページ読み込み終了
        @Override
        public void onPageFinished(WebView view,String url){
            Toast.makeText(view.getContext(),"onPageFinished",Toast.LENGTH_LONG).show();
        }
        //ページ読み込み失敗
        @Override
        public void onReceivedError(WebView view,int errorCode,String description,String failingUrl){
            Toast.makeText(view.getContext(),"onReceivedError",Toast.LENGTH_LONG).show();
        }
    }
}
