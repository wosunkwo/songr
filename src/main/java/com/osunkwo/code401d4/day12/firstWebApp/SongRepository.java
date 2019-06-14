package com.osunkwo.code401d4.day12.firstWebApp;

import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository <Song, Long> {
    // sets up how Spring will interact with the database to retrieve/save/etc Greetings
}
