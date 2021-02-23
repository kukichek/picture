package com.coherentsolutions.picture.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Fragment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fragment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_figure_group_id")
    private FigureGroup parentFigureGroup;

    public abstract void draw();
}
