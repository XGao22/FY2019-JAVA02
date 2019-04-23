create table student(
	id int(4) primary key,
	name varchar(20),
	password varchar(20),
	sex varchar(10),
	registerTimeStamp timestamp    default current_timestamp,
	lastedSetTimeStamp timestamp   default current_timestamp on update current_timestamp
)

create table admin(
	username varchar(20),
	password varchar(20),
	id int,
	registerTimeStamp timestamp,
	lastedLoginTimeStamp timestamp default current_timestamp
	)

create table student(
	id int(4) primary key,
	name varchar(20),
	password varchar(20),
	sex varchar(10),
	strRegisterTime datetime,
	strLastedSetTime datetime,
	registerTimeStamp timestamp  on update CURRENT_TIMESTAMP,
	lastedSetTimeStamp timestamp
)

insert into student(id,name,password,sex,registerTimeStamp,lastedSetTimeStamp)
values(1,"Cech","Cech","male",now(),now()),(2,"Ivanovic","ivanovic","male",now(),now())

insert into student(id,name,password,sex,registerTimeStamp,lastedSetTimeStamp)
values(3,"admin","admin","male",now(),now()),(11,"Drogba","drogba","male",now(),now()),(8,"Lampard","lampard","male",now(),now())
,(26,"Terry","terry","male",now(),now())

update student set name="Oscar",password="oscar",sex="female" where id = 8

delete from student where id = 1
