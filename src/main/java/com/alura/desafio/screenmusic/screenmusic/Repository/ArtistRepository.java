package com.alura.desafio.screenmusic.screenmusic.Repository;

import com.alura.desafio.screenmusic.screenmusic.Model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
