package com.gmail.farasabiyyu12.beritasekarang;

//import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail);

//        Intent a1 = new Intent();
//        String string = a1.getStringExtra("url");

        //register webview
        WebView webView = findViewById(R.id.webview);
        //setting Javascript
        webView.getSettings().setJavaScriptEnabled(true);
        //setting url with parsing data
        webView.loadUrl(getIntent().getStringExtra("browser"));
        //Making button can be clicked on web
        webView.setWebViewClient(new webViewClient());

    }

    private class webViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Uri.parse(url).getHost().equals(getIntent().getStringExtra("url")))
                return false;
            else
                return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
