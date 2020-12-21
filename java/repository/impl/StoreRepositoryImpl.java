package com.darkside.repository.impl;

import com.darkside.jpa.JpaStoreRepository;
import com.darkside.model.Album;
import com.darkside.repository.StoreRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StoreRepositoryImpl implements StoreRepository {

    // private List<Album> albumList;
    private final JpaStoreRepository jpaStoreRepository;

    public StoreRepositoryImpl(JpaStoreRepository jpaStoreRepository) {
        this.jpaStoreRepository = jpaStoreRepository;
        // albumList = new ArrayList<>();
    }

    @Override
    public List<Album> getAlbums() {
        //
        // return albumList;
        return (List<Album>) jpaStoreRepository.findAll();
    }

    @Override
    public Album addAlbum(Album album) {
        // albumList.add(album);
        // return album;

        return jpaStoreRepository.save(album);
    }

    /*
    @Override
    public long getNextAlbumId() {
        Album maxAlbum = albumList.stream().max(Comparator.comparing(Album::getAlbumId)).get();
        return maxAlbum.getAlbumId() + 1;
    }*/

    @Override
    public Album editAlbum(String albumName, String albumArtist, String albumGenre, String albumDate, int albumTracks,
                           Long albumId, String price) {
        /*Album existing = findAlbumById(albumId);
        if (existing == null) {
            throw new IllegalStateException("album with ID not found");
        }
        existing.setAlbumName(albumName);
        existing.setArtist(albumArtist);
        existing.setGenre(albumGenre);
        existing.setDate(albumDate);
        existing.setTracks(albumTracks);
        existing.setPrice(Double.valueOf(price));
        return existing;*/

        Album existing = findAlbumById(albumId);
        existing.setAlbumName(albumName);
        existing.setArtist(albumArtist);
        existing.setPrice(Double.valueOf(price));
        return jpaStoreRepository.save(existing);
    }

    @Override
    public boolean deleteAlbumById(Long albumId) {
        //albumList = albumList.stream().filter(g -> !g.getAlbumId().equals(albumId)).collect(Collectors.toList());
        //return true;

        jpaStoreRepository.deleteById(albumId);
        return true;
    }

    @Override
    public Album findAlbumById(Long albumId) {
        // return albumList.stream().filter(g -> g.getAlbumId().equals(albumId)).collect(MoreCollectors.onlyElement());

        Optional<Album> album = jpaStoreRepository.findById(albumId);
        if (album.isPresent()) {
            return album.get();
        }
        throw new IllegalStateException("Album with ID " + albumId + " is not found!");
    }
}
