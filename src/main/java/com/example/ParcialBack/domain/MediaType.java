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
@Table(name = MediaType.TABLE_NAME)
public class MediaType {
    public static final String TABLE_NAME = "media_types";

    @Id
    @Column(name = "mediaTypeId")
    int id;

    String name;

    public void update(String name) {
        this.name = name;
    }
}
