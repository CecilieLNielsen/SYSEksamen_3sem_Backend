INSERT INTO COUNTRY (ID, COUNTRYNAME) VALUES 
(1, 'Dubai'),
(2, 'Iceland'),
(3, 'China'),
(4, 'France'),
(5, 'England'), 
(6, 'Spain') ;


INSERT INTO AIRPORT (ID,AIRPORTNAME, COUNTRY_ID) VALUES 
(1, 'Dubai International Airport', 1), 
(2, 'Reykjavík–Keflavík Airport', 2), 
(3, 'Beijing Capital International Airport', 3), 
(4, 'Marseille Provence Airport', 4), 
(5, 'London Heathrow Airport', 5), 
(6, 'Barcelona–El Prat Airport', 6) ;


INSERT INTO FLIGHT (FLIGHTID, ARRIVAL, DEPARTURE, PRICE, DESTINATIONAIRPORT_ID, TAKEOFFAIRPORT_ID) VALUES 
(1, '2021-01-07', '2021-01-07', 62, 1, 6),
(2, '2021-01-06', '2021-01-06', 53, 2, 5),
(3, '2021-01-05', '2021-01-05', 47, 4, 3),
(4, '2021-01-05', '2021-01-05', 52, 3, 4),
(5, '2021-01-04', '2021-01-04', 59, 6, 1),
(6, '2021-01-03', '2021-01-03', 51, 5, 2);


INSERT INTO PASSENGER (ID, EMAIL, FIRSTNAME, LASTNAME, PHONENUMBER) VALUES 
(1,'HellenGate@hotmail.com','Hellen','Gate', 64738295),
(2,'PeterHome123@gmail.com','Peter','Hendersson',96739584),
(3,'DaveBusiness@outlook.com','Dave','Hallaway','26354737'),
(4,'Sona123@gmail.com','Sona','Petersen','86948576'),
(5,'LinkHazel@hotmail.com','Link','Hazel','26384657'),
(6,'TogaWay@gmail.com','Tess','Gallaway','94837263');


INSERT INTO BOOKING (ID, CREATED, FLIGHT_FLIGHTID, PASSENGERINFO_ID) VALUES 
(1,'2021-01-01',1,1),
(2,'2021-01-01',1,2),
(3,'2021-01-01',1,3),
(4,'2021-01-01',2,4),
(5,'2021-01-01',3,5),
(6,'2021-01-01',4,6);