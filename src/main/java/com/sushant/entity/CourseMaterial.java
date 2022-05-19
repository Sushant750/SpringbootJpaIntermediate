package com.sushant.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {

    @Id
    @SequenceGenerator(name="courseMaterialId_Generator", sequenceName = "courseMaterialId_Generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseMaterialId_Generator")
    private Long courseMaterialId;
    private String url;

    @OneToOne
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    private Course course;
}
