DROP TABLE passing;
DROP TABLE rushing;
DROP TABLE receiving;
DROP TABLE defense;
DROP TABLE players;

CREATE TABLE players (
    id serial primary key not null,
    first_name varchar(50),
    last_name varchar(50),
    team varchar(50),
    position varchar(50),
    games_played INT,
    UNIQUE (first_name, last_name, position)
);

CREATE TABLE passing(
    id serial primary key not null,
    f_name varchar(50),
    l_name varchar(50),
    pos varchar(50),
    attempts INT,
    completions INT,
    yards INT,
    touchdowns INT,
    interceptions INT,
    UNIQUE (f_name, l_name, pos),
    FOREIGN KEY (f_name, l_name, pos)
        REFERENCES players (first_name, last_name, position)
);

CREATE TABLE rushing(
    id serial primary key not null,
    f_name varchar(50),
    l_name varchar(50),
    pos varchar(50),
    attempts INT,
    yards INT,
    touchdowns INT,
    fumbles INT,
    UNIQUE (f_name, l_name, pos),
    FOREIGN KEY (f_name, l_name, pos)
        REFERENCES players (first_name, last_name, position)
);

CREATE TABLE receiving(
    id serial primary key not null,
    f_name varchar(50),
    l_name varchar(50),
    pos varchar(50),
    receptions INT,
    targets INT,
    yards INT,
    touchdowns INT,
    fumbles INT,
    UNIQUE (f_name, l_name, pos),
    FOREIGN KEY (f_name, l_name, pos)
        REFERENCES players (first_name, last_name, position)
);

CREATE TABLE defense(
    id serial primary key not null,
    f_name varchar(50),
    l_name varchar(50),
    pos varchar(50),
    tackles FLOAT,
    sacks FLOAT,
    tackles_for_loss FLOAT,
    interceptions INT,
    forced_fumbles INT,
    UNIQUE (f_name, l_name, pos),
    FOREIGN KEY (f_name, l_name, pos)
        REFERENCES players (first_name, last_name, position)
);


