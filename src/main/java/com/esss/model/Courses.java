package com.esss.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table
public class Courses {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2",strategy = "uuid2")
    @Column(name = "id", length = 36)
    private String id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "code", unique = true)
    private String code;
    @ManyToOne
    private User lecturer;
    @Column(name = "student")
    @ManyToMany
    private List<User> studentList;

    public Courses(String name, String code, User lecturer) {
        this.name = name;
        this.code = code;
        this.lecturer = lecturer;
    }

    public Courses(String name, String code, User lecturer, List<User> studentList) {
        this.name = name;
        this.code = code;
        this.lecturer = lecturer;
        this.studentList = studentList;
    }
}
