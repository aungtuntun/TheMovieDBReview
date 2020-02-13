package com.imceits.android.themoviedbreview.ui.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.imceits.android.themoviedbreview.data.Resource;
import com.imceits.android.themoviedbreview.data.entity.Movie;
import com.imceits.android.themoviedbreview.data.repository.MovieRepository;

import java.util.List;

import javax.inject.Inject;

// Created by AUNGTUNTUN on 29/12/2018.

public class MovieListViewModel extends ViewModel {

    private LiveData<Resource<List<Movie>>> movieList;

    @Inject
    MovieListViewModel(MovieRepository movieRepository) {
        movieList = movieRepository.loadPopularMovies();
    }

    public LiveData<Resource<List<Movie>>> getPopularMovies() {
        return movieList;
    }
}
