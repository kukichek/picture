package com.coherentsolutions.picture.controller;

import com.coherentsolutions.picture.entity.Picture;
import com.coherentsolutions.picture.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pictures")
@RequiredArgsConstructor
public class PictureController {
    private final PictureService pictureService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Picture> pictures = pictureService.findAll(Sort.by("modifiedAt").descending());

        return ResponseEntity.ok(
                Collections.singletonMap(
                        "pictures",
                        pictures
                )
        );
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Picture picture) {
        pictureService.save(picture);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Picture picture) {
        pictureService.delete(picture);

        return ResponseEntity.ok().build();
    }
}
