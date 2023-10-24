package com.example.ParcialBack.application.request;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PUTAddTrack {
    @NotNull(message = "Track is required")
    Integer trackId;
}
