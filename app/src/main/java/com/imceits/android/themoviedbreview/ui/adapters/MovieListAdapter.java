package com.imceits.android.themoviedbreview.ui.adapters;

import android.databinding.DataBindingComponent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imceits.android.themoviedbreview.data.entity.Movie;
import com.imceits.android.themoviedbreview.databinding.MovieItemBinding;
import com.imceits.android.themoviedbreview.ui.BaseAdapter;

import java.util.ArrayList;
import java.util.List;
// Created by AUNGTUNTUN on 30/12/2018.
public class MovieListAdapter extends BaseAdapter<MovieListAdapter.MovieViewHolder, Movie> {

    private final DataBindingComponent dataBindingComponent;
    private List<Movie> movieList;
    private final MovieDetailCallback listener;

    public MovieListAdapter(DataBindingComponent dataBindingComponent, MovieDetailCallback listener) {
        this.dataBindingComponent = dataBindingComponent;
        this.listener = listener;
        movieList = new ArrayList<>();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieItemBinding itemBinding = MovieItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false, dataBindingComponent);
        return new MovieViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, int position) {
        holder.onBind(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    @Override
    public void setData(List<Movie> movies) {
        movieList = movies;
        notifyDataSetChanged();
    }

    class  MovieViewHolder extends RecyclerView.ViewHolder {
        MovieItemBinding binding;
        MovieViewHolder(MovieItemBinding itemBinding) {
            super(itemBinding.getRoot());
            binding = itemBinding;
            itemBinding.setCallback(movie -> listener.viewDetail(movie, binding.imgPoster));
        }

        void onBind(Movie movie) {
            binding.setMovie(movie);
            binding.executePendingBindings();
        }
    }

    public interface MovieDetailCallback {
        void viewDetail(Movie movie, View sharedView);
    }
}
