  CREATE TABLE Flight (
    flight_Id integer identity primary key,
    name varchar(200) not null,
    type varchar(50) not null
);

  CREATE TABLE Hotel (
    hotel_Id integer identity primary key,
    name varchar(200) not null,
    type varchar(50) not null
);
 
  CREATE TABLE Passenger (
    passenger_Id integer identity primary key,
    name varchar(200) not null
);

  CREATE TABLE Flight_Passenger (
    flight_Id integer not null,
    passenger_Id integer not null,
    booked_from date,
    booked_to date
);

  CREATE TABLE Hotel_Passenger (
    hotel_Id integer not null,
    passenger_Id integer not null,
    booked_from date,
    booked_to date
);
 
