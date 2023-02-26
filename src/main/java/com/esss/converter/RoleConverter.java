package com.esss.converter;

import com.esss.dto.RoleDTO;
import com.esss.model.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleConverter {
    public RoleDTO entityToDto(Role entity){
        RoleDTO dto = new RoleDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public List<RoleDTO> entityToDto(List<Role> roleList){
        return roleList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Role dtoToEntity(RoleDTO dto){
        Role entity = new Role();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public List<Role> dtoToEntity(List<RoleDTO> roleDTOList){
        return roleDTOList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
