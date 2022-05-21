package com.sushant.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Course {

    @Id
    @SequenceGenerator(name = "CourseSequence", sequenceName = "CourseSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CourseSequence")
    private Long courseId;
    private String title;
    private Integer credit;


    //Implemented this to get the course with courseMaterial, By-directional-OneToOne Mapping
    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;
}
