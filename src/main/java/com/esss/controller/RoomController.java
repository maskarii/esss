package com.esss.controller;

import com.esss.dto.RoomDTO;
import com.esss.examRestBody;
import com.esss.service.ExamService;
import com.esss.service.RoomService;
import com.esss.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Room")
public class RoomController {
    private final RoomService service;
    private final ExamService examService;
    private final UserService userService;

    private RoomController(RoomService service, ExamService examService, UserService userService){
        this.service = service;
        this.examService = examService;
        this.userService = userService;
    }

    @GetMapping("/rooms")
    public List<RoomDTO> getAllRooms(){
        return service.getAllRooms();
    }

    @PostMapping("/availableByDatenTime")
    public ResponseEntity viewAvailableRoomByDatenTime(@RequestBody examRestBody exambody){
        List<String> listOfRoom = new ArrayList<String>();
        for(RoomDTO roomDTO: this.getAllRooms()){
            listOfRoom.add(roomDTO.getNumber());
        }
        List<RoomDTO> rooms = service.addRoomToListRoom(examService.checkRoomAvailability(listOfRoom, exambody.getDate(),exambody.getStartTime(), exambody.getEndTime()));
        return new ResponseEntity(rooms, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createRoom(@RequestBody RoomDTO roomDTO){
        if(service.addRoom(roomDTO)){
            return ResponseEntity.ok().body(roomDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteRoom(@PathVariable(name = "id") String id){
        if(service.removeRoom(id)){
            return ResponseEntity.ok().body(id);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/edit")
    public ResponseEntity editRoom(@RequestBody RoomDTO roomDTO){
        if(service.editRoom(roomDTO)){
            return ResponseEntity.ok().body(roomDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
