package com.esss.dao;

import com.esss.model.Room;

import java.util.List;

public interface RoomDAO {
    List<Room> getAllRooms();
    List<Room> addRoomsToListRoom(List<String> roomNumberList);
    Room getRoomById(String id);
    Room getRoomByNumber(String roomNumber);
    boolean createRoom(Room room);
    boolean updateRoom(Room room);
    boolean deleteRoom(String id);
    List<String> checkIfRoomsExistInListOfRooms(List<String> roomNumberList, List<Room> roomList);

}
