package com.imceits.android.themoviedbreview.data;
// Created by AUNGTUNTUN on 30/12/2018.

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.os.AsyncTask;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class NetworkBoundResource<ResultType, RequestType> {

    private final MediatorLiveData<Resource<ResultType>> result = new MediatorLiveData<>();

    @MainThread
    protected NetworkBoundResource() {
        result.setValue(Resource.loading(null));
        LiveData<ResultType> dbSource = loadFromDb();
        result.addSource(dbSource, resultType -> {
            result.removeSource(dbSource);
            if (shouldFetch(resultType)) {
                fetchFromNetwork(dbSource);
            } else {
                result.addSource(dbSource, resultType1 -> result.setValue(Resource.success(resultType1)));
            }
        });
    }

    private void fetchFromNetwork(final LiveData<ResultType> dbSource) {
        result.addSource(dbSource, resultType -> result.setValue(Resource.loading(resultType)));
        createCall().enqueue(new Callback<RequestType>() {
            @Override
            public void onResponse(@NonNull Call<RequestType> call, @NonNull Response<RequestType> response) {
                result.removeSource(dbSource);
                saveResultAndReInit(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<RequestType> call, @NonNull Throwable t) {
                onFetchFailed();
                result.removeSource(dbSource);
                result.addSource(dbSource, resultType -> result.setValue(Resource.error(t.getMessage(), resultType)));
            }
        });
    }
    @SuppressLint("StaticFieldLeak")
    private void saveResultAndReInit(RequestType response) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                saveCallResult(response);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                result.addSource(loadFromDb(), resultType -> result.setValue(Resource.success(resultType)));
            }
        }.execute();
    }
    protected void onFetchFailed() {}

    @WorkerThread
    protected abstract void saveCallResult(@NonNull RequestType item);

    @MainThread
    protected abstract boolean shouldFetch(@Nullable ResultType data);

    @NonNull
    @MainThread
    protected abstract LiveData<ResultType> loadFromDb();

    @NonNull
    @MainThread
    protected abstract Call<RequestType> createCall();

    public final LiveData<Resource<ResultType>> getAsLiveData() {
        return result;
    }
}
