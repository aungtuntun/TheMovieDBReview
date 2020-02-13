package com.imceits.android.themoviedbreview.ui.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.imceits.android.themoviedbreview.data.entity.Movie;
import com.imceits.android.themoviedbreview.data.repository.MovieRepository;
import com.imceits.android.themoviedbreview.ui.AbsentLiveData;

import java.util.Objects;

import javax.inject.Inject;

// Created by AUNGTUNTUN on 30/12/2018.

public class MovieDetailViewModel extends ViewModel {

    private final MutableLiveData<Integer> searchParam = new MutableLiveData<>();
    private LiveData<Movie> movieDetail;
    @Inject
    MovieDetailViewModel(MovieRepository movieRepository) {
        movieDetail = Transformations.switchMap(searchParam, input -> {
            if (input == 0) {
                return AbsentLiveData.create();
            } else {
                return movieRepository.getMovie(input);
            }
        });
    }

    public LiveData<Movie> getMovieDetail() {
        return movieDetail;
    }

    public void updateSearchParam(int id) {
        if (Objects.equals(id, searchParam.getValue())) {
            return;
        }
        searchParam.setValue(id);
    }
}
