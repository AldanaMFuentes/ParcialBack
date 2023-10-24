package com.example.ParcialBack.application.controllers;

import com.example.ParcialBack.application.ResponseHandler;
import com.example.ParcialBack.application.request.*;
import com.example.ParcialBack.application.response.AlbumResponse;
import com.example.ParcialBack.application.response.ArtistResponse;
import com.example.ParcialBack.services.AlbumService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/albums")
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AlbumController {
    AlbumService albumService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            val albums = albumService.findAll()
                    .stream()
                    .map(AlbumResponse::from)
                    .toList();

            return ResponseHandler.success(albums);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable Integer id) {
        try {
            return albumService.findById(id)
                    .map(AlbumResponse::from)
                    .map(ResponseHandler::success)
                    .orElseGet(ResponseHandler::notFound);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.notFound();
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody POSTAlbumRequest aRequest) {
        try {
            val album = albumService.create(aRequest.getArtistId(), aRequest.getTitle());
            return ResponseHandler.success(AlbumResponse.from(album));
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody PUTAlbumRequest aRequest) {
        try {
            albumService.update(id, aRequest.getArtistId(), aRequest.getTitle());
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
            albumService.delete(id);
            return ResponseHandler.noContent();
        } catch (IllegalArgumentException e) {
            return ResponseHandler.noContent();
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }
}
