package com.coherentsolutions.picture.service;

import com.coherentsolutions.picture.entity.Picture;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface PictureService {
    List<Picture> findAll(Sort sort);

    Picture save(Picture picture);

    void delete(Picture picture);
}
