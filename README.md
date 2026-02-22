# 🚀 NexExam Online Portal – Java (Spring Boot)

<p align="center">
<img src="https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=java&logoColor=white" alt="Java 17">
<img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot 3.x">
<img src="https://img.shields.io/badge/JPA%20%2F%20Hibernate-red?style=for-the-badge" alt="JPA / Hibernate">
<img src="https://img.shields.io/badge/H2%20Database-lightgrey?style=for-the-badge" alt="H2 Database">
</p>

A comprehensive **NexExam Online Portal** built using **Spring Boot, Spring Security, Thymeleaf, Bootstrap 5**, and **JPA/Hibernate**.  
The platform provides a secure and user-friendly environment for **Admins** and **Students** to manage and take online tests effectively.

# 📸 Screenshots


<table width="100%">


<tr>
<td align="center"><b>Exam Main Page (with Pagination)</b></td>
</tr>
<tr>
<td align="center"><img src="https://github.com/harshsnha/NexExam-Online-Portal/blob/main/uploads/Main.png" width="90%"></td>
</tr>

<tr>
<td align="center"><b>Admin Dashboard</b></td>
</tr>
<tr>
<td align="center"><img src="https://github.com/harshsnha/NexExam-Online-Portal/blob/main/uploads/Admin.png"></td>
</tr>

<tr>
<td align="center"><b>Manage Exam</b></td>
</tr>
<tr>
<td align="center"><img src="https://github.com/harshsnha/NexExam-Online-Portal/blob/main/uploads/Exam manage.png" width="90%"></td>
</tr>

<tr>
<td align="center"><b>Manage Students</b></td>
</tr>
<tr>
<td align="center"><img src="https://github.com/harshsnha/NexExam-Online-Portal/blob/main/uploads/C%20Student%20manage.png" width="90%"></td>
</tr>
</table>

<tr>
<td align="center"><b>Students Portal</b></td>
</tr>
<tr>
<td align="center"><img src="https://github.com/harshsnha/NexExam-Online-Portal/blob/main/uploads/F%20Student%20Potal.png" width="90%"></td>
</tr>
</table>

---

# ✨ Features

## 👨‍💻 Admin Features
- Secure Admin Login
- Stats Dashboard (Total Students, Exams, Questions, Submissions)
- **Exam CRUD** (title, duration, description)
- **Question CRUD** per exam
- Cascade deletes for exams → questions → results
- Protect answered questions from accidental delete
- Manage Students
- Reset Student Password
- Delete Student Account (cascade all related data)
- View all submissions for any exam

---

## 🧑‍🎓 Student Features
- Student Registration (Full Name, Email, Mobile, Profile Picture)
- Secure Login
- Dashboard with KPIs + Performance Chart
- Take Exam (paginated interface + question palette)
- Live Timer (auto submit)
- Instant Results (score, percentage, pass/fail)
- Detailed Review Page (correct vs incorrect answers)
- Profile Update
- Upload New Profile Picture
- Change Password
- View All Previous Exam Results

---

# 🛠️ Tech Stack

| Layer | Technology                                 |
|------|--------------------------------------------|
| Backend | Spring Boot 3, Spring Security 6           |
| Frontend | Thymeleaf, Html, Bootstrap 5, Chart.js     |
| Database | H2 (file-based) (configurable to other DB) |
| ORM | Hibernate / JPA                            |
| Build | Maven                                      |
| Storage | Local File System for images               |

---

# 🚀 How to Run the Project

### ✔️ Prerequisites
- Java **17+**
- Maven
- Any IDE (IntelliJ, VS Code, Eclipse)

---


---

### ✔️ Start the Application

Open the project → Run:

`OnlineExamApplication.java`

Server will start at:

👉 http://localhost:8081

---

# 🗄️ Database (H2)

Access H2 Console:

👉 http://localhost:8081/h2-console

