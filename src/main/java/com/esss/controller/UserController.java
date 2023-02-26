package com.esss.controller;

import com.esss.dto.UserDTO;
import com.esss.examRestBody;
import com.esss.service.ExamService;
import com.esss.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;
    private final ExamService examService;
    public UserController(UserService service, ExamService examService) {
        this.service = service;
        this.examService = examService;
    }

    @GetMapping("/{role}")
    public List<UserDTO> getUsersByRole(@PathVariable("role") String role){
        return service.getUsersByRole(role);
    }

    @PostMapping("/availableSTAFFByDatenTime")
    public ResponseEntity getStaffUserGivenDatenTime(@RequestBody examRestBody exambody){
        List<String> listOfStaff = new ArrayList<String>();
        List<UserDTO> ListOfUsers = service.getUsersByRole("STAFF");
        for(UserDTO userDTO: ListOfUsers){
            listOfStaff.add(userDTO.getEmail());
        }
        List<UserDTO> staffs = service.addNewUserToListOfExistingUsers(examService.checkStaffAvailability(listOfStaff,exambody.getDate(),exambody.getStartTime(), exambody.getEndTime()));
        return new ResponseEntity(staffs, HttpStatus.OK);
    }

    @PostMapping("/availableSTUDENTByDatenTime")
    public ResponseEntity getStudentUserGivenDatenTime(@RequestBody examRestBody exambody){
        List<String> listOfStudent = new ArrayList<String>();
        List<UserDTO> ListOfUsers = service.getUsersByRole("STUDENT");
        for(UserDTO userDTO: ListOfUsers){
            listOfStudent.add(userDTO.getEmail());
        }
        List<UserDTO> staffs = service.addNewUserToListOfExistingUsers(examService.checkStudentAvailability(listOfStudent,exambody.getDate(),exambody.getStartTime(), exambody.getEndTime()));
        return new ResponseEntity(staffs, HttpStatus.OK);
    }

}