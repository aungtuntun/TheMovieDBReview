package com.imceits.android.themoviedbreview.di;
// Created by AUNGTUNTUN on 29/12/2018.

import com.imceits.android.themoviedbreview.ui.fragments.MovieListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract MovieListFragment contributeMovieListFragment();
}
