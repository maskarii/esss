package com.esss.dao;

import com.esss.model.Seat;
import com.esss.repository.SeatRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatDAOImpl implements SeatDAO{
    private final SeatRepo repo;

    public SeatDAOImpl(SeatRepo repo) {
        this.repo = repo;
    }

    @Override
    public Seat getSeatBySeatNum(String seatNum) {
        return repo.getSeatBySeatNum(seatNum);
    }

    @Override
    public Seat getSeatByAsStudent(String asStudent) {
        return repo.getSeatByAsStudent(asStudent);
    }

    @Override
    public List<Seat> getAllSeats() {
        return repo.findAll();
    }
}
