package com.example.ParcialBack.services;

import com.example.ParcialBack.domain.Artist;
import com.example.ParcialBack.domain.MediaType;
import com.example.ParcialBack.repositories.IdentifierRepository;
import com.example.ParcialBack.repositories.MediaTypeRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class MediaTypeServiceImpl implements MediaTypeService{
    MediaTypeRepository mediaTypeRepository;
    IdentifierRepository identifierRepository;


    @Override
    public List<MediaType> findAll() {
        return mediaTypeRepository.findAll();
    }

    @Override
    public Optional<MediaType> findById(Integer id) {
        return mediaTypeRepository.findById(id);
    }
}
