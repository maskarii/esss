package com.esss.dao;

import com.esss.model.Courses;

import java.util.List;

public interface CourseDAO {
    Courses getCourseByName(String name);
    Courses getCourseByCode(String code);
    Courses getCourseByLecturer(String lecturer);
    List<Courses> getAllCourses();
}
