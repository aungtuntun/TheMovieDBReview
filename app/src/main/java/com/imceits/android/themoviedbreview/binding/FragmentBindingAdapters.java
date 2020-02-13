package com.imceits.android.themoviedbreview.binding;
// Created by AUNGTUNTUN on 30/12/2018.

import android.databinding.BindingAdapter;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.imceits.android.themoviedbreview.utils.Constants;

import javax.inject.Inject;

public class FragmentBindingAdapters {
    private Fragment fragment;

    @Inject
    FragmentBindingAdapters(Fragment fragment) {
        this.fragment = fragment;
    }

    @BindingAdapter("image_url")
    public void bindImage(ImageView imageView, String url) {
        if (url != null && !url.equals("")) {
            Glide.with(fragment).load(Constants.IMAGE_URL_PREFIX + url)
                    .into(imageView);
        }
    }
}
