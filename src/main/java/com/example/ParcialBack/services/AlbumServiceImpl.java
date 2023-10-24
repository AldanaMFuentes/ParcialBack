package com.example.ParcialBack.services;

import com.example.ParcialBack.domain.Album;
import com.example.ParcialBack.domain.Playlist;
import com.example.ParcialBack.domain.Track;
import com.example.ParcialBack.repositories.AlbumRepository;
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
public class AlbumServiceImpl implements AlbumService{
    AlbumRepository albumRepository;
    IdentifierRepository identifierRepository;
    ArtistService artistService;

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    @Transactional
    public Album create(Integer artistId, String title) {
        val albumId = identifierRepository.nextValue(Album.TABLE_NAME);
        val artist = artistService.findById(artistId).orElseThrow(() -> new IllegalArgumentException("Artist not found"));
        val album = new Album(albumId, artist, title);
        return albumRepository.save(album);
    }

    @Override
    @Transactional
    public void update(Integer id, Integer artistId, String title) {
        val existingAlbum = albumRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Album not found"));
        val artist = artistService.findById(artistId).orElseThrow(() -> new IllegalArgumentException("Artist not found"));
        existingAlbum.update(artist, title);
        albumRepository.save(existingAlbum);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        albumRepository.deleteById(id);
    }

    @Override
    public Optional<Album> findById(Integer id) {
        return albumRepository.findById(id);
    }
}
