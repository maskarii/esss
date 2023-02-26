package com.esss.converter;

import com.esss.dto.CourseDTO;
import com.esss.model.Courses;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseConverter {
    private final UserConverter userConverter = new UserConverter();
    public CourseDTO entityToDto(Courses entity){
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setLecturer(dto.getLecturer());
        dto.setName(entity.getName());
        dto.setStudentList(userConverter.entityToDto(entity.getStudentList()));
        return dto;
    }

    public Courses dtoToEntity(CourseDTO dto){
        Courses entity = new Courses();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setLecturer(userConverter.dtoToEntity(dto.getLecturer()));
        entity.setStudentList(userConverter.dtoToEntity(dto.getStudentList()));
        return entity;
    }

    public List<CourseDTO> entityToDto(List<Courses> coursesList){
        return coursesList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<Courses> dtoToEntity(List<CourseDTO> courseDTOList){
        return courseDTOList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
