package com.example.ParcialBack.services;

import com.example.ParcialBack.domain.Artist;
import com.example.ParcialBack.domain.Genre;
import com.example.ParcialBack.repositories.GenreRepository;
import com.example.ParcialBack.repositories.IdentifierRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService{
    GenreRepository genreRepository;
    IdentifierRepository identifierRepository;


    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Optional<Genre> findById(Integer id) {
        return genreRepository.findById(id);
    }
}
