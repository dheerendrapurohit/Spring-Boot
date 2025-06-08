package com.dheerendra.sms;

import com.dheerendra.sms.entity.Student;
import com.dheerendra.sms.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testExample(){
        assertEquals(4,2+2);
    }

    @Test
    public void testCreateStudent(){
        Student student=new Student(1L,"ram","das");
        Student savedStudent=studentRepository.save(student);
        assertNotNull(savedStudent);
    }

    @Test
    public void getAllStudent(){
        List<Student> studentList=(List<Student>) studentRepository.findAll();
        assertNotNull(studentList);
        assertFalse(studentList.isEmpty());
    }

    @Test
    public void getStudent(){
        Long id=1L;
        Optional<Student> student=studentRepository.findById(id);
        assertNotNull(student);
    }


    @Test
    public void deleteStudent(){
        Long id=1L;
        studentRepository.deleteById(id);
    }

}
