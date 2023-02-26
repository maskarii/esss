package com.esss.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", length = 36)
    private String id;
    @Column(name = "number", unique = true)
    private String number;
    @Column(name = "number_seats")
    private int nrOfSeats;

    public Room(String number, int nrOfSeats) {
        this.number = number;
        this.nrOfSeats = nrOfSeats;
    }
}
