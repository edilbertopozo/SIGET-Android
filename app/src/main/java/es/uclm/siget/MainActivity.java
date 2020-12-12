package es.uclm.siget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView miVisorWeb;
    String url = "https://mant-agibilibus.herokuapp.com/Login.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#212529")));


        miVisorWeb = (WebView) findViewById(R.id.visorWeb);
        miVisorWeb.setWebViewClient(new WebViewClient());
        miVisorWeb.setWebChromeClient(new WebChromeClient());
        final WebSettings ajustesVisorWeb = miVisorWeb.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);

        if (savedInstanceState == null)
        {
            miVisorWeb.loadUrl(url);
            getSupportActionBar().setBackgroundDrawable(
                    new ColorDrawable(Color.parseColor("#337ab7")));
        }

        miVisorWeb.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                if(url.contains("Login")){
                    getSupportActionBar().setBackgroundDrawable(
                            new ColorDrawable(Color.parseColor("#337ab7")));
                }else{
                    getSupportActionBar().setBackgroundDrawable(
                            new ColorDrawable(Color.parseColor("#212529")));
                }
                return true;
            }
        });

    }
    @Override
    protected void onSaveInstanceState(Bundle outState )
    {
        super.onSaveInstanceState(outState);
        miVisorWeb.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        miVisorWeb.restoreState(savedInstanceState);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (miVisorWeb.canGoBack()) {
                        miVisorWeb.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}