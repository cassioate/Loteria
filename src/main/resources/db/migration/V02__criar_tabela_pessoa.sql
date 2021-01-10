CREATE TABLE Pessoa (
	id SERIAL,
	nome VARCHAR(100) NOT NULL,
	email_proprietario_id Bigint,	
	constraint pk_pessoa primary key (id),
	constraint fk_pessoa foreign key (email_proprietario_id) REFERENCES Email(id)
);
