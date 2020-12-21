package com.darkside.bootstrap;

import com.darkside.model.Album;
import com.darkside.model.Artist;
import com.darkside.repository.ArtistRepository;
import com.darkside.repository.StoreRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {
    //
    //  instance data
    // instance managed by spring
    private final StoreRepository storeRepository;
    private final ArtistRepository artistRepository;

    public DatabaseLoader(StoreRepository storeRepository, ArtistRepository artistRepository) {
        // injected by constructor
        this.storeRepository = storeRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //
        //  Album Database
        this.storeRepository.addAlbum(new Album("Starboy", "The Weeknd", "Pop", "11/25/2018",
                18, 9.99));
        this.artistRepository.addArtist(new Artist("The Weeknd"));

        this.storeRepository.addAlbum(new Album("Astroworld", "Travis Scott", "Rap", "08/03/2013",
                17,9.99));
        this.artistRepository.addArtist(new Artist("Travis Scott"));

        this.storeRepository.addAlbum(new Album("Take Care", "Drake", "Rap", "11/15/2011",
                19,7.99));
        this.artistRepository.addArtist(new Artist("Drake"));

        this.storeRepository.addAlbum(new Album("Perfect Timing", "NAV", "Rap", "07/21/2017",
                15,8.99));
        this.artistRepository.addArtist(new Artist("NAV"));

        this.storeRepository.addAlbum(new Album("Hollywood's Bleeding", "Post Malone", "Pop",
                "09/06/2019", 17, 9.99));
        this.artistRepository.addArtist(new Artist("Post Malone"));
    }
}
