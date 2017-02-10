  CREATE TABLE Flight (
    flight_Id integer identity primary key,
    name varchar(200) not null,
    type varchar(50) not null,
    booked_from date not null,
    booked_to date not null
);

  CREATE TABLE Hotel (
    hotel_Id integer identity primary key,
    name varchar(200) not null,
    type varchar(50) not null,
    booked_from date not null,
    booked_to date not null
);
 
  CREATE TABLE Passenger (
    passenger_Id integer  not null,
    name varchar(200) not null,
    flight_Id varchar(50) not null,
    hotel_Id integer not null
);

 
