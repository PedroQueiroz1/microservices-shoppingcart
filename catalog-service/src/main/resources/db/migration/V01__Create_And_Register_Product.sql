CREATE TABLE product (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR NOT NULL,
description VARCHAR NOT NULL,
price DECIMAL(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO product (name,description,price) VALUES ('Estojo','Estojo grande para guardar material','10.00');
INSERT INTO product (name,description,price) VALUES ('Pulseira','Pulseira de madeira','15.00');
INSERT INTO product (name,description,price) VALUES ('Jogo de tabuleiro','Jogo aleatório','100.00');
