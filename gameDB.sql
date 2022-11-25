drop database if exists Game;
create database Game;
use Game;

create table Publisher(
name varchar(30) NOT NULL,
country varchar(30),
primary key(name)
);

insert into Publisher(name, country) values
("Nintendo", "Japan"),
("Sony", "Japan"),
("Microsoft", "United States"),
("Ubisoft", "France"),
("EA", "United States"),
("Activision", "United States"),
("Capcom", "Japan"),
("Bandai Namco", "Japan"),
("Take-Two", "United States");

create table Games(
gID int primary key auto_increment,
releaseDate Date,
gameName varchar(30) NOT NULL,
score int,
pubName varchar(30),
foreign key(pubName) references Publisher(name)
);

insert into Games(gameName, pubName, releaseDate, score) values
("Pokemon Scarlet", "Nintendo", "2022-11-18", 77), #1
("Pokemon Violet", "Nintendo", "2022-11-18", 77),
("Mario Kart 8: Deluxe", "Nintendo", "2017-04-27", 92),
("Zelda: Breath of the Wild", "Nintendo", "2017-03-03", 97), 
("God of War: Ragnarok", "Sony", "2022-11-09", 94), #5
("Resident Evil 4", "Capcom", "2023-03-24", null),
("Halo Infinite", "Microsoft", "2021-11-15", 87),
("Minecraft", "Microsoft", "2011-11-18", 93),
("Elden Ring", "Bandai Namco", "2022-02-25", 96),
("Hades", "Take-Two", "2018-12-06", 93), #10
("Far Cry 6", "Ubisoft", "2021-10-06", 74),
("Assassin's Creed Valhalla", "Ubisoft", "2020-11-10", 82),
("Apex Legends", "EA", "2019-02-04", 88),
("EA SPORTS FIFA 23", "EA", "2022-09-26", 76),
("CoD: Modern Warfare II", "Activision", "2022-10-28", 77), #15
("Tony Hawk Pro Skater", "Activision", "2021-06-25", 89),
("Monster Hunter Rise", "Capcom", "2021-03-26", 88),
("One Piece Odyssey", "Bandai Namco", "2023-01-12", null),
("NBA 2K23", "Take-Two", "2022-09-08", 78),
("Returnal", "Sony", "2021-04-30", 86), #20
("Super Mario Odyssey", "Nintendo", "2017-10-27", 97),
("Starfield", "Microsoft", "2023-12-31", null),
("Forza Horizon 5", "Microsoft", "2021-11-05", 92),
("The Last of Us Part 1", "Sony", "2022-09-02", 88),
("Zelda: Tears of the Kingdom", "Nintendo", "2023-05-12", null); #25

create table Platform(
releaseDate date,
pName varchar(30) NOT NULL,
company varchar(30),
primary key (pName)
);

insert into Platform(pName, company, releaseDate) values
("Playstation 5", "Sony", "2020-11-12"),
("Xbox Series X", "Microsoft", "2020-11-10"),
("Nintendo Switch", "Nintendo", "2017-03-04"); 

create table GamePlatform(
gID int,
pName varchar(30),
foreign key(gID) references Games(gID),
foreign key(pName) references Platform(pName),
constraint primary key(gID, pName)
);

insert into GamePlatform(gID, pName) values
(1, "Nintendo Switch"), ##pokemon
(2, "Nintendo Switch"), ##pokemon
(3, "Nintendo Switch"), ##mk8
(4, "Nintendo Switch"), ##botw
(5, "Playstation 5"), ##gow
(6, "Playstation 5"), ##re4
(6, "Xbox Series X"), 
(7, "Xbox Series X"), ##halo
(8, "Nintendo Switch"), ##minecraft
(8, "Playstation 5"),
(8, "Xbox Series X"),
(9, "Playstation 5"), ##elden ring
(9, "Xbox Series X"),
(10, "Nintendo Switch"), ##hades
(10, "Playstation 5"),
(10, "Xbox Series X"),
(11, "Playstation 5"), ##far cry
(11, "Xbox Series X"),
(12, "Playstation 5"), ##assassin
(12, "Xbox Series X"),
(13, "Xbox Series X"), ##apex
(13, "Nintendo Switch"),
(13, "Playstation 5"),
(14, "Xbox Series X"),##fifa
(14, "Playstation 5"),
(15, "Xbox Series X"), ##cod
(15, "Playstation 5"),
(16, "Xbox Series X"),##tony hawk
(16, "Nintendo Switch"),
(16, "Playstation 5"),
(17, "Nintendo Switch"),##mhr
(18, "Playstation 5"),##onepiece
(18, "Xbox Series X"),
(19, "Playstation 5"),##2k
(19, "Xbox Series X"),
(20, "Playstation 5"),##returnal
(21, "Nintendo Switch"), ##mario
(22, "Xbox Series X"), ##starfield
(23, "Xbox Series X"),#forza
(24, "Playstation 5"), #tlou
(25, "Nintendo Switch");#totk

