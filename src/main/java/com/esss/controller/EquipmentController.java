package com.esss.controller;

import com.esss.dto.EquipmentDTO;
import com.esss.examRestBody;
import com.esss.service.EquipmentService;
import com.esss.service.ExamService;
import com.esss.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    private final EquipmentService service;
    private final ExamService examService;
    private final UserService userService;

    public EquipmentController(EquipmentService service, ExamService examService, UserService userService) {
        this.service = service;
        this.examService = examService;
        this.userService = userService;
    }
    @GetMapping
    public List<EquipmentDTO> getAllEquipment(){
        return service.getAllEquipment();
    }

    @GetMapping("/available")
    public List<EquipmentDTO> getAvailableEquipment(){
        return service.getAvailableEquipment();
    }

    @PostMapping("/availableEquipmentsByDatenTime")
    public ResponseEntity viewAvailableEquipmentByDatenTime(@RequestBody examRestBody exambody){
        List<String> listOfEquipment = new ArrayList<String>();
        for(EquipmentDTO equipmentDTO: this.getAvailableEquipment()){
            listOfEquipment.add(equipmentDTO.getName());
        }
        List<EquipmentDTO> equipments = service.addEquipmentToListEquipment(examService.checkEquipmentAvailability(listOfEquipment,exambody.getDate(),exambody.getStartTime(), exambody.getEndTime()));
        return new ResponseEntity(equipments, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createEquipment(@RequestBody EquipmentDTO equipmentDTO){
        if(service.addEquipment(equipmentDTO)){
            return ResponseEntity.ok().body(equipmentDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteEquipment(@PathVariable(name = "id") String id){
        if(service.removeEquipment(id)){
            return ResponseEntity.ok().body(id);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/edit")
    public ResponseEntity editEquipment(@RequestBody EquipmentDTO equipmentDTO){
        if(service.editEquipment(equipmentDTO)){
            return ResponseEntity.ok().body(equipmentDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}