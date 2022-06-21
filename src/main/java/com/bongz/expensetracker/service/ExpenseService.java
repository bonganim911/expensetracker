package com.bongz.expensetracker.service;

import com.bongz.expensetracker.model.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getExpenses();

    Expense createExpense(Expense expense);
}
