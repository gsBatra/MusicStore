package com.darkside.controller.api;

import com.darkside.model.Album;
import com.darkside.model.Artist;
import com.darkside.service.ArtistService;
import com.darkside.service.StoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private final StoreService storeService;
    private final ArtistService artistService;

    public ApiController(StoreService storeService, ArtistService artistService) {
        this.storeService = storeService;
        this.artistService = artistService;
    }

    @GetMapping("/api/get-albums")
    public List<Album> getAlbums() {
        return storeService.getAlbums();
    }

    @GetMapping("/api/get-artists")
    public List<Artist> getArtists() {
        return artistService.getArtists();
    }
}
