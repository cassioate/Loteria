CREATE TABLE email_numero (
	EMAIL_ID Bigint ,
	NUMERO_ID Bigint,
	CONSTRAINT fk_numero FOREIGN KEY (NUMERO_ID) REFERENCES Numero_da_sorte(id),
	CONSTRAINT fk_email FOREIGN KEY (EMAIL_ID) REFERENCES Email(id)
);