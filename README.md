### ⚠ Still in development
# Colegio👩‍🏫

### Colegio is a Java REST API designed for managing teachers, students, and courses. It allows you to handle student information and manage related archives for courses.


## Table of Contents
1. [Instalation](#instalation)
2. [Archive configuration](#ArchiveConfiguration)
3. [Endpoints](#endpoints)

## Installation
Follow these steps to install and run the application on your local environment.

### Prerequisites
Ensure you have the following tools installed on your PC:
- **Java 17**: [Download Java 17](https://adoptium.net/)
- **Docker**: [Install Docker](https://docs.docker.com/get-docker/) 
 ### Clone the repository
 First, clone the repository to your local machine:
 ```bash
git clone https://github.com/camilaMartin14/Colegio-API.git
cd colegio
 ```

### Running the Application
The application will be available at http://localhost:8080.

## Features
- CRUD operations for students, teachers and courses.
- Filter students by their full name.
- Upload images to the database for a specific student.
## Endpoints
### Students
- GET /alumnos: Retrieve all registered students.
- GET /alumnos/{nombrecompleto}: Retrieve a student by their full name.
- POST /alumnos/crear: Register a new student.
- DELETE /alumnos/eliminar/{legajo}: delete a student by their ID.
- PUT /alumnos/ editar/{legajoOriginal}: Update all details of a student, including their ID.
- PUT /alumnos/editar: Update student details without changing the ID.

### 👉Note: To perform CRUD operations for teachers or courses, simply replace "alumnos" in the endpoints with "maestros" or "cursos" respectively.
