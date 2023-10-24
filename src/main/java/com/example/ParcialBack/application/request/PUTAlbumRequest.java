package com.example.ParcialBack.application.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PUTAlbumRequest {
    @NotNull(message = "Artist is required")
    Integer artistId;

    @NotBlank(message = "Title is required")
    String title;
}
