package com.example.ParcialBack.application.controllers;

import com.example.ParcialBack.application.ResponseHandler;
import com.example.ParcialBack.application.request.POSTAlbumRequest;
import com.example.ParcialBack.application.request.POSTTrackRequest;
import com.example.ParcialBack.application.request.PUTAlbumRequest;
import com.example.ParcialBack.application.request.PUTTrackRequest;
import com.example.ParcialBack.application.response.AlbumResponse;
import com.example.ParcialBack.application.response.TrackResponse;
import com.example.ParcialBack.services.TrackService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/tracks")
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TrackController {
    TrackService trackService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            val tracks = trackService.findAll()
                    .stream()
                    .map(TrackResponse::from)
                    .toList();

            return ResponseHandler.success(tracks);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable Integer id) {
        try {
            return trackService.findById(id)
                    .map(TrackResponse::from)
                    .map(ResponseHandler::success)
                    .orElseGet(ResponseHandler::notFound);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.notFound();
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody POSTTrackRequest aRequest) {
        try {
            val track = trackService.create(aRequest.getName(), aRequest.getComposer(), aRequest.getMilliseconds(), aRequest.getBytes(), aRequest.getUnitPrice(), aRequest.getAlbumId(), aRequest.getMediaTypeId(), aRequest.getGenreId());
            return ResponseHandler.success(TrackResponse.from(track));
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody PUTTrackRequest aRequest) {
        try {
            trackService.update(id, aRequest.getName(), aRequest.getComposer(), aRequest.getMilliseconds(), aRequest.getBytes(), aRequest.getUnitPrice(), aRequest.getAlbumId(), aRequest.getMediaTypeId(), aRequest.getGenreId());
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
            trackService.delete(id);
            return ResponseHandler.noContent();
        } catch (IllegalArgumentException e) {
            return ResponseHandler.noContent();
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }
}
