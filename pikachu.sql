CREATE DATABASE pikachu;
use pikachu;
#DROP DATABASE pikachu;

CREATE TABLE user (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255) NOT NULL,
    Username VARCHAR(255) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Score INT NOT NULL DEFAULT 0,
    State INT NOT NULL
);

CREATE TABLE game (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    TimeFinish TIME NOT NULL
);

CREATE TABLE game_detail (
    IDGame INT,
    IDPlayer INT,
    Point FLOAT,
    
    FOREIGN KEY (IDGame) REFERENCES game (ID),
    FOREIGN KEY (IDPlayer) REFERENCES user (ID)
);