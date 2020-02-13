package com.imceits.android.themoviedbreview.di;
// Created by AUNGTUNTUN on 29/12/2018.

import android.app.Application;
import android.arch.persistence.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imceits.android.themoviedbreview.data.MovieDatabase;
import com.imceits.android.themoviedbreview.data.dao.MovieDao;
import com.imceits.android.themoviedbreview.data.network.MovieApiInterface;
import com.imceits.android.themoviedbreview.data.network.RequestInterceptor;
import com.imceits.android.themoviedbreview.utils.Constants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {ViewModelModule.class})
class AppModule {

    @Singleton @Provides
    MovieDatabase provideMovieDatabase(Application application) {
        return Room.databaseBuilder(application, MovieDatabase.class, "movie.db")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Singleton @Provides
    MovieDao provideMovieDao(MovieDatabase db) {
        return db.movieDao();
    }

    @Singleton @Provides
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }
    @Singleton @Provides
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(Constants.TIMEOUT_IN_SEC, TimeUnit.SECONDS)
                .readTimeout(Constants.TIMEOUT_IN_SEC, TimeUnit.SECONDS)
                .addInterceptor(new RequestInterceptor());
        return okHttpClient.build();
    }
    @Singleton @Provides
    MovieApiInterface provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(MovieApiInterface.class);
    }
}
