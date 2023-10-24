package com.example.ParcialBack.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ManyToAny;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Table(name = Playlist.TABLE_NAME)
public class Playlist {
    public static final String TABLE_NAME = "playlists";
    @Id
    @Column(name = "playlistId")
    int id;

    String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(
            name = "playlist_track",
            joinColumns = @JoinColumn(name = "playlistId"),
            inverseJoinColumns = @JoinColumn(name = "trackId")
    )
    List<Track> tracks;

    public Playlist(int id, String name) {
        this.id = id;
        this.name = name;
        this.tracks = new LinkedList<>();
    }

    public void update(String name) {
        this.name = name;
    }
}
