package com.esss.service;

import com.esss.dto.ExamDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ExamService {
    List<ExamDTO> getAllExams();
    ExamDTO getExamById(String id);
    boolean addExam(ExamDTO examDTO);
    boolean editExam(ExamDTO examDTO);
    boolean removeExam(String id);
    List<ExamDTO> getAllExamsSorted();
    List<ExamDTO> getAllExamsBetween(LocalDate a, LocalDate b);
    List<String> checkStudentAvailability(List<String> studentIds, LocalDate date, LocalTime startTime, LocalTime endTime);
    List<String> checkStaffAvailability(List<String> staffIdlist, LocalDate date, LocalTime startTime, LocalTime endTime);
    List<String> checkRoomAvailability(List<String> roomIds, LocalDate date, LocalTime startTime, LocalTime endTime);
    List<String> checkEquipmentAvailability(List<String> equipmentsIds, LocalDate date, LocalTime startTime, LocalTime endTime);
}
