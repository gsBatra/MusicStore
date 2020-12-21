package com.darkside.repository;

import com.darkside.model.Artist;

import java.util.List;

public interface ArtistRepository {
    List<Artist> getArtists();

    Artist addArtist(Artist artist);

    Artist editArtist(String artist, Long artistId);

    boolean deleteArtistById(Long artistId);

    Artist findArtistById(Long artistId);
}
