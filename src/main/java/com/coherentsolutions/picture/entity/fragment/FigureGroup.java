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

    @Column
    @NonNull
    @Enumerated(EnumType.STRING)
    private Orientation orientation;

    @Override
    public void draw() {

    }
}
