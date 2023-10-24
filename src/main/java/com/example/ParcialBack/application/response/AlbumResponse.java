package com.example.ParcialBack.application.response;

import com.example.ParcialBack.domain.Album;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AlbumResponse {
    Integer id;
    ArtistResponse artist;
    String title;
    List<TrackResponse> tracks;

    public static AlbumResponse from(Album aAlbum) {
        List<TrackResponse> trackResponses = aAlbum.getTracks().stream()
                .map(TrackResponse::from)
                .collect(Collectors.toList());

        return AlbumResponse.builder()
                .id(aAlbum.getId())
                .artist(ArtistResponse.from(aAlbum.getArtistId()))
                .title(aAlbum.getTitle())
                .tracks(trackResponses)
                .build();
    }
}
