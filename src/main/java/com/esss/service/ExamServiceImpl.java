package com.esss.service;

import com.esss.converter.EquipmentConverter;
import com.esss.converter.ExamConverter;
import com.esss.converter.RoomConverter;
import com.esss.converter.UserConverter;
import com.esss.dao.ExamDAO;
import com.esss.dto.ExamDTO;
import com.esss.model.Exam;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService{
    private final ExamDAO data;
    private final ExamConverter converter;
    private final UserConverter userConverter;
    private final RoomConverter roomConverter;
    private final EquipmentConverter equipmentConverter;

    public ExamServiceImpl(ExamDAO data, ExamConverter converter, UserConverter userConverter, RoomConverter roomConverter, EquipmentConverter equipmentConverter){
        this.data = data;
        this.converter = converter;
        this.userConverter = userConverter;
        this.roomConverter = roomConverter;
        this.equipmentConverter = equipmentConverter;
    }

    @Override
    public List<ExamDTO> getAllExams(){return converter.entityToDto(data.getAllExams());}

    @Override
    public ExamDTO getExamById(String id){return converter.entityToDto(data.getExamById(id));}

    @Override
    public boolean addExam(ExamDTO examDTO){
        if (examDTO != null){
            Exam entity = converter.dtoToEntity(examDTO);
            data.createExam(entity);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean editExam(ExamDTO examDTO){
        Exam updatedExam = data.getExamById(examDTO.getId());
        if (updatedExam != null){
            if (examDTO.getName() != null){
                updatedExam.setName(examDTO.getName());
            }
            if (examDTO.getDate() != null){
                updatedExam.setDate(examDTO.getDate());
            }
            if (examDTO.getStartTime() != null){
                updatedExam.setStartTime(examDTO.getStartTime());
            }
            if(examDTO.getEndTime() != null){
                updatedExam.setEndTime(examDTO.getEndTime());
            }
            if (!examDTO.getStudents().isEmpty()){
                updatedExam.setStudents(userConverter.dtoToEntity(examDTO.getStudents()));
            }
            if (!examDTO.getStaff().isEmpty()){
                updatedExam.setStaff(userConverter.dtoToEntity(examDTO.getStaff()));
            }
            if (!examDTO.getRooms().isEmpty()){
                updatedExam.setRooms(roomConverter.dtoToEntity(examDTO.getRooms()));
            }
            if (!examDTO.getEquipment().isEmpty()){
                updatedExam.setEquipment(equipmentConverter.dtoToEntity(examDTO.getEquipment()));
            }
            data.updateExam(updatedExam);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean removeExam(String id){
        Exam exam = data.getExamById(id);
        if (exam != null){
            data.deleteExam(id);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public List<ExamDTO> getAllExamsSorted() {
        return converter.entityToDto(data.getAllExamsSorted());
    }

    @Override
    public List<ExamDTO> getAllExamsBetween(LocalDate a, LocalDate b) {
        return converter.entityToDto(data.getAllExamsBetween(a, b));
    }


    @Override
    public List<String> checkStudentAvailability(List<String> studentIds, LocalDate date, LocalTime startTime, LocalTime endTime) {
        return data.checkStudentAvailability(studentIds,date,startTime, endTime);
    }

    @Override
    public List<String> checkStaffAvailability(List<String> staffIdlist, LocalDate date, LocalTime startTime, LocalTime endTime) {
        return data.checkStaffAvailability(staffIdlist, date, startTime, endTime);
    }

    @Override
    public List<String> checkRoomAvailability(List<String> roomIds, LocalDate date, LocalTime startTime, LocalTime endTime) {
        return data.checkRoomAvailability(roomIds,date,startTime, endTime);
    }

    @Override
    public List<String> checkEquipmentAvailability(List<String> equipmentsIds, LocalDate date, LocalTime startTime, LocalTime endTime) {
        return data.checkEquipmentAvailability(equipmentsIds,date,startTime, endTime);
    }
}
