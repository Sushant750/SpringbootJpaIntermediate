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

    //optional = false is added to make sure that every time a courseMaterial is saved it should contain course also.
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    private Course course;
}
