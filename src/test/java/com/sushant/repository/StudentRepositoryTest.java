package com.sushant.repository;

import com.sushant.entity.Guardian;
import com.sushant.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest

class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentData(){

        Student student = Student.builder()
                .emailId("sonukumar@gmail.com")
                .firstName("Sonu")
                .lastName("kumar")
//                .guardianEmail("demoemail@gmail.com")
//                .guardianMobNo("99889858585")
//                .guardianName("AABBCC")
                .build();

        Student save = studentRepository.save(student);
        Assertions.assertEquals("Sonu", student.getFirstName());

    }

    @Test
    public void saveStudent(){
        Guardian guardian = Guardian.builder()
                .email("buildingguardianobject@gmail.com")
                .mobNo("99988877744556")
                .name("Demo")
                .build();
        Student student = Student.builder()
                .emailId("ravikumar@gmail.com")
                .firstName("Ravi")
                .lastName("kumar")
                .guardian(guardian)
                .build();

        Student save = studentRepository.save(student);
        Assertions.assertEquals("Demo", student.getGuardian().getName());

    }


    @Test
    public void getAllStudents(){

        List<Student> allStudents = studentRepository.findAll();
        Assertions.assertNotNull(allStudents);
    }



    @Test
    public void getStudentsByFirstName(){

        List<Student> allStudents = studentRepository.findByFirstName("Ravi");
        Assertions.assertNotNull(allStudents);
        System.out.println("Student details" + allStudents);
    }

    @Test
    public void getStudentsByFirstNameContaining(){

        List<Student> allStudents = studentRepository.findByFirstNameContaining("R");
        Assertions.assertNotNull(allStudents);
        System.out.println("Student details" + allStudents);
    }


    @Test
    public void getStudentsByGuardianName(){

        List<Student> demo = studentRepository.findByGuardianName("Demo");
        System.out.println("Student details" + demo);
    }

}