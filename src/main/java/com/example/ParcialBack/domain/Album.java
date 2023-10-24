package com.example.ParcialBack.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Album.TABLE_NAME)
public class Album {
    public static final String TABLE_NAME = "albums";

    @Id
    @Column(name = "albumId")
    int id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "artistId")
    Artist artistId;

    String title;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "albumid")
    private List<Track> tracks;

    public Album(int id, Artist artist, String title) {
        this.id = id;
        this.artistId = artist;
        this.title = title;
        this.tracks = new LinkedList<>();
    }

    public void update(Artist artist, String title) {
        this.artistId = artist;
        this.title = title;
    }
}
