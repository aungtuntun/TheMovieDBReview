package com.imceits.android.themoviedbreview.ui.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.view.MenuItem;
import android.view.View;

import com.imceits.android.themoviedbreview.R;
import com.imceits.android.themoviedbreview.data.entity.Movie;
import com.imceits.android.themoviedbreview.databinding.ActivityMovieDetailBinding;
import com.imceits.android.themoviedbreview.ui.NavigationController;
import com.imceits.android.themoviedbreview.ui.adapters.SimilarMovieAdapter;
import com.imceits.android.themoviedbreview.ui.viewmodels.MovieDetailViewModel;
import com.imceits.android.themoviedbreview.utils.Constants;
import com.imceits.android.themoviedbreview.utils.StringUtils;

import javax.inject.Inject;

import dagger.android.AndroidInjection;


public class MovieDetailActivity extends AppCompatActivity {

  //  @Inject
  //  DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    MovieDetailViewModel viewModel;

    public static Intent newIntent(Context context, int movieId) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(Constants.MOVIE_ID, movieId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ActivityMovieDetailBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail);
        dataBinding.setLifecycleOwner(this);
        setSupportActionBar(dataBinding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            Drawable drawable = dataBinding.toolbar.getNavigationIcon();
            assert drawable != null;
            drawable.setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_ATOP);
        }
        int movieId = getIntent().getIntExtra(Constants.MOVIE_ID, 0);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieDetailViewModel.class);
        viewModel.updateSearchParam(movieId);
        viewModel.getMovieDetail().observe(this, movie -> {
            dataBinding.setMovie(movie);
            if (movie != null && movie.getGenres() != null) {
                dataBinding.collectItemPicker.setUseRandomColor(true);
                dataBinding.collectItemPicker.setItems(StringUtils.getGenres(movie.getGenres()));
            }
            if (movie != null && movie.getSimilarMovies() != null) {
                dataBinding.similarLayout.similarMovieList.setFocusable(false);
                dataBinding.similarLayout.similarMovieList.setItemAnimator(new DefaultItemAnimator());
                dataBinding.similarLayout.similarMovieList.setHasFixedSize(true);
                dataBinding.similarLayout.similarMovieList.setNestedScrollingEnabled(false);
                dataBinding.similarLayout.similarMovieList.setAdapter(new SimilarMovieAdapter(this::showMovieDetail));
                dataBinding.similarLayout.setDataList(movie.getSimilarMovies());
            }
        });
    }

    private void showMovieDetail(Movie movie, View sharedView) {
        NavigationController.redirectToMovieDetailScreen(this, movie, sharedView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            ActivityCompat.finishAfterTransition(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

   /* @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }*/
}
