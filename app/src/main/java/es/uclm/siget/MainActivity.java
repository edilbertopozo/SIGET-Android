package es.uclm.siget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
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
        miVisorWeb = (WebView) findViewById(R.id.visorWeb);
        final WebSettings ajustesVisorWeb = miVisorWeb.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);
        miVisorWeb.loadUrl(url);
        miVisorWeb.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                getSupportActionBar().setBackgroundDrawable(
                        new ColorDrawable(Color.parseColor("#212529")));
                return true;
            }
        });
    }
}