-- Database: cinema

-- DROP DATABASE cinema;

CREATE DATABASE cinema
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_El Salvador.1252'
    LC_CTYPE = 'Spanish_El Salvador.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
--Done	
CREATE TABLE USUARIO(
	c_usuario INT PRIMARY KEY,
	c_pais INT,
	c_estado INT,
	c_ciudad INT,
	c_rol INT,
	u_nombre VARCHAR(100),
	u_apellido VARCHAR(100),
	u_fechaNacimiento DATE,
	u_direccion TEXT,
	u_username VARCHAR(50),
	u_password VARCHAR(50),
	u_activo BOOLEAN,
	u_sesion BOOLEAN,
	u_saldo MONEY DEFAULT 20
);
--Done
CREATE TABLE ROL(
	c_rol INT PRIMARY KEY,
	rol_nombre VARCHAR(100)
);
--Done
CREATE TABLE PAIS(
	c_pais INT PRIMARY KEY,
	pais_nombre VARCHAR(50)
);
--Done
CREATE TABLE ESTADO(
	c_estado INT PRIMARY KEY,
	estado_nombre VARCHAR(50)
);
--Done
CREATE TABLE CIUDAD(
	c_ciudad INT PRIMARY KEY,
	ciudad_nombre VARCHAR(50)
);

CREATE TABLE RESERVACION(
	c_reserva INT PRIMARY KEY,
	c_usuario INT,
	c_exhibicion INT,
	reservacion_asiento VARCHAR(5)
);

CREATE TABLE EXHIBICION(
	c_exhibicion INT PRIMARY KEY,
	c_sala INT,
	c_pelicula INT,
	exhibicion_horario VARCHAR(20),
	exhibicion_formato VARCHAR(3)
);

CREATE TABLE SALA(
	c_sala INT PRIMARY KEY,
	c_usuarioCreacion INT,
	c_usuarioModificacion INT,
	sala_numero INT,
	sala_descripcion TEXT,
	sala_activo BOOLEAN,
	sala_capacidad INT,
	sala_creacion DATE,
	sala_ultimaModificacion DATE
);

CREATE TABLE PELICULA(
	c_pelicula INT PRIMARY KEY,
	c_usuarioCreacion INT,
	c_usuarioModificacion INT,
	pelicula_nombre VARCHAR (100),
	pelicula_descripcion TEXT,
	pelicula_activo BOOLEAN,
	pelicula_imagen TEXT,
	pelicula_creacion DATE,
	pelicula_ultimaModificacion DATE
);


INSERT INTO PAIS VALUES (1, 'Estados Unidos');
INSERT INTO PAIS VALUES (2, 'Canada');
INSERT INTO PAIS VALUES (3, 'El Salvador');

INSERT INTO ESTADO VALUES (1, 'California');
INSERT INTO ESTADO VALUES (2, 'Florida');
INSERT INTO ESTADO VALUES (3, 'Quebec');
INSERT INTO ESTADO VALUES (4, 'Alberta');
INSERT INTO ESTADO VALUES (5, 'San Salvador');
INSERT INTO ESTADO VALUES (5, 'Santa Ana');

INSERT INTO CIUDAD VALUES (1, 'Sacramento');
INSERT INTO CIUDAD VALUES (2, 'San Francisco');
INSERT INTO CIUDAD VALUES (3, 'Miami');
INSERT INTO CIUDAD VALUES (4, 'Orlando');
INSERT INTO CIUDAD VALUES (5, 'Quebec');
INSERT INTO CIUDAD VALUES (6, 'Motreal');
INSERT INTO CIUDAD VALUES (7, 'Edson');
INSERT INTO CIUDAD VALUES (8, 'Calgary');
INSERT INTO CIUDAD VALUES (9, 'San Salvador');
INSERT INTO CIUDAD VALUES (10, 'Ayutuxtepeque');
INSERT INTO CIUDAD VALUES (11, 'El Congo');
INSERT INTO CIUDAD VALUES (12, 'Santa Ana');

INSERT INTO ROL VALUES (1, 'Administrador');
INSERT INTO ROL VALUES (2, 'Cliente');

