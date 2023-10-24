package com.example.ParcialBack.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ManyToAny;

import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Table(name = Track.TABLE_NAME)
public class Track {
    public static final String TABLE_NAME = "tracks";

    @Id
    @Column(name = "trackId")
    int id;

    String name;
    String composer;
    int milliseconds;
    int bytes;
    double unitPrice;

    @OneToOne
    @JoinColumn(name = "albumId")
    Album albumId;

    @OneToOne
    @JoinColumn(name = "mediaTypeId")
    MediaType mediaTypeId;

    @OneToOne
    @JoinColumn(name = "genreId")
    Genre genreId;

    public Track(int trackId, String name, String composer, int milliseconds, int bytes, double unitPrice, Album album, MediaType mediaType, Genre genre) {
        this.id = trackId;
        this.name = name;
        this.composer = composer;
        this.milliseconds = milliseconds;
        this.bytes = bytes;
        this.unitPrice = unitPrice;
        this.albumId = album;
        this.mediaTypeId = mediaType;
        this.genreId = genre;
    }

    public void update(String name, String composer, int milliseconds, int bytes, double unitPrice, Album album, MediaType mediaType, Genre genre) {
        this.name = name;
        this.composer = composer;
        this.milliseconds = milliseconds;
        this.bytes = bytes;
        this.unitPrice = unitPrice;
        this.albumId = album;
        this.mediaTypeId = mediaType;
        this.genreId = genre;
    }
}
