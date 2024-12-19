package com.example.SpringFinanzasPersonales.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringFinanzasPersonales.models.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
}
