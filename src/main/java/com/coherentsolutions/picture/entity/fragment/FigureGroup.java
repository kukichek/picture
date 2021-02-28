package com.coherentsolutions.picture.entity.fragment;

import com.coherentsolutions.picture.entity.Fragment;
import com.coherentsolutions.picture.entity.enumeration.Orientation;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@RequiredArgsConstructor
public class FigureGroup extends Fragment {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_figure_group_id")
    private List<Fragment> fragments;

    @Column(nullable = false)
    private Integer orientationId;

    @Transient
    @NonNull
    private Orientation orientation;

    @PostLoad
    @PostUpdate
    public void fillOrientation() {
        this.orientation = Orientation.of(orientationId);
    }

    @PrePersist
    @PreUpdate
    public void fillOrientationId() {
        this.orientationId = orientation.getId();
    }

    @Override
    public void draw() {

    }
}
