package com.coherentsolutions.picture.entity.fragment;

import com.coherentsolutions.picture.entity.Fragment;
import com.coherentsolutions.picture.entity.enumeration.Orientation;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.IntStream;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@RequiredArgsConstructor
public class FigureGroup extends Fragment {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_figure_group_id")
    @OrderBy("queueOrder")
    private List<Fragment> fragments;

    @Column
    @NonNull
    @Enumerated(EnumType.STRING)
    private Orientation orientation;

    @PrePersist
    public void setOrder() {
        if (fragments != null) {
            IntStream
                    .range(0, fragments.size())
                    .forEach(i -> fragments.get(i).setQueueOrder(i));
        }
    }

    @Override
    public void draw() {

    }
}
