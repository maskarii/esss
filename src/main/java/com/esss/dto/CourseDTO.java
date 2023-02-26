package com.esss.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private String id;
    private String name;
    private String code;
    private UserDTO lecturer;
    private List<UserDTO> studentList;

    public CourseDTO(String name, String code, UserDTO lecturer) {
        this.name = name;
        this.code = code;
        this.lecturer = lecturer;
    }

    public CourseDTO(String name, String code, UserDTO lecturer, List<UserDTO> studentList) {
        this.name = name;
        this.code = code;
        this.lecturer = lecturer;
        this.studentList = studentList;
    }
}
