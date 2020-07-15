package com.sam.lib.qmui

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import androidx.annotation.Keep
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedBottomAreaBehavior
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedBottomRecyclerView
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedTopAreaBehavior
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedTopWebView
import com.sam.lib.qmui.webview.QMUIBridgeWebViewClient
import com.sam.lib.qmui.webview.QMUIWebViewBridgeHandler
import kotlinx.android.synthetic.main.activity_qmui_web_view_recycler_view.*
import org.json.JSONObject


class QMUIWebViewRecyclerViewActivity : AppCompatActivity() {

    lateinit var mWebView: QMUIContinuousNestedTopWebView
    lateinit var mRecyclerView: QMUIContinuousNestedBottomRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qmui_web_view_recycler_view)

        mWebView = QMUIContinuousNestedTopWebView(this)
        mRecyclerView = QMUIContinuousNestedBottomRecyclerView(this)

        val topLayoutParams = CoordinatorLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        )
        topLayoutParams.behavior = QMUIContinuousNestedTopAreaBehavior(this)
        mCoordinatorLayout.setTopAreaView(mWebView, topLayoutParams)

        val bottomLayoutParams = CoordinatorLayout.LayoutParams(
                CoordinatorLayout.LayoutParams.MATCH_PARENT,
                CoordinatorLayout.LayoutParams.MATCH_PARENT
        )
        bottomLayoutParams.behavior = QMUIContinuousNestedBottomAreaBehavior()

        mCoordinatorLayout.setBottomAreaView(mRecyclerView, bottomLayoutParams)


//        mWebView.webViewClient = QMUIWebViewClient(true,true)
//        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mWebView.settings.javaScriptEnabled = true

        mWebView.webViewClient = QMUIBridgeWebViewClient(true, true, object : QMUIWebViewBridgeHandler(mWebView) {
            override fun handleMessage(message: String?): JSONObject {

                Log.e("sam", "handleMessage: $message")
                val obj = JSONObject();
                obj.put("sssssssssssssssssss","WWWWWWWWWWWWWW")
                return obj
            }
        })


//        mWebView.addJavascriptInterface(ObjectInterface(),"a")


//        mWebView.loadUrl("https://mp.weixin.qq.com/s/zgfLOMD2JfZJKfHx-5BsBg")
//        mWebView.loadUrl("http://cnki.net/")
        mWebView.loadDataWithBaseURL("", HtmlParse.html, "text/html", "utf-8", "");

        mRecyclerView.layoutManager = object : LinearLayoutManager(this) {
            override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
                return RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT)
            }
        }

        mRecyclerView.adapter = RecyclerAdapter()

    }

    @Keep
    class ObjectInterface {

        @JavascriptInterface
        fun zxcx() {
            Log.e("sam", "zxcx: ")
        }
    }

    override fun onDestroy() {
        (mWebView.parent as ViewGroup).removeAllViews()
        mWebView.destroy()
        super.onDestroy()
    }
}
