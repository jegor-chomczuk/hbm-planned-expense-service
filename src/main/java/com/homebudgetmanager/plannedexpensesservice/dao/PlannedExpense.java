package com.homebudgetmanager.plannedexpensesservice.dao;

import com.homebudgetmanager.plannedexpensesservice.enums.Month;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PlannedExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private Double amount;
    private Month month;
    private int year;
    @Column(name="user_id")
    private Long userId;

    public PlannedExpense(String category, Double amount, Month month, int year, Long userId) {
        this.category = category;
        this.amount = amount;
        this.month = month;
        this.year = year;
        this.userId = userId;
    }
}
