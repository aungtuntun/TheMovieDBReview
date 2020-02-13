package com.imceits.android.themoviedbreview.data.model;
// Created by AUNGTUNTUN on 29/12/2018.

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class CreditResponseTypeConverter {
    @TypeConverter
    public CreditResponse fromString(String value) {
        Type listType = new TypeToken<CreditResponse>(){}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromModel(CreditResponse response) {
        return new Gson().toJson(response);
    }
}
