package com.imceits.android.themoviedbreview.data.dao;
// Created by AUNGTUNTUN on 29/12/2018.

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.view.View;

import com.imceits.android.themoviedbreview.data.entity.Movie;

import java.util.List;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM Movie")
    LiveData<List<Movie>> getAllMovies();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveMovies(List<Movie> movies);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(Movie movies);

    @Query("SELECT * FROM Movie WHERE movie_id = :id")
    LiveData<Movie> getMovie(int id);


}
