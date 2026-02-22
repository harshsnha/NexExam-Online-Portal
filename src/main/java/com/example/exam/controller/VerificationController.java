package com.example.exam.controller;

import com.example.exam.model.ExamResult;
import com.example.exam.repository.ExamResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VerificationController {

    @Autowired
    private ExamResultRepository examResultRepository;

    @GetMapping("/verify/result/{id}")
    public String verifyCertificate(@PathVariable Long id, Model model) {
        ExamResult result = examResultRepository.findById(id).orElse(null);
        if (result != null) {
            model.addAttribute("result", result);
            model.addAttribute("status", "VERIFIED");

            double pct = (result.getScoreAchieved() * 100.0) / result.getTotalMarks();
            model.addAttribute("percentage", (int)pct);


            String specialNumber = "NEX-" + result.getSubmissionTime().getYear() + "-" + (1000 + result.getId());
            model.addAttribute("specialNumber", specialNumber);
        } else {
            model.addAttribute("status", "INVALID");
        }
        return "public/verify_result";
    }
}