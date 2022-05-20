package com.sushant.repository;

import com.sushant.entity.Course;
import com.sushant.entity.CourseMaterial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseMaterialRepositoryTest {


    @Autowired
    private CourseMaterialRepository courseMaterialRepository;


    @Test
    void testCourseMaterialRepository(){

        Course course = Course.builder()
                .title("BCA")
                .credit(5)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.tutorialspoint.com")
                .course(course)
                .build();

        CourseMaterial saveCourseDetails = courseMaterialRepository.save(courseMaterial);
        Assertions.assertNotNull(saveCourseDetails);


    }

}