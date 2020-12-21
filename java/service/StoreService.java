package com.darkside.service;

import com.darkside.model.Album;

import java.util.List;

public interface StoreService {
    List<Album> getAlbums();

    Album addAlbum(String albumName, String albumArtist, String albumGenre, String albumDate, int albumTracks,
                   String price);

    List<Album> findAllFilteredAlbums(String filter);

    Album findAlbumById(Long albumId);

    Album editAlbum(String albumName, String albumArtist, String albumGenre, String albumDate, int albumTracks,
                    Long albumId, String price);

    boolean deleteAlbumById(Long albumId);
}
