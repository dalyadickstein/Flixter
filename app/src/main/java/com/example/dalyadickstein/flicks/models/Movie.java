package com.example.dalyadickstein.flicks.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dalyadickstein on 6/22/17.
 */

public class Movie {

    // values from API
    private String title;
    private String overview;
    private String posterPath; // only the path
    private String backdropPath; // only the path

    // constructor: initialize from JSON data
    public Movie(JSONObject object) throws JSONException {
        this.title = object.getString("title");
        this.overview = object.getString("overview");
        this.posterPath = object.getString("poster_path");
        this.backdropPath = object.getString("backdrop_path");
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

}
