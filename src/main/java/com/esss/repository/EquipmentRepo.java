package com.esss.repository;

import com.esss.model.Equipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepo extends JpaRepository<Equipment, String> {
    @Query("SELECT eq from Equipment eq WHERE eq.availability = true")
    List<Equipment> getAllAvailableEquipment();

    @Query("SELECT eq FROM Equipment eq WHERE eq.name = ?1")
    Equipment getEquipmentByName(String equipmentName);

}
