package com.esss.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
@Data
@NoArgsConstructor
@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", length = 36)
    private String id;
    @Column(name = "seatNum", unique = true)
    private String seatNum;
    @OneToOne
    private User asStudent;

    public Seat(String seatNum, User asStudent) {
        this.seatNum = seatNum;
        this.asStudent = asStudent;
    }
}
