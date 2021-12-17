package com.homebudgetmanager.plannedexpensesservice;

import com.homebudgetmanager.plannedexpensesservice.dao.PlannedExpense;
import com.homebudgetmanager.plannedexpensesservice.enums.Month;
import com.homebudgetmanager.plannedexpensesservice.repository.PlannedExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Data {
    @Autowired
    private PlannedExpenseRepository plannedExpenseRepository;

    public void populate() {
//        plannedExpenseRepository.save(new PlannedExpense("Debt repayment", 10.00, Month.JANUARY, 2021, 1l));
//        plannedExpenseRepository.save(new PlannedExpense("Debt repayment", 11.00, Month.MARCH, 2021, 1l));
//        plannedExpenseRepository.save(new PlannedExpense("Savings", 12.00, Month.JANUARY, 2021, 1l));
//        plannedExpenseRepository.save(new PlannedExpense("Debt repayment", 13.00, Month.JANUARY, 2022, 2l));
//        plannedExpenseRepository.save(new PlannedExpense("Food", 14.00, Month.FEBRUARY, 2021, 1l));
//        plannedExpenseRepository.save(new PlannedExpense("Apartment / house", 15.00, Month.FEBRUARY, 2021, 1l));
//        plannedExpenseRepository.save(new PlannedExpense("Savings", 16.00, Month.FEBRUARY, 2022, 2l));
    }
}
