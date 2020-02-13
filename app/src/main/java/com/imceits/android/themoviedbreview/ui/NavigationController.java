package com.imceits.android.themoviedbreview.ui;
// Created by AUNGTUNTUN on 30/12/2018.

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import com.imceits.android.themoviedbreview.R;
import com.imceits.android.themoviedbreview.data.entity.Movie;
import com.imceits.android.themoviedbreview.ui.activities.MovieDetailActivity;
import com.imceits.android.themoviedbreview.utils.Constants;

import java.util.Objects;

public class NavigationController extends Constants {

    public static void redirectToMovieDetailScreen(Activity activity, Movie movie, View sharedView) {

        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                Objects.requireNonNull(activity),  sharedView, activity.getString(R.string.shared_image));
        activity.startActivity(MovieDetailActivity.newIntent(activity, movie.getId()), optionsCompat.toBundle());
     //   Intent intent = new Intent(activity, MovieDetailActivity.class);
     //   activity.startActivity(intent);
    }
}
