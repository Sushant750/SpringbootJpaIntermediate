package com.sushant.entity;


import lombok.*;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(name="courseMaterialId_Generator", sequenceName = "courseMaterialId_Generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseMaterialId_Generator")
    private Long courseMaterialId;
    private String url;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    private Course course;
}
