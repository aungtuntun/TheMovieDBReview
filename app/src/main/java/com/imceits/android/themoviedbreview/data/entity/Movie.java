package com.imceits.android.themoviedbreview.data.entity;
// Created by AUNGTUNTUN on 29/12/2018.

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.imceits.android.themoviedbreview.data.model.Cast;
import com.imceits.android.themoviedbreview.data.model.CastListTypeConverter;
import com.imceits.android.themoviedbreview.data.model.Crew;
import com.imceits.android.themoviedbreview.data.model.CrewListTypeConverter;
import com.imceits.android.themoviedbreview.data.model.Genre;
import com.imceits.android.themoviedbreview.data.model.GenreListTypeConverter;
import com.imceits.android.themoviedbreview.data.model.MovieListTypeConverter;

import java.util.List;

@Entity(tableName = "Movie")
public class Movie {

    @PrimaryKey
    @ColumnInfo(name = "movie_id")
    @SerializedName("id")
    @Expose
    private int id;
    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @ColumnInfo(name = "adult")
    @SerializedName("adult")
    @Expose
    private boolean adult;
    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    @Expose
    private String overview;
    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    private String title;
    @ColumnInfo(name = "original_language")
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @ColumnInfo(name = "vote_count")
    @SerializedName("vote_count")
    @Expose
    private int voteCount;
    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average")
    @Expose
    private double voteAverage;

    @ColumnInfo(name = "genres")
    @SerializedName("genres")
    @Expose
    @TypeConverters(GenreListTypeConverter.class)
    private List<Genre> genres;

    @ColumnInfo(name = "crews")
    @SerializedName("crews")
    @Expose
    @TypeConverters(CrewListTypeConverter.class)
    private List<Crew> crews;
    @ColumnInfo(name = "casts")
    @SerializedName("casts")
    @Expose
    @TypeConverters(CastListTypeConverter.class)
    private List<Cast> casts;
    @ColumnInfo(name = "category_types")
    @SerializedName("category_types")
    @Expose
    private List<String> categoryTypes;
    @ColumnInfo(name = "similar_movies")
    @SerializedName("similar_movies")
    @Expose
    @TypeConverters(MovieListTypeConverter.class)
    private List<Movie> similarMovies;
    @SerializedName("runtime")
    @Expose
    private int runtime;
    @SerializedName("status")
    @Expose
    private String status;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Crew> getCrews() {
        return crews;
    }

    public void setCrews(List<Crew> crews) {
        this.crews = crews;
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public void setCasts(List<Cast> casts) {
        this.casts = casts;
    }

    public List<String> getCategoryTypes() {
        return categoryTypes;
    }

    public void setCategoryTypes(List<String> categoryTypes) {
        this.categoryTypes = categoryTypes;
    }

    public List<Movie> getSimilarMovies() {
        return similarMovies;
    }

    public void setSimilarMovies(List<Movie> similarMovies) {
        this.similarMovies = similarMovies;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
