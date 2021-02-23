package com.coherentsolutions.picture.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Orientation {
    ROW(1), COL(2);

    private Integer id;

    public static Orientation of(Integer id) {
        return Arrays
                .stream(Orientation.values())
                .filter(orientation -> orientation.id.equals(id))
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("There is no border style with such id");
                });
    }
}
