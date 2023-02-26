package com.esss.service;

import com.esss.dao.SeatDAO;
import com.esss.converter.SeatConverter;
import com.esss.dto.SeatDTO;
import com.esss.service.SeatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    private final SeatDAO data;
    private final SeatConverter seatConverter;

    public SeatServiceImpl(SeatDAO data, SeatConverter seatConverter) {
        this.data = data;
        this.seatConverter = seatConverter;
    }

    @Override
    public SeatDTO getSeatBySeatNum(String seatNum) {
        return seatConverter.entityToDto(data.getSeatBySeatNum(seatNum));
    }

    @Override
    public SeatDTO getSeatByAsStudent(String asStudent) {
        return seatConverter.entityToDto(data.getSeatByAsStudent(asStudent));
    }

    @Override
    public List<SeatDTO> getAllSeats() {
        return seatConverter.entityToDto(data.getAllSeats());
    }
}
