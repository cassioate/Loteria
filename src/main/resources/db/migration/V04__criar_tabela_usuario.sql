CREATE TABLE Users (
	id SERIAL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(500),
	constraint pk_usuario primary key (id)
);