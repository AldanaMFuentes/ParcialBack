package com.example.ParcialBack.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Artist.TABLE_NAME)
public class Artist {
    public static final String TABLE_NAME = "artists";

    @Id
    @Column(name = "artistId")
    int id;

    String name;

    public void update(String name) {
        this.name = name;
    }
}
