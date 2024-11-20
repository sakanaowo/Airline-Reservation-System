CREATE SCHEMA `airline`;

CREATE TABLE `airline`.`airports`
(
    `AirportID`   INT         NOT NULL AUTO_INCREMENT,
    `AirportName` VARCHAR(45) NOT NULL,
    `City`        VARCHAR(45) NOT NULL,
    `Country`     VARCHAR(45) NOT NULL,
    PRIMARY KEY (`AirportID`)
);

CREATE TABLE `airline`.`admins`
(
    `AdminID`   INT         NOT NULL AUTO_INCREMENT,
    `AdminName` VARCHAR(45) NOT NULL,
    `Password`  VARCHAR(64) NOT NULL,
    `Email`     VARCHAR(45) NOT NULL,
    PRIMARY KEY (`AdminID`)
);

CREATE TABLE `airline`.`planes`
(
    `PlaneID`     INT         NOT NULL AUTO_INCREMENT,
    `Model`       VARCHAR(45) NOT NULL,
    `Seats`       INT         NOT NULL,
    `UpdatedBy`   INT NULL,
    `UpdatedDate` DATE        NOT NULL,
    PRIMARY KEY (`PlaneID`),
    CONSTRAINT `fk_updatedby`
        FOREIGN KEY (`UpdatedBy`)
            REFERENCES `airline`.`admins` (`AdminID`)
            ON DELETE SET NULL
            ON UPDATE CASCADE
);

