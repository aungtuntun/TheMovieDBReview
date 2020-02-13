package com.imceits.android.themoviedbreview.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imceits.android.themoviedbreview.data.entity.Movie;
import com.imceits.android.themoviedbreview.databinding.SimilarMovieItemBinding;
import com.imceits.android.themoviedbreview.ui.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

// Created by AUNGTUNTUN on 30/12/2018.

public class SimilarMovieAdapter extends BaseAdapter<SimilarMovieAdapter.SimilarViewHolder, Movie> {

    private List<Movie> movieList;
    private MovieDetailCallback listener;

    public SimilarMovieAdapter(MovieDetailCallback listener) {
        movieList = new ArrayList<>();
        this.listener = listener;
    }

    @Override
    public void setData(List<Movie> movies) {
        movieList = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SimilarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        SimilarMovieItemBinding itemBinding = SimilarMovieItemBinding.inflate(
                LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new SimilarViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarViewHolder holder, int i) {
        holder.onBind(movieList.get(i));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class SimilarViewHolder extends RecyclerView.ViewHolder {
        SimilarMovieItemBinding binding;
        SimilarViewHolder(SimilarMovieItemBinding itemBinding) {
            super(itemBinding.getRoot());
            binding = itemBinding;
            binding.setCallback(movie -> listener.showDetail(movie, binding.imageView));
        }

        void onBind(Movie movie) {
            binding.setMovie(movie);
            binding.executePendingBindings();
        }
    }

    public interface MovieDetailCallback {
        void showDetail(Movie movie, View sharedView);
    }
}
