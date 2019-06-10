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
	
--Creación de tablas	
CREATE TABLE USUARIO(
	c_usuario INT PRIMARY KEY,
	c_pais INT,
	c_estado INT,
	c_ciudad INT,
	c_rol INT,
	u_nombres VARCHAR(100),
	u_apellido VARCHAR(100),
	u_fechaNacimiento DATE,
	u_direccion TEXT,
	u_username VARCHAR(50),
	u_password VARCHAR(50),
	u_activo BOOLEAN,
	u_sesion BOOLEAN,
	u_saldo MONEY DEFAULT 20,
);

CREATE TABLE ROL(
	c_rol INT PRIMARY KEY,
	rol_nombre VARCHAR(100),
);

CREATE TABLE PAIS(
	c_pais INT PRIMARY KEY,
	pais_nombre VARCHAR(50),
);

CREATE TABLE ESTADO(
	c_estado INT PRIMARY KEY,
	estado_nombre VARCHAR(50),
);

CREATE TABLE CIUDAD(
	c_ciudad INT PRIMARY KEY,
	ciudad_nombre VARCHAR(50),
);

CREATE TABLE RESERVACION(
	c_reserva INT PRIMARY KEY,
	c_usuario INT,
	c_exhibicion INT,
	reservacion_asiento VARCHAR(5),
);

CREATE TABLE EXHIBICION(
	c_exhibicion INT PRIMARY KEY,
	c_sala INT,
	c_pelicula INT,
	exhibicion_horario VARCHAR(20),
	exhibicion_formato VARCHAR(3),
);

CREATE TABLE SALA(
	c_sala INT PRIMARY KEY,
	c_usuario INT,
	sala_numero INT,
	sala_descripcion TEXT,
	sala_activo BOOLEAN,
	sala_capacidad INT,
);

CREATE TABLE PELICULA(
	c_pelicula INT PRIMARY KEY,
	c_usuario INT,
	pelicula_nombre VARCHAR (100),
	pelicula_descripcion TEXT,
	pelicula_activo BOOLEAN,
	pelicula_imagen TEXT,
);

CREATE TABLE MODIFICACION_SALA(
	c_modificacionSala INT PRIMARY KEY,
	c_usuario INT,
	c_sala INT,
);

CREATE TABLE MODIFICACION_PELICULA(
	c_modificacionPelicula INT PRIMARY KEY,
	c_usuario INT,
	c_pelicula INT,
);

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
ADD FOREIGN KEY (c_exhibicio) REFERENCES EXHIBICION(c_exhibicion);
ALTER TABLE	EXHIBICION
ADD FOREIGN KEY (c_sala) REFERENCES SALA(c_sala);
ALTER TABLE	EXHIBICION
ADD FOREIGN KEY (c_pelicula) REFERENCES PELICULA(c_pelicula);
ALTER TABLE	MODIFICACION_SALA
ADD FOREIGN KEY (c_usuario) REFERENCES USUARIO(c_usuario);
ALTER TABLE	MODIFICACION_SALA
ADD FOREIGN KEY (c_sala) REFERENCES SALA(c_sala);
ALTER TABLE	MODIFICACION_PELICULA
ADD FOREIGN KEY (c_usuario) REFERENCES USUARIO(c_usuario);
ALTER TABLE	MODIFICACION_PELICULA
ADD FOREIGN KEY (c_pelicula) REFERENCES SALA(c_pelicula);
ALTER TABLE	MODIFICACION
ADD FOREIGN KEY (c_usuario) REFERENCES USUARIO(c_usuario);
ALTER TABLE	SALA
ADD FOREIGN KEY (c_usuario) REFERENCES USUARIO(c_usuario);
ALTER TABLE	PELICULA
ADD FOREIGN KEY (c_usuario) REFERENCES USUARIO(c_usuario);