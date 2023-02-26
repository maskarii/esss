package com.esss.service;

import com.esss.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    CourseDTO getCourseByName(String name);
    CourseDTO getCourseByCode(String code);
    CourseDTO getCourseByLecturer(String lecturer);
    List<CourseDTO> getAllCourses();
}
