CREATE TABLE person (
    id serial primary key not null,
    first_name varchar(100),
    last_name varchar(100),
    dob varchar(50),
    ssn varchar(50),
    gender varchar(20)
);
