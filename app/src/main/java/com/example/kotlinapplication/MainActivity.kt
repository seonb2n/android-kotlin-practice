package com.example.kotlinapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val webView: WebView by lazy {
        findViewById(R.id.webView)
    }

    private val addressBar: EditText by lazy {
        findViewById(R.id.addressBar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        bindViews()
    }

    private fun bindViews() {
        addressBar.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE) {
                webView.loadUrl(v.text.toString())
            }

            return@setOnEditorActionListener false
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initViews() {
        webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl("http://www.google.com")
        }
    }


}