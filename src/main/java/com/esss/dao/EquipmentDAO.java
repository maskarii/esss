package com.esss.dao;

import com.esss.model.Equipment;

import java.util.List;

public interface EquipmentDAO {
    List<Equipment> getAllEquipment();
    List<Equipment> addEquipmentToListEquipment(List<String> equipmentIdList);
    Equipment getEquipmentById(String id);
    Equipment getEquipmentByName(String equipmentName);
    boolean createEquipment(Equipment equipment);
    boolean updateEquipment(Equipment equipment);
    boolean deleteEquipment(String id);
    List<String> checkIfEquipmentsExistInListOfEquipments(List<String> equipmentNameList, List<Equipment> equipmentList);



    List<Equipment> getAvailableEquipment();

}
