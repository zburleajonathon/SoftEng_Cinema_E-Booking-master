
show databases;
use termprojdb;
select * from Customer;

-- Everyone add an admin account here if you want
-- Aaron:
insert into User (email) values ('aaronAdmin@gmail.com');
insert into Administrator set adminPassword = 'aaron',
userID = (select userID from User where email = 'aaronAdmin@gmail.com'),
adminEmail = 'aaronAdmin@gmail.com';
-- Kyle:
insert into User (email) values ('kjacks89@gmail.com');
insert into Administrator set adminPassword = 'password',
userID = (select userID from User where email = 'kjacks89@gmail.com'),
adminEmail = 'kjacks89@gmail.com';
-- James:
insert into User (email) values ('jyg25523@gmail.com');
insert into Administrator set adminPassword = 'gong',
userID = (select userID from User where email = 'jyg25523@gmail.com'),
adminEmail = 'jyg25523@gmail.com';

-- Customers for testing login and edit profile
insert into User (email) values ('user2@gmail.com');
insert into Customer (userID, customerEmail, password, firstName, lastName, phoneNumber,
status, age, subToPromo) values ((select userID from User where email = 'user2@gmail.com'), 
'user2@gmail.com', 'password', 'Test', 'User', '770-789-6543', 'Active', 'Adult', true);
insert into Address (street, city, state, zip, userID) values ('1234 Main Street',
'Conyers', 'GA', 30094, (select userID from Customer where customerEmail = 'user2@gmail.com'));


-- Create TicketTypes
insert into TicketType (type, price) values ('EVEADULT', 10.79);
insert into TicketType (type, price) values ('MATADULT', 8.49);
insert into TicketType (type, price) values ('CHILD', 7.79);
insert into TicketType (type, price) values ('SENIOR', 8.29);

-- Create Promos
insert into Promos (promoName, promoRate) values('YOUSAVE10', 0.10);
insert into Promos (promoName, promoRate) values('YOUSAVE25', 0.25);
insert into Promos set promoName = 'UGA50', promoRate = '.5';
insert into Promos set promoName = 'SALEH25', promoRate = '.25';

-- Create Halls
insert into Hall set name = 'H1', numOfSeats = 120;
insert into Hall set name = 'H2', numOfSeats = 120;

-- Insert 120 seats into each hall
drop procedure if exists insertSeats1;
delimiter //
CREATE PROCEDURE insertSeats1()
BEGIN
	DECLARE i int DEFAULT 1;
	WHILE i <= 120 DO
	      insert into Seat set hallID = (select hallID from Hall where name = 'H1'), seatNum = i;
	      SET i = i + 1;
	END WHILE;
END;
//
delimiter ;
call insertSeats1();

drop procedure if exists insertSeats2;
delimiter //
CREATE PROCEDURE insertSeats2()
BEGIN
	DECLARE i int DEFAULT 1;
	WHILE i <= 120 DO
	      insert into Seat set hallID = (select hallID from Hall where name = 'H2'), seatNum = i;
	      SET i = i + 1;
	END WHILE;
END;
//
delimiter ;
call insertSeats2();

