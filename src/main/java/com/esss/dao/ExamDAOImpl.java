package com.esss.dao;

import com.esss.model.Exam;
import com.esss.repository.ExamRepo;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.ArrayList;


@Repository
public class ExamDAOImpl implements ExamDAO{

    private final ExamRepo repo;
    private final UserDAO userDAO;
    private final RoomDAO roomDAO;
    private final EquipmentDAO equipmentDAO;
    public ExamDAOImpl(ExamRepo repo, UserDAO userDAO, RoomDAO roomDAO, EquipmentDAO equipmentDAO) {this.repo = repo;
        this.userDAO = userDAO;
        this.roomDAO = roomDAO;
        this.equipmentDAO = equipmentDAO;
    }

    @Override
    public List<Exam> getAllExams() {return repo.findAll();}

    @Override
    public Exam getExamById(String id) {return repo.findById(id).get();}

    @Override
    public boolean createExam(Exam exam) {
        if (exam != null) {
            repo.save(exam);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateExam(Exam exam) {
        if (this.getExamById(exam.getId()) != null) {
            repo.save(exam);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteExam(String id) {
        if (this.getExamById(id) != null) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<String> checkStudentAvailability(List<String> studentEmailList, LocalDate date, LocalTime startTime, LocalTime endTime) {
        List<Exam> examsGivenDate = repo.getExamByDate(date);
        List<String> finalList = new ArrayList<String>();

        if(examsGivenDate != null){
            for(Exam exam: examsGivenDate){
                if(this.crossCheckTimes(exam.getStartTime(), exam.getEndTime(), startTime, endTime)){
                    List<String> checkList = userDAO.checkIfUsersExistInListOfUsers(studentEmailList, exam.getStudents());
                    if(!checkList.isEmpty()){
                        for(int i = 0; i < checkList.size(); i++){
                            if(studentEmailList.get(i) != checkList.get(i)){
                                finalList.add(checkList.get(i));
                            }
                        }
                    }
                }
            }
            if(!finalList.isEmpty()){
                return finalList;
            }else{
                return studentEmailList;
            }
        }else{
            return studentEmailList;
        }
    }

    @Override
    public List<String> checkStaffAvailability(List<String> staffEmailList, LocalDate date, LocalTime startTime, LocalTime endTime) {
        List<Exam> examsGivenDate = repo.getExamByDate(date);
        List<String> finalList = new ArrayList<String>();

        if(examsGivenDate != null){
            for(Exam exam: examsGivenDate){
                if(this.crossCheckTimes(exam.getStartTime(), exam.getEndTime(), startTime, endTime)){
                    List<String> checkList = userDAO.checkIfUsersExistInListOfUsers(staffEmailList, exam.getStaff());
                    if(!checkList.isEmpty()){
                        for(int i = 0; i < checkList.size(); i++){
                            if(staffEmailList.get(i) != checkList.get(i)){
                                finalList.add(checkList.get(i));
                            }
                        }
                    }
                }
            }
            if(!finalList.isEmpty()){
                return finalList;
            }else{
                return staffEmailList;
            }
        }else{
            return staffEmailList;
        }
    }

    @Override
    public List<String> checkRoomAvailability(List<String> roomNumberList, LocalDate date, LocalTime startTime, LocalTime endTime) {
        List<Exam> examsGivenDate = repo.getExamByDate(date);
        List<String> finalList = new ArrayList<String>();

        if(examsGivenDate != null){
            for(Exam exam: examsGivenDate){
                if(this.crossCheckTimes(exam.getStartTime(), exam.getEndTime(), startTime, endTime)){
                    List<String> checkList = roomDAO.checkIfRoomsExistInListOfRooms(roomNumberList, exam.getRooms());
                    if(!checkList.isEmpty()){
                        for(int i = 0; i < checkList.size(); i++){
                            if(roomNumberList.get(i) != checkList.get(i)){
                                finalList.add(checkList.get(i));
                            }
                        }
                    }
                }
            }
            if(!finalList.isEmpty()){
                return finalList;
            }else{
                return roomNumberList;
            }
        }else{
            return roomNumberList;
        }
    }

    @Override
    public List<String> checkEquipmentAvailability(List<String> equipmentNameList, LocalDate date, LocalTime startTime, LocalTime endTime) {
        List<Exam> examsGivenDate = repo.getExamByDate(date);
        List<String> finalList = new ArrayList<String>();

        if(examsGivenDate != null){
            for(Exam exam: examsGivenDate){
                if(this.crossCheckTimes(exam.getStartTime(), exam.getEndTime(), startTime, endTime)){
                    List<String> checkList = equipmentDAO.checkIfEquipmentsExistInListOfEquipments(equipmentNameList, exam.getEquipment());
                    if(!checkList.isEmpty()){
                        for(int i = 0; i < checkList.size(); i++){
                            if(equipmentNameList.get(i) != checkList.get(i)){
                                finalList.add(checkList.get(i));
                            }
                        }
                    }
                }
            }
            if(!finalList.isEmpty()){
                return finalList;
            }else{
                return equipmentNameList;
            }
        }else{
            return equipmentNameList;
        }
    }

    @Override
    public List<Exam> getAllExamsSorted() { return repo.getAllExamsSorted(); }

    @Override
    public List<Exam> getAllExamsBetween(LocalDate a, LocalDate b){
        return repo.getAllExamsBetweem(a, b);
    }

    @Override
    public boolean crossCheckTimes(LocalTime existExStartTime, LocalTime existExEndTime, LocalTime startT, LocalTime endT) {
        if((LocalTime.parse(startT.toString()+":00").isAfter(LocalTime.parse(existExStartTime.toString()+":00")) && LocalTime.parse(startT.toString()+":00").isBefore(LocalTime.parse(existExEndTime.toString()+":00"))) ||
                (LocalTime.parse(endT.toString()+":00").isAfter(LocalTime.parse(existExStartTime.toString()+":00")) && LocalTime.parse(endT.toString()+":00").isBefore(LocalTime.parse(existExEndTime.toString()+":00")))){
            return true;
        }else if(Objects.equals(existExEndTime,startT) || Objects.equals(existExEndTime,endT) ||
                Objects.equals(existExStartTime,startT) || Objects.equals(existExStartTime,endT)){
            return true;
        } else{
            return false;
        }
    }
}
