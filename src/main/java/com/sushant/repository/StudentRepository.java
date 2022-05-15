package com.sushant.repository;

import com.sushant.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String firstName);
    public List<Student> findByGuardianName(String guardianName);

//    find below link for more details regarding jpa query
//    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
}
