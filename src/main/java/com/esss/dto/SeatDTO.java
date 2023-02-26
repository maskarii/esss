package com.esss.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDTO {
    private String id;
    private String seatNum;
    private UserDTO asStudent;

    public SeatDTO(String seatNum, UserDTO asStudent) {
        this.seatNum = seatNum;
        this.asStudent = asStudent;
    }
}
