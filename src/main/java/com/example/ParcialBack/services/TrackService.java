package com.example.ParcialBack.services;

import com.example.ParcialBack.domain.Album;
import com.example.ParcialBack.domain.Playlist;
import com.example.ParcialBack.domain.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {
    List<Track> findAll();

    Track create(String name, String composer, int milliseconds, int bytes, double unitPrice, int albumId, int mediaTypeId, int genreId);

    void update(Integer id, String name, String composer, int milliseconds, int bytes, double unitPrice, int albumId, int mediaTypeId, int genreId);

    void delete(Integer id);

    Optional<Track> findById(Integer id);

}
