package com.example.SpringFinanzasPersonales.service;

import com.example.SpringFinanzasPersonales.DAO.ExpenseRepository;
import com.example.SpringFinanzasPersonales.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense createExpense( Expense expense ){
        return expenseRepository.save( expense );
    }

    public Optional< Expense > getExpenseById( Long id ){
        return expenseRepository.findById(id);
    }

    public List< Expense > getExpenses( ){
        return expenseRepository.findAll();
    }

    public Expense updateExpense( Long id, Expense expenseDetails ){
        Expense expense = expenseRepository.findById( id ).orElseThrow();
        expense.setAmount( expenseDetails.getAmount() );
        expense.setDescription( expenseDetails.getDescription() );
        return expenseRepository.save(expense);
    }

    public void deleteExpense( Long id ){
        expenseRepository.deleteById( id );
    }
}
