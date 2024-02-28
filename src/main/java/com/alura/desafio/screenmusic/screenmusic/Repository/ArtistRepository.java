package com.alura.desafio.screenmusic.screenmusic.Repository;

import com.alura.desafio.screenmusic.screenmusic.Model.Artist;
import com.alura.desafio.screenmusic.screenmusic.Model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findByNameContainingIgnoreCase(String artistName);

    @Query(value ="select * from musics;" ,nativeQuery = true)
    List<Music> findAllMusics();

    @Query("SELECT m FROM Artist a JOIN a.musicList m WHERE a.name = :artistName")
    List<Music> findMusicByArtist(String artistName);

}
