package com.dheerendra.sms.service;

import com.dheerendra.sms.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long studentId);

    List<StudentDto> getAllStudents();

    StudentDto updateStudent(Long studentId, StudentDto updatedStudent);

    Void deleteStudent(Long studentId);
}
