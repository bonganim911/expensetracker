package com.bongz.expensetracker.service;

import com.bongz.expensetracker.model.Expense;
import com.bongz.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
}
