DROP DATABASE IF EXISTS amt;
CREATE DATABASE amt;
USE amt;

CREATE TABLE user(
	id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(16) UNIQUE,
    firstName VARCHAR(16),
    lastName VARCHAR(16),
    email VARCHAR(32),
    password VARCHAR(16)	
);