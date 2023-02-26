package com.esss.converter;

import com.esss.dto.ExamDTO;
import com.esss.model.Exam;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExamConverter {
    private final UserConverter userConverter = new UserConverter();
    private final RoomConverter roomConverter = new RoomConverter();
    private final EquipmentConverter equipmentConverter = new EquipmentConverter();

    public ExamDTO entityToDto(Exam entity){
        ExamDTO dto = new ExamDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDate(entity.getDate());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        dto.setStudents(userConverter.entityToDto(entity.getStudents()));
        dto.setStaff(userConverter.entityToDto(entity.getStaff()));
        dto.setRooms(roomConverter.entityToDto(entity.getRooms()));
        dto.setEquipment(equipmentConverter.entityToDto(entity.getEquipment()));
        return dto;
    }

    public List<ExamDTO> entityToDto(List<Exam> examList){
        return examList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Exam dtoToEntity(ExamDTO dto){
        Exam entity = new Exam();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        entity.setStudents(userConverter.dtoToEntity(dto.getStudents()));
        entity.setStaff(userConverter.dtoToEntity(dto.getStaff()));
        entity.setRooms(roomConverter.dtoToEntity(dto.getRooms()));
        entity.setEquipment(equipmentConverter.dtoToEntity(dto.getEquipment()));
        return entity;
    }

    public List<Exam> dtoToEntity(List<ExamDTO> examDTOList){
        return examDTOList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
