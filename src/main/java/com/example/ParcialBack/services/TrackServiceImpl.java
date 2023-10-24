package com.example.ParcialBack.services;

import com.example.ParcialBack.domain.Album;
import com.example.ParcialBack.domain.MediaType;
import com.example.ParcialBack.domain.Playlist;
import com.example.ParcialBack.domain.Track;
import com.example.ParcialBack.repositories.AlbumRepository;
import com.example.ParcialBack.repositories.IdentifierRepository;
import com.example.ParcialBack.repositories.TrackRepository;
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
public class TrackServiceImpl implements TrackService{
    TrackRepository trackRepository;
    IdentifierRepository identifierRepository;
    AlbumService albumService;
    MediaTypeService mediaTypeService;
    GenreService genreService;

    @Override
    public List<Track> findAll() {
        return trackRepository.findAll();
    }

    @Override
    @Transactional
    public Track create(String name, String composer, int milliseconds, int bytes, double unitPrice, int albumId, int mediaTypeId, int genreId) {
        val trackId = identifierRepository.nextValue(Track.TABLE_NAME);
        val album = albumService.findById(albumId).orElseThrow(() -> new IllegalArgumentException("Album not found"));
        val mediaType = mediaTypeService.findById(mediaTypeId).orElseThrow(() -> new IllegalArgumentException("MediaType not found"));
        val genre = genreService.findById(genreId).orElseThrow(() -> new IllegalArgumentException("Genre not found"));
        val track = new Track(trackId, name, composer, milliseconds, bytes, unitPrice, album, mediaType, genre);
        return trackRepository.save(track);
    }

    @Override
    @Transactional
    public void update(Integer id, String name, String composer, int milliseconds, int bytes, double unitPrice, int albumId, int mediaTypeId, int genreId) {
        val existingTrack = trackRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Track not found"));
        val album = albumService.findById(albumId).orElseThrow(() -> new IllegalArgumentException("Album not found"));
        val mediaType = mediaTypeService.findById(mediaTypeId).orElseThrow(() -> new IllegalArgumentException("MediaType not found"));
        val genre = genreService.findById(genreId).orElseThrow(() -> new IllegalArgumentException("Genre not found"));
        existingTrack.update(name, composer, milliseconds, bytes, unitPrice, album, mediaType, genre);
        trackRepository.save(existingTrack);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        trackRepository.deleteById(id);
    }

    @Override
    public Optional<Track> findById(Integer id) {
        return trackRepository.findById(id);
    }
}
