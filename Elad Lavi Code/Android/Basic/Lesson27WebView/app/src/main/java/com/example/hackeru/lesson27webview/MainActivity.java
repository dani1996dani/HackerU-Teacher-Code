package com.example.hackeru.lesson27webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends Activity {

    private WebView webView;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setAllowContentAccess(true);
        webSettings.setBuiltInZoomControls(false);
        //webView.loadUrl("https://edition.cnn.com/");
        updateHtml();
    }

    private void updateHtml(){
        String html = "<html><head></head><body><h1>Welcome to my website</h1><p id=\"p1\">this is the <strong>first</strong> paragraph "+counter+"</p></body></html>";
        webView.loadData(html, "text/html", "utf-8");
    }


    public void btnIncrement(View view) {
        counter++;
        updateHtml();
    }
}
