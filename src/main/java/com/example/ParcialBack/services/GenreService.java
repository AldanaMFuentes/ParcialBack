package com.example.ParcialBack.services;

import com.example.ParcialBack.domain.Artist;
import com.example.ParcialBack.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<Genre> findAll();



    Optional<Genre> findById(Integer id);
}
