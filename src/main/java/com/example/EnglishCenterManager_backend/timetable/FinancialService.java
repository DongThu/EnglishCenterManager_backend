package com.example.EnglishCenterManager_backend.timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EnglishCenterManager_backend.classChild.ClassChildService;

@Service
public class FinancialService {
    
    @Autowired
    private ClassChildService classChildService;
    @Autowired
    private TimetableService timetableService;

    public double calculateTotalProfit() {
        double totalRevenue = classChildService.calculateTotalRevenue();
        double totalSalary = timetableService.calculateTotalSalary();

        return totalRevenue - totalSalary;
    }
}
