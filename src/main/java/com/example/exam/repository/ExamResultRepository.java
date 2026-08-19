package com.example.exam.repository;

import com.example.exam.model.Exam;
import com.example.exam.model.ExamResult;
import com.example.exam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ExamResultRepository extends JpaRepository<ExamResult, Long> {

    List<ExamResult> findByExam(Exam exam);

    List<ExamResult> findByStudent(User student);

    List<ExamResult> findByStudentOrderBySubmissionTimeDesc(User student);

    List<ExamResult> findTop5ByOrderBySubmissionTimeDesc();

    List<ExamResult> findAllByOrderBySubmissionTimeDesc();

    @Transactional
    @Modifying
    @Query("DELETE FROM ExamResult r WHERE r.student = ?1")
    void deleteByStudent(User student);

    @Transactional
    @Modifying
    @Query("DELETE FROM ExamResult r WHERE r.student.id = ?1")
    void deleteByStudent_Id(Long studentId);
}