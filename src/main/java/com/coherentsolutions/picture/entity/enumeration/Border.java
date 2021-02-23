package com.coherentsolutions.picture.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Border {
    SOLID(1), DOTTED(2), DASHED(3);

    private Integer id;

    public static Border of(Integer id) {
        return Arrays
                .stream(Border.values())
                .filter(border -> border.id.equals(id))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("There is no border style with such id");
                });
    }
}
