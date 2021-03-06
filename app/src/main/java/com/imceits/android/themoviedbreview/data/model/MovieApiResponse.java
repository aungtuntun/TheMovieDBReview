package com.imceits.android.themoviedbreview.data.model;
// Created by AUNGTUNTUN on 29/12/2018.

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.imceits.android.themoviedbreview.data.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieApiResponse {

    private int page;
    @SerializedName("total_results")
    @Expose
    private int totalResults;
    @SerializedName("total_pages")
    @Expose
    private int totalPages;
    private List<Movie> results;

    public MovieApiResponse() {
        results = new ArrayList<>();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
