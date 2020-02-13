package com.imceits.android.themoviedbreview.ui;
// Created by AUNGTUNTUN on 29/12/2018.

import android.support.v7.widget.RecyclerView;

import java.util.List;

public abstract class BaseAdapter<Type extends RecyclerView.ViewHolder, Data> extends RecyclerView.Adapter<Type> {

    public abstract void setData(List<Data> data);
}
