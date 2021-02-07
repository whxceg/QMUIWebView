package com.sam.lib.qmui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addView(AppbarLayoutWebViewRecyclerViewActivity::class.java)
        addView(QMUIWebViewRecyclerViewActivity::class.java)
        addView(QMUIWebViewHeaderFooterViewRecyclerViewActivity::class.java)
        addView(QMUIHeaderWebViewFooterViewViewPagerActivity::class.java)
        addView(ViewPagerActivity::class.java)
    }

    private fun addView(clazz: Class<out Activity>) {
        val button = Button(this)
        button.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.text = clazz.simpleName
        button.isAllCaps = false
        button.setOnClickListener {
            startActivity(Intent(it.context, clazz))
        }
        mRootView.addView(button)
    }
}
