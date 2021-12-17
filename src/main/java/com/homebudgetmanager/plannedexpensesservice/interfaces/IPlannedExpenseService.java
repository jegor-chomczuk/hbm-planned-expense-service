package com.homebudgetmanager.plannedexpensesservice.interfaces;

import com.homebudgetmanager.plannedexpensesservice.dao.PlannedExpense;

import java.util.List;
import java.util.Optional;

public interface IPlannedExpenseService {
    List<PlannedExpense> filterPlannedExpenses(Long userId, int year, Optional<String> month, Optional<String> category);
    void updatePlannedExpenses(PlannedExpense plannedExpense);
}
