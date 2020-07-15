package com.sam.lib.qmui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.sam.lib.qmui.nestedscroll.*
import com.sam.lib.qmui.webview.QMUIWebViewClient
import kotlinx.android.synthetic.main.activity_web_view_header_footer_recycler_view.*

class QMUIWebViewHeaderFooterViewRecyclerViewActivity : AppCompatActivity() {

    lateinit var mWebView: QMUIContinuousNestedTopWebView

    lateinit var mRecyclerView: QMUIContinuousNestedBottomRecyclerView

    lateinit var mTopContainer: QMUIContinuousNestedTopDelegateLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_header_footer_recycler_view)

        mWebView = QMUIContinuousNestedTopWebView(this)

        mRecyclerView = QMUIContinuousNestedBottomRecyclerView(this)

        mTopContainer = QMUIContinuousNestedTopDelegateLayout(this)


        val headerView = LayoutInflater.from(this).inflate(R.layout.top_view, null)
        val footerView = LayoutInflater.from(this).inflate(R.layout.bottom_view, null)

        mTopContainer.headerView = headerView
        mTopContainer.footerView = footerView
        mTopContainer.delegateView = mWebView

        mWebView.webViewClient = QMUIWebViewClient(true, true)

        val matchParent = ViewGroup.LayoutParams.MATCH_PARENT
        val topLp = CoordinatorLayout.LayoutParams(
                matchParent, matchParent)
        topLp.behavior = QMUIContinuousNestedTopAreaBehavior(this)

        mCoordinatorLayout.setTopAreaView(mTopContainer, topLp)

        val bottomLayoutParams = CoordinatorLayout.LayoutParams(
                CoordinatorLayout.LayoutParams.MATCH_PARENT,
                CoordinatorLayout.LayoutParams.MATCH_PARENT
        )
        bottomLayoutParams.behavior = QMUIContinuousNestedBottomAreaBehavior()
        mCoordinatorLayout.setBottomAreaView(mRecyclerView, bottomLayoutParams)

        mRecyclerView.layoutManager = LinearLayoutManager(this)

        mRecyclerView.adapter = RecyclerAdapter()

//                mWebView.loadUrl("https://mp.weixin.qq.com/s/zgfLOMD2JfZJKfHx-5BsBg")
        mWebView.loadUrl("http://cnki.net/")

    }
}
