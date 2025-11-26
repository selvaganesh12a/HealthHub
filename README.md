# Health Hub - Appointment Booking System

A full-stack healthcare appointment booking application built with **Spring Boot** (Backend) and **React.js** (Frontend). This system allows patients to book appointments with doctors and enables administrators to manage doctors and view all appointments.

## 🚀 Features

### 🏥 Patient Portal
*   **User Registration & Login**: Secure account creation and authentication.
*   **Doctor Discovery**: View a list of available doctors with their specialization, experience, and consultation fees.
*   **Appointment Booking**: Book appointments with doctors for specific dates and times.
*   **Conflict Detection**: The system prevents double-booking the same doctor at the same time.
*   **My Appointments**: View a history of booked appointments with status (Booked/Cancelled).
*   **Cancel Appointment**: Ability to cancel upcoming appointments.

### 👨‍⚕️ Admin Dashboard
*   **Admin Authentication**: Secure login for administrators.
*   **Doctor Management**: Add, Update, and Delete doctor profiles.
*   **Appointment Overview**: View all appointments across the system to monitor hospital activity.

## 🛠️ Tech Stack

### Backend
*   **Java 17**
*   **Spring Boot 3.2.3**
*   **Spring Data JPA** (Hibernate)
*   **MySQL** (Database)
*   **Maven** (Build Tool)

### Frontend
*   **React.js 18**
*   **Vite** (Build Tool)
*   **CSS** (Custom Styling)
*   **Axios** (API Integration)

## ⚙️ Prerequisites

Ensure you have the following installed on your machine:
*   **Java Development Kit (JDK) 17** or higher
*   **Node.js** (v18 or higher) and **npm**
*   **MySQL Server**

## 📦 Setup Instructions

### 1. Database Setup
1.  Open your MySQL client (Workbench, Command Line, etc.).
2.  Create a new database named `health_hub`:
    ```sql
    CREATE DATABASE health_hub;
    ```
3.  The backend application will automatically create the necessary tables (`users`, `doctors`, `appointments`) on the first run.

### 2. Backend Setup (Spring Boot)
1.  Navigate to the `backend` directory:
    ```bash
    cd backend
    ```
2.  Open `src/main/resources/application.properties` and update your MySQL credentials if they differ from the defaults:
    ```properties
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```
3.  Build and run the application:
    ```bash
    mvn spring-boot:run
    ```
    The backend server will start at `http://localhost:8080`.

### 3. Frontend Setup (React)
1.  Open a new terminal and navigate to the `frontend` directory:
    ```bash
    cd frontend
    ```
2.  Install dependencies:
    ```bash
    npm install
    ```
3.  Start the development server:
    ```bash
    npm run dev
    ```
    The frontend application will be accessible at `http://localhost:5173`.

## 🔌 API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **POST** | `/api/users/register` | Register a new patient/admin |
| **POST** | `/api/users/login` | Login user |
| **GET** | `/api/doctors` | Get list of all doctors |
| **POST** | `/api/doctors` | Add a new doctor (Admin) |
| **PUT** | `/api/doctors/{id}` | Update doctor details (Admin) |
| **DELETE** | `/api/doctors/{id}` | Delete a doctor (Admin) |
| **POST** | `/api/appointments` | Book an appointment |
| **GET** | `/api/appointments` | Get all appointments (Admin) |
| **GET** | `/api/appointments/patient/{id}` | Get appointments for a patient |
| **PUT** | `/api/appointments/{id}/cancel` | Cancel an appointment |

## 🛡️ Usage

1.  **Register a Patient**: Go to the Register page and create a new account.
2.  **Login**: Use your credentials to log in.
3.  **Book Appointment**: Select a doctor and choose a date/time.
4.  **Admin Access**:
    *   You can create an admin user via the API or database directly, or register a new user and manually update their role to `ADMIN` in the `users` table.
    *   Login as Admin to access the dashboard for managing doctors and viewing all appointments.

## 🤝 Contributing

Contributions are welcome! Please fork the repository and submit a Pull Request.

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).
