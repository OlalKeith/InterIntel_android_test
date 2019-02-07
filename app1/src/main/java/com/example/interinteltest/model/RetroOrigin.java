package com.example.interinteltest.model;

import com.google.gson.annotations.SerializedName;

public class RetroOrigin {

    @SerializedName("origin")
    private Integer origin;

    @SerializedName("url")
    private String url;

    public RetroOrigin(Integer origin, String url) {
        this.origin = origin;
        this.url = url;
    }

    public Integer getOrigin() {
        return origin;
    }

    public void setOrigin(Integer origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
