package com.bongz.expensetracker.service;

import com.bongz.expensetracker.model.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {
    List<Expense> getExpenses();

    Expense createExpense(Expense expense);

    void deleteExpense(Long id);

    Expense updateAnExpense(Expense expense, Long id);

    Expense getExpenseById(Long id);
}