-- Create Movies (only adding 8 cast members per movie)
insert into Movie (name, trailer, cast, rating, genre, review, runtimeMins)
values ('Venom', 'https://www.youtube.com/watch?v=xLCn88bfW1o', 'Tom Hardy, Michelle Williams, Riz Ahmed, 
Scott Haze, Reid Scott, Jenny Slate, Melora Walters, Woody Harrelson', 'PG-13',
'SciFi', '8.2', 140);  
insert into Movie (name, trailer, cast, rating, genre, review, runtimeMins)
values ('Creed II', 'https://www.youtube.com/watch?v=u22BXhMu4tI', 'Michael B Jordan, Sylvester Stallone, Tessa Thompson,
Phylicia Rashad, Dolph Lundgren, Florian Munteanu, Russell Honrsby, Wood Harris', 'PG-13',
'Drama', '8.4', 130);  
insert into Movie (name, trailer, cast, rating, genre, review, runtimeMins)
values ('Widows', 'https://www.youtube.com/watch?v=nN2yBBSRC78', 'Viola Davis, Liam Neeson, Jon Bernthal, Manueal Garcia-Rulfo, 
Coburn Goss, Michelle Rodrigues, Alejandro Verdin, Bailey Rhyse Walters', 'R',
'Thriller', '7.1', 130);  
insert into Movie (name, trailer, cast, rating, genre, review, runtimeMins)
values ('The Grinch', 'https://www.youtube.com/watch?v=_UOh0UX3alI', 'Benedict Cumberbatch, Cameron Seely, Rashida Jones, 
Pharrell Williams, Tristan OHare, Kenan Thompson, Sam Lavagnino, Ramone Hamilton', 'PG',
'Family Film', '9.1', 126);  
insert into Movie (name, trailer, cast, rating, genre, review, runtimeMins)
values ('Ralph Breaks The Internet', 'https://www.youtube.com/watch?v=T73h5bmD8Dc', 'John C Reilly, Sarah Silverman, Gal Gadot, 
Taraji P Henson, Jack McBrayer, Jane Lynch, Alan Tudyk, Alfred Molina', 'PG',
'Family Film', '8.0', 118);  
insert into Movie (name, trailer, cast, rating, genre, review, runtimeMins)
values ('Tyrel', 'https://www.youtube.com/watch?v=QQiSXQdfQBM', 'Jason Mitchell, Christopher Abbott, Michael Cera, Caleb Landry, Michael Zegen, Philip Ettinger', 'NR', 'Drama', 'NA', '86');
insert into Movie (name, trailer, cast, rating, genre, review, runtimeMins)
values ('Ben Is Back', 'https://www.youtube.com/watch?v=MI9NdYktzfE', 'Julia Roberts, Lucas Hedges, Courtney Vance, Kathryn Newton, Alexandra Park', 'R', 'Drama', '7.2', 103);
insert into Movie (name, trailer, cast, rating, genre, review, runtimeMins)
values ('Mortal Engines', 'https://www.youtube.com/watch?v=IRsFc2gguEg', 'Hugo Weaving, Hera Hilmar, Robert Sheehan, Jihae Fang, Ronan Raftery, Leila George', 'PG-13', 'Action and Adventure', 'NA', '91');
insert into Movie (name, trailer, cast, rating, genre, review, runtimeMins)
values ('Once Upon a Deadpool', 'https://www.youtube.com/watch?v=PCf03KXyzIg', 'Ryan Reynolds, Fred Savage, Josh Bolin, Morena Baccarin, Julian Dennison, Zazie Beetz', 'PG-13', 'Comedy', 'NA', '116');

-- Add Showtimes
-- Hall 1, 28th, 1100, Venom
insert into Showtime set date = '11/28/18', time = '1100', showStatus = 'Valid',
movieID = (select movieID from Movie where name = 'Venom'),
hallID = (select hallID from Hall where name = 'H1'),
remainingSeats = (select numOfSeats from Hall where name ='H1');

-- Hall 1, 28th, 1500, Venom
insert into Showtime set date = '11/28/18', time = '1500', showStatus = 'Valid',
movieID = (select movieID from Movie where name = 'Venom'),
hallID = (select hallID from Hall where name = 'H1'),
remainingSeats = (select numOfSeats from Hall where name ='H1');

-- Hall 1, 28th, 1900, Venom
insert into Showtime set date = '11/28/18', time = '1900', showStatus = 'Valid',
movieID = (select movieID from Movie where name = 'Venom'),
hallID = (select hallID from Hall where name = 'H1'),
remainingSeats = (select numOfSeats from Hall where name ='H1');

-- Hall 2, 28th, 1300, Creed II
insert into Showtime set date = '11/28/18', time = '1300', showStatus = 'Valid',
movieID = (select movieID from Movie where name = 'Creed II'),
hallID = (select hallID from Hall where name = 'H2'),
remainingSeats = (select numOfSeats from Hall where name ='H2');

-- Hall 1, 28th, 1700, The Grinch
insert into Showtime set date = '11/28/18', time = '1700', showStatus = 'Valid',
movieID = (select movieID from Movie where name = 'Venom'),
hallID = (select hallID from Hall where name = 'H1'),
remainingSeats = (select numOfSeats from Hall where name ='H1');

-- Hall 2, 28th, 2100, Ralph Breaks the Internet
insert into Showtime set date = '11/28/18', time = '2100', showStatus = 'Valid',
movieID = (select movieID from Movie where name = 'Ralph Breaks the Internet'),
hallID = (select hallID from Hall where name = 'H2'),
remainingSeats = (select numOfSeats from Hall where name ='H2');

-- Hall 1, 29th 1100, Widows
insert into Showtime set date = '11/29/18', time = '1100', showStatus = 'Valid',
movieID = (select movieID from Movie where name = 'Widows'),
hallID = (select hallID from Hall where name = 'H1'),
remainingSeats = (select numOfSeats from Hall where name ='H1');

-- Hall 2, 29th, 1500, Tyrel
insert into Showtime set date = '11/29/18', time = '1500', showStatus = 'Valid',
movieID = (select movieID from Movie where name = 'Tyrel'),
hallID = (select hallID from Hall where name = 'H2'),
remainingSeats = (select numOfSeats from Hall where name ='H2');



