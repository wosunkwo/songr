package com.osunkwo.code401d4.day12.firstWebApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/album")
    public String getAllAlbums(Model m){
        Iterable<Album> albums = albumRepository.findAll();
        m.addAttribute("albums", albums);
        return "album";
    }

    @GetMapping("/addNewFileForm")
    public String addIntoForm(){
        return "addNewFileForm";
    }

    @PostMapping(value = "/album/add")
    public RedirectView addIntoDatabase(@RequestParam("title") String title, @RequestParam("artist") String artist, @RequestParam("songCount") int songCount, @RequestParam("length") int length, @RequestParam("imageUrl") String imageUrl) {
        Album newAlbum =  new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(newAlbum);
        return new RedirectView("/album");
    }
}
