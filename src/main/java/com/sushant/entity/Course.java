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
}
