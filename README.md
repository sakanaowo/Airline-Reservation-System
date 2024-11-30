
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

## Technologies Used

- **Language**: Java
- **Paradigm**: Object-Oriented Programming (OOP)
- **Libraries/Frameworks**:
    - Java Standard Edition (Java SE)
    - Java Swing (for GUI, if applicable)
    - JDBC (for database integration)

## Project Structure
```
src
│
├── DataHandle
│   ├── constants          # Stores application constants
│   └── Data               # Handles data-related operations
│
├── Models
│   ├── Admin.java         # Represents the admin entity
│   ├── Airport.java       # Represents an airport with relevant attributes
│   ├── Flight.java        # Represents a flight entity
│   ├── Passenger.java     # Represents a passenger entity
│   ├── Plane.java         # Represents an airplane entity
│   ├── Seat.java          # Represents seating information
│   ├── Ticket.java        # Represents a ticket entity
│   └── User.java          # Represents a user entity
│
├── System
│   ├── AirlineSystem.java # Core system operations, initialization, and management
│   ├── FlightControl.java # Manages flight-related operations
│   ├── ReservationControl.java # Handles reservation logic
│   └── UserControl.java   # Manages user-related operations
│
├── UI
│   ├── Admin
│   │   └── Plugin
│   │       ├── addAirport.java    # Allows admin to add an airport
│   │       ├── addFlight.java     # Allows admin to add a flight
│   │       ├── addPlane.java      # Allows admin to add a plane
│   │       ├── deleteAirport.java # Allows admin to delete an airport
│   │       ├── deleteFlight.java  # Allows admin to delete a flight
│   │       ├── deletePlane.java   # Allows admin to delete a plane
│   │       ├── editAirport.java   # Allows admin to edit airport details
│   │       ├── editFlight.java    # Allows admin to edit flight details
│   │       ├── editPlane.java     # Allows admin to edit plane details
│   │       ├── searchAirport.java # Allows admin to search for airports
│   │       ├── searchFlight.java  # Allows admin to search for flights
│   │       ├── searchPlane.java   # Allows admin to search for planes
│   │       └── view.java          # Admin view management
│   │
│   ├── Icon                      # Contains images and icons used in the UI
│   │   ├── login.png             # Login screen icon
│   │   ├── menu.png              # Main menu icon
│   │   └── ...                   # Additional icons
│   │
│   └── main
│       └── CustomPlugin
│           ├── BackGroundChangedByTime.java # Adjusts background based on time
│           ├── ChangeEmail.java            # Handles email changes
│           ├── ChangePasswordDialog.java   # Manages password change dialogs
│           ├── Icons.java                  # Loads and manages icons
│           ├── ImageLabel.java             # Custom label for displaying images
│           ├── ImagePanel.java             # Panel for managing images
│           └── TimeHandle.java             # Handles time-based operations
│
└── README.md
```

### Explanation of Key Components:

- **DataHandle**:  
  Contains classes for managing data operations:
  - `Data`: Handles file-based data storage and retrieval.
  - `constants`: Stores application constants used across the system.

- **Models**:  
  Core entity classes representing the domain of the system:
  - `Admin`: Represents administrators with specific permissions.
  - `Airport`: Represents airport entities.
  - `Flight`: Represents flight details and operations.
  - `Passenger`: Represents passengers in the system.
  - `Plane`: Represents airplane entities.
  - `Seat`: Manages seating arrangements.
  - `Ticket`: Represents tickets issued for passengers and flights.
  - `User`: Represents system users (customers or admins).

- **System**:  
  Implements core logic and system management:
  - `AirlineSystem`: Central system class that coordinates operations.
  - `FlightControl`: Handles flight-related operations such as search, add, or delete.
  - `ReservationControl`: Manages reservations and booking processes.
  - `UserControl`: Manages user authentication and account operations.

- **UI**:  
  Handles the user interface:
  - **Admin Plugin**: Includes classes for administrative tasks like adding, deleting, and searching for flights, airports, or planes.
  - **Icons**: Contains UI assets such as images and icons used throughout the system.
  - **main**: Contains the main entry point and other UI-related classes:
    - `Login`: Handles user login.
    - `Menu`: Displays main menu options.
    - `CustomPlugin`: Provides additional features such as background changes, icon handling, and time-based operations.

---

## Installation and Setup

1. **Clone the Repository**:  
   Clone the project to your local machine:
   ```bash
   git clone https://github.com/sakanaowo/Airline-Reservation-System
   cd Airline-Reservation-System
   ```

2. **Compile the Source Code**:  
   Navigate to the `src` directory and compile the source code:
   ```bash
   javac main/Main.java
   ```

3. **Run the Application**:  
   Run the application after successful compilation:
   ```bash
   java main.Main
   ```

4. **Database Setup**:  
   - Configure your database using the provided `DBdesign.sql` script.
   - Update connection settings in `DBManager.java` or relevant classes.

---

## Usage

1. **User Flow**:
    - **Login/Register**: Users can log in or create a new account.
    - **Search Flights**: Browse available flights by destination, date, or other criteria.
    - **Book Tickets**: Make reservations and select seats.
    - **Manage Bookings**: View or cancel existing bookings.

2. **Admin Flow**:
    - **Login**: Use admin credentials to access management features.
    - **Manage Flights**: Add, edit, or remove flights.
    - **Airport and Plane Management**: Handle airport and airplane information.
    - **User and Reservation Management**: Oversee user accounts and reservations.

---

## Future Enhancements

- **UI Improvements**: Upgrade to JavaFX or another modern UI framework for better user experience.
- **Enhanced Roles**: Add additional user roles such as airline staff or premium customers.
- **Real-Time Updates**: Incorporate APIs for live flight status and notifications.
- **Mobile Application**: Develop a mobile app for better accessibility.

## Contributors

- [Nguyễn Thái Anh](https://github.com/sakanaowo)
- [Hoàng Ngọc Đăng Khoa](https://github.com/Solozyyy)
- [Nguyễn Thiên Thịnh](https://github.com/thinhnguyenpy)
- [Trần Minh Tân](https://github.com/MinhTan777)
- [Trần Tiến Dũng](https://github.com/DungHieu2319)
---
