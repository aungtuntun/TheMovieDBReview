package com.imceits.android.themoviedbreview.data.repository;
// Created by AUNGTUNTUN on 29/12/2018.

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.imceits.android.themoviedbreview.data.NetworkBoundResource;
import com.imceits.android.themoviedbreview.data.Resource;
import com.imceits.android.themoviedbreview.data.dao.MovieDao;
import com.imceits.android.themoviedbreview.data.entity.Movie;
import com.imceits.android.themoviedbreview.data.model.CreditResponse;
import com.imceits.android.themoviedbreview.data.model.MovieApiResponse;
import com.imceits.android.themoviedbreview.data.network.MovieApiInterface;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function3;
import retrofit2.Call;

@Singleton
public class MovieRepository {
    private final MovieDao movieDao;
    private final MovieApiInterface apiInterface;

    @Inject
    MovieRepository(MovieDao movieDao, MovieApiInterface apiInterface) {
        this.movieDao = movieDao;
        this.apiInterface = apiInterface;
    }

    public LiveData<Resource<List<Movie>>> loadPopularMovies() {
        return new NetworkBoundResource<List<Movie>, MovieApiResponse>() {

            @SuppressLint("CheckResult")
            @Override
            protected void saveCallResult(@NonNull MovieApiResponse item) {
                for (int i = 0; i < item.getResults().size(); i++) {
                    String id = String.valueOf(item.getResults().get(i).getId());
                    Observable.combineLatest(apiInterface.fetchMovieDetail(id),
                            apiInterface.fetchCastDetail(id),
                            apiInterface.fetchSimilarMovie(id, item.getPage()), new Function3<Movie, CreditResponse, MovieApiResponse, Movie>() {
                                @Override
                                public Movie apply(Movie movie, CreditResponse response, MovieApiResponse movieApiResponse) throws Exception {
                                    if (response != null) {
                                        movie.setCasts(response.getCast());
                                        movie.setCrews(response.getCrew());
                                    }
                                    if (movieApiResponse != null) {
                                        movie.setSimilarMovies(movieApiResponse.getResults());
                                    }
                                    return movie;
                                }
                            }).subscribe(new Consumer<Movie>() {
                        @Override
                        public void accept(Movie movies) throws Exception {
                            movieDao.insertMovie(movies);
                        }
                    });
                }
              //  movieDao.saveMovies(item.getResults());
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Movie> data) {
                return true;
            }

            @NonNull
            @Override
            protected LiveData<List<Movie>> loadFromDb() {
                return movieDao.getAllMovies();
            }

            @NonNull
            @Override
            protected Call<MovieApiResponse> createCall() {
                return apiInterface.loadMovies();
            }
        }.getAsLiveData();
    }

    public LiveData<Movie> getMovie(int id) {
        return movieDao.getMovie(id);
    }
}
