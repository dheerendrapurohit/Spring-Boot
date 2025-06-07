package com.dheerendra.sms.service.impl;


import com.dheerendra.sms.dto.StudentDto;
import com.dheerendra.sms.entity.Student;
import com.dheerendra.sms.exception.ResourceNotFoundException;
import com.dheerendra.sms.mapper.StudentMapper;
import com.dheerendra.sms.repository.StudentRepository;
import com.dheerendra.sms.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());

        Student savedStudent = studentRepository.save(student);
        return new StudentDto(savedStudent.getId(), savedStudent.getFirstName(), savedStudent.getLastName());
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student=studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("student is not exist with given id:"+studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students=studentRepository.findAll();
        return students.stream().map((student)->StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {
        Student student=studentRepository.findById(studentId).orElseThrow(
                ()->new ResourceNotFoundException("student not exist with given id:"+studentId)
        );
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());

        Student updateStudentObj=studentRepository.save(student);
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public Void deleteStudent(Long studentId) {
        Student student=studentRepository.findById(studentId).orElseThrow(
                ()->new ResourceNotFoundException("student not exist with given id:"+studentId)
        );
        studentRepository.deleteById(studentId);
        return null;
    }
}
