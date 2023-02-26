package com.esss.repository;


import com.esss.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Courses, String> {
    @Query("SELECT course FROM Courses course WHERE course.name = ?1")
    Courses getCoursesByName(String name);

    @Query("SELECT course FROM Courses course WHERE course.code = ?1")
    Courses getCoursesByCode(String code);

    @Query("SELECT course FROM Courses course WHERE course.lecturer = ?1")
    Courses getCoursesByLecturer(String lecturer);
}
