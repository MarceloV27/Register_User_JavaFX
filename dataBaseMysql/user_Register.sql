USE user_register;

CREATE TABLE userRegister(
id INT UNSIGNED UNIQUE AUTO_INCREMENT PRIMARY KEY NOT NULL, 
userName VARCHAR(50) NOT NULL,
lastName VARCHAR(50) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE,
phoneNumber VARCHAR(15) NOT NULL,
address VARCHAR(100) NOT NULL,
zipCode VARCHAR(10) NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO userRegister (userName, lastName, emial, phoneNumber, address, zipCode)
VALUES ('Marcelo', 'Veintimilla','marcelov47@gmail.com','1234567891','23 eewr ST.', 'E1WE3');

SELECT * FROM userRegister;

DROP TABLE IF EXISTS userRegister;


