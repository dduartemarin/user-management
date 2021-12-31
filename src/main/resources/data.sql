create table userm (
id integer generated by default as identity, 
created_timestamp timestamp, 
updated_timestamp timestamp, 
lastLogin_timestamp timestamp, 
name varchar(255), 
email varchar(255), 
is_active boolean, 
password varchar(255), 
token varchar(255), 
primary key (id));

create table phone (
id integer generated by default as identity, 
number varchar(25), 
city_code integer, 
country_code integer, 
primary key (id));

ALTER TABLE phone ADD CONSTRAINT FK_USERM FOREIGN KEY (id) REFERENCES userm(id);
