package com.imceits.android.themoviedbreview.data;
// Created by AUNGTUNTUN on 29/12/2018.

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.imceits.android.themoviedbreview.data.dao.MovieDao;
import com.imceits.android.themoviedbreview.data.entity.Movie;
import com.imceits.android.themoviedbreview.data.model.CastListTypeConverter;
import com.imceits.android.themoviedbreview.data.model.CreditResponseTypeConverter;
import com.imceits.android.themoviedbreview.data.model.CrewListTypeConverter;
import com.imceits.android.themoviedbreview.data.model.GenreListTypeConverter;
import com.imceits.android.themoviedbreview.data.model.StringListTypeConverter;

@TypeConverters({DateConverter.class, CastListTypeConverter.class, CreditResponseTypeConverter.class,
        CrewListTypeConverter.class, GenreListTypeConverter.class, StringListTypeConverter.class})
@Database(entities = {Movie.class}, version = 1)
public abstract class MovieDatabase extends RoomDatabase {

    public abstract MovieDao movieDao();
}
