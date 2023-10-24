package com.example.ParcialBack.application.response;

import com.example.ParcialBack.domain.Artist;
import com.example.ParcialBack.domain.Genre;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GenreResponse {
    Integer id;
    String name;

    public static GenreResponse from(Genre aGenre) {
        return GenreResponse.builder()
                .id(aGenre.getId())
                .name(aGenre.getName())
                .build();
    }
}
