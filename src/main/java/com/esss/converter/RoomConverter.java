package com.esss.converter;

import com.esss.dto.RoomDTO;
import com.esss.model.Room;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomConverter {
    public RoomDTO entityToDto(Room entity){
        RoomDTO dto = new RoomDTO();
        dto.setId(entity.getId());
        dto.setNumber(entity.getNumber());
        dto.setNrOfSeats(entity.getNrOfSeats());
        return dto;
    }

    public List<RoomDTO> entityToDto(List<Room> roomList){
        return roomList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public Room dtoToEntity(RoomDTO dto){
        Room entity = new Room();
        entity.setId(dto.getId());
        entity.setNumber(dto.getNumber());
        entity.setNrOfSeats(dto.getNrOfSeats());
        return entity;
    }

    public List<Room> dtoToEntity(List<RoomDTO> roomDTOList){
        return roomDTOList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
