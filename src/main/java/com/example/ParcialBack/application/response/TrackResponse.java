package com.example.ParcialBack.application.response;

import com.example.ParcialBack.domain.Playlist;
import com.example.ParcialBack.domain.Track;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TrackResponse {
    int id;
    String name;
    String composer;
    int milliseconds;
    int bytes;
    double unitPrice;
    String album;
    MediaTypeResponse mediaType;
    GenreResponse genre;

    public static TrackResponse from(Track aTrack) {
        return TrackResponse.builder()
                .id(aTrack.getId())
                .name(aTrack.getName())
                .composer(aTrack.getComposer())
                .milliseconds(aTrack.getMilliseconds())
                .bytes(aTrack.getBytes())
                .unitPrice(aTrack.getUnitPrice())
                .album(aTrack.getAlbumId().getTitle())
                .mediaType(MediaTypeResponse.from(aTrack.getMediaTypeId()))
                .genre(GenreResponse.from(aTrack.getGenreId()))
                .build();
    }
}
