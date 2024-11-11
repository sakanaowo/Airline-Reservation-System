CREATE SCHEMA `airline`;

CREATE TABLE `airline`.`airports` (
  `AirportID` INT NOT NULL AUTO_INCREMENT,
  `AirportName` VARCHAR(45) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  `Country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`AirportID`)
);

CREATE TABLE `airline`.`admins` (
  `AdminID` INT NOT NULL AUTO_INCREMENT,
  `AdminName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(64) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`AdminID`)
);

CREATE TABLE `airline`.`planes` (
  `PlaneID` INT NOT NULL AUTO_INCREMENT,
  `Model` VARCHAR(45) NOT NULL,
  `Seats` INT NOT NULL,
  `UpdatedBy` INT NULL,
  `UpdatedDate` DATE NOT NULL,  
  PRIMARY KEY (`PlaneID`),
  CONSTRAINT `fk_updatedby` 
    FOREIGN KEY (`UpdatedBy`)
    REFERENCES `airline`.`admins` (`AdminID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);

CREATE TABLE `airline`.`flights` (
  `FlightID` INT NOT NULL AUTO_INCREMENT,
  `DepartureTime` DATETIME NOT NULL,
  `ArrivalTime` DATETIME NOT NULL,
  `PlaneID` INT NOT NULL,
  `DepartureAirportID` INT NOT NULL,
  `ArrivalAirportID` INT NOT NULL,
  `UpdatedBy` INT NULL,
  `UpdatedDate` DATE NOT NULL,  
  PRIMARY KEY (`FlightID`),
  INDEX `PlaneID_idx` (`PlaneID` ASC),
  INDEX `DepartureAirportID_idx` (`DepartureAirportID` ASC),
  INDEX `ArrivalAirportID_idx` (`ArrivalAirportID` ASC),
  INDEX `UpdatedBy_idx` (`UpdatedBy` ASC),
  CONSTRAINT `fk_planeid`
    FOREIGN KEY (`PlaneID`)
    REFERENCES `airline`.`planes` (`PlaneID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_departureairportid`
    FOREIGN KEY (`DepartureAirportID`)
    REFERENCES `airline`.`airports` (`AirportID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_arrivalairportid`
    FOREIGN KEY (`ArrivalAirportID`)
    REFERENCES `airline`.`airports` (`AirportID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_updatedby_flights`
    FOREIGN KEY (`UpdatedBy`)
    REFERENCES `airline`.`admins` (`AdminID`)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);

CREATE TABLE `airline`.`seats` (
  `SeatID` INT NOT NULL AUTO_INCREMENT,
  `FlightID` INT NOT NULL,
  `Class` VARCHAR(45) NOT NULL,
  `Available` TINYINT NOT NULL,
  `Price` DOUBLE NOT NULL,
  `UpdatedBy` INT NULL,
  `UpdatedDate` DATE NOT NULL,  
  PRIMARY KEY (`SeatID`, `FlightID`),
  INDEX `FlightID_idx` (`FlightID` ASC),
  CONSTRAINT `fk_flightid`
    FOREIGN KEY (`FlightID`)
    REFERENCES `airline`.`flights` (`FlightID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE `airline`.`users` (
  `UserID` INT NOT NULL AUTO_INCREMENT,
  `UserName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`UserID`)
);

CREATE TABLE `airline`.`passengers` (
  `PassengerID` INT NOT NULL AUTO_INCREMENT,
  `UserID` INT NOT NULL,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PassengerID`),
  INDEX `UserID_idx` (`UserID` ASC),
  CONSTRAINT `fk_userid`
    FOREIGN KEY (`UserID`)
    REFERENCES `airline`.`users` (`UserID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE `airline`.`tickets` (
  `TicketID` INT NOT NULL AUTO_INCREMENT,
  `PassengerID` INT NOT NULL,
  `SeatID` INT NOT NULL,
  `FlightID` INT NOT NULL,
  `TicketCode` VARCHAR(45) NOT NULL,
  `ReservationDate` DATETIME NOT NULL,  
  PRIMARY KEY (`TicketID`),
  INDEX `PassengerID_idx` (`PassengerID` ASC),
  INDEX `SeatID_idx` (`SeatID` ASC),
  INDEX `FlightID_idx` (`FlightID` ASC),
  CONSTRAINT `fk_passengerid`
    FOREIGN KEY (`PassengerID`)
    REFERENCES `airline`.`passengers` (`PassengerID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_seat_flight`
    FOREIGN KEY (`SeatID`, `FlightID`)
    REFERENCES `airline`.`seats` (`SeatID`, `FlightID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Insert sample data
INSERT INTO `airline`.`admins` (`AdminName`, `Password`, `Email`)
VALUES ('thinh', SHA2('1', 256), 'thinhthiennguyen2004@gmail.com');

INSERT INTO `airline`.`planes` (`Model`, `Seats`, `UpdatedBy`, `UpdatedDate`) VALUES
('Boeing 737', 160, 1, CURDATE()),
('Boeing 777', 396, 1, CURDATE()),
('Boeing 737', 160, 1, CURDATE());

INSERT INTO `airline`.`airports` (`AirportName`, `City`, `Country`) VALUES
('Noi Bai International Airport', 'Ha Noi', 'Vietnam'),
('Tan Son Nhat International Airport', 'Ho Chi Minh', 'Vietnam'),
('Da Nang International Airport', 'Da Nang', 'Vietnam'),
('Cam Ranh International Airport', 'Nha Trang', 'Vietnam'),
('Phu Quoc International Airport', 'Phu Quoc', 'Vietnam'),
('Cat Bi International Airport', 'Hai Phong', 'Vietnam'),
('Vinh International Airport', 'Vinh', 'Vietnam'),
('Can Tho International Airport', 'Can Tho', 'Vietnam'),
('Chu Lai Airport', 'Quang Nam', 'Vietnam'),
('Dong Hoi Airport', 'Quang Binh', 'Vietnam');

INSERT INTO `airline`.`flights` 
    (`DepartureTime`, `ArrivalTime`, `PlaneID`, `DepartureAirportID`, `ArrivalAirportID`, `UpdatedDate`) 
VALUES 
    (DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL '08:00:00' HOUR_SECOND, 
     DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL '10:00:00' HOUR_SECOND, 
     1, 1, 2, CURDATE()),  
    (DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL '09:00:00' HOUR_SECOND, 
     DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL '11:30:00' HOUR_SECOND, 
     2, 6, 3, CURDATE());

USE airline;

DELIMITER //

CREATE PROCEDURE InsertSeats(
    IN flightID INT, 
    IN numEconomySeats INT, 
    IN economyPrice DOUBLE, 
    IN numBusinessSeats INT, 
    IN businessPrice DOUBLE,
    IN updatedBy INT,
    IN updatedDate DATE 
)
BEGIN
    DECLARE economySeatsInserted INT DEFAULT 0;
    DECLARE businessSeatsInserted INT DEFAULT 0;

    WHILE economySeatsInserted < numEconomySeats DO
        INSERT INTO `airline`.`seats` (`FlightID`, `Class`, `Available`, `Price`, `UpdatedBy`, `UpdatedDate`)
        VALUES (flightID, 'Economy', 1, economyPrice, updatedBy, updatedDate);
        SET economySeatsInserted = economySeatsInserted + 1;
    END WHILE;

    WHILE businessSeatsInserted < numBusinessSeats DO
        INSERT INTO `airline`.`seats` (`FlightID`, `Class`, `Available`, `Price`, `UpdatedBy`, `UpdatedDate`)
        VALUES (flightID, 'Business', 1, businessPrice, updatedBy, updatedDate);  
        SET businessSeatsInserted = businessSeatsInserted + 1;
    END WHILE;
END //

DELIMITER ;

CALL InsertSeats(3, 170, 500000, 10, 1500000, 1, CURDATE());
CALL InsertSeats(4, 200, 500000, 20, 1500000, 1, CURDATE());
CALL InsertSeats(5, 250, 500000, 16, 1500000, 1, CURDATE());
CALL InsertSeats(6, 300, 500000, 25, 1500000, 1, CURDATE());
CALL InsertSeats(8, 180, 500000, 9, 1500000, 1, CURDATE());
CALL InsertSeats(10, 180, 500000, 20, 1500000, 1, CURDATE());
CALL InsertSeats(1, 150, 500000, 10, 1500000, 1, CURDATE());
CALL InsertSeats(2, 380, 500000, 16, 1500000, 1, CURDATE());

INSERT INTO `airline`.`planes` (`Model`, `Seats`, `UpdatedBy`, `UpdatedDate`) VALUES
('Airbus A320', 180, 1, CURDATE()),     
('Airbus A321', 220, 1, CURDATE()),     
('Airbus A330', 277, 1, CURDATE()),     
('Airbus A350', 325, 1, CURDATE()),     
('Airbus A380', 555, 1, CURDATE()),     
('Boeing 737', 189, 1, CURDATE()),      
('Boeing 747', 416, 1, CURDATE()),     
('Boeing 757', 200, 1, CURDATE()),     
('Boeing 767', 375, 1, CURDATE()),     
('Boeing 787', 242, 1, CURDATE());   

INSERT INTO `airline`.`flights` (`DepartureTime`, `ArrivalTime`, `PlaneID`, `DepartureAirportID`, `ArrivalAirportID`, `UpdatedBy`, `UpdatedDate`) 
VALUES
(DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL '08:00:00' HOUR_SECOND, 
 DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL '10:30:00' HOUR_SECOND, 
 4, 1, 2, 1, CURDATE()),  
 
(DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL '09:00:00' HOUR_SECOND, 
 DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL '12:00:00' HOUR_SECOND, 
 5, 2, 3, 1, CURDATE()),   

(DATE_ADD(CURDATE(), INTERVAL 3 DAY) + INTERVAL '07:00:00' HOUR_SECOND, 
 DATE_ADD(CURDATE(), INTERVAL 3 DAY) + INTERVAL '10:15:00' HOUR_SECOND, 
 6, 3, 4, 1, CURDATE()),   

(DATE_ADD(CURDATE(), INTERVAL 4 DAY) + INTERVAL '10:00:00' HOUR_SECOND, 
 DATE_ADD(CURDATE(), INTERVAL 4 DAY) + INTERVAL '13:00:00' HOUR_SECOND, 
 7, 4, 5, 1, CURDATE()),   

(DATE_ADD(CURDATE(), INTERVAL 5 DAY) + INTERVAL '06:00:00' HOUR_SECOND, 
 DATE_ADD(CURDATE(), INTERVAL 5 DAY) + INTERVAL '09:30:00' HOUR_SECOND, 
 8, 5, 6, 1, CURDATE()),   -- Flight 5, Plane 8 (Airbus A380)

(DATE_ADD(CURDATE(), INTERVAL 6 DAY) + INTERVAL '11:00:00' HOUR_SECOND, 
 DATE_ADD(CURDATE(), INTERVAL 6 DAY) + INTERVAL '13:45:00' HOUR_SECOND, 
 9, 6, 7, 1, CURDATE()),  

(DATE_ADD(CURDATE(), INTERVAL 7 DAY) + INTERVAL '08:30:00' HOUR_SECOND, 
 DATE_ADD(CURDATE(), INTERVAL 7 DAY) + INTERVAL '12:00:00' HOUR_SECOND, 
 10, 7, 8, 1, CURDATE()),   

(DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL '14:00:00' HOUR_SECOND, 
 DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL '16:30:00' HOUR_SECOND, 
 11, 8, 9, 1, CURDATE()),  

(DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL '17:00:00' HOUR_SECOND, 
 DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL '20:00:00' HOUR_SECOND, 
 12, 9, 10, 1, CURDATE()),  

(DATE_ADD(CURDATE(), INTERVAL 3 DAY) + INTERVAL '15:30:00' HOUR_SECOND, 
 DATE_ADD(CURDATE(), INTERVAL 3 DAY) + INTERVAL '18:45:00' HOUR_SECOND, 
 13, 10, 1, 1, CURDATE()); 



















