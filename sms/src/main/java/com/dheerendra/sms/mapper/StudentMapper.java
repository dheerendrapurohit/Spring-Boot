package com.dheerendra.sms.mapper;

import lombok.NonNull;
import com.dheerendra.sms.dto.StudentDto;
import com.dheerendra.sms.entity.Student;

public class StudentMapper {

    @NonNull
    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName()
        );
    }

    public static Student mapToStudent(StudentDto studentDto){
        Student student=new Student();
        student.setId(studentDto.getId());
        student.setFirstName(student.getFirstName());
        student.setLastName(student.getLastName());
        return student;
    }
}
