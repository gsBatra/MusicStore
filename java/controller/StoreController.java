package com.darkside.controller;

import com.darkside.model.Album;
import com.darkside.service.ArtistService;
import com.darkside.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StoreController {
    private final StoreService storeService;
    private final ArtistService artistService;

    public StoreController(StoreService storeService, ArtistService artistService) {
        this.storeService = storeService;
        this.artistService = artistService;
    }

    @GetMapping("/album/add")
    public String addAlbumForm(Model model) { return "addalbum"; }

    @PostMapping("/album/add")
    public String addAlbumSubmit(Model model, @RequestParam("albumName") String albumName,
                                @RequestParam("albumArtist") String albumArtist,
                                @RequestParam("albumGenre") String albumGenre,
                                @RequestParam("albumDate") String albumDate,
                                @RequestParam("albumTracks") int albumTracks,
                                @RequestParam("albumPrice") String albumPrice) {

        //
        //  Add the album to the database
        try {
            this.storeService.addAlbum(albumName, albumArtist, albumGenre, albumDate, albumTracks,
            albumPrice);
            this.artistService.addArtist(albumArtist);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "addalbum";
        }

        model.addAttribute("success", "Your album was successfully added");
        return "redirect:/success";
    }

    @GetMapping("/albums/edit/{albumId}")
    public String editAlbumPage(@PathVariable Long albumId, Model model) {

        //
        //  find the album
        Album album = storeService.findAlbumById(albumId);

        //
        //  set the model
        model.addAttribute("albumId", album.getAlbumId());
        model.addAttribute("albumName", album.getAlbumName());
        model.addAttribute("albumArtist", album.getArtist());
        model.addAttribute("albumGenre", album.getGenre());
        model.addAttribute("albumDate", album.getDate());
        model.addAttribute("albumTracks", album.getTracks());
        model.addAttribute("albumPrice", album.getPrice());
        return "editalbum";
    }

    @PostMapping("/albums/edit")
    public String editAlbumSubmit(@RequestParam Long albumId, @RequestParam String albumName,
                                  @RequestParam String albumArtist,
                                  @RequestParam String albumGenre,
                                  @RequestParam String albumDate,
                                  @RequestParam int albumTracks,
                                  @RequestParam String albumPrice, Model model) {

        //
        //  submit the form
        try {
            this.storeService.editAlbum(albumName, albumArtist, albumGenre, albumDate,albumTracks, albumId, albumPrice);
            this.artistService.editArtist(albumArtist, albumId);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
        }

        //
        //  success
        return "redirect:/success";
    }

}
