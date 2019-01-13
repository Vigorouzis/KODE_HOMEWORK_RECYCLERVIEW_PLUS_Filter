package com.example.pc.kode_homework_recycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_web.*
import android.webkit.WebView
import android.webkit.WebViewClient


class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)


        val Intent = intent
        val name = Intent.getStringExtra("Title")
        webview.webViewClient = WebViewClient()
        when (name) {
            "Java" -> webview.loadUrl("https://ru.wikipedia.org/wiki/Java")
            "C" -> webview.loadUrl("https://ru.wikipedia.org/wiki/Си_(язык_программирования)")
            "Python" -> webview.loadUrl("https://ru.wikipedia.org/wiki/Python")
            "C++" -> webview.loadUrl("https://ru.wikipedia.org/wiki/C%2B%2B")
            "Visual Basic.NET" -> webview.loadUrl("https://ru.wikipedia.org/wiki/Visual_Basic")
            "Javascript" -> webview.loadUrl("https://ru.wikipedia.org/wiki/JavaScript")
            "C#" -> webview.loadUrl("https://ru.wikipedia.org/wiki/C_Sharp")
            "Php" -> webview.loadUrl("https://ru.wikipedia.org/wiki/PHP")
            "SQL" -> webview.loadUrl("https://ru.wikipedia.org/wiki/SQL")
            "Objective-C" -> webview.loadUrl("https://ru.wikipedia.org/wiki/Objective-C")

        }
    }
}
