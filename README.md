# 🚀 NexExam Online Portal – Java (Spring Boot)

<p align="center">
<img src="https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=java&logoColor=white" alt="Java 17">
<img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot 3.x">
<img src="https://img.shields.io/badge/JPA%20%2F%20Hibernate-red?style=for-the-badge" alt="JPA / Hibernate">
<img src="https://img.shields.io/badge/H2%20%2F%20PostgreSQL-lightgrey?style=for-the-badge" alt="H2 / PostgreSQL">
<img src="https://img.shields.io/badge/face--api.js-AI%20Proctoring-8b5cf6?style=for-the-badge" alt="AI Proctoring">
</p>

A comprehensive **NexExam Online Portal** built using **Spring Boot, Spring Security, Thymeleaf, Bootstrap 5**, and **JPA/Hibernate** — featuring a premium **3D animated glassmorphism UI**, **AI-based exam proctoring**, and **QR-verified digital result credentials**.

The platform provides a secure, cheating-resistant, and visually immersive environment for **Admins** and **Students** to manage and take online exams.

---

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
<td align="center"><img src="https://github.com/harshsnha/NexExam-Online-Portal/blob/main/uploads/D%20Exam%20manage.png" width="90%"></td>
</tr>
<tr>
<td align="center"><b>Leader Board</b></td>
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
- Live Stats Dashboard (Total Students, Exams, Questions, Submissions, Pass/Fail analytics with charts)
- **Exam CRUD** (title, duration, description)
- **Question CRUD** per exam
- Cascade deletes for exams → questions → results
- Protect answered questions from accidental delete
- Manage Students (view full academic profile, reset password, delete account with cascade cleanup)
- **Exam Analytics** — per-exam submission table with score, percentage, time taken, and QUALIFIED/FAILED status
- **Disqualification tracking** — flags and reasons visible directly in results (from AI proctoring violations)
- **Digital Credential QR Verification** — generate a scannable QR per result, linking to a public verification page
- Student Rankings / Leaderboard (overall and per-exam)

## 🧑‍🎓 Student Features
- Student Registration — Name, Age, DOB (auto-calculated age), Email, Phone, Photo, cascading **Course → Department → Specialization** dropdowns, Year of Passout
- Secure Login
- Dashboard with KPIs + Score Trend / Accuracy charts (Chart.js)
- Take Exam — paginated interface with question navigator
- **Live Timer** with auto-submit
- **AI-Powered Exam Proctoring** (face-api.js):
  - Mobile device blocking
  - Pre-exam camera check screen
  - Live pinned camera widget during the exam
  - 3-strike violation system (fullscreen exit, no-face-detected, multiple-faces-detected)
  - Auto-submit with recorded disqualification reason on 3rd strike
- Instant Results (score, percentage, pass/fail)
- Detailed Review Page — correct vs incorrect answers, visually distinguished
- Digital Certificate with QR-based public verification
- Profile Update — new profile picture, change password
- View All Previous Exam Results

## 🌐 Public Features
- **Result Verification Page** — scan a result's QR code or visit the verification link to instantly confirm a candidate's exam result and authenticity, without needing to log in

---

# 🎨 Design System
- **Fonts:** Sora (headings), DM Sans (body)
- **Theme:** Deep navy/void base with a violet → cyan gradient accent, full light/dark mode support
- **Visuals:** Three.js animated 3D background, glassmorphism cards with backdrop blur, cursor-tracked tilt-on-hover effects

---

# 🛠️ Tech Stack

| Layer | Technology |
|------|--------------------------------------------|
| Backend | Spring Boot 3, Spring Security 6 |
| Frontend | Thymeleaf, HTML, Bootstrap 5, Chart.js, Three.js |
| AI Proctoring | face-api.js |
| Database | H2 (local/dev) · PostgreSQL (production) |
| ORM | Hibernate / JPA |
| Build | Maven |
| Storage | Local File System for images |
| Deployment | Railway (PostgreSQL-backed, environment-variable driven config) |

---

# 🚀 How to Run the Project

### ✔️ Prerequisites
- Java **17+**
- Maven
- Any IDE (IntelliJ, VS Code, Eclipse)

### ✔️ Start the Application (Local / H2)
Open the project → Run:
`OnlineExamApplication.java`

By default the app uses a local file-based H2 database — no extra setup needed.

Server will start at:
👉 http://localhost:8081

---

# 🗄️ Database

### Local Development (H2)
Access H2 Console:
👉 http://localhost:8081/h2-console

### Production (PostgreSQL)
The app switches to PostgreSQL automatically when the following environment variables are set (e.g. on Railway):
