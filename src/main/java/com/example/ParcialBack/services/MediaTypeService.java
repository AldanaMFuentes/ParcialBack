package com.example.ParcialBack.services;

import com.example.ParcialBack.domain.Album;
import com.example.ParcialBack.domain.MediaType;

import java.util.List;
import java.util.Optional;

public interface MediaTypeService {
    List<MediaType> findAll();



    Optional<MediaType> findById(Integer id);
}
