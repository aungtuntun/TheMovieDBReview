package com.imceits.android.themoviedbreview;
// Created by AUNGTUNTUN on 29/12/2018.

import android.app.Activity;
import android.app.Application;

import com.imceits.android.themoviedbreview.di.AppInjector;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MovieApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> androidInjector;
    @Override
    public AndroidInjector<Activity> activityInjector() {
        return androidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppInjector.init(this);
    }
}
