package com.example.EnglishCenterManager_backend.timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/financial")
public class FinancialResource {
   
    @Autowired
    private FinancialService financialService;

    @GetMapping("/total-profit")
    public ResponseEntity<Double> calculateTotalProfit() {
        double totalProfit = financialService.calculateTotalProfit();
        return ResponseEntity.ok(totalProfit);
    }
}
