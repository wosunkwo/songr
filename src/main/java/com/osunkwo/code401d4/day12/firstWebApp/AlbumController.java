package com.osunkwo.code401d4.day12.firstWebApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;


@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @GetMapping("/album")
    public String getAllAlbums(Model m){
        Iterable<Album> albums = albumRepository.findAll();
        m.addAttribute("albums", albums);
        return "album";
    }

    @GetMapping("/addNewFileForm")
    public String addIntoFormAlbum(){
        return "addNewFileForm";
    }

    @GetMapping("/addNewSongForm")
    public String addIntoFormSong(Model m){
        Iterable<Song> songs = songRepository.findAll();
        m.addAttribute("songs", songs);
        String albumWasNotFoundErrorMessage = "The Album You tried to add this song to, does not exit in our database";
        m.addAttribute("albumWasNotFoundErrorMessage", albumWasNotFoundErrorMessage);
        return "addNewSongForm";
    }

    @PostMapping("/album")
    public RedirectView addIntoDatabase(@RequestParam("title") String title, @RequestParam("artist") String artist, @RequestParam("songCount") int songCount, @RequestParam("length") int length, @RequestParam("imageUrl") String imageUrl) {
        Album newAlbum =  new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(newAlbum);
        return new RedirectView("/album");
    }

    @PostMapping("/song")
    public RedirectView addSongIntoDatabase(@RequestParam String title, @RequestParam int length, @RequestParam int trackNumber, @RequestParam String album, Model m){
        List<Album> albumWithThatTitle = albumRepository.findByTitle(album);
        if(albumWithThatTitle.size() > 0){
            Song song = new Song(title, length, trackNumber, albumWithThatTitle.get(0));
            songRepository.save(song);
            return new RedirectView("/addNewSongForm");
        }else{
           return new RedirectView("/addNewSongForm");
        }
    }

    @GetMapping("/individualAlbum/{albumTitle}")
    public String showIndividualAlbum(@PathVariable String albumTitle, Model m){
        List<Album> albumToShow = albumRepository.findByTitle(albumTitle);
        m.addAttribute("albumToShow", albumToShow.get(0));
        return "individualAlbumPage";
    }
}
