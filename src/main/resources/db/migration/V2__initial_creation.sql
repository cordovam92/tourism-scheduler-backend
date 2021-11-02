CREATE TABLE players (
    first_name varchar(50),
    last_name varchar(50),
    team varchar(50),
    position varchar(50),
    games_played INT,
    PRIMARY KEY (first_name, last_name, position)
);

CREATE TABLE passing(
    f_name varchar(50),
    l_name varchar(50),
    pos varchar(50),
    attempts INT,
    completions INT,
    yards INT,
    touchdowns INT,
    interceptions INT,
    PRIMARY KEY (f_name, l_name, pos),
    FOREIGN KEY (f_name, l_name, pos)
        REFERENCES players (first_name, last_name, position)
);

CREATE TABLE rushing(
    f_name varchar(50),
    l_name varchar(50),
    pos varchar(50),
    attempts INT,
    yards INT,
    touchdowns INT,
    fumbles INT,
    PRIMARY KEY (f_name, l_name, pos),
    FOREIGN KEY (f_name, l_name, pos)
        REFERENCES players (first_name, last_name, position)
);

CREATE TABLE receiving(
    f_name varchar(50),
    l_name varchar(50),
    pos varchar(50),
    receptions INT,
    targets INT,
    yards INT,
    touchdowns INT,
    fumbles INT,
    PRIMARY KEY (f_name, l_name, pos),
    FOREIGN KEY (f_name, l_name, pos)
        REFERENCES players (first_name, last_name, position)
);

CREATE TABLE defense(
    f_name varchar(50),
    l_name varchar(50),
    pos varchar(50),
    tackles FLOAT,
    sacks FLOAT,
    tackles_for_loss FLOAT,
    interceptions INT,
    forced_fumbles INT,
    PRIMARY KEY (f_name, l_name, pos),
    FOREIGN KEY (f_name, l_name, pos)
        REFERENCES players (first_name, last_name, position)
);

