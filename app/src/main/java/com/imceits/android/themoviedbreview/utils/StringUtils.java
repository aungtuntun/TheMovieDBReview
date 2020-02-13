package com.imceits.android.themoviedbreview.utils;
// Created by AUNGTUNTUN on 30/12/2018.


import com.imceits.android.themoviedbreview.data.model.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringUtils {

    public static String runtime(int runtime) {
        String playtime = "";
        if (runtime > 0) {
            int hr = runtime / 60;
            int min = runtime % 60;
            playtime = hr + "hr(s) "+ min + "min(s)";
        }
            return playtime;
    }

    public static List<String> getGenres(List<Genre> genres) {
        List<String> genreNames = new ArrayList<>(genres.size());
        for(Object obj : genres) {
            if(obj instanceof String)
                genreNames.add(Objects.toString(obj, null));
            else genreNames.add(String.valueOf(((Genre)obj).getName()));
        }
        return genreNames;
    }

}
