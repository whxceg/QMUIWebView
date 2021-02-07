package com.sam.lib.qmui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.sam.lib.qmui.viewpager.QMUIFragmentPagerAdapter;

class MyFragmentViewPager extends QMUIFragmentPagerAdapter {

    public MyFragmentViewPager(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment createFragment(int position) {
        return new ItemFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Item:" + position;
    }
}