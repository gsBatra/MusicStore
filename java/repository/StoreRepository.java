package com.darkside.repository;

import com.darkside.model.Album;

import java.util.List;

public interface StoreRepository {
    List<Album> getAlbums();

    Album addAlbum(Album album);

    //long getNextAlbumId();

    Album editAlbum(String albumName, String albumArtist, String albumGenre, String albumDate, int albumTracks,
                    Long albumId, String price);

    boolean deleteAlbumById(Long albumId);

    Album findAlbumById(Long albumId);
}
