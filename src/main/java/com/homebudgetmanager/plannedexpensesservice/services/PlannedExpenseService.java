package com.homebudgetmanager.plannedexpensesservice.services;

import com.homebudgetmanager.plannedexpensesservice.dao.PlannedExpense;
import com.homebudgetmanager.plannedexpensesservice.enums.Month;
import com.homebudgetmanager.plannedexpensesservice.interfaces.IPlannedExpenseService;
import com.homebudgetmanager.plannedexpensesservice.repository.PlannedExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PlannedExpenseService implements IPlannedExpenseService {
    @Autowired
    private PlannedExpenseRepository plannedExpenseRepository;

    public List<PlannedExpense> filterPlannedExpenses(Long userId, int year, Optional<String> month, Optional<String> category){

        if (month.isPresent() && category.isPresent()){
            return plannedExpenseRepository.findByUserIdAndMonthAndCategoryAndYear(userId, Month.valueOf(month.get().toUpperCase()), category.get(), year);
        } else if (!month.isPresent() && category.isPresent()){
            return plannedExpenseRepository.findByUserIdAndCategoryAndYear(userId,category.get(), year);
        } else if (month.isPresent() && !category.isPresent()) {
            return plannedExpenseRepository.findByUserIdAndMonthAndYear(userId, Month.valueOf(month.get().toUpperCase()), year);
        } else {
            return plannedExpenseRepository.findByUserIdAndYear(userId, year);
        }
    }

    public void updatePlannedExpenses(PlannedExpense plannedExpense){
        Optional<PlannedExpense> storedPlannedExpense = plannedExpenseRepository.findById(plannedExpense.getId());
        if (storedPlannedExpense.isPresent()) {
            storedPlannedExpense.get().setCategory(plannedExpense.getCategory());
            storedPlannedExpense.get().setAmount(plannedExpense.getAmount());

            plannedExpenseRepository.save(storedPlannedExpense.get());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no expense with provided id.");
        }
    }
}
