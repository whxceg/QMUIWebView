package com.sam.lib.qmui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.webkit.*
import androidx.annotation.Keep
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_appbar_web_view_recycler_view.*

class AppbarLayoutWebViewRecyclerViewActivity : AppCompatActivity() {


    @SuppressLint("JavascriptInterface")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appbar_web_view_recycler_view)

//        mWebView.loadUrl("https://mp.weixin.qq.com/s/zgfLOMD2JfZJKfHx-5BsBg")
//        mWebView.loadUrl("http://cnki.net/")

//
//        mWebView.webViewClient = QMUIWebViewClient(true,true)
////        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mWebView.settings.javaScriptEnabled = true

        mWebView.webChromeClient = object : WebChromeClient() {

        }

        mWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }
        }
//
        mWebView.addJavascriptInterface(ObjectInterface(), "a")

        mRecyclerView.layoutManager = object : LinearLayoutManager(this) {
            override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
                return RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT)
            }
        }

        mRecyclerView.adapter = RecyclerAdapter()
        mWebView.loadDataWithBaseURL("", HtmlParse.html, "text/html", "utf-8", "");
    }

    @Keep
    class ObjectInterface {

        @JavascriptInterface
        fun zxcx() {
            Log.e("sam", "zxcx: ")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
