create database if not exists cloud;

create table if not exists cloud.ratings(
	id bigint(20) auto_increment, 
	accomodation_id bigint(20) not null,
	user_id varchar(255),
    agent varchar(255) not null,
    rating int not null,
	comment varchar(500) not null,
    approved bit(1) default 0,
    reviewed bit(1) default 0,
	primary key (id),
    check (rating > 0 && rating <= 10)
);