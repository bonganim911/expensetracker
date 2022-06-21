package com.bongz.expensetracker.controller;

import com.bongz.expensetracker.model.Expense;
import com.bongz.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class expenseController {

    @Autowired
    private ExpenseService expenseService;
    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(){
        return expenseService.getExpenses();
    }

    @PostMapping("/expenses")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Expense createExpense(@RequestBody Expense expense){
        return expenseService.createExpense(expense);
    }

    @GetMapping("/expenses/{id}")
    public Expense getAnExpenseById(@PathVariable Long id){
        return expenseService.getExpenseById(id);
    }
    @PutMapping("/expenses/{id}")
    public Expense updateExpense(@RequestBody Expense expense, @PathVariable Long id){
        return expenseService.updateAnExpense(expense, id);
    }

    @DeleteMapping("/expenses/{id}")
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
    }
}
