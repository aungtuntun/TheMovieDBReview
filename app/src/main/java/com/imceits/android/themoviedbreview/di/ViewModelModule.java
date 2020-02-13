package com.imceits.android.themoviedbreview.di;
// Created by AUNGTUNTUN on 29/12/2018.

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.imceits.android.themoviedbreview.factory.MovieViewModelFactory;
import com.imceits.android.themoviedbreview.ui.viewmodels.MovieDetailViewModel;
import com.imceits.android.themoviedbreview.ui.viewmodels.MovieListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel.class)
    abstract ViewModel bindMovieListViewModel(MovieListViewModel movieListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel.class)
    abstract ViewModel bindMovieDetailViewModel(MovieDetailViewModel movieDetailViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(MovieViewModelFactory factory);
}
