package com.sushant.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(name = "teacherId_generator",sequenceName = "teacherId_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacherId_generator")
    private Long teacherId;
    private String firstName;
    private String lastName;


    //Uni-directional Mapping
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
//    private List<Course> course;
}
