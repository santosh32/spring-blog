  CREATE TABLE Flight (
    flight_Id integer identity primary key,
    name varchar(50) not null,
    type varchar(50) not null,
    booked_from date not null,
    booked_to date not null
);
 