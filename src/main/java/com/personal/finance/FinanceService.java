package com.personal.finance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinanceService {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(double amount, LocalDate date, String category, String type, String description) {
        transactions.add(new Transaction(amount, date, category, type, description));
    }

    public double getTotalIncome() {
        return transactions.stream()
                .filter(t -> "INCOME".equals(t.getType()))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double getTotalExpense() {
        return transactions.stream()
                .filter(t -> "EXPENSE".equals(t.getType()))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double getBalance() {
        return getTotalIncome() - getTotalExpense();
    }

    public Map<String, Double> getExpenseByCategory() {
        Map<String, Double> result = new HashMap<>();
        transactions.stream()
                .filter(t -> "EXPENSE".equals(t.getType()))
                .forEach(t -> result.merge(t.getCategory(), t.getAmount(), Double::sum));
        return result;
    }

    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }
}
