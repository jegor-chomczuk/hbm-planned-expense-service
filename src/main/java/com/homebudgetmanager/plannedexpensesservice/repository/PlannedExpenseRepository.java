package com.homebudgetmanager.plannedexpensesservice.repository;

import com.homebudgetmanager.plannedexpensesservice.dao.PlannedExpense;
import com.homebudgetmanager.plannedexpensesservice.enums.Month;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlannedExpenseRepository extends JpaRepository<PlannedExpense, Long> {
    void deleteByUserId(Long id);
    void deleteByCategory(String category);
    List<PlannedExpense> findByUserIdAndMonthAndCategoryAndYear(Long userId, Month month, String category, int year);
    List<PlannedExpense> findByUserIdAndCategoryAndYear(Long userId, String category, int year);
    List<PlannedExpense> findByUserIdAndMonthAndYear(Long userId, Month month, int year);
    List<PlannedExpense> findByUserIdAndYear(Long userId, int year);
}
