package com.coherentsolutions.picture.entity;

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

    @Column(nullable = false)
    private Integer borderId;

    @Transient
    private Border border = Border.SOLID;

    @PostUpdate
    @PostLoad
    private void fillBorder() {
        this.border = Border.of(borderId);
    }

    @PrePersist
    private void fillBorderId() {
        this.borderId = border.getId();
    }

    @Override
    public void draw() {

    }
}
