package com.esss.service;

import com.esss.dto.RoomDTO;

import java.util.List;

public interface RoomService {
    List<RoomDTO> getAllRooms();
    RoomDTO getRoomById(String id);
    List<RoomDTO> addRoomToListRoom(List<String> roomNumberList);
    boolean addRoom(RoomDTO roomDTO);
    boolean editRoom(RoomDTO roomDTO);
    boolean removeRoom(String id);
}
