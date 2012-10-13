drop table personTbl if exists;


create table personTbl (personId integer identity primary key, personFirstName varchar(50) not null, personLastName varchar(50) not null );
