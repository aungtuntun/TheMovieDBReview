package com.imceits.android.themoviedbreview.data.network;
// Created by AUNGTUNTUN on 30/12/2018.

import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectivityStatus extends ContextWrapper {
    public ConnectivityStatus(Context base) {
        super(base);
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo connection = null;
        if (manager != null) {
            connection = manager.getActiveNetworkInfo();
        }
        return connection != null && connection.isConnectedOrConnecting();
    }
}
