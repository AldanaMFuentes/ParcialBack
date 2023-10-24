package com.example.ParcialBack.services;

import com.example.ParcialBack.domain.Playlist;
import com.example.ParcialBack.domain.Track;

import java.util.List;
import java.util.Optional;

public interface PlaylistService {
    List<Playlist> findAll();

    Playlist create(String name);

    void update(Integer id, String name);

    void delete(Integer id);

    Optional<Playlist> findById(Integer id);

    void addTrack(Integer playlistId, Integer trackId);
}
