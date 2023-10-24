package com.example.ParcialBack.services;

import com.example.ParcialBack.domain.Album;
import com.example.ParcialBack.domain.Artist;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<Album> findAll();

    Album create(Integer artistId, String title);

    void update(Integer id, Integer artistId, String title);

    void delete(Integer id);

    Optional<Album> findById(Integer id);

}
