package com.darkside.service.impl;

import com.darkside.model.Artist;
import com.darkside.repository.ArtistRepository;
import com.darkside.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public boolean deleteArtistById(Long artistId) {
        return artistRepository.deleteArtistById(artistId);
    }

    @Override
    public Artist addArtist(String albumArtist) {

        Artist artist = new Artist(albumArtist);
        return artistRepository.addArtist(artist);
    }

    @Override
    public Artist editArtist(String artist, Long artistId) {
        return artistRepository.editArtist(artist, artistId);
    }


    @Override
    public List<Artist> getArtists() {
        return artistRepository.getArtists();
    }

}
