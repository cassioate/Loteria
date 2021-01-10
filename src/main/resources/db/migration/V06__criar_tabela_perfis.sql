CREATE TABLE Perfil (
	id SERIAL,
	PERFIS VARCHAR(50) NOT NULL,
	constraint pk_usuario primary key (id),
	cosntraint fk_perfil foreign key (id) references users (id)
);