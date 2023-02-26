package com.esss.dao;

import com.esss.model.Seat;

import java.util.List;

public interface SeatDAO {
    Seat getSeatBySeatNum(String seatNum);
    Seat getSeatByAsStudent(String asStudent);
    List<Seat> getAllSeats();
}
