package com.homebudgetmanager.plannedexpensesservice.controller;

import com.homebudgetmanager.plannedexpensesservice.dao.PlannedExpense;
import com.homebudgetmanager.plannedexpensesservice.interfaces.IPlannedExpenseService;
import com.homebudgetmanager.plannedexpensesservice.repository.PlannedExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*")
//@Transactional
@RestController
@RequestMapping("/planned-expense/")
public class PlannedExpenseController {
    @Autowired
    private PlannedExpenseRepository plannedExpenseRepository;

    @Autowired
    private IPlannedExpenseService plannedExpenseService;

    // GET Methods
    //  http://localhost:8400/planned-expense/all
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<PlannedExpense> getAllPlannedExpenses() {
        return plannedExpenseRepository.findAll();
    }

    //  http://localhost:8400/planned-expense/id/1
    @GetMapping("id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PlannedExpense> getPlannedExpenseById(@PathVariable Long id) {
        return plannedExpenseRepository.findById(id);
    }

    //  http://localhost:8400/planned-expense/user-id/1/year/2021
    //  http://localhost:8400/planned-expense/user-id/1/year/2021/?month=january
    //  http://localhost:8400/planned-expense/user-id/1/year/2021/?category=Debt repayment
    //  http://localhost:8400/planned-expense/user-id/1/year/2021/?month=january&category=Debt repayment
    @GetMapping("user-id/{userId}/year/{year}")
    @ResponseStatus(HttpStatus.OK)
    public List<PlannedExpense> getFilteredPlannedExpenses(@PathVariable Long userId, @PathVariable int year, @RequestParam Optional<String> month, @RequestParam Optional<String> category) {
        return plannedExpenseService.filterPlannedExpenses(userId, year, month, category);
    }

    //  DELETE Methods
    //  http://localhost:8400/planned-expense/delete/id/1
    @DeleteMapping("delete/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlannedExpenseById(@PathVariable Long id){
        plannedExpenseRepository.deleteById(id);
    }

    //  http://localhost:8400/planned-expense/delete/user-id/1
    @DeleteMapping("delete/user-id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlannedExpenseByUserId(@PathVariable Long id){
        plannedExpenseRepository.deleteByUserId(id);
    }

    //  http://localhost:8400/planned-expense/delete/category/Debt repayment
    @DeleteMapping("delete/category/{category}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlannedExpensesByCategory(@PathVariable String category){
        plannedExpenseRepository.deleteByCategory(category);
    }

    //  POST Method
    //  http://localhost:8400/planned-expense/add
    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPlannedExpense(@RequestBody PlannedExpense plannedExpense){
        plannedExpenseRepository.save(plannedExpense);
    }

    //  PUT Method
    //  http://localhost:8400/planned-expense/update/id/1
    @PutMapping("update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePlannedExpense(@RequestBody PlannedExpense plannedExpense){
        plannedExpenseService.updatePlannedExpenses(plannedExpense);
    }
}
