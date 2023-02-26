package com.esss.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDTO {
    private String id;
    private String name;
    private Boolean availability;

    public EquipmentDTO(String name, Boolean availability) {
        this.name = name;
        this.availability = availability;
    }
}
