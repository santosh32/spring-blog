INSERT INTO Flight (flight_Id, name, type) VALUES (100,'Lufthansa', 'business')
INSERT INTO Flight (flight_Id, name, type) VALUES (101,'Emirates Air', 'business')
INSERT INTO Flight (flight_Id, name, type) VALUES (102,'Swiss International Airlines', 'business')
INSERT INTO Flight (flight_Id, name, type) VALUES (103,'Singapore Airlines', 'business')
INSERT INTO Flight (flight_Id, name, type) VALUES (104,'Thai Airways', 'business')
INSERT INTO Flight (flight_Id, name, type) VALUES (105,'Cathay Pacific Airways', 'business')
INSERT INTO Flight (flight_Id, name, type) VALUES (106,'Air New Zealand', 'business')
INSERT INTO Flight (flight_Id, name, type) VALUES (107,'British airways', 'business')
INSERT INTO Flight (flight_Id, name, type) VALUES (108,'China Southern Airlines', 'business')
INSERT INTO Flight (flight_Id, name, type) VALUES (109,'Airasia', 'business')
INSERT INTO Flight (flight_Id, name, type) VALUES (110,'Virgin Atlantic', 'business')

INSERT INTO Hotel (Hotel_Id, name, type) VALUES (200,'Radisson Montevideo Victoria Plaza Hotel', 'business')
INSERT INTO Hotel (Hotel_Id, name, type) VALUES (201,'Hotel Carrasco', 'business')
INSERT INTO Hotel (Hotel_Id, name, type) VALUES (202,'Casapueblo', 'business')
INSERT INTO Hotel (Hotel_Id, name, type) VALUES (203,'Emirates Towers', 'business')
INSERT INTO Hotel (Hotel_Id, name, type) VALUES (204,'Burj Al Arab', 'business')
INSERT INTO Hotel (Hotel_Id, name, type) VALUES (205,'Claremont Resort', 'business')
INSERT INTO Hotel (Hotel_Id, name, type) VALUES (206,'Colony Palms Hotel', 'business')
INSERT INTO Hotel (Hotel_Id, name, type) VALUES (207,'Hilton Waterfront Beach Resort', 'business')
INSERT INTO Hotel (Hotel_Id, name, type) VALUES (208,'San Diego Marriott Hotel and Marina', 'business')
INSERT INTO Hotel (Hotel_Id, name, type) VALUES (209,'Downtown Standard Hotel', 'business')
INSERT INTO Hotel (Hotel_Id, name, type) VALUES (210,'Park Plaza Hotel', 'business')

INSERT INTO Passenger (passenger_Id, name) VALUES (1000,'James Bond')
INSERT INTO Hotel_Passenger (Hotel_Id, passenger_Id) VALUES (208, 1000)
INSERT INTO Flight_Passenger (flight_Id, passenger_Id) VALUES (209, 1000)







