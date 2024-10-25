CREATE SCHEMA `test_airline` ;

-- users table
CREATE TABLE `test_airline`.`users` (
  `UserID` INT NOT NULL,
  `UserName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE INDEX `UserName_UNIQUE` (`UserName` ASC) VISIBLE,
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE); CREATE TABLE `test_airline`.`users` (
  `UserID` INT NOT NULL,
  `UserName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE INDEX `UserName_UNIQUE` (`UserName` ASC) VISIBLE,
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE);

-- planes table
CREATE TABLE `test_airline`.`planes` (
  `PlaneID` INT NOT NULL,
  `Model` VARCHAR(45) NOT NULL,
  `Capacity` INT NOT NULL,
  PRIMARY KEY (`PlaneID`));

-- airport table
CREATE TABLE `test_airline`.`airports` (
  `AirportID` INT NOT NULL,
  `AirportName` VARCHAR(45) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  `Country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`AirportID`));

--routes table
CREATE TABLE `test_airline`.`routes` (
  `RouteID` INT NOT NULL,
  `DepartureAirportID` INT NOT NULL,
  `ArrivalAirportID` INT NOT NULL,
  `Distance` INT NOT NULL,
  PRIMARY KEY (`RouteID`),
  INDEX `DepartureAirportID_idx` (`DepartureAirportID` ASC) VISIBLE,
  INDEX `ArrivalAirportID_idx` (`ArrivalAirportID` ASC) VISIBLE,
  CONSTRAINT `DepartureAirportID`
    FOREIGN KEY (`DepartureAirportID`)
    REFERENCES `test_airline`.`airports` (`AirportID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ArrivalAirportID`
    FOREIGN KEY (`ArrivalAirportID`)
    REFERENCES `test_airline`.`airports` (`AirportID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

-flights table
CREATE TABLE `test_airline`.`flights` (
  `FlightID` INT NOT NULL,
  `DepartureTime` DATETIME NOT NULL,
  `ArrivalTime` DATETIME NOT NULL,
  `Duration` TIME NOT NULL,
  `PlaneID` INT NOT NULL,
  `RouteID` INT NOT NULL,
  PRIMARY KEY (`FlightID`),
  INDEX `RouteID_idx` (`RouteID` ASC) VISIBLE,
  INDEX `PlaneID_idx` (`PlaneID` ASC) VISIBLE,
  CONSTRAINT `PlaneID`
    FOREIGN KEY (`PlaneID`)
    REFERENCES `test_airline`.`planes` (`PlaneID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `RouteID`
    FOREIGN KEY (`RouteID`)
    REFERENCES `test_airline`.`routes` (`RouteID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

-- passenger tables
CREATE TABLE `test_airline`.`passengers` (
  `PassengerID` INT NOT NULL,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `UserID` INT NOT NULL,
  `PhoneNumber` VARCHAR(45) NOT NULL,
  `PassportCode` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PassengerID`),
  INDEX `UserID_idx` (`UserID` ASC) VISIBLE,
  CONSTRAINT `UserID`
    FOREIGN KEY (`UserID`)
    REFERENCES `test_airline`.`users` (`UserID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

-- reservation 
CREATE TABLE `test_airline`.`reservations` (
  `ReservationID` INT NOT NULL,
  `PassengerID` INT NOT NULL,
  `FlightID` INT NOT NULL,
  `SeatNumber` INT NOT NULL,
  `ReservationDate` DATETIME NOT NULL,
  PRIMARY KEY (`ReservationID`),
  INDEX `PassengerID_idx` (`PassengerID` ASC) VISIBLE,
  INDEX `FlightID_idx` (`FlightID` ASC) VISIBLE,
  CONSTRAINT `PassengerID`
    FOREIGN KEY (`PassengerID`)
    REFERENCES `test_airline`.`passengers` (`PassengerID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FlightID`
    FOREIGN KEY (`FlightID`)
    REFERENCES `test_airline`.`flights` (`FlightID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Seats 
CREATE TABLE `test_airline`.`seats` (
  `SeatID` INT NOT NULL,
  `FlightID` INT NOT NULL,
  `SeatNumber` INT NOT NULL,
  `Class` VARCHAR(45) NOT NULL,
  `Avaiable` BIT NOT NULL,
  `SeatRow` INT NOT NULL,
  `SetColumn` INT NOT NULL,
  `Price` DOUBLE NOT NULL,
  PRIMARY KEY (`SeatID`),
  INDEX `FlightID_idx` (`FlightID` ASC) VISIBLE,
  CONSTRAINT `FK_FlightID`  -- Đổi tên ràng buộc khóa ngoại tại đây
    FOREIGN KEY (`FlightID`)
    REFERENCES `test_airline`.`flights` (`FlightID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Tickets table
CREATE TABLE `test_airline`.`tickets` (
  `TicketID` INT NOT NULL,
  `ReservationID` VARCHAR(45) NOT NULL,
  `Status` VARCHAR(45) NOT NULL,
  `SeatID` INT NOT NULL,
  PRIMARY KEY (`TicketID`),
  INDEX `SeatID_idx` (`SeatID` ASC) VISIBLE,
  CONSTRAINT `SeatID`
    FOREIGN KEY (`SeatID`)
    REFERENCES `test_airline`.`seats` (`SeatID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- Payments table
CREATE TABLE `test_airline`.`payments` (
  `PaymentID` INT NOT NULL AUTO_INCREMENT,
  `ReservationID` INT NOT NULL,
  `PaymentDate` DATETIME NOT NULL,
  `PaymentAmount` DOUBLE NOT NULL,
  `UserID` INT NOT NULL,
  `PaymentMethod` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PaymentID`),
  INDEX `UserID_idx` (`UserID` ASC),
  CONSTRAINT `FK_UserID`
    FOREIGN KEY (`UserID`)
    REFERENCES `test_airline`.`users` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ReservationID`
    FOREIGN KEY (`ReservationID`)
    REFERENCES `test_airline`.`reservations` (`ReservationID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);



