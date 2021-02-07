package com.sam.lib.qmui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sam.lib.qmui.viewpager.QMUIViewPager

class ViewPagerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        val vp = findViewById<QMUIViewPager>(R.id.vp);

        vp.adapter = MyFragmentViewPager(supportFragmentManager);
    }

}