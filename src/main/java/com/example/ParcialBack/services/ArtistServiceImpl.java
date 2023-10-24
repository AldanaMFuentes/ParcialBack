package com.example.ParcialBack.services;

import com.example.ParcialBack.domain.Album;
import com.example.ParcialBack.domain.Artist;
import com.example.ParcialBack.repositories.AlbumRepository;
import com.example.ParcialBack.repositories.ArtistRepository;
import com.example.ParcialBack.repositories.IdentifierRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService{

    ArtistRepository artistRepository;
    IdentifierRepository identifierRepository;
    AlbumRepository albumRepository;

    @Override
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    @Transactional
    public Artist create(String name) {
        val artistId = identifierRepository.nextValue(Artist.TABLE_NAME);
        val artist = new Artist(artistId, name);
        return artistRepository.save(artist);
    }

    @Override
    @Transactional
    public void update(Integer id, String name) {
        val artist = artistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Artist not found"));
        artist.update(name);
        artistRepository.save(artist);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        try {
            artistRepository.deleteById(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Artist not found");
        }
    }

    @Override
    public Optional<Artist> findById(Integer id) {
        return artistRepository.findById(id);
    }
}
