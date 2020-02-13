package com.imceits.android.themoviedbreview.binding;
// Created by AUNGTUNTUN on 30/12/2018.


import android.databinding.DataBindingComponent;
import android.support.v4.app.Fragment;

public class FragmentDataBindingComponent implements DataBindingComponent {

    private final FragmentBindingAdapters adapters;

    public FragmentDataBindingComponent(Fragment fragment) {
        this.adapters = new FragmentBindingAdapters(fragment);
    }

    @Override
    public FragmentBindingAdapters getFragmentBindingAdapters() {
        return adapters;
    }
}
