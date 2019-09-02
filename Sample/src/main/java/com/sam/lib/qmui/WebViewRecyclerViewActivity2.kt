package com.sam.lib.qmui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedBottomRecyclerView
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedTopWebView

class WebViewRecyclerViewActivity2 : AppCompatActivity() {

    lateinit var mWebView: QMUIContinuousNestedTopWebView
    lateinit var mRecyclerView: QMUIContinuousNestedBottomRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_recycler_view3)


    }
}
