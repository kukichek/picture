package com.coherentsolutions.picture.entity;

import com.coherentsolutions.picture.entity.fragment.Circle;
import com.coherentsolutions.picture.entity.fragment.FigureGroup;
import com.coherentsolutions.picture.entity.fragment.Square;
import com.coherentsolutions.picture.entity.fragment.Triangle;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Circle.class, name = "circle"),
        @JsonSubTypes.Type(value = Triangle.class, name = "triangle"),
        @JsonSubTypes.Type(value = Square.class, name = "square"),
        @JsonSubTypes.Type(value = FigureGroup.class, name = "figureGroup")
})
public abstract class Fragment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fragment_id")
    private Long id;

    @Column(name = "queue_order")
    private Integer queueOrder;

    public abstract void draw();
}
