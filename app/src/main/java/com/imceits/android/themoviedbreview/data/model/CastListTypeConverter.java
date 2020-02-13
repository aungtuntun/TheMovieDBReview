package com.imceits.android.themoviedbreview.data.model;
// Created by AUNGTUNTUN on 29/12/2018.

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class CastListTypeConverter {
    @TypeConverter
    public List<Cast> fromString(String value) {
        Type listType = new TypeToken<List<Cast>>(){}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public String fromList(List<Cast> casts) {
        return new Gson().toJson(casts);
    }
}
