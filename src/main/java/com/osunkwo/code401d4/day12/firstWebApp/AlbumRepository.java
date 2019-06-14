package com.osunkwo.code401d4.day12.firstWebApp;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

// sets up how Spring will interact with the database to retrieve/save/etc Greetings
public interface AlbumRepository extends CrudRepository<Album, Long> {
    //match exactly (method name and parameter name) with the album title property in the Album class
    public List<Album> findByTitle(String title);
}
