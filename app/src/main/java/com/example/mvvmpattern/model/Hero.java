package com.example.mvvmpattern.model;

import com.google.gson.annotations.SerializedName;

public class Hero {

    @SerializedName("name")
    public String name;

    @SerializedName("realname")
    public String realname;

    @SerializedName("team")
    public String team;

    @SerializedName("firstappearance")
    public String firstappearance;

    @SerializedName("createdby")
    public String createdby;

    @SerializedName("publisher")
    public String publisher;

    @SerializedName("imageurl")
    public String imageurl;

    @SerializedName("bio")
    public String bio;

    public Hero(String name, String realname, String team, String firstappearance, String createdby, String publisher, String imageurl, String bio) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
        this.bio = bio;
    }
    public Hero(){

    }


}
