package com.mahmoudsallam.task.data.model.api;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company {
    @Expose
    @SerializedName("bs")
    private String bs;
    @Expose
    @SerializedName("catchPhrase")
    private String catchPhrase;
    @Expose
    @SerializedName("name")
    private String name;

    public Company(String bs, String catchPhrase, String name) {
        this.bs = bs;
        this.catchPhrase = catchPhrase;
        this.name = name;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String  getCompanyForRoom (String connectedString) {
        return name + bs + catchPhrase;
    }

    @NonNull
    @Override
    public String toString() {
        return name + bs + catchPhrase;
    }
}
