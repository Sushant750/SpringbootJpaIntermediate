package com.sushant.repository;

import com.sushant.entity.Course;
import com.sushant.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void testTeacherRepositorySave(){

        Course course =  Course.builder()
                .title("MCA")
                .credit(6)
                .build();

        Course course1 =  Course.builder()
                .title("DSA")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("BalMukund")
                .lastName("Mishra")
              //  .course(Arrays.asList(course,course1))
                .build();


        teacherRepository.save(teacher);


    }

}