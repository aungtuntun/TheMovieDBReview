package com.imceits.android.themoviedbreview.binding;
// Created by AUNGTUNTUN on 29/12/2018.


import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.imceits.android.themoviedbreview.data.entity.Movie;
import com.imceits.android.themoviedbreview.ui.BaseAdapter;
import com.imceits.android.themoviedbreview.utils.Constants;

import java.util.List;

public class BindingAdapters {

    @SuppressWarnings("unchecked")
    @BindingAdapter("resource")
    public static void setDataList(RecyclerView recyclerView, List<Movie> movies) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null)
            return;
        if (movies == null)
            return;
        if (adapter instanceof BaseAdapter){
            ((BaseAdapter) adapter).setData(movies);
        }
    }

    @BindingAdapter("imageUrl")
    public static void bindImage(ImageView imageView, String url) {
        if (url != null && !url.equals("")) {
            Glide.with(imageView.getContext()).load(Constants.IMAGE_URL_PREFIX + url)
                    .into(imageView);
        }
    }
}
