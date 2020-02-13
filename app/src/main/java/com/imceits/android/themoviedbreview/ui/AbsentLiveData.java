package com.imceits.android.themoviedbreview.ui;

import android.arch.lifecycle.LiveData;

// Created by AUNGTUNTUN on 30/12/2018.

public class AbsentLiveData extends LiveData {

    private AbsentLiveData() {
        postValue(null);
    }

    public static <T> LiveData<T> create() {
        return new AbsentLiveData();
    }
}
