package com.sam.lib.qmui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedBottomAreaBehavior
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedTopAreaBehavior
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedTopDelegateLayout
import com.sam.lib.qmui.nestedscroll.QMUIContinuousNestedTopWebView
import com.sam.lib.qmui.webview.QMUIWebViewClient
import kotlinx.android.synthetic.main.activity_web_view_header_footer_recycler_view.*

class QMUIHeaderWebViewFooterViewViewPagerActivity : AppCompatActivity() {

    lateinit var mTopContainer: QMUIContinuousNestedTopDelegateLayout
    lateinit var mBottomContainer: QDContinuousBottomView
    lateinit var mWebView: QMUIContinuousNestedTopWebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_header_footer_recycler_view)

        mTopContainer = QMUIContinuousNestedTopDelegateLayout(this)
        mBottomContainer = QDContinuousBottomView(this)

        mWebView = QMUIContinuousNestedTopWebView(this)
        val headerView = LayoutInflater.from(this).inflate(R.layout.top_view, null)
        val footerView = LayoutInflater.from(this).inflate(R.layout.bottom_view, null)

        mTopContainer.headerView = headerView
        mTopContainer.footerView = footerView
        mTopContainer.delegateView = mWebView


        val matchParent = ViewGroup.LayoutParams.MATCH_PARENT

        val topLp = CoordinatorLayout.LayoutParams(matchParent, matchParent)
        topLp.behavior = QMUIContinuousNestedTopAreaBehavior(this)
        mCoordinatorLayout.setTopAreaView(mTopContainer, topLp)

        val bottomLayoutParams = CoordinatorLayout.LayoutParams(matchParent, matchParent)
        bottomLayoutParams.behavior = QMUIContinuousNestedBottomAreaBehavior()
        mCoordinatorLayout.setBottomAreaView(mBottomContainer, bottomLayoutParams)


        mWebView.webViewClient = QMUIWebViewClient(true, true)

//                mWebView.loadUrl("https://mp.weixin.qq.com/s/zgfLOMD2JfZJKfHx-5BsBg")
        mWebView.loadUrl("http://cnki.net/")

    }
}
