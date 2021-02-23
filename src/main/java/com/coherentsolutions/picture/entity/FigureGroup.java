package com.coherentsolutions.picture.entity;

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
    @OneToMany(mappedBy = "parentFigureGroup", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
        setFragmentsParentGroup();
    }

    private void setFragmentsParentGroup() {
        if (fragments != null) {
            for (Fragment fragment: fragments) {
                if (fragment != null) {
                    fragment.setParentFigureGroup(this);
                }
            }
        }
    }
}
