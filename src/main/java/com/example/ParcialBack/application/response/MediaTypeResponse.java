package com.example.ParcialBack.application.response;

import com.example.ParcialBack.domain.Artist;
import com.example.ParcialBack.domain.MediaType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MediaTypeResponse {
    Integer id;
    String name;

    public static MediaTypeResponse from(MediaType aMediaType) {
        return MediaTypeResponse.builder()
                .id(aMediaType.getId())
                .name(aMediaType.getName())
                .build();
    }
}
