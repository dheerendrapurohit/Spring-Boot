package com.dheerendra.sms.dto;

import lombok.AllArgsConstructor;




public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;

    public StudentDto(){}

    public StudentDto(Long id, String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
