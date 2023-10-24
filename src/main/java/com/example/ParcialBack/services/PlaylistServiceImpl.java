package com.example.ParcialBack.services;

import com.example.ParcialBack.domain.Playlist;
import com.example.ParcialBack.domain.Track;
import com.example.ParcialBack.repositories.IdentifierRepository;
import com.example.ParcialBack.repositories.PlaylistRepository;
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
public class PlaylistServiceImpl implements PlaylistService {
    PlaylistRepository playlistRepository;
    IdentifierRepository identifierRepository;
    TrackService trackService;

    @Override
    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    @Transactional
    public Playlist create(String name) {
        val playlistId = identifierRepository.nextValue(Playlist.TABLE_NAME);
        val playlist = new Playlist(playlistId, name);
        return playlistRepository.save(playlist);
    }

    @Override
    @Transactional
    public void update(Integer id, String name) {
        val existingPlaylist = playlistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Playlist not found"));
        existingPlaylist.update(name);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        playlistRepository.deleteById(id);
    }

    @Override
    public Optional<Playlist> findById(Integer id) {
        return playlistRepository.findById(id);
    }

    @Override
    @Transactional
    public void addTrack(Integer playlistId, Integer trackId) {
        Optional<Track> track = trackService.findById(trackId);
        if (track.isEmpty()) {
            throw new RuntimeException("Track not found");
        }

        Optional<Playlist> playlist = playlistRepository.findById(playlistId);
        if (playlist.isEmpty()) {
            throw new RuntimeException("Playlist not found");
        } else {
            if (playlist.get().getTracks().contains(track)) {
                throw new IllegalArgumentException("Track already exists in the playlist");
            } else {
                playlist.get().getTracks().add(track.get());
                playlistRepository.save(playlist.get());
            }
        }
    }
}
