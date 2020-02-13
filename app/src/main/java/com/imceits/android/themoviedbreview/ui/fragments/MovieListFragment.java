package com.imceits.android.themoviedbreview.ui.fragments;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingComponent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imceits.android.themoviedbreview.R;
import com.imceits.android.themoviedbreview.binding.FragmentDataBindingComponent;
import com.imceits.android.themoviedbreview.data.entity.Movie;
import com.imceits.android.themoviedbreview.databinding.FragmentMovieListBinding;
import com.imceits.android.themoviedbreview.di.Injectable;
import com.imceits.android.themoviedbreview.ui.AutoClearedValue;
import com.imceits.android.themoviedbreview.ui.NavigationController;
import com.imceits.android.themoviedbreview.ui.activities.MovieDetailActivity;
import com.imceits.android.themoviedbreview.ui.adapters.MovieListAdapter;
import com.imceits.android.themoviedbreview.ui.viewmodels.MovieListViewModel;

import java.util.Objects;

import javax.inject.Inject;

import static com.imceits.android.themoviedbreview.utils.Constants.PAGE_COUNT;

// Created by AUNGTUNTUN on 30/12/2018.
public class MovieListFragment extends Fragment implements Injectable {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);

    private int count = 0;
    MovieListViewModel viewModel;
    AutoClearedValue<FragmentMovieListBinding> binding;

    public MovieListFragment() {
    }

    public static MovieListFragment newInstance(int columnCount) {
        MovieListFragment fragment = new MovieListFragment();
        Bundle args = new Bundle();
        args.putInt(PAGE_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            count = getArguments().getInt(PAGE_COUNT);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentMovieListBinding  dataBinding = FragmentMovieListBinding.inflate(inflater, container,
                false, dataBindingComponent);
        dataBinding.setLifecycleOwner(this);
        binding = new AutoClearedValue<>(this, dataBinding);
        dataBinding.movieListView.setHasFixedSize(true);
        dataBinding.movieListView.setItemAnimator(new DefaultItemAnimator());
        dataBinding.movieListView.setFocusable(false);
        dataBinding.movieListView.setAdapter(new MovieListAdapter(dataBindingComponent, this::showDetail));
        return dataBinding.getRoot();
    }

    private void showDetail(Movie movie, View sharedView) {
  /*      ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                Objects.requireNonNull(getActivity()),  sharedView, getString(R.string.shared_image));
        startActivity(MovieDetailActivity.newIntent(getActivity(), movie.getId()), optionsCompat.toBundle());*/
        NavigationController.redirectToMovieDetailScreen(getActivity(), movie, sharedView);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieListViewModel.class);
        if (count == 0) {
            viewModel.getPopularMovies().observe(this, listResource -> {
                if (listResource != null && listResource.data != null) {
                    binding.getValue().setDataList(listResource.data);
                }
            });
        } else if (count == 1) {
            viewModel.getPopularMovies().observe(this, listResource -> {
                if (listResource != null && listResource.data != null) {
                    binding.getValue().setDataList(listResource.data);
                }
            });
        } else if (count == 2) {
            viewModel.getPopularMovies().observe(this, listResource -> {
                if (listResource != null && listResource.data != null) {
                    binding.getValue().setDataList(listResource.data);
                }
            });
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
