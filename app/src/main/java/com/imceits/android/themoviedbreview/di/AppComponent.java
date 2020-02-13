package com.imceits.android.themoviedbreview.di;
// Created by AUNGTUNTUN on 29/12/2018.

import android.app.Application;

import com.imceits.android.themoviedbreview.MovieApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AppModule.class, ActivityModule.class, AndroidSupportInjectionModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(MovieApp app);
}
