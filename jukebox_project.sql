CREATE DATABASE IF NOT EXISTS Jukebox_Project;
USE Jukebox_Project;
CREATE TABLE Music(Song_id int primary key auto_increment,Title varchar(50),Genre varchar(50),Duration varchar(50),Artist varchar(50),Realease_Date varchar(50));
INSERT INTO Music values(1,'Prachand','Devotional', '00:00:45', 'PiyushMishra','21/9/2009');
INSERT INTO Music(Title,Genre,Duration,Artist,Realease_Date) values('BrownMundey','Punjabi', '00:00:45', 'APDhillon','10/08/2020');
INSERT INTO Music(Title,Genre,Duration,Artist,Realease_Date)  values('Enemy','Rapping', '00:00:35', 'AaronMaron','10/4/21');
INSERT INTO Music(Title,Genre,Duration,Artist,Realease_Date) values('SilenceOfReality','HeavyMetal', '00:00:40', 'Durmus','4/8/2019');
INSERT INTO Music(Title,Genre,Duration,Artist,Realease_Date)  values('PirateOfCaribean','HeavyMetal', '00:00:34', 'tic','1/9/2017');
INSERT INTO Music(Title,Genre,Duration,Artist,Realease_Date)  values('HarHarShambhu','Devotional', '00:00:30', 'PiyushMishra','16/7/2021');
INSERT INTO Music(Title,Genre,Duration,Artist,Realease_Date)  values('Believer','Rock', '00:00:30', 'Imagine Dragon','1/2/2017');
INSERT INTO Music(Title,Genre,Duration,Artist,Realease_Date)  values('LikheKhatTujhe','Romantic', '00:02:30', 'Aman','26/10/2021');

CREATE TABLE PlayList(Playlist_Id int primary key , Playlist_Name varchar(50));
CREATE TABLE PlaylistData(Playlist_Id int,foreign key(Playlist_Id) references PlayList(Playlist_Id),Song_id int,foreign key(Song_id) references Music(Song_id));






