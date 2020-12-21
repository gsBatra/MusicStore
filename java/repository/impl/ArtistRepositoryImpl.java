package com.darkside.repository.impl;

import com.darkside.jpa.JpaArtistRepository;
import com.darkside.model.Artist;
import com.darkside.repository.ArtistRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepositoryImpl implements ArtistRepository {
    private final JpaArtistRepository jpaArtistRepository;


    public ArtistRepositoryImpl(JpaArtistRepository jpaArtistRepository) {
        this.jpaArtistRepository = jpaArtistRepository;
    }

    @Override
    public List<Artist> getArtists() {
        return (List<Artist>) jpaArtistRepository.findAll();
    }

    @Override
    public Artist addArtist(Artist artist) {
        return jpaArtistRepository.save(artist);
    }

    @Override
    public Artist editArtist(String artist, Long artistId) {
        Artist existing = findArtistById(artistId);
        existing.setName(artist);
        return jpaArtistRepository.save(existing);
    }

    @Override
    public boolean deleteArtistById(Long artistId) {
        jpaArtistRepository.deleteById(artistId);
        return true;
    }

    @Override
    public Artist findArtistById(Long artistId) {
        // return albumList.stream().filter(g -> g.getAlbumId().equals(albumId)).collect(MoreCollectors.onlyElement());

        Optional<Artist> artist = jpaArtistRepository.findById(artistId);
        if (artist.isPresent()) {
            return artist.get();
        }
        throw new IllegalStateException("Artist with ID " + artistId + " is not found!");
    }
}
