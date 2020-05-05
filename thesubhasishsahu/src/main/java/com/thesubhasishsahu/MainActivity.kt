package com.thesubhasishsahu

import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.thesubhasishsahu.R

class MainActivity : AppCompatActivity() {

    lateinit  var webView: WebView
    lateinit  var webSettings: WebSettings

    override fun onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else {
            super.onBackPressed()
        }
    }

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById(R.id.webView);
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(WebViewClient());
        webView.loadUrl("https://thesubhasishsahu.com");

        
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            //If there is history, then the canGoBack method will return ‘true’//
            return true
        }

     //If the button that’s been pressed wasn’t the ‘Back’ button, or there’s currently no
     //WebView history, then the system should resort to its default behavior and return
     //the user to the previous Activity//
        return super.onKeyDown(keyCode, event)
     }
}
