package com.coherentsolutions.picture;

import com.coherentsolutions.picture.entity.*;
import com.coherentsolutions.picture.entity.enumeration.Border;
import com.coherentsolutions.picture.entity.enumeration.Orientation;
import com.coherentsolutions.picture.entity.fragment.Circle;
import com.coherentsolutions.picture.entity.fragment.FigureGroup;
import com.coherentsolutions.picture.entity.fragment.Square;
import com.coherentsolutions.picture.repository.PictureRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PictureApplication.class)
@TestPropertySource(
        locations = "classpath:application.properties")
public class SpringTest {
    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void setup() throws JsonProcessingException {
        Picture pictureToSave = new Picture("First", getRootFigureGroup());
        String json = objectMapper.writeValueAsString(pictureToSave);
        Picture picture = objectMapper.readValue(json, Picture.class);
//        pictureRepository.save(pictureToSave);
//
//        Optional<Picture> optionalPictureToFind = pictureRepository.findById(pictureToSave.getId());
//
//        Picture pictureToFind = optionalPictureToFind.orElseThrow(AssertionError::new);
//        assertEquals(pictureToSave, pictureToFind);
    }

    private FigureGroup getRootFigureGroup() {
        FigureGroup rootGroup = new FigureGroup(Orientation.COL);
        FigureGroup innerGroup = new FigureGroup(Orientation.ROW);

        innerGroup.setFragments(
                List.of(
                        new Square('I'),
                        new Square('N'),
                        new Square('E')
                )
        );

        rootGroup.setFragments(
                List.of(
                        new Circle(),
                        innerGroup,
                        new Circle(Border.DASHED)
                )
        );

        return rootGroup;
    }
}