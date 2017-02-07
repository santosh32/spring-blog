   CREATE TABLE CUSTOMER (
    customerId integer identity primary key,
    contact varchar(50) not null,
    address varchar(255),
    city varchar(50) not null,
    firstOrder varchar(50) not null,
    state varchar(30) not null,
    zipCode varchar(50) not null,
    country varchar(255),
    phone varchar(50) not null,
    name varchar(30) not null
);

  CREATE TABLE Employee (
    empId integer identity primary key,
    hireDate varchar(50) not null,
    salary varchar(255),
    dept varchar(50) not null,
    jobcode varchar(50) not null,
    sex varchar(30) not null,  
    birthDate varchar(50) not null,
    lastName varchar(255),
    firstName varchar(50) not null,
    middleName varchar(50) not null,
    phone varchar(30) not null
);

 
