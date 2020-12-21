package com.darkside.model;

import javax.persistence.*;

@Entity
public class Album {

    //
    //  instance data
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "album_id_seq")
    @SequenceGenerator(name = "album_id_seq", sequenceName = "album_id_seq", allocationSize = 100)
    private Long albumId;
    private String albumName;
    private String albumArtist;
    private String genre;
    private String date;
    private int tracks;
    private Double albumPrice;

    public Album(){}

    public Album(String title, String artist, String genre, String date, int tracks, Double price) {
        this.albumName = title;
        this.albumArtist = artist;
        this.genre = genre;
        this.date = date;
        this.tracks = tracks;
        this.albumPrice = price;
    }

    public String getAlbumName() { return albumName; }

    public void setAlbumName(String title) { this.albumName = title; }

    public void setDate(String date) { this.date = date; }

    public String getDate(){ return date; }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setArtist(String artist) { this.albumArtist = artist; }

    public String getArtist() {
        return albumArtist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() { return genre; }

    public void setTracks(int tracks) { this.tracks = tracks; }

    public int getTracks() { return tracks; }

    public void setPrice(Double price) { this.albumPrice = price; }

    public Double getPrice() { return albumPrice; }
}
