package com.example.ParcialBack.application.response;

import com.example.ParcialBack.domain.Artist;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArtistResponse {
    Integer id;
    String name;

    public static ArtistResponse from(Artist aArtist) {
        return ArtistResponse.builder()
                .id(aArtist.getId())
                .name(aArtist.getName())
                .build();
    }
}
