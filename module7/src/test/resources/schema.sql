CREATE TABLE BOOKS (
	id BIGINT auto_increment primary key,
	name VARCHAR(50),
	author VARCHAR(50),
	publish_date DATE NULL,
	price NUMERIC
);