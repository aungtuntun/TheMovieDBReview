package com.imceits.android.themoviedbreview.data.model;
// Created by AUNGTUNTUN on 29/12/2018.

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreditResponse implements Parcelable {

    @SerializedName("cast")
    @Expose
    private List<Cast> cast;
    @SerializedName("crew")
    @Expose
    private List<Crew> crew;

    public CreditResponse(List<Cast> cast, List<Crew> crew) {
        this.cast = cast;
        this.crew = crew;
    }


    private CreditResponse(Parcel in) {
        cast = in.createTypedArrayList(Cast.CREATOR);
        crew = in.createTypedArrayList(Crew.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(cast);
        dest.writeTypedList(crew);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CreditResponse> CREATOR = new Creator<CreditResponse>() {
        @Override
        public CreditResponse createFromParcel(Parcel in) {
            return new CreditResponse(in);
        }

        @Override
        public CreditResponse[] newArray(int size) {
            return new CreditResponse[size];
        }
    };

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public List<Crew> getCrew() {
        return crew;
    }

    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }


}
