create database AirlineReservation

CREATE TABLE Flight (
                        flight_id VARCHAR(30) PRIMARY KEY,
                        origin VARCHAR(30) NOT NULL,
                        destination VARCHAR(30) NOT NULL,
                        departure_time DATETIME,
                        arrival_time DATETIME,
                        seat_map JSON,
                        price DECIMAL(10, 2),
                        seat_row INT,
                        seat_column INT
);

CREATE TABLE Passenger (
                           passenger_id VARCHAR(30) PRIMARY KEY,
                           passenger_name VARCHAR(30),
                           birth_date DATE,
                           ethnicity VARCHAR(30),
                           id_number VARCHAR(20)
);

CREATE TABLE Ticket (
                        ticket_id VARCHAR(30) PRIMARY KEY,
                        passenger_id VARCHAR(30),
                        flight_id VARCHAR(30),
                        seat VARCHAR(30),
                        is_cancelled BOOL default FALSE,
                        FOREIGN KEY (passenger_id) REFERENCES Passenger(passenger_id),
                        FOREIGN KEY (flight_id) REFERENCES Flight(flight_id)
);

CREATE TABLE Reservation (
                             reservation_id VARCHAR(30) PRIMARY KEY,
                             passenger_id VARCHAR(30),
                             flight_id VARCHAR(30),
                             ticket_id VARCHAR(30),
                             reservation_status VARCHAR(10),
                             reservation_date DATETIME,
                             FOREIGN KEY (passenger_id) REFERENCES Passenger(passenger_id),
                             FOREIGN KEY (flight_id) REFERENCES Flight(flight_id),
                             FOREIGN KEY (ticket_id) REFERENCES Ticket(ticket_id)
);

CREATE TABLE User (
                      account VARCHAR(30) PRIMARY KEY,
                      password VARCHAR(256) NOT NULL, 
                      passenger_id VARCHAR(30),
                      ticket JSON,
                      FOREIGN KEY (passenger_id) REFERENCES Passenger(passenger_id)
);
