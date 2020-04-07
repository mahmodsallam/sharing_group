package com.mahmoudsallam.task.data.model.api;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geo {
    @Expose
    @SerializedName("lng")
    private String lng;
    @Expose
    @SerializedName("lat")
    private String lat;

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @NonNull
    @Override
    public String toString() {
        return lng + "," + lat;
    }
}
