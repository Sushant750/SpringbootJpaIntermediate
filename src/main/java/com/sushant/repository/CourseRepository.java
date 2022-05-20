package com.sushant.repository;

import com.sushant.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


    @Query(value = "select * from course s where s.course_id = ?1", nativeQuery = true)
    Course findAllCoursesById(long course_id);
}
