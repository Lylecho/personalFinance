package com.personal.finance;

import javax.swing.table.AbstractTableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TransactionTableModel extends AbstractTableModel {
    private List<Transaction> transactions;
    private final String[] columnNames = {"日期", "类型", "分类", "金额", "描述"};
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public TransactionTableModel(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return transactions.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Transaction transaction = transactions.get(rowIndex);
        switch (columnIndex) {
            case 0: return transaction.getDate().format(dateFormatter);
            case 1: return transaction.getType().equals("INCOME") ? "收入" : "支出";
            case 2: return transaction.getCategory();
            case 3: return transaction.getAmount();
            case 4: return transaction.getDescription();
            default: return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 3: return Double.class;
            default: return String.class;
        }
    }
}
