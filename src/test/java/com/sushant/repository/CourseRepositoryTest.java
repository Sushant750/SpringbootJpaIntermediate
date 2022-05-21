package com.sushant.repository;

import com.sushant.entity.Course;
import com.sushant.entity.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;


    @Test
    void testGetAllCoursesByCourseId(){

        Course allCoursesById = courseRepository.findAllCoursesById(1l);
        Assertions.assertNotNull(allCoursesById);
        System.out.println("PresentCourses based on given id" + allCoursesById);

    }


    @Test
    void testGetAllCourses(){

        List<Course> courseList = courseRepository.findAll();
        Assertions.assertNotNull(courseList);
        System.out.println("Here is all the courses" + courseList);
    }


    @Test
    void testTeacherSave(){

        Teacher teacher = Teacher.builder()
                .firstName("Neha")
                .lastName("Singh")
                .build();

        Course course = Course.builder()
                .title("C++")
                .credit(4)
                .teacher(teacher)
                .build();

        Course save = courseRepository.save(course);
        Assertions.assertNotNull(save);
    }

}