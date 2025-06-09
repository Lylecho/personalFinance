# Personal Finance Manager

一个简单而功能完整的个人财务管理系统，帮助用户追踪收入和支出，管理个人财务。

## 功能特点

- 📝 交易记录管理
  - 添加收入和支出记录
  - 记录交易日期、金额、类别和描述
  - 查看所有交易历史

- 📊 财务统计
  - 计算总收入
  - 计算总支出
  - 显示当前余额
  - 按类别统计支出

- 🎨 用户友好的图形界面
  - 直观的操作界面
  - 交易记录表格显示
  - 实时更新统计数据

## 技术架构

- 开发语言：Java
- 用户界面：Swing GUI
- 项目结构：
  ```
  src/main/java/com/personal/finance/
  ├── MainApp.java           # 应用程序入口
  ├── FinanceGUI.java        # 图形界面实现
  ├── FinanceService.java    # 业务逻辑处理
  ├── Transaction.java       # 交易数据模型
  ├── TransactionTableModel.java  # 表格数据模型
  ├── User.java             # 用户数据模型
  └── UserService.java      # 用户服务
  ```

## 快速开始

### 系统要求
- Java Runtime Environment (JRE) 8 或更高版本
- Maven（用于构建项目）

### 构建和运行

1. 克隆项目到本地：
```bash
git clone [项目地址]
```

2. 进入项目目录：
```bash
cd personalFinance
```

3. 使用Maven构建项目：
```bash
mvn clean package
```

4. 运行应用程序：
```bash
java -jar target/finance-manager-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## 核心功能说明

### 交易管理
- 通过FinanceService类处理所有交易相关操作
- 支持添加新交易记录
- 提供交易历史查询功能

### 财务统计
- 实时计算总收入和总支出
- 自动更新当前余额
- 提供按类别的支出统计

### 用户界面
- 使用Java Swing构建直观的图形界面
- 表格形式展示交易记录
- 提供便捷的数据输入表单

## 项目结构说明

### 核心类说明

1. `MainApp.java`
   - 应用程序的入口点
   - 初始化并启动图形界面

2. `FinanceGUI.java`
   - 实现图形用户界面
   - 处理用户交互
   - 显示交易记录和统计数据

3. `FinanceService.java`
   - 处理核心业务逻辑
   - 管理交易记录
   - 提供财务统计功能

4. `Transaction.java`
   - 定义交易数据模型
   - 包含交易的基本属性（金额、日期、类别等）

5. `TransactionTableModel.java`
   - 为交易记录表格提供数据模型
   - 管理表格数据的显示和更新

## 开发计划

### 已实现功能
- ✅ 基本的交易记录管理
- ✅ 收入支出统计
- ✅ 图形用户界面
- ✅ 按类别统计支出

### 计划实现功能
- 📌 数据持久化存储
- 📌 导出财务报表
- 📌 预算管理功能
- 📌 图表可视化
- 📌 多用户支持

## 贡献指南

欢迎提交问题和改进建议！如果您想为项目做出贡献，请：

1. Fork 项目
2. 创建您的特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交您的更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 打开一个 Pull Request

## 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详细信息
