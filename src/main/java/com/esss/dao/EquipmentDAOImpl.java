package com.esss.dao;

import com.esss.model.Equipment;
import com.esss.repository.EquipmentRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EquipmentDAOImpl implements EquipmentDAO{
    private final EquipmentRepo repo;
    public EquipmentDAOImpl(EquipmentRepo repo) {this.repo = repo;}

    @Override
    public List<Equipment> getAllEquipment() {return repo.findAll();}

    @Override
    public List<Equipment> addEquipmentToListEquipment(List<String> equipmentNameList) {
        List<Equipment> newList = new ArrayList<Equipment>();
        for(int i = 0; i < equipmentNameList.size(); i++){
            newList.add(this.getEquipmentByName(equipmentNameList.get(i)));
        }
        return newList;
    }

    @Override
    public Equipment getEquipmentById(String id) {return repo.findById(id).get();}

    @Override
    public Equipment getEquipmentByName(String equipmentName) {
        return repo.getEquipmentByName(equipmentName);
    }

    @Override
    public boolean createEquipment (Equipment equipment) {
        if (equipment != null) {
            repo.save(equipment);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateEquipment(Equipment equipment) {
        if (this.getEquipmentById(equipment.getId()) != null) {
            repo.save(equipment);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEquipment(String id) {
        if (this.getEquipmentById(id) != null) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<String> checkIfEquipmentsExistInListOfEquipments(List<String> equipmentNameList, List<Equipment> equipmentList) {
        List<String> comparinglist = new ArrayList<String>();
        if(equipmentList != null){
            for(Equipment equipment: equipmentList){
                comparinglist.add(equipment.getName());
            }
            equipmentNameList.removeAll(comparinglist);
            return equipmentNameList;
        }else {
            return equipmentNameList;
        }
    }

    @Override
    public List<Equipment> getAvailableEquipment(){
        return repo.getAllAvailableEquipment();
    }

}
