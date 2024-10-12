create database AirLineReservationSystem;

create table Flight(
	flightID varchar(30),
    status varchar(30),
	origin varchar(30),
    destination varchar(30),
    departureTime varchar(30),
    arrivalTime varchar(30),
	price float,
    seatMap json,
	primary key(flightID)
);

insert into Flight 
values
('F001', 'Da cat canh', 'Ha Noi', 'Ho Chi Minh City', '06:00:00', '09:00:00', 150, '[["A1", "A2", "A3"], ["B1", "B2", "B3"]]');

select * from Flight;

create table Passenger(
	passengerID varchar(30),
    name varchar(30),
    bithDate varchar(30),
    ehnicity varchar(30),
    primary key(ID)
);

create table Reservation(
	reservationCounter int,
    reservationID varchar(30),
    passengerID varchar(30),
    flightID varchar(30),
    ticketID varchar(30),
    status varchar(30),
    reservationDate date,
    primary key (reservationID),
    foreign key (passenggerID) references Passenger(passengerID),
    foreign key (flightID) references Flight(FlightID),
    foreign key (ticketID) references Ticket(TicketID)
);

create table Ticket(
	ticketCounter int,
    ticketID varchar(30),
    passengerID varchar(30),
    flightID varchar(30),
    seat varchar(30),
    price int,
	status varchar(10),
    primary key (tikectID),
    foreign key (passengerID) references Passenger(passengerID),
    foreign key (flightID) references Flight(FlilghtID)
);
