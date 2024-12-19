package com.example.SpringFinanzasPersonales.controller;

import com.example.SpringFinanzasPersonales.models.Expense;
import com.example.SpringFinanzasPersonales.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ( "/api/expenses/" )
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense ){
        return expenseService.createExpense( expense );
    }

    @GetMapping
    public List< Expense > getAllExpenses( ){
        return expenseService.getExpenses();
    }

    @GetMapping("/{id}")
    public ResponseEntity< Expense > getExpenseId( @PathVariable Long id){
        Optional< Expense > expense = expenseService.getExpenseById( id );
        return expense.map(ResponseEntity::ok).orElseGet( ( ) -> ResponseEntity.notFound().build());
    }

    @PutMapping( "/{id}" )
    public ResponseEntity< Expense > updateExpense( @PathVariable Long id, @RequestBody Expense expense ){
        return ResponseEntity.ok( expenseService.updateExpense( id, expense ) );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity< Void > deleteExpense( @PathVariable Long id ){
        expenseService.deleteExpense( id );
        return ResponseEntity.noContent().build();
    }
}
