package com.darkside.controller;

import com.darkside.model.Album;
import com.darkside.service.ArtistService;
import com.darkside.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    private final StoreService storeService;
    private final ArtistService artistService;

    //  constructor injection!
    public IndexController(StoreService storeService, ArtistService artistService) {
        this.storeService = storeService;
        this.artistService = artistService;
    }

    @GetMapping("/view")
    public String index(Model model) {
        List<Album> albums = storeService.getAlbums();
        model.addAttribute("albums", albums);
        return "view";
    }

    @GetMapping("/search")
    public String indexFiltered(Model model, @RequestParam(value = "term", required = false) String term) {
        if(term == null)
            term = "";
        List<Album> albums = storeService.findAllFilteredAlbums(term);
        model.addAttribute("albums", albums);
        return "view";
    }

    @GetMapping("/success")
    public String indexWithSuccess(Model model) {
        List<Album> albums = storeService.getAlbums();
        model.addAttribute("albums", albums);
        model.addAttribute("success", "Your changes were successfully saved.");
        return "view";
    }

    @GetMapping("/albums/delete/{albumId}")
    public String deleteAlbum(@PathVariable Long albumId) {
        storeService.deleteAlbumById(albumId);
        artistService.deleteArtistById(albumId);
        return "redirect:/view";
    }
}
