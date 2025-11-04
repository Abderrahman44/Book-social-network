# Book Social Network

A social networking platform for book enthusiasts to connect, review, recommend, and discuss books. Built primarily in Java (backend) and HTML (frontend).

---

## Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

---

## Overview

**Book Social Network** lets users:
- Create and manage their profiles
- Add, search, and curate books
- Write and share reviews and ratings
- Follow other readers
- Engage in book-related discussions

The platform aims to foster a community of book lovers by helping them find new books and connect with like-minded readers.

---

## Architecture

The app follows a multi-tiered architecture:

### 1. Frontend (Client Layer)
- **HTML/CSS/JavaScript:** Delivers responsive, user-friendly interfaces.
- Handles display, user interactions, form submissions, and communicates with the backend via HTTP requests.

### 2. Backend (Application Layer)
- **Java :** Handles business logic, API endpoints, user authentication, authorization, data validation, and server-side rendering if needed.
- Likely uses a framework such as **Spring Boot** for RESTful APIs and service orchestration.

### 3. Database (Persistence Layer)
- **Relational Database:** (e.g., MySQL, PostgreSQL)
- Stores users, books, friendships, reviews, comments, and discussion data.
- Backend uses an ORM (likely JPA/Hibernate) to map objects to database entities.

### 4. Integration Points
- **Build tools:** Maven or Gradle for dependencies and build automation.
- **Version Control:** Managed with Git and GitHub.

#### Component Flow Example

1. User interacts with the web interface (HTML forms, buttons).
2. Browser sends an HTTP request (GET/POST/PUT/DELETE) to Java backend.
3. Backend processes the request, runs business logic, updates/queries the database, and prepares a response.
4. Frontend renders the data or updates the UI accordingly.

---

## Technologies Used

- **Java:** Core backend programming, REST APIs, and business logic.
- **HTML:** Rendering the website UI and structure.
- **Spring Boot:** (if used, based on Java conventions) For REST API and web server.
- **Hibernate/JPA:** ORM layer for database communication.
- **PostgreSQL:** Relational data storage.
- **Maven/Gradle:** Build automation and dependency management.
- **JUnit:** Automated testing framework.
- **Git & GitHub:** Version control and collaboration.

---

## Features

- **Profile Management:** User registration, login, and profile editing.
- **Book Collection:** Add, edit, search, and remove books from user collections.
- **Reviews & Ratings:** Write, edit, and read reviews and ratings for books.
- **Social Features:** Add friends, follow users, news feed.
- **Discussion Forums:** Participate in public or private book discussions.
- **Responsive Design:** Mobile and desktop browser compatibility.
- **Security:** User authentication, password encryption.

---

## Getting Started

### Prerequisites

- **Java JDK 21+**
- **Maven or Gradle**
- **MySQL/PostgreSQL** (or chosen database)
- **Web browser**

---

### Installation

1. **Clone the repo:**
   ```bash
   git clone https://github.com/Abderrahman44/Book-social-network.git
   cd Book-social-network
   ```

2. **Configure Database:**
   - Create a database (e.g., `book_social_network`).
   - Update `application.properties` or `application.yml` with your DB credentials.

3. **Build the app:**
   ```bash
   mvn clean install    # Or: gradle build
   ```

### Running the Application

- **With Spring Boot (if used):**
  ```bash
  mvn spring-boot:run
  # or
  java -jar target/book-social-network-*.jar
  ```

- **Visit in Browser:**  
  Go to `http://localhost:8080` (default port) unless otherwise configured.

---


## Contributing

1. Fork this repository
2. Create your feature branch: `git checkout -b my-feature`
3. Commit your changes: `git commit -m 'Add awesome feature'`
4. Push to the branch: `git push origin my-feature`
5. Open a [Pull Request](https://github.com/Abderrahman44/Book-social-network/pulls)

---

## License

This project is licensed under the [MIT License](LICENSE).

---

## Acknowledgements

- Made with 💙 by [Abderrahman44](https://github.com/Abderrahman44)
