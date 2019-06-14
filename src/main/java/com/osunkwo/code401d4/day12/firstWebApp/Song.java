package com.osunkwo.code401d4.day12.firstWebApp;


import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String title;
    int length;
    int trackNumber;

    @ManyToOne
    Album album;

    public Song(){}

    public Song(String title, int length, int trackNumber, Album album){
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public Album getAlbum() {
        return album;
    }

}
