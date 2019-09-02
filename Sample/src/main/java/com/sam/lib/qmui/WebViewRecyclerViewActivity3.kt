package com.sam.lib.qmui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedBottomRecyclerView
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedTopDelegateLayout
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedTopWebView
import kotlinx.android.synthetic.main.activity_web_view_recycler_view3.*

class WebViewRecyclerViewActivity3 : AppCompatActivity() {

    lateinit var mWebView: QMUIContinuousNestedTopWebView

    lateinit var mRecyclerView: QMUIContinuousNestedBottomRecyclerView

    lateinit var mTopContainer: QMUIContinuousNestedTopDelegateLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_recycler_view3)

        mWebView = QMUIContinuousNestedTopWebView(this)

        mRecyclerView = QMUIContinuousNestedBottomRecyclerView(this)

        mTopContainer = QMUIContinuousNestedTopDelegateLayout(this)


        val headerView = LayoutInflater.from(this).inflate(R.layout.top_view, null)
        val footerView = LayoutInflater.from(this).inflate(R.layout.bottom_view, null)

        mTopContainer.headerView = headerView
        mTopContainer.footerView = footerView
        mTopContainer.delegateView = mWebView

        mCoordinatorLayout.setTopAreaView(mTopContainer, null)

        mCoordinatorLayout.setBottomAreaView(mRecyclerView, null)

        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = RecyclerAdapter()

        //        mWebView.loadUrl("https://mp.weixin.qq.com/s/zgfLOMD2JfZJKfHx-5BsBg")
        mWebView.loadUrl("http://cnki.net/")

    }
}
