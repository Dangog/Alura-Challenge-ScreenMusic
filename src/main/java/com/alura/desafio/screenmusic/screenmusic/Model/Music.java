package com.alura.desafio.screenmusic.screenmusic.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "musics")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "musicName", unique = true)
    private String musicName;

    @Column(name = "albumName")
    private String albumName;

    @ManyToOne
    private Artist artist;

    public Music(String musicName, String albumName) {
        this.musicName = musicName;
        this.albumName = albumName;
    }
    public Music() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", musicName='" + musicName + '\'' +
                ", albumName='" + albumName + '\'' +
                ", artist=" + artist.getName();
    }
}
