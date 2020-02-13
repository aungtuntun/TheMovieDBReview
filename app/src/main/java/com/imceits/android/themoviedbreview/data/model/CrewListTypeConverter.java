package com.imceits.android.themoviedbreview.data.model;
// Created by AUNGTUNTUN on 29/12/2018.

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class CrewListTypeConverter {

    @TypeConverter
    public List<Crew> fromString(String value) {
        Type listType = new TypeToken<List<Crew>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromList(List<Crew> crews) {
        return new Gson().toJson(crews);
    }
}
