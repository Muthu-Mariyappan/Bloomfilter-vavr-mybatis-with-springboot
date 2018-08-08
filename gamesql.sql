delimiter ;

DROP table IF EXISTS games ;
create table games(id int primary key AUTO_INCREMENT,name varchar(30)not null,price int not null) ;

insert into games Values(0,'AC origins',5000) ;
insert into games Values(0,'Dota 2',3000) ;
insert into games Values(0,'Injustice 2',3000) ;
insert into games Values(0,'Final fantasy XV',6000) ;
insert into games Values(0,'Warcraft 3',1500) ;