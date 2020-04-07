package com.mahmoudsallam.task.data.model.api;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {
    @Expose
    @SerializedName("geo")
    private Geo geo;
    @Expose
    @SerializedName("zipcode")
    private String zipcode;
    @Expose
    @SerializedName("city")
    private String city;
    @Expose
    @SerializedName("suite")
    private String suite;
    @Expose
    @SerializedName("street")
    private String street;

    public Address(Geo geo, String zipcode, String city, String suite, String street) {
        this.geo = geo;
        this.zipcode = zipcode;
        this.city = city;
        this.suite = suite;
        this.street = street;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public String getAddressForRoom() {
        return city + "," + suite + "," + street;
    }

    @NonNull
    @Override
    public String toString() {
        return geo.toString() + city + "," + suite + "," + street;
    }
}
