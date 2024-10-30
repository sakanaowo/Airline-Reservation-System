CREATE SCHEMA `airline` ;

  CREATE TABLE `airline`.`airports` (
  `AirportID` INT NOT NULL AUTO_INCREMENT,
  `AirportName` VARCHAR(45) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  `Country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`AirportID`));

  CREATE TABLE `airline`.`planes` (
  `PlaneID` INT NOT NULL AUTO_INCREMENT,
  `Model` VARCHAR(45) NOT NULL,
  `Seats` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PlaneID`));

  CREATE TABLE `airline`.`flights` (
  `FlightID` INT NOT NULL AUTO_INCREMENT,
  `DepatureTime` DATETIME NOT NULL,
  `ArrivalTime` DATETIME NOT NULL,
  `PlaneID` INT NOT NULL,
  `DepartureAirportID` INT NOT NULL,
  `ArrivalAirportID` INT NOT NULL,
  PRIMARY KEY (`FlightID`),
  INDEX `PlaneID_idx` (`PlaneID` ASC) VISIBLE,
  INDEX `DepartureAirportID_idx` (`DepartureAirportID` ASC) VISIBLE,
  INDEX `ArrivalAirportID_idx` (`ArrivalAirportID` ASC) VISIBLE,
  CONSTRAINT `PlaneID`
    FOREIGN KEY (`PlaneID`)
    REFERENCES `airline`.`planes` (`PlaneID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `DepartureAirportID`
    FOREIGN KEY (`DepartureAirportID`)
    REFERENCES `airline`.`airports` (`AirportID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ArrivalAirportID`
    FOREIGN KEY (`ArrivalAirportID`)
    REFERENCES `airline`.`airports` (`AirportID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

  CREATE TABLE `airline`.`seats` (
  `SeatID` INT NOT NULL AUTO_INCREMENT,
  `FlightID` INT NOT NULL,
  `SeatNumber` INT NOT NULL,
  `Class` VARCHAR(45) NOT NULL,
  `Avaiable` BIT NOT NULL,
  `Price` DOUBLE NOT NULL,
  PRIMARY KEY (`SeatID`, `FlightID`),
  INDEX `FlightID_idx` (`FlightID` ASC) VISIBLE,
  CONSTRAINT `FlightID`
    FOREIGN KEY (`FlightID`)
    REFERENCES `airline`.`flights` (`FlightID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
  
  CREATE TABLE `airline`.`users` (
  `UserID` INT NOT NULL AUTO_INCREMENT,
  `UserName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`UserID`));

  CREATE TABLE `airline`.`passengers` (
  `PassengerID` INT NOT NULL AUTO_INCREMENT,
  `UserID` INT NOT NULL,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Passengerscol` VARCHAR(45) NOT NULL,
  `Passengerscol1` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PassengerID`),
  INDEX `UserID_idx` (`UserID` ASC) VISIBLE,
  CONSTRAINT `UserID`
    FOREIGN KEY (`UserID`)
    REFERENCES `airline`.`users` (`UserID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

  CREATE TABLE `airline`.`tickets` (
  `TicketID` INT NOT NULL AUTO_INCREMENT,
  `PassengerID` INT NOT NULL,
  `SeatID` INT NOT NULL,
  `FlightID` INT NOT NULL,
  `TicketCode` VARCHAR(45) NOT NULL,
  `ReservationDate` DATETIME NOT NULL,
  `Ticketscol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`TicketID`),
  INDEX `PassengerID_idx` (`PassengerID` ASC) VISIBLE,
  INDEX `SeatID_idx` (`SeatID` ASC) VISIBLE,
  INDEX `FlightID_idx` (`FlightID` ASC) VISIBLE,
  CONSTRAINT `FK_PassengerID`
    FOREIGN KEY (`PassengerID`)
    REFERENCES `airline`.`passengers` (`PassengerID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_SeatID`
    FOREIGN KEY (`SeatID`)
    REFERENCES `airline`.`seats` (`SeatID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_FlightID`
    FOREIGN KEY (`FlightID`)
    REFERENCES `airline`.`seats` (`FlightID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
  );


INSERT INTO `airline`.`planes` (`Model`, `Seats`) VALUES
('Boeing 737', '160'),
('Boeing 777', '396');

INSERT INTO `airline`.`airports` (`AirportName`, `City`, `Country`) VALUES
('Noi Bai International Airport', 'Hanoi', 'Vietnam'),
('Tan Son Nhat International Airport', 'Ho Chi Minh City', 'Vietnam'),
('Da Nang International Airport', 'Da Nang', 'Vietnam'),
('Cam Ranh International Airport', 'Nha Trang', 'Vietnam'),
('Phu Quoc International Airport', 'Phu Quoc', 'Vietnam'),
('Cat Bi International Airport', 'Hai Phong', 'Vietnam'),
('Vinh International Airport', 'Vinh', 'Vietnam'),
('Can Tho International Airport', 'Can Tho', 'Vietnam'),
('Chu Lai Airport', 'Quang Nam', 'Vietnam'),
('Dong Hoi Airport', 'Quang Binh', 'Vietnam');

INSERT INTO `airline`.`flights` (`DepatureTime`, `ArrivalTime`, `PlaneID`, `DepartureAirportID`, `ArrivalAirportID`) VALUES
(DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL '08:00:00' HOUR_SECOND, DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL '10:00:00' HOUR_SECOND, 1, 1, 2),
(DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL '09:00:00' HOUR_SECOND, DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL '11:30:00' HOUR_SECOND, 2, 6, 3);

USE airline;

DELIMITER //

CREATE PROCEDURE InsertSeats(IN flightID INT, IN numEconomySeats INT, IN economyPrice DOUBLE, IN numBusinessSeats INT, IN businessPrice DOUBLE)
BEGIN
    DECLARE seatNumber INT DEFAULT 1;

    WHILE seatNumber <= numEconomySeats DO
        INSERT INTO `airline`.`seats` (`FlightID`, `SeatNumber`, `Class`, `Avaiable`, `Price`)
        VALUES (flightID, seatNumber, 'Economy', 1, economyPrice);
        SET seatNumber = seatNumber + 1;
    END WHILE;

    SET seatNumber = numEconomySeats + 1;
    WHILE seatNumber <= (numEconomySeats + numBusinessSeats) DO
        INSERT INTO `airline`.`seats` (`FlightID`, `SeatNumber`, `Class`, `Avaiable`, `Price`)
        VALUES (flightID, seatNumber, 'Business', 1, businessPrice);
        SET seatNumber = seatNumber + 1;
    END WHILE;
END //

DELIMITER ;

CALL InsertSeats(1, 150, 500000, 10, 1500000);

CALL InsertSeats(2, 380, 500000, 16, 1500000);


