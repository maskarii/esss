package com.esss.controller;

import com.esss.dto.ExamDTO;
import com.esss.examRestBody;
import com.esss.service.EquipmentService;
import com.esss.service.ExamService;
import com.esss.service.RoomService;
import com.esss.service.UserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/exams")
public class ExamController {
    private final ExamService service;
    private final UserService userService;
    private final RoomService roomService;
    private final UserController userController;
    private final EquipmentService equipmentService;
    public ExamController(ExamService service, UserService userService, RoomService roomService, UserController userController, EquipmentService equipmentService){
        this.service = service;
        this.userService = userService;
        this.roomService = roomService;
        this.userController = userController;
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public ResponseEntity<List<ExamDTO>> getAllExams(){
        List<ExamDTO> allUsers = service.getAllExams();
        if (allUsers != null){
            return ResponseEntity.ok().body(allUsers);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/sorted")
    public List<ExamDTO> getAllExamsSorted(){
        return service.getAllExamsSorted();
    }

    @GetMapping("/{dateA}/{dateB}")
    public List<ExamDTO> getAllExamsBetween(@PathVariable("dateA") @DateTimeFormat(pattern = "MM/DD/YY") LocalDate a, @PathVariable("dateB")  @DateTimeFormat(pattern = "MM/DD/YY") LocalDate b) {
        return service.getAllExamsBetween(a,b);
    }


    @GetMapping("{id}")
    public ResponseEntity<ExamDTO> getExamById(@PathVariable(value = "id") String id){
        ExamDTO examDTO = service.getExamById(id);
        if (examDTO != null){
            return ResponseEntity.ok().body(examDTO);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExamDTO> createExam(@RequestBody examRestBody exambody){

        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
        System.out.println(exambody.getStudentid());
        System.out.println(exambody.getEquipmentid());
        System.out.println(exambody.getRoomid());
        System.out.println(exambody.getStaffid());
        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
        ExamDTO examDTO = new ExamDTO();
        examDTO.setStartTime(exambody.getStartTime());
        examDTO.setEndTime(exambody.getEndTime());
        examDTO.setName(exambody.getName());
        examDTO.setDate(exambody.getDate());
        examDTO.setEquipment(equipmentService.addEquipmentToListEquipment(exambody.getEquipmentid()));
        examDTO.setRooms(roomService.addRoomToListRoom(exambody.getRoomid()));

        examDTO.setStaff(userService.addNewUserToListOfExistingUsers(exambody.getStaffid()));
        examDTO.setStudents(userService.addNewUserToListOfExistingUsers(exambody.getStudentid()));

        if (service.addExam(examDTO)){
            return ResponseEntity.ok().body(examDTO);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExamDTO> updateExam(@RequestBody examRestBody exambody){
//        ObjectMapper o = new ObjectMapper();
//        String n = o.writeValueAsString(exambody.g)
        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
        System.out.println(exambody.getStudentid());
        System.out.println(exambody.getEquipmentid());
        System.out.println(exambody.getRoomid());
        System.out.println(exambody.getStaffid());
        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");

        ExamDTO examDTO = new ExamDTO();
        examDTO.setId(exambody.getId());
        examDTO.setName(exambody.getName());
        examDTO.setEquipment(equipmentService.addEquipmentToListEquipment(exambody.getEquipmentid()));
        examDTO.setRooms(roomService.addRoomToListRoom(exambody.getRoomid()));
        examDTO.setStaff(userService.addNewUserToListOfExistingUsers(exambody.getStaffid()));
        examDTO.setStudents(userService.addNewUserToListOfExistingUsers(exambody.getStudentid()));
        if (service.editExam(examDTO)){
            return ResponseEntity.ok().body(examDTO);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ExamDTO> deleteExam(@PathVariable(name = "id") String id){
        if (service.removeExam(id)){
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}

