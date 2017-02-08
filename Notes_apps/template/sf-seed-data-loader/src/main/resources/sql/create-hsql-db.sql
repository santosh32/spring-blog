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
    name varchar(500) not null
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

CREATE TABLE Invoice (invoiceId integer identity primary key, 
  billedTo varchar(500) not null, 
  amtBilled varchar(500) not null, 
  country varchar(500) not null, 
  amtInUS varchar(500) not null, 
  billedBy varchar(500) not null, 
  billedOn varchar(500) not null, 
  paidOn varchar(500) not null );
  
  
CREATE TABLE Staff (staffId integer identity primary key, 
  lLame varchar(500) not null, 
  fName varchar(500) not null, 
  city varchar(500) not null, 
  state varchar(500) not null, 
  hPhone varchar(500) not null );
  
  CREATE TABLE OrderItem (orderId integer identity primary key, 
  stockId varchar(500) not null, 
  length varchar(500) not null, 
  fabCharges varchar(500) not null, 
  shipTo varchar(500) not null, 
  orderDate varchar(500) not null, 
  shipped varchar(500) not null, 
  takenBy varchar(500) not null, 
  proccessdBy varchar(500) not null, 
  specinstr varchar(500) not null );



 
