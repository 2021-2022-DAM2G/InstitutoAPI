CREATE DATABASE instituto;

USE instituto;

CREATE TABLE alumnos(
id INT AUTO_INCREMENT NOT NULL primary key,
nif VARCHAR(9) NOT NULL,
nombre VARCHAR(20) NOT NULL,
apellido1 VARCHAR(20) NOT NULL,
apellido2 VARCHAR(20) ,
codigo_postal INT NOT NULL,
direcion VARCHAR(90),
mail VARCHAR(40) NOT NULL
);



CREATE TABLE titulos(
id_titulo INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
nombre VARCHAR(20) NOT NULL,
nivel VARCHAR(20) NOT NULL,
familia VARCHAR(20) NOT NULL,
descripcion VARCHAR(90) NOT NULL

);

CREATE TABLE grupos(
id_grupo INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
curso INT NOT NULL,
letra VARCHAR(10) NOT NULL,
titulo VARCHAR(60) NOT NULL,
año INT NOT NULL

);

CREATE TABLE matriculas(
id_matricula INT AUTO_INCREMENT NOT NULL,
id_alumno INT NOT NULL,
año_matricula int NOT NULL,
id_titulo INT NOT NULL,
id_curso INT NOT NULL,
estado VARCHAR(30) NOT NULL,
CONSTRAINT Pk_matricula
PRIMARY KEY (id_matricula, id_alumno,id_titulo, id_curso ),

CONSTRAINT FK_matriculas_alumnos
FOREIGN KEY (id_alumno) 
REFERENCES alumnos (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE,

CONSTRAINT FK_matriculas_titulos
FOREIGN KEY (id_titulo) 
REFERENCES titulos (id_titulo)
    ON UPDATE CASCADE
    ON DELETE CASCADE,


CONSTRAINT FK_matriculas_grupo
FOREIGN KEY (id_curso) 
REFERENCES grupos (id_grupo)
    ON UPDATE CASCADE
    ON DELETE CASCADE

);