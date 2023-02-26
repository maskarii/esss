package com.esss.dao;

import com.esss.model.Exam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ExamDAO {
    List<Exam> getAllExams();
    Exam getExamById(String id);
    boolean createExam(Exam exam);
    boolean updateExam(Exam exam);
    boolean deleteExam(String id);
    List<Exam> getAllExamsSorted();
    List<Exam> getAllExamsBetween(LocalDate a, LocalDate b);
    boolean crossCheckTimes(LocalTime existExStartTime, LocalTime existExEndTime, LocalTime startT, LocalTime endT);
    List<String> checkStudentAvailability(List<String> studentEmailList, LocalDate date, LocalTime startTime, LocalTime endTime);
    List<String> checkStaffAvailability(List<String> staffEmailList, LocalDate date, LocalTime startTime, LocalTime endTime);
    List<String> checkRoomAvailability(List<String> roomNumberList, LocalDate date, LocalTime startTime, LocalTime endTime);
    List<String> checkEquipmentAvailability(List<String> equipmentNameList, LocalDate date, LocalTime startTime, LocalTime endTime);
}