CREATE TABLE `airline`.`flights`
(
    `FlightID`           INT      NOT NULL AUTO_INCREMENT,
    `DepartureTime`      DATETIME NOT NULL,
    `ArrivalTime`        DATETIME NOT NULL,
    `PlaneID`            INT      NOT NULL,
    `DepartureAirportID` INT      NOT NULL,
    `ArrivalAirportID`   INT      NOT NULL,
    `UpdatedBy`          INT NULL,
    `UpdatedDate`        DATE     NOT NULL,
    PRIMARY KEY (`FlightID`),
    INDEX                `PlaneID_idx` (`PlaneID` ASC),
    INDEX                `DepartureAirportID_idx` (`DepartureAirportID` ASC),
    INDEX                `ArrivalAirportID_idx` (`ArrivalAirportID` ASC),
    INDEX                `UpdatedBy_idx` (`UpdatedBy` ASC),
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

CREATE TABLE `airline`.`seats`
(
    `SeatID`      INT         NOT NULL AUTO_INCREMENT,
    `FlightID`    INT         NOT NULL,
    `Class`       VARCHAR(45) NOT NULL,
    `Position`    VARCHAR(45) NOT NULL,
    `Available`   TINYINT     NOT NULL,
    `Price` DOUBLE NOT NULL,
    `UpdatedBy`   INT NULL,
    `UpdatedDate` DATE        NOT NULL,
    PRIMARY KEY (`SeatID`),
    INDEX         `FlightID_idx` (`FlightID` ASC),
    CONSTRAINT `fk_flightid`
        FOREIGN KEY (`FlightID`)
            REFERENCES `airline`.`flights` (`FlightID`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

CREATE TABLE `airline`.`users`
(
    `UserID`   INT         NOT NULL AUTO_INCREMENT,
    `UserName` VARCHAR(45) NOT NULL,
    `Password` VARCHAR(45) NOT NULL,
    `Email`    VARCHAR(45) NOT NULL,
    PRIMARY KEY (`UserID`)
);

CREATE TABLE `airline`.`passengers`
(
    `PassengerID` INT         NOT NULL AUTO_INCREMENT,
    `UserID`      INT         NOT NULL,
    `FirstName`   VARCHAR(45) NOT NULL,
    `LastName`    VARCHAR(45) NOT NULL,
    PRIMARY KEY (`PassengerID`),
    INDEX         `UserID_idx` (`UserID` ASC),
    CONSTRAINT `fk_userid`
        FOREIGN KEY (`UserID`)
            REFERENCES `airline`.`users` (`UserID`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

CREATE TABLE `airline`.`tickets`
(
    `TicketID`        INT         NOT NULL AUTO_INCREMENT,
    `PassengerID`     INT         NOT NULL,
    `SeatID`          INT         NOT NULL,
    `TicketCode`      VARCHAR(45) NOT NULL,
    `ReservationDate` DATETIME    NOT NULL,
    PRIMARY KEY (`TicketID`),
    INDEX             `PassengerID_idx` (`PassengerID` ASC),
    INDEX             `SeatID_idx` (`SeatID` ASC),
    CONSTRAINT `fk_passengerid`
        FOREIGN KEY (`PassengerID`)
            REFERENCES `airline`.`passengers` (`PassengerID`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

INSERT INTO `airline`.`admins` (`AdminName`, `Password`, `Email`)
VALUES ('thinh', SHA2('1', 256), 'thinhthiennguyen2004@gmail.com');


-- INSERT INTO `airline`.`airports` (`AirportName`, `City`, `Country`)
-- VALUES ('Noi Bai International Airport', 'Ha Noi', 'Vietnam'),
--        ('Tan Son Nhat International Airport', 'Ho Chi Minh', 'Vietnam'),
--        ('Da Nang International Airport', 'Da Nang', 'Vietnam'),
--        ('Cam Ranh International Airport', 'Nha Trang', 'Vietnam'),
--        ('Phu Quoc International Airport', 'Phu Quoc', 'Vietnam'),
--        ('Cat Bi International Airport', 'Hai Phong', 'Vietnam'),
--        ('Vinh International Airport', 'Vinh', 'Vietnam'),
--        ('Can Tho International Airport', 'Can Tho', 'Vietnam'),
--        ('Chu Lai Airport', 'Quang Nam', 'Vietnam'),
--        ('Dong Hoi Airport', 'Quang Binh', 'Vietnam');

INSERT INTO `airline`.`planes` (`Model`, `Seats`, `UpdatedBy`, `UpdatedDate`)
VALUES ('Airbus A320', 180, 1, CURDATE()),
       ('Airbus A320', 180, 1, CURDATE()),
       ('Airbus A320', 180, 1, CURDATE()),
       ('Airbus A320', 180, 1, CURDATE()),
       ('Airbus A320', 180, 1, CURDATE()),
       ('Airbus A320', 180, 1, CURDATE()),
       ('Airbus A320', 180, 1, CURDATE()),
       ('Airbus A320', 180, 1, CURDATE()),
       ('Airbus A320', 180, 1, CURDATE()),
       ('Airbus A320', 180, 1, CURDATE()),
       ('Airbus A320', 180, 1, CURDATE()),
       ('Airbus A320', 180, 1, CURDATE());


INSERT INTO `airline`.`flights`
(`DepartureTime`, `ArrivalTime`, `PlaneID`, `DepartureAirportID`, `ArrivalAirportID`, `UpdatedBy`, `UpdatedDate`)
VALUES (DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL '08:00:00' HOUR_SECOND,
        DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL '10:00:00' HOUR_SECOND,
        1, 1, 2, 1, CURDATE()),

       (DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL '09:00:00' HOUR_SECOND,
        DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL '11:30:00' HOUR_SECOND,
        2, 6, 3, 1, CURDATE()),

       (DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL '08:00:00' HOUR_SECOND,
        DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL '10:30:00' HOUR_SECOND,
        3, 1, 2, 1, CURDATE()),

       (DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL '09:00:00' HOUR_SECOND,
        DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL '12:00:00' HOUR_SECOND,
        4, 2, 3, 1, CURDATE()),

       (DATE_ADD(CURDATE(), INTERVAL 3 DAY) + INTERVAL '07:00:00' HOUR_SECOND,
        DATE_ADD(CURDATE(), INTERVAL 3 DAY) + INTERVAL '10:15:00' HOUR_SECOND,
        5, 3, 4, 1, CURDATE()),

       (DATE_ADD(CURDATE(), INTERVAL 4 DAY) + INTERVAL '10:00:00' HOUR_SECOND,
        DATE_ADD(CURDATE(), INTERVAL 4 DAY) + INTERVAL '13:00:00' HOUR_SECOND,
        6, 4, 5, 1, CURDATE()),

       (DATE_ADD(CURDATE(), INTERVAL 5 DAY) + INTERVAL '06:00:00' HOUR_SECOND,
        DATE_ADD(CURDATE(), INTERVAL 5 DAY) + INTERVAL '09:30:00' HOUR_SECOND,
        7, 5, 6, 1, CURDATE()),

       (DATE_ADD(CURDATE(), INTERVAL 6 DAY) + INTERVAL '11:00:00' HOUR_SECOND,
        DATE_ADD(CURDATE(), INTERVAL 6 DAY) + INTERVAL '13:45:00' HOUR_SECOND,
        8, 6, 7, 1, CURDATE()),

       (DATE_ADD(CURDATE(), INTERVAL 7 DAY) + INTERVAL '08:30:00' HOUR_SECOND,
        DATE_ADD(CURDATE(), INTERVAL 7 DAY) + INTERVAL '12:00:00' HOUR_SECOND,
        9, 7, 8, 1, CURDATE()),

       (DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL '14:00:00' HOUR_SECOND,
        DATE_ADD(CURDATE(), INTERVAL 1 DAY) + INTERVAL '16:30:00' HOUR_SECOND,
        10, 8, 9, 1, CURDATE()),

       (DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL '17:00:00' HOUR_SECOND,
        DATE_ADD(CURDATE(), INTERVAL 2 DAY) + INTERVAL '20:00:00' HOUR_SECOND,
        11, 9, 10, 1, CURDATE()),

       (DATE_ADD(CURDATE(), INTERVAL 3 DAY) + INTERVAL '15:30:00' HOUR_SECOND,
        DATE_ADD(CURDATE(), INTERVAL 3 DAY) + INTERVAL '18:45:00' HOUR_SECOND,
        12, 10, 1, 1, CURDATE());

USE
airline;

DELIMITER
//

CREATE PROCEDURE InsertSeats(
    IN flightID INT,
    IN businessPrice DOUBLE,
    IN economyPrice DOUBLE,
    IN updatedBy INT,
    IN updatedDate DATE
)
BEGIN
    DECLARE
totalBusinessSeats INT DEFAULT 30;
    DECLARE
totalEconomySeats INT DEFAULT 150;
    DECLARE
economySeatsInserted INT DEFAULT 0;
    DECLARE
businessSeatsInserted INT DEFAULT 0;
    DECLARE
position CHAR(3);

    DECLARE
seatLetters CHAR(1) DEFAULT 'A';

    WHILE
businessSeatsInserted < totalBusinessSeats DO
        SET seatLetters = CHAR(65 + (businessSeatsInserted % 6)); 
        SET
position = CONCAT(seatLetters, FLOOR(businessSeatsInserted / 6) + 1);

INSERT INTO `airline`.`seats` (`FlightID`, `Class`, `Position`, `Available`, `Price`, `UpdatedBy`, `UpdatedDate`)
VALUES (flightID, 'Business', position, 1, businessPrice, updatedBy, updatedDate);

SET
businessSeatsInserted = businessSeatsInserted + 1;
END WHILE;


    WHILE
economySeatsInserted < totalEconomySeats DO

        SET seatLetters = CHAR(65 + (economySeatsInserted % 6)); 
        SET
position = CONCAT(seatLetters, FLOOR(economySeatsInserted / 6) + 1);

INSERT INTO `airline`.`seats` (`FlightID`, `Class`, `Position`, `Available`, `Price`, `UpdatedBy`, `UpdatedDate`)
VALUES (flightID, 'Economy', position, 1, economyPrice, updatedBy, updatedDate);

SET
economySeatsInserted = economySeatsInserted + 1;
END WHILE;
END
//

DELIMITER ;

CALL InsertSeats(1, 1500000, 500000, 1, CURDATE());
CALL InsertSeats(2, 1500000, 500000, 1, CURDATE());
CALL InsertSeats(3, 1500000, 500000, 1, CURDATE());
CALL InsertSeats(4, 1500000, 500000, 1, CURDATE());
CALL InsertSeats(5, 1500000, 500000, 1, CURDATE());
CALL InsertSeats(6, 1500000, 500000, 1, CURDATE());
CALL InsertSeats(7, 1500000, 500000, 1, CURDATE());
CALL InsertSeats(8, 1500000, 500000, 1, CURDATE());
CALL InsertSeats(9, 1500000, 500000, 1, CURDATE());
CALL InsertSeats(10, 1500000, 500000, 1, CURDATE());
CALL InsertSeats(11, 1500000, 500000, 1, CURDATE());
CALL InsertSeats(12, 1500000, 500000, 1, CURDATE());

-- thay doi ten column va cap nhat
delete
from airports
where AirportID in (1, 11);
ALTER TABLE `airports` CHANGE COLUMN `Country` `AirportCode` VARCHAR (10) NOT NULL;
INSERT INTO `airline`.`airports` (`AirportName`, `City`, `AirportCode`)
VALUES ('San bay Chu Lai', 'Quang Nam', 'VCL'),
       ('San bay Tho Xuan', 'Thanh Hoa', 'THD'),
       ('San bay Dong Hoi', 'Quang Binh', 'VDH'),
       ('San bay Dien Bien Phu', 'Dien Bien', 'DIN'),
       ('San bay Tuy Hoa', 'Phu Yen', 'TBB'),
       ('San bay Pleiku', 'Gia Lai', 'PXU'),
       ('San bay Buon Me Thuot', 'Dak Lak', 'BMV'),
       ('San bay Rach Gia', 'Kien Giang', 'VKG'),
       ('San bay Ca Mau', 'Ca Mau', 'CAH'),
       ('San bay Con Dao', 'Ba Ria – Vung Tau', 'VCS'),
       ('San bay quoc te Noi Bai', 'Ha Noi', 'HAN'),
       ('San bay quoc te Tan Son Nhat', 'Thanh pho Ho Chi Minh', 'SGN'),
       ('San bay quoc te Phu Quoc', 'Kien Giang', 'PQC'),
       ('San bay quoc te Da Nang', 'Da Nang', 'DAD'),
       ('San bay quoc te Cam Ranh', 'Khanh Hoa', 'CXR'),
       ('San bay quoc te Phu Bai', 'Thua Thien Hue', 'HUI'),
       ('San bay quoc te Van Don', 'Quang Ninh', 'VDO'),
       ('San bay quoc te Can Tho', 'Can Tho', 'VCA'),
       ('San bay quoc te Vinh', 'Nghe An', 'VII'),
       ('San bay Quoc te Phu Cat', 'Binh Dinh', 'UIH'),
       ('San bay Quoc te Cat Bi', 'Hai Phong', 'HPH'),
       ('San bay Quoc te Lien Khuong (dang de xuat)', 'Lam Dong', 'DLI');