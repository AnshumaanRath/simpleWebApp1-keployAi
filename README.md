
# 🛍️ Simple Web App – Keploy AI API Testing & CI/CD

This is a basic **Spring Boot** application that demonstrates **CRUD operations** for products, enhanced with:

- 🔍 **Automated API Testing** using [Keploy](https://keploy.io/)
- 🚀 **CI/CD integration** via **GitHub Actions**

---

## 📌 Features

| Feature                            | Description                                               |
|------------------------------------|-----------------------------------------------------------|
| ✅ Product CRUD APIs               | Built with Spring Boot                                    |
| ✅ OpenAPI Specification           | Generated using Springdoc                                 |
| ✅ Automated API Testing           | Powered by Keploy                                         |
| ✅ CI/CD Pipeline                  | Built using GitHub Actions                                |

---

## 🧪 API Testing with Keploy

We used [Keploy](https://keploy.io) to **automatically record and test APIs** using:

- `curl` commands
- OpenAPI specification

📸 **Keploy Test Report UI:**

![Keploy Test Report](assets/keploy-test.png)

> ℹ️ Test cases and mocks are **not committed** to the repo — the results are shown via screenshot.

---

## 🔁 CI/CD Pipeline (GitHub Actions)

The project includes a CI/CD pipeline that:

1. 🔨 Builds the application using **Maven**
2. 🧪 Runs the **Keploy test suite**
3. ✅ Ensures all tests pass before deployment

📂 Workflow File: [`ci.yml`](.github/workflows/ci.yml)

---

## 📦 Running Locally

To run the project on your local machine:

```bash
mvn clean package
java -jar target/simpleWebApp1-keployAi-0.0.1-SNAPSHOT.jar
````

🌐 Access Swagger UI at:

```
http://localhost:8080/swagger-ui.html
```

---

## 🧰 Tech Stack

| Technology     | Version     |
| -------------- | ----------- |
| Java           | 17          |
| Spring Boot    | Latest      |
| Maven          | Build Tool  |
| Keploy CLI     | API Testing |
| GitHub Actions | CI/CD       |

---






Place your Keploy dashboard screenshot at:

```
![image](https://github.com/user-attachments/assets/76dfcf7a-1747-4453-9307-8c3c99664ee0)

```

---




