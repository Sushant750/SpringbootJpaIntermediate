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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseMaterialRepositoryTest {


    @Autowired
    private CourseMaterialRepository courseMaterialRepository;


    @Test
    void testCourseMaterialRepository(){

        Course course = Course.builder()
                .title("Algorithm")
                .credit(8)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.techreily.com")
                .course(course)
                .build();

        CourseMaterial saveCourseDetails = courseMaterialRepository.save(courseMaterial);
        Assertions.assertNotNull(saveCourseDetails);


    }


    @Test
    void testCourseMaterialLazyFetch(){

        Optional<CourseMaterial> byCourseId = courseMaterialRepository.findByCourseId(1L);
        Assertions.assertNotNull(byCourseId);
        System.out.println("CourseMaterial for id" + byCourseId);

    }

    @Test
    void testPrintAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        Assertions.assertNotNull(courseMaterialList);
        System.out.println("CourseMaterial" + courseMaterialList);

    }

}