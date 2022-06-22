package com.bongz.expensetracker.service;

import com.bongz.expensetracker.model.Expense;
import com.bongz.expensetracker.repository.ExpenseRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Page<Expense> getExpenses(Pageable page) {
        return expenseRepository.findAll(page);
    }

    @Override
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public Expense updateAnExpense(Expense expense, Long id) {
       Expense existingExpense = getExpenseById(id);
       existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());
       existingExpense.setDescription(
               expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());
       existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());
       existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());
       return expenseRepository.save(existingExpense);
    }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense =  expenseRepository.findById(id);
        if(expense.isPresent()){
            return expense.get();
        }
        else{
            throw new RuntimeException("No expense found for id: " + id);
        }
    }
}
