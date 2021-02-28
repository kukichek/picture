package com.coherentsolutions.picture.entity.fragment;

import com.coherentsolutions.picture.entity.Fragment;
import com.coherentsolutions.picture.entity.enumeration.Border;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Circle extends Fragment {
    public Circle(Border border) {
        this.border = border;
    }

    @Column
    @Enumerated(EnumType.STRING)
    private Border border = Border.SOLID;

    @Override
    public void draw() {

    }
}
