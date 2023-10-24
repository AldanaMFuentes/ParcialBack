package com.example.ParcialBack.application.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class POSTTrackRequest {
    @NotBlank(message = "Name is required")
    String name;

    @NotBlank(message = "Composer is required")
    String composer;

    @NotNull(message = "Milliseconds is required")
    int milliseconds;

    @NotNull(message = "Bytes is required")
    int bytes;

    @NotNull(message = "UnitPrice is required")
    double unitPrice;

    @NotNull(message = "Album is required")
    int albumId;

    @NotNull(message = "MediaType is required")
    int mediaTypeId;

    @NotNull(message = "Genre is required")
    int genreId;
}
