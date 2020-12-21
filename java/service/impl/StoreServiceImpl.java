package com.darkside.service.impl;

import com.darkside.model.Album;
import com.darkside.repository.StoreRepository;
import com.darkside.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {
    // managed by spring!
    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        // injected by constructor!
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Album> getAlbums() { return storeRepository.getAlbums(); }

    @Override
    public Album addAlbum(String albumName, String albumArtist, String albumGenre, String albumDate, int albumTracks,
                          String albumPrice) {
        //
        //  validation
        if (albumName == null || albumName.isEmpty()) {
            throw new IllegalArgumentException("album name cannot be null");
        }
        Double price;
        try {
            price = Double.valueOf(albumPrice);
        } catch (NumberFormatException nfex) {
            throw new IllegalArgumentException("invalid album price");
        }

        //  test if null/empty
        //long nextId = storeRepository.getNextAlbumId();
        Album album = new Album(albumName, albumArtist, albumGenre, albumDate, albumTracks, price);
        return storeRepository.addAlbum(album);
    }

    @Override
    public List<Album> findAllFilteredAlbums(String filter) {
        List<Album> allAlbums = storeRepository.getAlbums();
        return allAlbums.stream()
                .filter(g -> g.getAlbumName().toLowerCase().contains(filter))
                .collect(Collectors.toList());
    }

    @Override
    public Album findAlbumById(Long albumId) { return storeRepository.findAlbumById(albumId); }

    @Override
    public Album editAlbum(String albumName, String albumArtist, String albumGenre, String albumDate, int albumTracks,
                           Long albumId, String price) {
        return storeRepository.editAlbum(albumName, albumArtist, albumGenre, albumDate, albumTracks, albumId,
                price);
    }

    @Override
    public boolean deleteAlbumById(Long albumId) { return storeRepository.deleteAlbumById(albumId); }
}
