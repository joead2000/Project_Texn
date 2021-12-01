package com.petify_v2.model;

public class Album {
    private final String albumName;
    private final String year;

    public Album(String albumName, String year) {
        this.albumName = albumName;
        this.year = year;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumName='" + albumName + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}