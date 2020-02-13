package com.imceits.android.themoviedbreview.data.network;
// Created by AUNGTUNTUN on 29/12/2018.


import com.imceits.android.themoviedbreview.data.entity.Movie;
import com.imceits.android.themoviedbreview.data.model.CreditResponse;
import com.imceits.android.themoviedbreview.data.model.MovieApiResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApiInterface {

    @GET("movie/popular")
    Call<MovieApiResponse> loadMovies();

    @GET("movie/{movieId}")
    Observable<Movie> fetchMovieDetail(@Path("movieId") String movieId);

    @GET("movie/{movieId}/credits")
    Observable<CreditResponse> fetchCastDetail(@Path("movieId") String movieId);


    @GET("movie/{movieId}/similar")
    Observable<MovieApiResponse> fetchSimilarMovie(@Path("movieId") String movieId,
                                                   @Query("page") int page);
}
