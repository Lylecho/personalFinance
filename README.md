# Personal Finance Manager

一个简单而功能完整的个人财务管理系统，帮助用户追踪收入和支出，实现高效的个人财务管理。

## 功能特点

- 📝 交易记录管理
  - 添加收入和支出记录
  - 记录交易日期、金额、类别和描述
  - 查看所有交易历史
  - 支持交易记录筛选和排序

- 📊 财务统计
  - 计算总收入和总支出
  - 显示实时更新的当前余额
  - 按类别统计支出
  - 提供月度和年度财务概览

- 🎨 用户友好的图形界面
  - 直观的操作界面
  - 交易记录表格显示
  - 实时更新统计数据
  - 响应式设计适应不同屏幕尺寸

## 技术架构

- 开发语言：Java
- 用户界面：Swing GUI
- 构建工具：Maven
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
- Windows、macOS 或 Linux 操作系统
- Java Runtime Environment (JRE) 8 或更高版本
- Maven（仅用于从源代码构建项目）

### 运行方式

#### 方式一：直接运行可执行文件（Windows）
1. 下载最新的 `PersonalFinanceManager.exe` 文件
2. 双击运行即可启动应用程序

#### 方式二：运行 JAR 文件（跨平台）
1. 确保已安装 Java 8 或更高版本
2. 下载最新的 `finance-manager-1.0-SNAPSHOT-jar-with-dependencies.jar` 文件
3. 运行命令：
```bash
java -jar finance-manager-1.0-SNAPSHOT-jar-with-dependencies.jar
```

### 从源代码构建

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

4. 构建完成后，可以找到：
   - JAR 文件：`target/finance-manager-1.0-SNAPSHOT-jar-with-dependencies.jar`
   - EXE 文件：`target/PersonalFinanceManager.exe`（仅限 Windows）

## 核心功能说明

### 交易管理
- 通过 FinanceService 类处理所有交易相关操作
- 支持添加、编辑和删除交易记录
- 提供交易历史查询和筛选功能
- 支持按日期范围、交易类型和金额查找交易

### 财务统计
- 实时计算总收入和总支出
- 自动更新当前余额和财务状况
- 提供按类别的收支统计分析
- 生成月度和年度财务摘要

### 用户界面
- 使用 Java Swing 构建现代化图形界面
- 表格形式展示交易记录，支持排序和筛选
- 提供便捷的数据输入表单和验证
- 直观的财务状况仪表板

## 项目结构说明

### 核心类说明

1. `MainApp.java`
   - 应用程序的入口点
   - 初始化系统组件和服务
   - 启动图形界面和后台服务

2. `FinanceGUI.java`
   - 实现完整的图形用户界面
   - 处理所有用户交互事件
   - 显示交易记录和实时统计数据
   - 提供表单验证和用户反馈

3. `FinanceService.java`
   - 处理核心业务逻辑和数据处理
   - 管理交易记录的增删改查
   - 提供财务统计和分析功能
   - 实现数据验证和业务规则

4. `Transaction.java`
   - 定义完整的交易数据模型
   - 包含交易的所有属性（ID、金额、日期、类别、描述等）
   - 提供数据验证和格式化方法

5. `TransactionTableModel.java`
   - 为交易记录表格提供高效的数据模型
   - 管理表格数据的显示、排序和过滤
   - 处理表格与底层数据的同步

6. `User.java` 和 `UserService.java`
   - 管理用户信息和认证
   - 支持个性化设置和偏好存储

## 应用亮点

- **易于使用**：直观的界面设计，无需复杂操作即可管理个人财务
- **实时统计**：所有财务数据实时更新，随时掌握最新财务状况
- **跨平台支持**：支持 Windows、macOS 和 Linux 系统
- **无需安装**：Windows 用户可直接运行 EXE 文件，其他平台用户可运行 JAR 文件
- **数据安全**：本地存储个人财务数据，保护隐私安全

## 开发计划

### 已实现功能
- ✅ 基本的交易记录管理
- ✅ 收入支出统计和分析
- ✅ 用户友好的图形界面
- ✅ 按类别统计支出
- ✅ Windows 可执行文件打包

### 计划实现功能
- 📌 数据持久化存储（本地数据库）
- 📌 导出财务报表（PDF、Excel）
- 📌 预算管理和提醒功能
- 📌 图表可视化财务数据
- 📌 多用户支持和数据同步
- 📌 移动端应用开发

## 贡献指南

欢迎提交问题和改进建议！如果您想为项目做出贡献，请：

1. Fork 项目
2. 创建您的特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交您的更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 打开一个 Pull Request

## 版本历史

- **1.0.0** (2024-06-09)
  - 首次发布
  - 基本交易管理功能
  - Windows EXE 文件支持

## 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详细信息

## 联系方式

如有问题或建议，请通过以下方式联系我们：
- 项目 Issues 页面
- 电子邮件：[您的邮箱]
