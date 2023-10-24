package com.example.ParcialBack.application.controllers;

import com.example.ParcialBack.application.ResponseHandler;
import com.example.ParcialBack.application.response.ArtistResponse;
import com.example.ParcialBack.application.response.MediaTypeResponse;
import com.example.ParcialBack.services.MediaTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/media_types")
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class MediaTypeController {
    MediaTypeService mediaTypeService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            val mediaTypes = mediaTypeService.findAll()
                    .stream()
                    .map(MediaTypeResponse::from)
                    .toList();

            return ResponseHandler.success(mediaTypes);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable Integer id) {
        try {
            return mediaTypeService.findById(id)
                    .map(MediaTypeResponse::from)
                    .map(ResponseHandler::success)
                    .orElseGet(ResponseHandler::notFound);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.notFound();
        } catch (Exception e) {
            return ResponseHandler.internalError();
        }
    }
}
