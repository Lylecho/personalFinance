package com.personal.finance;

import java.time.LocalDate;

public class Transaction {
    private double amount;
    private LocalDate date;
    private String category;
    private String type; // "INCOME" or "EXPENSE"
    private String description;

    public Transaction(double amount, LocalDate date, String category, String type, String description) {
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.type = type;
        this.description = description;
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
