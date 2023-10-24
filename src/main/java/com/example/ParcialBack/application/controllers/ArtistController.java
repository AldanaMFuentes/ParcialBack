package com.example.ParcialBack.application.controllers;

import com.example.ParcialBack.application.ResponseHandler;
import com.example.ParcialBack.application.request.POSTArtistRequest;
import com.example.ParcialBack.application.request.PUTArtistRequest;
import com.example.ParcialBack.application.response.ArtistResponse;
import com.example.ParcialBack.services.ArtistService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/artists")
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ArtistController {
    ArtistService artistService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            val artists = artistService.findAll()
                    .stream()
                    .map(ArtistResponse::from)
                    .toList();

            return ResponseHandler.success(artists);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable Integer id) {
        try {
            return artistService.findById(id)
                    .map(ArtistResponse::from)
                    .map(ResponseHandler::success)
                    .orElseGet(ResponseHandler::notFound);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.notFound();
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody POSTArtistRequest aRequest) {
        try {
            val artist = artistService.create(aRequest.getName());
            return ResponseHandler.success(ArtistResponse.from(artist));
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody PUTArtistRequest aRequest) {
        try {
            artistService.update(id, aRequest.getName());
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
            artistService.delete(id);
            return ResponseHandler.noContent();
        } catch (IllegalArgumentException e) {
            return ResponseHandler.noContent();
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }
}
