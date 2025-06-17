package com.dheerendra.sms.service;

import com.dheerendra.sms.dto.StudentDto;
import com.dheerendra.sms.entity.Student;
import com.dheerendra.sms.repository.StudentRepository;
import com.dheerendra.sms.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class StudentServiceTest {


    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateStudent() {
        StudentDto dto =new StudentDto(null, "ram", "das");
        Student savedStudent =new Student(1L, "ram", "das");

        when(studentRepository.save(Mockito.<Student>any())).thenReturn(savedStudent);
        StudentDto result =studentService.createStudent(dto);

        Assertions.assertEquals("ram", result.getFirstName());
        Assertions.assertEquals("das", result.getLastName());

    }

    @Test
    void testGetStudentById(){
        Student student=new Student(1L,"ram","das");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        StudentDto result=studentService.getStudentById(1L);
        Assertions.assertEquals("ram",result.getFirstName());
    }

    @Test
    void  testDeleteStudent(){
        Student student=new Student(1L,"ram","das");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        doNothing().when(studentRepository).deleteById(1L);

        Assertions.assertDoesNotThrow(()->studentService.deleteStudent(1L));
        verify(studentRepository,times(1)).deleteById(1L);
    }

    @Test
    void testGetAllStudents(){
        Student student1=new Student(1L,"ram","das");
        Student student2=new Student(2L,"raja","ram");

        when(studentRepository.findAll()).thenReturn(List.of(student1, student2));

        List<StudentDto> result = studentService.getAllStudents();

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("ram", result.get(0).getFirstName());
        Assertions.assertEquals("raja", result.get(1).getFirstName());

        verify(studentRepository, times(1)).findAll();
    }
}
