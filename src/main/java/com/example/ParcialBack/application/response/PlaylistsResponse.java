package com.example.ParcialBack.application.response;

import com.example.ParcialBack.domain.Playlist;
import com.example.ParcialBack.domain.Track;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaylistsResponse {
    int id;
    String name;
    List<TrackResponse> tracks;

    public static PlaylistsResponse from(Playlist aPlaylist) {
        List<TrackResponse> trackResponses = aPlaylist.getTracks().stream()
                .map(TrackResponse::from)
                .collect(Collectors.toList());

        return PlaylistsResponse.builder()
                .id(aPlaylist.getId())
                .name(aPlaylist.getName())
                .tracks(trackResponses)
                .build();
    }
}