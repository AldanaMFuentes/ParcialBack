package com.example.ParcialBack.application.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class POSTArtistRequest {
    @NotBlank(message = "Name is required")
    String name;
}
