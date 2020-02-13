package com.imceits.android.themoviedbreview.data.model;
// Created by AUNGTUNTUN on 29/12/2018.

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imceits.android.themoviedbreview.data.entity.Movie;

import java.lang.reflect.Type;
import java.util.List;

public class MovieListTypeConverter {

    @TypeConverter
    public List<Movie> fromString(String value) {
        Type listType = new TypeToken<List<Movie>>(){}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public String fromList(List<Movie> movies) {
        return new Gson().toJson(movies);
    }
}
