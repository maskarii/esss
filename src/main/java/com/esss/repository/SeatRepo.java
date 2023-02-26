package com.esss.repository;

import com.esss.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepo extends JpaRepository<Seat, String> {
    @Query("SELECT seat FROM Seat seat Where seat.seatNum =?1")
    Seat getSeatBySeatNum(String seatNum);

    @Query("SELECT seat FROM Seat seat Where seat.asStudent =?1")
    Seat getSeatByAsStudent(String asStudent);
}
