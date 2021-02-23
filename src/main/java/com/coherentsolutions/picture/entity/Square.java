package com.coherentsolutions.picture.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Square extends Figure {
    @Column(name = "inner_char")
    private Character character;

    @Override
    public void draw() {

    }
}
