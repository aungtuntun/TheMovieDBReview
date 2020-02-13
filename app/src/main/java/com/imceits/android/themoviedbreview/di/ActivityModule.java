package com.imceits.android.themoviedbreview.di;
// Created by AUNGTUNTUN on 29/12/2018.

import com.imceits.android.themoviedbreview.ui.activities.MainActivity;
import com.imceits.android.themoviedbreview.ui.activities.MovieDetailActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MainActivity contributeMainActivity();
    @ContributesAndroidInjector
    abstract MovieDetailActivity contributeMovieDetailActivity();
}
