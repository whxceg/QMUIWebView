package com.sam.lib.qmui

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedBottomAreaBehavior
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedBottomRecyclerView
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedTopAreaBehavior
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedTopWebView
import kotlinx.android.synthetic.main.activity_web_view_recycler_view.*


class WebViewRecyclerViewActivity : AppCompatActivity() {

    lateinit var mWebView: QMUIContinuousNestedTopWebView
    lateinit var mRecyclerView: QMUIContinuousNestedBottomRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_recycler_view)

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


//        mWebView.loadUrl("https://mp.weixin.qq.com/s/zgfLOMD2JfZJKfHx-5BsBg")
        mWebView.loadUrl("http://cnki.net/")

        mRecyclerView.layoutManager = LinearLayoutManager(this)

        mRecyclerView.adapter = RecyclerAdapter()

    }
}
