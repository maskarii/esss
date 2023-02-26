package com.esss.service;

import com.esss.converter.RoomConverter;
import com.esss.dao.RoomDAO;
import com.esss.dto.RoomDTO;
import com.esss.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    private final RoomDAO data;
    private final RoomConverter roomConverter;

    public RoomServiceImpl(RoomDAO data, RoomConverter roomConverter) {
        this.data = data;
        this.roomConverter = roomConverter;
    }


    @Override
    public List<RoomDTO> getAllRooms() {
        return roomConverter.entityToDto(data.getAllRooms());
    }

    @Override
    public RoomDTO getRoomById(String id) {
        return roomConverter.entityToDto(data.getRoomById(id));
    }

    @Override
    public List<RoomDTO> addRoomToListRoom(List<String> roomNumberList) {
        return roomConverter.entityToDto(data.addRoomsToListRoom(roomNumberList));
    }

    @Override
    public boolean addRoom(RoomDTO roomDTO) {
        if (roomDTO != null){
            Room entity = roomConverter.dtoToEntity(roomDTO);
            data.createRoom(entity);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean editRoom(RoomDTO roomDTO) {
        if (roomDTO != null){
            Room entity = roomConverter.dtoToEntity(roomDTO);
            data.updateRoom(entity);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean removeRoom(String id) {
        if (id != null){
            data.deleteRoom(id);
            return true;
        }
        else {
            return false;
        }
    }
}