#game to gameplatform
#select gameName, pName from Games, GamePlatform where Games.gID = GamePlatform.gID;

#game, release date, platform
#select distinct gameName, releaseDate, pName from Games, GamePlatform where releaseDate > 2020 AND Games.gID = GamePlatform.gID GROUP BY gameName;

#total number of games over 90 score by platform
#select  pName, COUNT(Games.gID) from Games, GamePlatform where Games.gID = GamePlatform.gID AND Games.score > 90 GROUP BY pName;

create table Staff(
staffID int primary key,
staffName varchar(30),
staffUN varchar(15),
staffPW varchar(44),
staffPerms int # 0 = view only, 1 = edit games, 2 = admin (edit users)
);

insert into Staff(staffID, staffName, staffUN, staffPW, staffPerms) values
(000, "Bryan Benham", "bcb046", "10/w7o2juYBrGMh32/KbveULW9jk2tejpyUAD+uC6PE=", 1), # password = 'pass'
(001, "Stephen Badeaux", "stbx26", "mMHrTuk0dnQ3Y4ePy5aiX7yaF1B01kAEd57LUkL2ReY=", 1), # password = 'word'
(002, "William Pearce", "wpp004", "AfgDJ+8oovHD3atkwTiyaAQgT11tnWeiP2F7lj/+bLg=", 2), # password = 'very-secure'
(003, "Dummy", "dummy", "taLJYlBhI2bqJy/6xtl0Sq9LRarNlqp8/Lkx7jtVglk=", 0); # password = 'dummy'


create table Sale(
sNo int primary key auto_increment,
saleDate date,
sRegion varchar(15),
staffID int,
foreign key(staffID) references Staff(staffID)
);

insert into Sale(saleDate, sRegion, staffID) values
("2022-11-17", "North America", 000), #1
("2022-11-21", "North America", 001),
("2022-11-18", "North America", 000),
("2022-11-22", "Europe", 000),
("2022-11-19", "North America", 000), #5
("2022-09-23", "Europe", 001),
("2020-12-12", "Asia", 000),
("2020-05-14", "Asia", 001),
("2020-11-22", "North America", 001),
("2022-01-01", "North America", 000), #10
("2022-03-30", "Asia", 001),
("2021-10-31", "Australia", 001),
("2021-07-04", "Europe", 000),
("2021-08-16", "Europe", 001),
("2021-04-27", "Japan", 001); #15

create table saleItems(
sNo int,
gID int,
sPrice double,
foreign key(sNO) references Sale(sNo),
foreign key(gID) references Games(gID),
primary key(sNo, gID)
);

insert into saleItems(sNo, gID, sPrice) values
(1, 1, 60),
(1, 2, 60),
(2, 1, 60),
(2, 2, 60),
(2, 7, 60),
(3, 1, 60),
(3, 2, 60),
(3, 3, 60),
(3, 4, 60),
(3, 21, 60),
(3, 25, 60),
(4, 1, 60),
(4, 5, 60),
(4, 6, 60),
(5, 15, 70),
(5, 19, 60),
(5, 9, 60),
(6, 9, 60),
(6, 14, 60),
(7, 20, 70),
(7, 5, 70),
(8, 18, 60),
(9, 10, 20),
(9, 1, 60),
(10, 11, 60),
(11, 13, null),
(11, 22, 60),
(11, 9, 60),
(11, 6, 60),
(12, 13, null),
(13, 24, 70),
(13, 12, 60);

create table PreOwned(
sNo int,
gID int,
usedPrice varchar(3),
constraint foreign key(sNo) references Sale(sNo),
primary key(sNo, gID)
);

insert into PreOwned(sNo, gID, usedPrice) values
(2, 7, 20),
(5, 19, 30),
(10, 11, 15),
(13, 12, 20),
(6, 14, 45),
(3, 3, 45),
(3, 4, 45),
(7, 20, 50);


#list all relevant game sale data
#select saleItems.sNo, Games.gID, gameName, sPrice, usedPrice, saleDate, sRegion, staffName from Games, Staff, Sale, saleItems LEFT JOIN Preowned ON PreOwned.sNo = saleItems.sNo AND PreOwned.gID = saleItems.gID where 
#Games.gID = saleItems.gID AND Sale.staffID = Staff.staffID AND Sale.sNo = saleItems.sNo GROUP BY Games.gID, saleItems.sNo;

#total sales by platform
#select GamePlatform.pName, COUNT(saleItems.gID) from GamePlatform INNER JOIN saleItems ON saleItems.gID = GamePlatform.gID GROUP BY GamePlatform.pName;

#total sales by staff
#select staffName, COUNT(Sale.sNo) from Staff, Sale where Sale.staffID = Staff.staffID GROUP BY staffName;

#list games that are free
#select Games.gameName from Games, saleItems where Games.gID = saleItems.gID AND saleItems.sPrice is null GROUP BY Games.gameName;