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
@Table(name = Genre.TABLE_NAME)
public class Genre {
    public static final String TABLE_NAME = "genres";

    @Id
    @Column(name = "genreId")
    int id;

    String name;

    public void update(String name) {
        this.name = name;
    }
}
