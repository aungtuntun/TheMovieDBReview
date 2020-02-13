package com.imceits.android.themoviedbreview.data.model;
// Created by AUNGTUNTUN on 29/12/2018.

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cast implements Parcelable {

    @SerializedName("cast_id")
    @Expose
    private int castId;
    private String character;
    @SerializedName("credit_id")
    @Expose
    private String creditId;
    private int id;
    private String name;
    private int order;
    @SerializedName("profile_path")
    @Expose
    private String profilePath;

    private Cast(Parcel in) {
        castId = in.readInt();
        character = in.readString();
        creditId = in.readString();
        id = in.readInt();
        name = in.readString();
        order = in.readInt();
        profilePath = in.readString();
    }

    public static final Creator<Cast> CREATOR = new Creator<Cast>() {
        @Override
        public Cast createFromParcel(Parcel in) {
            return new Cast(in);
        }

        @Override
        public Cast[] newArray(int size) {
            return new Cast[size];
        }
    };

    public int getCastId() {
        return castId;
    }

    public void setCastId(int castId) {
        this.castId = castId;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(castId);
        dest.writeString(character);
        dest.writeString(creditId);
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(order);
        dest.writeString(profilePath);
    }
}
