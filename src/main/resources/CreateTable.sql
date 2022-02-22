create table if not exists employee(id bigserial primary  key,firstname varchar (50),lastname varchar(50),username varchar (50),password varchar (50));
create table if not exists prof(id bigserial primary key,firstname varchar (50),lastname varchar(50),username varchar (50),password varchar (50));
create table if not exists student(id bigserial primary key,firstname varchar (50),lastname varchar(50),username varchar (50),password varchar (50));
create table if not exists course(id bigserial primary key,coursename varchar (50),profid integer ,yearofcourse integer,term integer,unit integer,
    constraint fk_customer foreign key (profid) references prof(id));
create table if not exists studentscourses(id bigserial,courseid integer ,studentid integer,
constraint fk_customer foreign key (courseid) references course(id),foreign key (studentid) references student(id));