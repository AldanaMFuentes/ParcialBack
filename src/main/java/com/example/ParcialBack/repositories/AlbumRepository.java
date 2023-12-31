package com.example.ParcialBack.repositories;

import com.example.ParcialBack.domain.Album;
import com.example.ParcialBack.domain.Artist;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    void deleteAllByArtistId(Artist artistId);
}
