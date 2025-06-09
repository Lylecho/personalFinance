package com.personal.finance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class FinanceGUI {
    private JFrame frame;
    private UserService userService;
    private FinanceService financeService;
    private User currentUser;

    public FinanceGUI() {
        userService = new UserService();
        financeService = new FinanceService();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("个人财务管理系统");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        showLoginPanel();
        frame.setVisible(true);
    }

    // 登录面板
    private void showLoginPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("个人财务管理系统", JLabel.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        JLabel userLabel = new JLabel("用户名:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(userLabel, gbc);

        JTextField userText = new JTextField(15);
        gbc.gridx = 1;
        panel.add(userText, gbc);

        JLabel passwordLabel = new JLabel("密码:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passwordLabel, gbc);

        JPasswordField passwordText = new JPasswordField(15);
        gbc.gridx = 1;
        panel.add(passwordText, gbc);

        JButton loginButton = new JButton("登录");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(loginButton, gbc);

        JButton registerButton = new JButton("注册");
        gbc.gridx = 1;
        panel.add(registerButton, gbc);

        loginButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());
            currentUser = userService.login(username, password);
            if (currentUser != null) {
                showMainPanel();
            } else {
                JOptionPane.showMessageDialog(frame, "用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });

        registerButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());
            if (userService.userExists(username)) {
                JOptionPane.showMessageDialog(frame, "用户名已存在", "错误", JOptionPane.ERROR_MESSAGE);
            } else {
                userService.register(username, "", password);
                JOptionPane.showMessageDialog(frame, "注册成功", "成功", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.setContentPane(panel);
        frame.revalidate();
    }

    // 主菜单面板
    private void showMainPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel welcomeLabel = new JLabel("欢迎, " + currentUser.getUsername(), JLabel.CENTER);
        welcomeLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
        panel.add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

        JButton transactionButton = new JButton("交易记录管理");
        transactionButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        transactionButton.addActionListener(e -> showTransactionPanel());
        buttonPanel.add(transactionButton);

        JButton analysisButton = new JButton("财务分析");
        analysisButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        analysisButton.addActionListener(e -> showAnalysisPanel());
        buttonPanel.add(analysisButton);

        JButton logoutButton = new JButton("退出登录");
        logoutButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        logoutButton.addActionListener(e -> {
            currentUser = null;
            showLoginPanel();
        });
        buttonPanel.add(logoutButton);

        panel.add(buttonPanel, BorderLayout.CENTER);
        frame.setContentPane(panel);
        frame.revalidate();
    }

    // 交易记录面板
    private void showTransactionPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 输入面板
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("添加交易记录"));

        JLabel amountLabel = new JLabel("金额:");
        JTextField amountField = new JTextField();
        
        JLabel dateLabel = new JLabel("日期(YYYY-MM-DD):");
        JTextField dateField = new JTextField(LocalDate.now().toString());
        
        JLabel categoryLabel = new JLabel("分类:");
        JTextField categoryField = new JTextField();
        
        JLabel typeLabel = new JLabel("类型:");
        JComboBox<String> typeCombo = new JComboBox<>(new String[]{"收入", "支出"});
        
        JLabel descLabel = new JLabel("描述:");
        JTextField descField = new JTextField();

        inputPanel.add(amountLabel);
        inputPanel.add(amountField);
        inputPanel.add(dateLabel);
        inputPanel.add(dateField);
        inputPanel.add(categoryLabel);
        inputPanel.add(categoryField);
        inputPanel.add(typeLabel);
        inputPanel.add(typeCombo);
        inputPanel.add(descLabel);
        inputPanel.add(descField);

        // 按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JButton addButton = new JButton("添加记录");
        JButton refreshButton = new JButton("刷新数据");
        JButton backButton = new JButton("返回主菜单");
        
        buttonPanel.add(addButton);
        buttonPanel.add(refreshButton);
        buttonPanel.add(backButton);

        // 交易记录表格
        TransactionTableModel tableModel = new TransactionTableModel(financeService.getAllTransactions());
        JTable transactionTable = new JTable(tableModel);
        transactionTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(transactionTable);
        
        // 添加组件到主面板
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // 事件监听器
        addButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                LocalDate date = LocalDate.parse(dateField.getText(), java.time.format.DateTimeFormatter.ISO_LOCAL_DATE);
                String category = categoryField.getText();
                String type = typeCombo.getSelectedItem().equals("收入") ? "INCOME" : "EXPENSE";
                String description = descField.getText();

                financeService.addTransaction(amount, date, category, type, description);
                JOptionPane.showMessageDialog(frame, "交易记录添加成功", "成功", JOptionPane.INFORMATION_MESSAGE);
                
                // 清空输入并刷新表格
                amountField.setText("");
                categoryField.setText("");
                descField.setText("");
                tableModel.setTransactions(financeService.getAllTransactions());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "输入格式错误: " + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
            }
        });

        refreshButton.addActionListener(e -> {
            tableModel.setTransactions(financeService.getAllTransactions());
        });

        backButton.addActionListener(e -> showMainPanel());

        frame.setContentPane(panel);
        frame.revalidate();
    }

    // 财务分析面板
    private void showAnalysisPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 财务概览面板
        JPanel summaryPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        summaryPanel.setBorder(BorderFactory.createTitledBorder("财务概览"));

        double totalIncome = financeService.getTotalIncome();
        double totalExpense = financeService.getTotalExpense();
        double balance = financeService.getBalance();

        summaryPanel.add(new JLabel(String.format("总收入: %.2f", totalIncome)));
        summaryPanel.add(new JLabel(String.format("总支出: %.2f", totalExpense)));
        summaryPanel.add(new JLabel(String.format("当前结余: %.2f", balance)));

        // 支出分类图表
        Map<String, Double> expenseByCategory = financeService.getExpenseByCategory();
        DefaultPieDataset dataset = new DefaultPieDataset();
        expenseByCategory.forEach(dataset::setValue);

        JFreeChart chart = ChartFactory.createPieChart(
            "支出分类统计",
            dataset,
            true,
            true,
            false
        );
        chart.setBackgroundPaint(Color.WHITE);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton refreshButton = new JButton("刷新数据");
        JButton backButton = new JButton("返回主菜单");

        buttonPanel.add(refreshButton);
        buttonPanel.add(backButton);

        // 添加组件到主面板
        panel.add(summaryPanel, BorderLayout.NORTH);
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // 事件监听器
        refreshButton.addActionListener(e -> {
            Map<String, Double> newData = financeService.getExpenseByCategory();
            dataset.clear();
            newData.forEach(dataset::setValue);
        });

        backButton.addActionListener(e -> showMainPanel());

        frame.setContentPane(panel);
        frame.revalidate();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new FinanceGUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
