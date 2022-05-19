package com.sushant.repository;

import com.sushant.entity.Student;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String firstName);
    public List<Student> findByGuardianName(String guardianName);

//    find below link for more details regarding jpa query
//    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods



    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    public List<Student> findByEmailId(String emailId);



    //JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailId(String emailId);


    //NativeQuery columnName is used here instead of field name.
    @Query(value = "select * from tbl_student s where s.Email_address = ?1", nativeQuery = true)
    public List<Student> findByEmailIdNativeQuery(String emailId);



    //NativeMethodParam
    @Query(value = "select * from tbl_student s where s.Email_address = :emailId", nativeQuery = true)
    public List<Student> findByEmailIdNativeQueryByNameParam(@Param("emailId") String emailId);




    //Updating Data
    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_Name = :firstName where Email_address = :emailId", nativeQuery = true)
    int updateFirstNameByEmailId(@Param("firstName") String firstName, @Param("emailId") String emailId);


}
