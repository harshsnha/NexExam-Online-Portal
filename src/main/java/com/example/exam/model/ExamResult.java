package com.example.exam.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exam_results")
public class ExamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    private int scoreAchieved;
    private int totalMarks;
    private LocalDateTime submissionTime;

    private String timeTaken;

    private boolean disqualified = false;
    private String disqualifyReason;

    @OneToMany(mappedBy = "examResult", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ExamAnswer> answers = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getStudent() { return student; }
    public void setStudent(User student) { this.student = student; }
    public Exam getExam() { return exam; }
    public void setExam(Exam exam) { this.exam = exam; }
    public int getScoreAchieved() { return scoreAchieved; }
    public void setScoreAchieved(int scoreAchieved) { this.scoreAchieved = scoreAchieved; }
    public int getTotalMarks() { return totalMarks; }
    public void setTotalMarks(int totalMarks) { this.totalMarks = totalMarks; }
    public LocalDateTime getSubmissionTime() { return submissionTime; }
    public void setSubmissionTime(LocalDateTime submissionTime) { this.submissionTime = submissionTime; }

    public String getTimeTaken() { return timeTaken; }
    public void setTimeTaken(String timeTaken) { this.timeTaken = timeTaken; }

    public boolean isDisqualified() { return disqualified; }
    public void setDisqualified(boolean disqualified) { this.disqualified = disqualified; }

    public String getDisqualifyReason() { return disqualifyReason; }
    public void setDisqualifyReason(String disqualifyReason) { this.disqualifyReason = disqualifyReason; }

    public List<ExamAnswer> getAnswers() { return answers; }
    public void setAnswers(List<ExamAnswer> answers) { this.answers = answers; }

    public void addAnswer(ExamAnswer answer) {
        answers.add(answer);
        answer.setExamResult(this);
    }
}