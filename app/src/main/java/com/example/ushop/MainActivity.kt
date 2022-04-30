package com.example.ushop

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    val webTarget : String = "https://onlinetst.unibank.az/testmob2/ushop/?sessionKey=5DCC97359FF7E28F8AF3D5998C3AFE7E&terminalId=mobile&appType=RETAIL&deviceId=test_device&userAgent=insomnia_rest&lang=ru&mode=dark";
    private val webView: WebView? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        val webView = findViewById<WebView>(R.id.webview)
        webView.webViewClient = WebViewClient();
        webView.loadUrl(webTarget)
        val webSettings = webView.settings;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(WebChromeClient())


        val fab = findViewById<View>(R.id.btn)
        fab.setOnClickListener {
            webView.evaluateJavascript("updateSession ('test_session_key');", null);
        }


    }



}