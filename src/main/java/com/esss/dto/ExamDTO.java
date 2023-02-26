package com.esss.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamDTO {
    private String id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime endTime;
    private List<UserDTO> students;
    private List<UserDTO> staff;
    private List<RoomDTO> rooms;
    private List<EquipmentDTO> equipment;

    public ExamDTO(String name, LocalDate date, LocalTime time, LocalTime endTime, List<UserDTO> students, List<UserDTO> staff, List<RoomDTO> rooms, List<EquipmentDTO> equipment) {
        this.name = name;
        this.date = date;
        this.startTime = time;
        this.endTime = endTime;
        this.students = students;
        this.staff = staff;
        this.rooms = rooms;
        this.equipment = equipment;
    }
}
