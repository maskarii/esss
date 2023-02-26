package com.esss.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", length = 36)
    private String id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "availability")
    private Boolean availability;

    public Equipment(String name, Boolean availability) {
        this.name = name;
        this.availability = availability;
    }
}
