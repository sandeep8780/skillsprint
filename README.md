# 📘 SkillSprint – Developer Skill Tracker API

SkillSprint is a RESTful API built using Spring Boot, Hibernate, and MySQL that helps developers track their learning progress, store notes/resources as files, and manage their skill growth efficiently.

---

## 🚀 Features

- 📚 Add, update, delete skills with learning status
- ⏱ Track hours spent per skill
- 📂 Upload and store related files (PDFs, screenshots, notes)
- 🔍 Filter skills by status (`planned`, `in-progress`, `completed`)
- 🔐 Easily extendable for JWT-based authentication
- 📄 Swagger UI for interactive API documentation

---

## 🧱 Tech Stack

| Layer        | Technology              |
|--------------|--------------------------|
| Backend      | Java 17, Spring Boot     |
| ORM          | Hibernate (JPA)          |
| Database     | MySQL                    |
| Validation   | Spring Validation        |
| File Upload  | Spring Multipart         |
| API Docs     | SpringDoc OpenAPI (Swagger UI) |
| Build Tool   | Maven                    |

---

## 📁 Project Structure

skillsprint/
├── controller/ # REST APIs
├── service/ # Business logic
├── entity/ # JPA entities
├── repository/ # Data access layer
├── dto/ # Request DTOs
├── static/uploads/ # Uploaded files
└── application.properties



---

## 🔧 Setup Instructions

 1. Clone the repo
```bash
git clone https://github.com/your-username/skillsprint.git
cd skillsprint

2. Configure MySQL

Create a database named skillsprint_db in MySQL.
spring.datasource.url=jdbc:mysql://localhost:3306/skillsprint_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
file.upload-dir=uploads/

3. Run the application
./mvnw spring-boot:run


 API Endpoints
| Method | Endpoint           | Description                        |
| ------ | ------------------ | ---------------------------------- |
| POST   | `/api/skills`      | Add new skill (with optional file) |
| GET    | `/api/skills`      | Get all skills                     |
| PUT    | `/api/skills/{id}` | Update skill details               |
| DELETE | `/api/skills/{id}` | Delete a skill                     |

📂 File Upload Example (Postman)
POST /api/skills (form-data):

data: { "skillName": "Spring Boot", "status": "in-progress", "hoursSpent": 10 } (as JSON)

file: attach a PDF or image file

 Swagger Documentation
After starting the app, open:
http://localhost:8080/swagger-ui.html

📘 License
This project is licensed under the MIT License.

✨ Author
Made with ❤️ by Sandip Prajapati
