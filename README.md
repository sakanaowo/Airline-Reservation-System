
---

# Airline Reservation System

## Project Overview

The **Airline Reservation System** is a Java-based application designed to simplify the booking, cancellation, and management of flight reservations. The system features modules for handling user accounts, reservations, payments, and administrative tasks, as well as a user-friendly interface for both customers and administrators.

## Features

- **User Features**:
    - Search for flights based on origin, destination, and date.
    - Reserve tickets based on available flights and seating.
    - Cancel existing reservations.
    - View current reservations and booking details.

- **Admin Features**:
    - Add, edit, and remove flights from the system.
    - Manage user accounts and reservations.
    - View and manage payments and transactions.

## Technologies Used

- **Language**: Java
- **Paradigm**: Object-Oriented Programming (OOP)
- **Libraries/Frameworks**:
    - Java Standard Edition (Java SE)
    - Java Swing (for GUI, if applicable)
    - File I/O (for persistent data storage)
    - Optional: JDBC (for database integration)

## Project Structure

```
src
│
├── Data
│   ├── DBManager.java      # Manages database connections (optional if using database)
│   └── FileManager.java    # Handles file operations for storing flight, user, and reservation data
│
├── Service
│   ├── PaymentService.java # Handles payment-related operations
│   └── UserManager.java    # Manages user-related operations such as login, registration, etc.
│
├── UI
│   ├── Main.java           # Entry point of the application; handles main menu navigation
│   ├── Login.java          # Handles user login operations
│   └── NewUser.java        # Handles new user registration functionality
│
├── models
│   ├── Flight.java         # Represents a flight entity with attributes like flight number, origin, destination, etc.
│   ├── Passenger.java      # Represents a passenger entity with relevant attributes
│   ├── Ticket.java         # Represents the ticket entity associated with a passenger and flight
│   ├── Reservation.java    # Manages reservation logic connecting passengers to flights
│   └── User.java           # Represents a user in the system (either a customer or an admin)
│
└── system
│   ├── AirlineSystem.java  # Core system operations, initialization, and high-level management
│   ├── FlightManager.java  # Manages all flight-related operations (e.g., adding, updating, removing flights)
│   └── ReservationManager.java # Manages reservation operations including booking and cancellations
│---README.md
```

### Explanation of Key Components:

- **Data**: Contains classes responsible for managing data storage and retrieval, either through file handling (`FileManager`) or database management (`DBManager`).

- **Service**: Business logic for managing users and payments. The `PaymentService` handles payment-related operations, and the `UserManager` is responsible for user authentication and management.

- **UI**: Handles the user interface, where `Main` is the entry point, `Login` is the login screen, and `NewUser` manages user registration.

- **models**: Contains core entity classes such as `Flight`, `Passenger`, `Ticket`, `Reservation`, and `User`. These represent the key objects in the reservation system.

- **system**: Contains the core classes that tie together the application logic, such as `AirlineSystem`, which serves as the backbone of the application. The `FlightManager` and `ReservationManager` classes are responsible for managing flights and reservations, respectively.

## Installation and Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/sakanaowo/Airtline-reservation-system.git
   cd airline-reservation-system
   ```

2. **Compile the Source Code**:
   Navigate to the `src` directory and run the following command:
   ```bash
   javac UI/Main.java
   ```

3. **Run the Application**:
   After compilation, run the application using:
   ```bash
   java UI.Main
   ```

4. **Database Setup** (Optional):
   If the system is configured to use a database, set up your database and update connection details in the `DBManager.java` class.

## Usage

1. **User Flow**:
    - Login or register as a new user.
    - Search for available flights.
    - Make reservations and pay for tickets.
    - View or cancel existing reservations.

2. **Admin Flow**:
    - Login as an admin user.
    - Add, update, or delete flights.
    - Manage user accounts and reservations.
    - Handle payments and refunds.

## Future Enhancements

- Integration with a relational database (e.g., MySQL, SQLite) to replace file-based data storage.
- Improved user interface using a modern framework like JavaFX.
- Implementing additional user roles (e.g., airline staff).
- Integration of real-time flight status updates.
- Mobile application version.

## Contributors

- **Nguyễn Thái Anh**
- **Hoàng Ngọc Đăng Khoa**
- **Nguyễn Thiên Thịnh**
- **Trần Minh Tân**
- **Trần Tiến Dũng**
---
