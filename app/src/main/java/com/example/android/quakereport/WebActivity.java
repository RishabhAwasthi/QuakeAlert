package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Bundle extras = getIntent().getExtras();
        String url, title;


        title = extras.getString("place");
        setTitle(title);

        url = extras.getString("url");

        WebView webView = (WebView) findViewById(R.id.WebView);
        WebSettings wv_settings = webView.getSettings();


        webView.setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage cm) {

                return true;
            }
        });
        wv_settings.setDomStorageEnabled(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                setTitle(view.getTitle());
                //do your stuff ...
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("file"))
                {
                    // Keep local assets in this WebView.
                    return false;
                }
                return true;
            }
        });

//wv.setWebViewClient(new HelpClient(this));//
        webView.clearCache(true);
        webView.clearHistory();
        wv_settings.setJavaScriptEnabled(true);//XSS vulnerable
        wv_settings.setJavaScriptCanOpenWindowsAutomatically(true);

        // webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }
}

