package com.esss.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private String id;
    private String number;
    private int nrOfSeats;

    public RoomDTO(String number, int nrOfSeats) {
        this.number = number;
        this.nrOfSeats = nrOfSeats;
    }
}
