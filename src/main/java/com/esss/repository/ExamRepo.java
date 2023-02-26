package com.esss.repository;

import com.esss.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ExamRepo extends JpaRepository<Exam, String> {
    @Query("SELECT e FROM Exam e WHERE e.date =?1 AND e.startTime =?2")
    List<Exam> getExamByDateNTime(LocalDate date, LocalTime time);

    @Query("SELECT e FROM Exam e WHERE e.date =?1")
    List<Exam> getExamByDate(LocalDate date);

    @Query("SELECT exam FROM Exam exam ORDER BY exam.date ASC ")
    List<Exam> getAllExamsSorted();

    @Query("SELECT exam FROM Exam exam WHERE exam.date >= :a AND exam.date <= :b")
    List<Exam> getAllExamsBetweem(LocalDate a, LocalDate b);

}
