package com.esss.dao;

import com.esss.model.Courses;
import com.esss.repository.CourseRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO{
    private final CourseRepo repo;

    public CourseDAOImpl(CourseRepo repo) {
        this.repo = repo;
    }

    @Override
    public Courses getCourseByName(String name) {
        return repo.getCoursesByName(name);
    }

    @Override
    public Courses getCourseByCode(String code) {
        return repo.getCoursesByCode(code);
    }

    @Override
    public Courses getCourseByLecturer(String lecturer) {
        return repo.getCoursesByLecturer(lecturer);
    }

    @Override
    public List<Courses> getAllCourses() {
        return repo.findAll();
    }
}
