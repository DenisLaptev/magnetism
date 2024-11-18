# Magnetism

## Overview
**Magnetism** is an application designed to manage and streamline scientific calculations. It provides user-friendly tools for assigning, tracking, and managing scientific tasks within a system that supports role-based user access. The application includes features for authentication, authorization, and task management, making it ideal for collaborative scientific workflows.

---

## Features
- **Role-based Access Control**: 
  - Users have different roles, granting varying levels of access and authority.
- **Task Management**:
  - Assign tasks to users, view task lists, and track progress.
  - Sort and filter tasks by field values for efficient management.
- **User Management**:
  - View user lists, roles, and permissions within the system.
- **Authentication and Authorization**:
  - Secure login and access control via **Spring Security**.
- **Data Persistence**:
  - Primary database: PostgreSQL.
  - In-memory database for testing: H2.
- **Interactive Web Interface**:
  - Built with **Thymeleaf** for dynamic and intuitive user interactions.

---

## Technology Stack
- **Programming Language**: Java 11
- **Frameworks**: 
  - Spring Boot
  - Spring Security
  - Spring MVC
- **Template Engine**: Thymeleaf
- **Databases**: PostgreSQL, H2
- **Build Tool**: Maven
- **Other Tools**: Lombok for boilerplate code reduction

---

## Getting Started

### Prerequisites
- Java 11 installed
- PostgreSQL database configured
- Maven installed

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo-url-here/magnetism.git
   cd magnetism


2. Update the application.properties file with your PostgreSQL credentials.

3. Build the project:
   ```bash
   mvn clean install

4. Run the application:
   ```bash
   java -jar target/magnetism.jar

## Usage

### Users
- Register users with specific roles (e.g., Admin, Scientist).
- Manage roles and permissions through an intuitive admin interface.

### Tasks
- Create, assign, and view tasks seamlessly.
- Filter and sort tasks based on various criteria, such as:
  - Date
  - Priority
  - Assigned user

---

## Future Enhancements
- **Task Notifications**: Implement reminders for task deadlines.
- **Report Exporting**: Add the ability to export reports in formats like PDF or Excel.
- **Task Visualization**: Introduce visual tools such as Gantt charts and interactive graphs to improve task management and analysis.
