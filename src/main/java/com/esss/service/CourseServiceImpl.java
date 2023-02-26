package com.esss.service;

import com.esss.converter.CourseConverter;
import com.esss.dao.CourseDAO;
import com.esss.dto.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseDAO data;
    private final CourseConverter courseConverter;

    public CourseServiceImpl(CourseDAO data, CourseConverter courseConverter) {
        this.data = data;
        this.courseConverter = courseConverter;
    }

    @Override
    public CourseDTO getCourseByName(String name) {
        return courseConverter.entityToDto(data.getCourseByName(name));
    }

    @Override
    public CourseDTO getCourseByCode(String code) {
        return courseConverter.entityToDto(data.getCourseByCode(code));
    }

    @Override
    public CourseDTO getCourseByLecturer(String lecturer) {
        return courseConverter.entityToDto(data.getCourseByLecturer(lecturer));
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseConverter.entityToDto(data.getAllCourses());
    }
}
