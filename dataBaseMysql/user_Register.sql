USE user_register;
/*
Old Version
CREATE TABLE userRegister(
userId1 INT, 

name VARCHAR(25), 
lastName VARCHAR(25), 
email VARCHAR(25), 
phoneNumber VARCHAR(25), 
address VARCHAR(25), 
zipCode VARCHAR(25)

);
*/

#INSERT INTO userRegister (userId) VALUES ('Marcelo','Veintimilla','marceloV42@gmail.com','1123456789', '44rett', 'E3RK22');
#INSERT INTO userRegister (userId) VALUES ('Marcelo','Veintimilla','marceloV42@gmail.com','1123456789', '44rett', 'E3RK22');

CREATE TABLE userRegister(
id INT UNSIGNED UNIQUE AUTO_INCREMENT PRIMARY KEY NOT NULL, 
userName VARCHAR(50) NOT NULL,
lastName VARCHAR(50) NOT NULL,
emial VARCHAR(100) NOT NULL UNIQUE,
phoneNumber VARCHAR(15) NOT NULL,
address VARCHAR(100) NOT NULL,
zipCode VARCHAR(10) NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO userRegister (userName, lastName, emial, phoneNumber, address, zipCode) VALUES ('Marcelo', 'Veintimilla','marcelov47@gmail.com','1234567891','23 eewr ST.', 'E1WE3');

SELECT * FROM userRegister;

DROP TABLE IF EXISTS userRegister;


