package com.coherentsolutions.picture.service.impl;

import com.coherentsolutions.picture.entity.Picture;
import com.coherentsolutions.picture.repository.PictureRepository;
import com.coherentsolutions.picture.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;

    @Override
    public List<Picture> findAll(Sort sort) {
        return pictureRepository.findAll(sort);
    }

    @Override
    public Picture save(Picture picture) {
        return pictureRepository.save(picture);
    }

    @Override
    public void delete(Picture picture) {
        pictureRepository.delete(picture);
    }
}
