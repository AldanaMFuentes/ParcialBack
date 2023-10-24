package com.example.ParcialBack.application.controllers;

import com.example.ParcialBack.application.ResponseHandler;
import com.example.ParcialBack.application.request.POSTPlaylistRequest;
import com.example.ParcialBack.application.request.PUTAddTrack;
import com.example.ParcialBack.application.request.PUTPlaylistRequest;
import com.example.ParcialBack.application.response.PlaylistsResponse;
import com.example.ParcialBack.services.PlaylistService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/playlists")
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PlaylistController {
    PlaylistService playlistService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            val playlists = playlistService.findAll()
                    .stream()
                    .map(PlaylistsResponse::from)
                    .toList();
            return ResponseHandler.success(playlists);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable Integer id) {
        try {
            return playlistService.findById(id)
                    .map(PlaylistsResponse::from)
                    .map(ResponseHandler::success)
                    .orElseGet(ResponseHandler::notFound);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.notFound();
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody POSTPlaylistRequest aRequest) {
        try {
            val playlist = playlistService.create(aRequest.getName());
            return ResponseHandler.success(PlaylistsResponse.from(playlist));
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody PUTPlaylistRequest aRequest) {
        try {
            playlistService.update(id, aRequest.getName());
            return ResponseHandler.noContent();
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            playlistService.delete(id);
            return ResponseHandler.noContent();
        } catch (IllegalArgumentException e) {
            return ResponseHandler.noContent();
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @PutMapping("/{playlistId}/addTrack")
    public ResponseEntity<Object> addTrack(@PathVariable Integer playlistId, @RequestBody PUTAddTrack aRequest) {
        try {
            playlistService.addTrack(playlistId, aRequest.getTrackId());
            return ResponseHandler.noContent();
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }
}