INSERT INTO USUARIO VALUES (1,1,1,1,1, 'George', 'Smith', '26/1/1987', 'direccion1', 'georges1', '12345678', true,false,$200.00);
INSERT INTO USUARIO VALUES (2,1,1,2,2, 'James', 'Swift', '2/2/1989', 'direccion2', 'swift89', '12345678', false,false,$5.00);
INSERT INTO USUARIO VALUES (3,1,2,3,1, 'Thomas', 'Johnson', '10/2/1980', 'direccion3', 'tj1002', '12345678', true,false,$500.00);
INSERT INTO USUARIO VALUES (4,1,2,4,2, 'John', 'Steward', '5/12/1996', 'direccion4', 'stewardj', '12345678', false,false,$2.00);
INSERT INTO USUARIO VALUES (5,3,5,9,2, 'Rodrigo', 'Alvarenga', '23/4/1998', 'direccion5', 'tupic_toxic', '12345678', true,false,$1.00);
INSERT INTO USUARIO VALUES (5,3,6,12,2, 'Marcelo', 'Martinez', '26/10/1997', 'direccion6', 'marcelo2m97', '12345678', true,false,$20.00);
INSERT INTO USUARIO VALUES (5,3,6,12,2, 'Edward', 'Martinez', '5/9/1997', 'direccion7', 'emartinezs', '12345678', false,false,$2000.00);

INSERT INTO PELICULA VALUES (1,1,3,'Harry Potter','Lorem ipsum dolor sit amet, consectetur adipiscing elit.',false,'harrypotter.jpg','26/8/1998','10/1/2007');
INSERT INTO PELICULA VALUES (2,3,3,'Toy Story','Lorem ipsum dolor sit amet, consectetur adipiscing elit.',true,'toystory.jpg','21/6/2019','21/6/2019');
INSERT INTO PELICULA VALUES (3,3,1,'El Rey Leon','Lorem ipsum dolor sit amet, consectetur adipiscing elit.',false,'elreyleon.jpg','22/4/2007','10/12/2009');
INSERT INTO PELICULA VALUES (4,1,1,'Avengers Endgame','Lorem ipsum dolor sit amet, consectetur adipiscing elit.',true,'avengersendgame.jpg','26/4/2019','29/8/2019');

INSERT INTO SALA VALUES (1,1,3,1,'Lorem ipsum dolor sit amet',true,70,'15/6/2018','15/6/2018');
INSERT INTO SALA VALUES (2,1,3,2,'Lorem ipsum dolor sit amet',true,70,'15/6/2018','15/6/2018');
INSERT INTO SALA VALUES (3,1,3,3,'Lorem ipsum dolor sit amet',true,70,'15/6/2018','15/6/2018');
INSERT INTO SALA VALUES (4,1,3,4,'Lorem ipsum dolor sit amet',true,70,'15/6/2018','15/6/2018');
INSERT INTO SALA VALUES (5,1,3,5,'Lorem ipsum dolor sit amet',true,70,'15/6/2018','15/6/2018');

--FK's
ALTER TABLE	USUARIO
ADD FOREIGN KEY (c_pais) REFERENCES PAIS(c_pais);
ALTER TABLE	USUARIO
ADD FOREIGN KEY (c_estado) REFERENCES ESTADO(c_estado);
ALTER TABLE	USUARIO
ADD FOREIGN KEY (c_ciudad) REFERENCES CIUDAD(c_ciudad);
ALTER TABLE	USUARIO
ADD FOREIGN KEY (c_rol) REFERENCES ROL(c_rol);
ALTER TABLE	RESERVACION
ADD FOREIGN KEY (c_usuario) REFERENCES USUARIO(c_usuario);
ALTER TABLE	RESERVACION
ADD FOREIGN KEY (c_exhibicion) REFERENCES EXHIBICION(c_exhibicion);
ALTER TABLE	EXHIBICION
ADD FOREIGN KEY (c_sala) REFERENCES SALA(c_sala);
ALTER TABLE	EXHIBICION
ADD FOREIGN KEY (c_pelicula) REFERENCES PELICULA(c_pelicula);
ALTER TABLE	SALA
ADD FOREIGN KEY (c_usuarioCreacion) REFERENCES USUARIO(c_usuario);
ALTER TABLE	SALA
ADD FOREIGN KEY (c_usuarioModificacion) REFERENCES USUARIO(c_usuario);
ALTER TABLE	PELICULA
ADD FOREIGN KEY (c_usuarioCreacion) REFERENCES USUARIO(c_usuario);
ALTER TABLE	PELICULA
ADD FOREIGN KEY (c_usuarioModificacion) REFERENCES USUARIO(c_usuario);
