CREATE TABLE inventory (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	product_id BIGINT NOT NULL,
	quantity INTEGER NOT NULL,
	FOREIGN KEY (product_id) REFERENCES product(id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO inventory (product_id,quantity) VALUES (1,10);
INSERT INTO inventory (product_id,quantity) VALUES (2,34);
INSERT INTO inventory (product_id,quantity) VALUES (3,5);