package com.esss.dao;

import com.esss.model.Room;
import com.esss.repository.RoomRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomDAOImpl implements RoomDAO{
    private final RoomRepo repo;
    public RoomDAOImpl(RoomRepo repo) {this.repo = repo;}

    @Override
    public List<Room> getAllRooms() {return repo.findAll();}

    @Override
    public List<Room> addRoomsToListRoom(List<String> roomNumberList) {
        List<Room> newList = new ArrayList<Room>();
        for(int i = 0; i < roomNumberList.size(); i++){
            newList.add(this.getRoomByNumber(roomNumberList.get(i)));
        }
        return newList;
    }

    @Override
    public Room getRoomById(String id) {return repo.findById(id).get();}

    @Override
    public Room getRoomByNumber(String roomNumber) {
        return repo.getRoomByNumber(roomNumber);
    }

    @Override
    public boolean createRoom(Room room) {
        if (room != null) {
            repo.save(room);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRoom(Room room) {
        if (this.getRoomById(room.getId()) != null) {
            repo.save(room);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRoom(String id) {
        if (this.getRoomById(id) != null) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<String> checkIfRoomsExistInListOfRooms(List<String> roomNumberList, List<Room> roomList) {
        List<String> comparinglist = new ArrayList<String>();
        if(roomList != null){
            for(Room room: roomList){
                comparinglist.add(room.getNumber());
            }
            roomNumberList.removeAll(comparinglist);
            return roomNumberList;
        }else {
            return roomNumberList;
        }
    }
}
