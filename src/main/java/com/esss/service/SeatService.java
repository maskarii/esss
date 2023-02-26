package com.esss.service;

import com.esss.dto.SeatDTO;

import java.util.List;

public interface SeatService {
    SeatDTO getSeatBySeatNum(String seatNum);
    SeatDTO getSeatByAsStudent(String asStudent);
    List<SeatDTO> getAllSeats();
}
