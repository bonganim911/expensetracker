package com.bongz.expensetracker.service;

import com.bongz.expensetracker.model.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {
    Page<Expense> getExpenses(Pageable page);

    Expense createExpense(Expense expense);

    void deleteExpense(Long id);

    Expense updateAnExpense(Expense expense, Long id);

    Expense getExpenseById(Long id);
}
