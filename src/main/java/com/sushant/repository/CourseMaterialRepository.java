package com.sushant.repository;

import com.sushant.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

    @Query(value = "select * from course_material s where s.course_id = ?1", nativeQuery = true)
    Optional<CourseMaterial> findByCourseId(long course_id);
}
