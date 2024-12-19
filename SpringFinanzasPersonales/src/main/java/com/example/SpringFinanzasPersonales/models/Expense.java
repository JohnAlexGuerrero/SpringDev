package com.example.SpringFinanzasPersonales.models;

import jakarta.persistence.*;

@Entity
@Table( name="expenses" )
public class Expense {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String createdAt;
    private String description;

    public Expense( ) {

    }

    public Expense(double amount, String createdAt, String description) {
        this.amount = amount;
        this.createdAt = createdAt;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
