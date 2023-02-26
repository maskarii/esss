package com.esss.service;

import com.esss.converter.EquipmentConverter;
import com.esss.dao.EquipmentDAO;
import com.esss.dto.EquipmentDTO;
import com.esss.model.Equipment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService{
    private final EquipmentDAO data;
    private final EquipmentConverter equipmentConverter;

    public EquipmentServiceImpl(EquipmentDAO data, EquipmentConverter equipmentConverter) {
        this.data = data;
        this.equipmentConverter = equipmentConverter;
    }


    @Override
    public List<EquipmentDTO> getAllEquipment() {
        return equipmentConverter.entityToDto(data.getAllEquipment());
    }

    @Override
    public List<EquipmentDTO> addEquipmentToListEquipment(List<String> equipmentNameList) {
        return equipmentConverter.entityToDto(data.addEquipmentToListEquipment(equipmentNameList));
    }

    @Override
    public EquipmentDTO getEquipmentById(String id) {
        return null;
    }

    @Override
    public boolean addEquipment(EquipmentDTO equipmentDTO) {
        if (equipmentDTO != null){
            Equipment entity = equipmentConverter.dtoToEntity(equipmentDTO);
            data.createEquipment(entity);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean editEquipment(EquipmentDTO equipmentDTO) {
        if (equipmentDTO != null){
            Equipment entity = equipmentConverter.dtoToEntity(equipmentDTO);
            data.updateEquipment(entity);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean removeEquipment(String id) {
        if (id != null){
            data.deleteEquipment(id);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<EquipmentDTO> getAvailableEquipment() {
        return equipmentConverter.entityToDto(data.getAvailableEquipment());
    }
}
