package com.esss.repository;

import com.esss.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room, String> {

    @Query("SELECT room FROM Room room WHERE room.number=?1")
    Room getRoomByNumber(String roomNumber);

}
