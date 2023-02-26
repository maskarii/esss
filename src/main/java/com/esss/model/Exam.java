package com.esss.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", length = 36)
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;
    @Column(name = "startTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime startTime;
    @Column(name = "endTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime endTime;
    @ManyToMany
    private List<User> students;
    @ManyToMany
    private List<User> staff;
    @ManyToMany
    private List<Room> rooms;
    @ManyToMany
    private List<Equipment> equipment;

    public Exam(String name, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Exam(String name, LocalDate date, LocalTime startTime, LocalTime endTime,List<User> students, List<User> staff, List<Room> rooms, List<Equipment> equipment) {
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.students = students;
        this.staff = staff;
        this.rooms = rooms;
        this.equipment = equipment;
    }



    public Exam(String name, List<User> students, List<User> staff, List<Room> rooms, List<Equipment> equipment) {
        this.name = name;
        this.date = date;
        this.students = students;
        this.staff = staff;
        this.rooms = rooms;
        this.equipment = equipment;
    }
}
