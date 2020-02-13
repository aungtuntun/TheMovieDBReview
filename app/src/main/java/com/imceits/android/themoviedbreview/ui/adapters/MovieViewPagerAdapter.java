package com.imceits.android.themoviedbreview.ui.adapters;
// Created by AUNGTUNTUN on 30/12/2018.

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.imceits.android.themoviedbreview.ui.fragments.MovieListFragment;

public class MovieViewPagerAdapter extends FragmentStatePagerAdapter {
    private static final String[] titles = new String[]{"Popular", "Science", "Comedy"};

    public MovieViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return MovieListFragment.newInstance(i);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
