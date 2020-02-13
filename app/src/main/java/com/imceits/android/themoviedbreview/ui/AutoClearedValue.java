package com.imceits.android.themoviedbreview.ui;
// Created by AUNGTUNTUN on 30/12/2018.

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class AutoClearedValue<T> {

    private T value;

    public AutoClearedValue(Fragment fragment, T value) {
        this.value = value;
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
                @Override
                public void onFragmentViewDestroyed(@NonNull FragmentManager fm, @NonNull Fragment f) {
                    if (f == fragment) {
                        AutoClearedValue.this.value = null;
                        fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                    }
                }
            }, false);
        }
    }

    public T getValue() {
        return value;
    }
}
