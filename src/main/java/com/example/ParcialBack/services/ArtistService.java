package com.example.ParcialBack.services;

import com.example.ParcialBack.domain.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<Artist> findAll();

    Artist create(String name);

    void update(Integer id, String name);

    void delete(Integer id);

    Optional<Artist> findById(Integer id);

}
