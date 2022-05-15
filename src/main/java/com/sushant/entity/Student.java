package com.sushant.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_student", uniqueConstraints = @UniqueConstraint(name = "UniqueEmailId", columnNames = "Email_address"))
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence",allocationSize = 1)
    @Column(name = "StudentUniqueId", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long Student_id;
    @Column(name = "First_Name", nullable = false)
    private String firstName;
    @Column(name = "Last_Name", nullable = false)
    private String lastName;
    @Column(name = "Email_address", nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;

}
