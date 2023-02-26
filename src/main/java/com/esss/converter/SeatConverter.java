package com.esss.converter;

import com.esss.dto.SeatDTO;
import com.esss.model.Seat;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeatConverter {
    private final UserConverter userConverter = new UserConverter();
    public SeatDTO entityToDto(Seat entity){
        SeatDTO dto = new SeatDTO();
        dto.setSeatNum(entity.getSeatNum());
  //      dto.setAsStudent(userConverter.entityToDto(dto.getAsStudent()));
        dto.setId(entity.getId());
        return dto;
    }

    public Seat dtoToEntity(SeatDTO dto){
        Seat entity = new Seat();
        entity.setSeatNum(dto.getSeatNum());
        entity.setId(dto.getId());
       // entity.setAsStudent(userConverter.entityToDto(dto.getAsStudent()));
        return entity;
    }

    public List<SeatDTO> entityToDto(List<Seat> seatList){
        return seatList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<Seat> dtoToEnity(List<SeatDTO> seatDTOList){
        return seatDTOList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
