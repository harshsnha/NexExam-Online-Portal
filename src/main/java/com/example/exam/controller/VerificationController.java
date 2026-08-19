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

    @GetMapping("/verify/{serialNumber}")
    public String verifyCertificate(@PathVariable String serialNumber, Model model) {
        try {
            // Serial Number format: NEX-YYYY-ID (e.g., NEX-2026-1001)
            String[] parts = serialNumber.split("-");
            Long id = Long.parseLong(parts[2]) - 1000; 

            ExamResult result = examResultRepository.findById(id).orElse(null);
            
            if (result != null) {
                model.addAttribute("result", result);
                model.addAttribute("status", "VERIFIED");
                
                double pct = (result.getScoreAchieved() * 100.0) / result.getTotalMarks();
                model.addAttribute("percentage", (int)pct);
                model.addAttribute("specialNumber", serialNumber);
            } else {
                model.addAttribute("status", "INVALID");
            }
        } catch (Exception e) {
            model.addAttribute("status", "INVALID");
        }
        return "public/verify_result";
    }
}