package com.coherentsolutions.picture.entity.fragment;

import com.coherentsolutions.picture.entity.Fragment;
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
public class Square extends Fragment {
    @Column(name = "inner_char")
    private Character character;

    @Override
    public void draw() {

    }
}
