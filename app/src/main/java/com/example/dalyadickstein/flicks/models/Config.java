package com.example.dalyadickstein.flicks.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dalyadickstein on 6/22/17.
 */

public class Config {
    String imageBaseUrl; // the base url for loading images
    String posterSize; // poster size to use when loading images vertically, part of the url
    String backdropSize; // backdrop size to use when loading images horizontally, part of the url

    public Config(JSONObject object) throws JSONException {
        JSONObject images = object.getJSONObject("images");
        // get the image base url
        imageBaseUrl = images.getString("secure_base_url");
        // get the poster size
        JSONArray posterSizeOptions = images.getJSONArray("poster_sizes");
        // use the option at index 3 or w342 as a fallback
        posterSize = posterSizeOptions.optString(3, "w342");
        // get the backdrop size
        JSONArray backdropSizeOptions = images.getJSONArray("backdrop_sizes");
        // use the option at index 2 or w780 as a fallback
        backdropSize = backdropSizeOptions.optString(1, "w780");
    }

    public String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public String getPosterSize() {
        return posterSize;
    }

    public String getBackdropSize() {
        return backdropSize;
    }

    // helper method for constructing urls
    public String getImageUrl(String size, String path) {
        return String.format("%s%s%s", imageBaseUrl, size, path);
    }

}
