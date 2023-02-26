package com.esss.service;

import com.esss.dto.EquipmentDTO;

import java.util.List;

public interface EquipmentService {
    List<EquipmentDTO> getAllEquipment();
    List<EquipmentDTO> addEquipmentToListEquipment(List<String> equipmentNameList);
    EquipmentDTO getEquipmentById(String id);
    boolean addEquipment(EquipmentDTO equipmentDTO);
    boolean editEquipment(EquipmentDTO equipmentDTO);
    boolean removeEquipment(String id);

    List<EquipmentDTO> getAvailableEquipment();
}
