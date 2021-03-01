package com.coherentsolutions.picture.entity;

import com.coherentsolutions.picture.entity.fragment.FigureGroup;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "picture_id")
    private Long id;

    @Column
    @NonNull
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "root_figure_group_id", referencedColumnName = "fragment_id")
    @NonNull
    private FigureGroup rootGroup;

    @Column(updatable = false)
    @CreationTimestamp
    private Calendar createdAt;

    @Column
    @UpdateTimestamp
    private Calendar modifiedAt;
}
