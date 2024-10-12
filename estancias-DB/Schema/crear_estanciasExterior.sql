DROP DATABASE IF EXISTS estancias_exterior;
CREATE DATABASE IF NOT EXISTS estancias_exterior;
USE estancias_exterior;

CREATE TABLE cliente (
  id_cliente INT UNSIGNED AUTO_INCREMENT NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  calle VARCHAR(50) DEFAULT NULL,
  numero INT NOT NULL,
  codigo_postal VARCHAR(10) DEFAULT NULL,
  ciudad VARCHAR(50) NOT NULL,
  pais VARCHAR(50) NOT NULL,
  email VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id_cliente)
)ENGINE=INNODB;

CREATE TABLE casa (
  id_casa INT UNSIGNED AUTO_INCREMENT NOT NULL,
  calle VARCHAR(50) DEFAULT NULL,
  numero INT NOT NULL,
  codigo_postal VARCHAR(10) DEFAULT NULL,
  ciudad VARCHAR(50) NOT NULL,
  pais VARCHAR(50) NOT NULL,
  fecha_desde date NOT NULL,
  fecha_hasta date NOT NULL,
  tiempo_minimo INT NOT NULL,
  tiempo_maximo INT NOT NULL,
  precio_habitacion NUMERIC(15,2) NOT NULL,
  tipo_vivienda VARCHAR(30) NOT NULL,
  PRIMARY KEY (id_casa)
)ENGINE=INNODB;

CREATE TABLE familia (
  id_familia INT UNSIGNED AUTO_INCREMENT NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  edad_minima INT NOT NULL,
  edad_maxima INT NOT NULL,
  num_hijos INT NOT NULL,
  email VARCHAR(50) NOT NULL,
  id_casa_familia INT UNSIGNED NOT NULL,
  PRIMARY KEY (id_familia),
  CONSTRAINT fk_familia_casa FOREIGN KEY (id_casa_familia) REFERENCES casa (id_casa)
)ENGINE=INNODB;

CREATE TABLE estancia (
  id_estancia  INT UNSIGNED AUTO_INCREMENT NOT NULL,
  id_cliente INT UNSIGNED NOT NULL,
  id_casa INT UNSIGNED NOT NULL,
  nombre_huesped VARCHAR(70) NOT NULL,
  fecha_desde date NOT NULL,
  fecha_hasta date NOT NULL,
  PRIMARY KEY (id_estancia),
  CONSTRAINT fk_estancia_cliente FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente),
  CONSTRAINT fk_estancia_casa FOREIGN KEY (id_casa) REFERENCES casa (id_casa)
)ENGINE=INNODB;

CREATE TABLE comentario (
  id_comentario INT UNSIGNED AUTO_INCREMENT NOT NULL,
  id_casa INT UNSIGNED NOT NULL,
  comentario VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id_comentario),
  CONSTRAINT fk_comentario_casa FOREIGN KEY (id_casa) REFERENCES casa (id_casa)
)ENGINE=INNODB;