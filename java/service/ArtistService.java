package com.darkside.service;

import com.darkside.model.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> getArtists();

    Artist addArtist(String artist);

    Artist editArtist(String artist, Long artistId);

    boolean deleteArtistById(Long artistId);
}
