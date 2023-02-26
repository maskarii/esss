package com.esss.converter;

import com.esss.dto.EquipmentDTO;
import com.esss.model.Equipment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EquipmentConverter {
    public EquipmentDTO entityToDto(Equipment entity){
        EquipmentDTO dto = new EquipmentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAvailability(entity.getAvailability());
        return dto;
    }

    public List<EquipmentDTO> entityToDto(List<Equipment> equipmentList){
        return equipmentList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Equipment dtoToEntity(EquipmentDTO dto){
        Equipment entity = new Equipment();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAvailability(dto.getAvailability());
        return entity;
    }

    public List<Equipment> dtoToEntity(List<EquipmentDTO> equipmentDTOList){
        return equipmentDTOList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
