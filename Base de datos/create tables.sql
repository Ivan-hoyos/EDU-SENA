create database colegio;
use colegio;
create table estudiantes(
id_Alumno int primary key not null,
Nombres varchar (50) not null,
Apellidos varchar (50) not null,
Fecha_Nacimiento date NOT NULL,
Sexo char (1) NOT NULL,
Grado tinyint NOT NULL,
Seccion char(1) NOT NULL,
Direccion varchar(20) NOT NULL,
Telefono bigint NULL,
Email varchar(30) NULL,
Contraseña varchar(20) NOT NULL,
id_Curso varchar(4) NOT NULL,
Rol varchar(10) NOT NULL  default 'student');

select * from estudiantes;

INSERT INTO  estudiantes (id_Alumno, Nombres, Apellidos, Fecha_Nacimiento, Sexo, Grado, Seccion, Direccion, Telefono, Email, Contraseña, id_Curso)VALUES
(1043695754, 'Luis Angel','Catro Cabrera','2002-06-28','M', 11 ,'A','xxx',3105689965,'luis@gmail.com','123','11A');

create table curso(
id_Curso varchar (5) primary key not null,
Grado tinyint NOT NULL,
Seccion char(1) NOT NULL);

INSERT INTO  curso (id_Curso, Grado, Seccion)VALUES
('9A', 9, 'A'),('9B', 9, 'B'),('9C', 9, 'C'),('10A', 10, 'A'),('10B', 10, 'B'),('10C', 10, 'C'),('11A', 11, 'A'),('11B', 11, 'B'),('11C',11,'C');
select * from curso;

create table materia(
id_Materia int primary key not null auto_increment,
Nombre_Materia varchar(30) NOT NULL);

CREATE TABLE notas(
	id_Nota int primary key not NULL auto_increment,
	id_Alumno bigint NOT NULL,
	id_Curso varchar(4) NOT NULL,
	id_Materia int NOT NULL,
	id_Profesor bigint NOT NULL,
	Promedio float NOT NULL);
    
    CREATE TABLE Roles(Rol varchar(10) primary key NOT NULL);
    Insert into Roles (Rol) values ('student'),('teacher'),('admin');
    
create table profesores(
id_Profesor int primary key not null,
Nombres varchar (50) not null,
Apellidos varchar (50) not null,
Direccion varchar(20) NOT NULL,
Telefono bigint NULL,
Email varchar(30) NULL,
Contraseña varchar(20) NOT NULL,
Rol varchar(10) NOT NULL  default 'teacher');

Alter table estudiantes ADD FOREIGN KEY (id_Curso) REFERENCES curso(id_Curso);
Alter table estudiantes ADD FOREIGN KEY (Rol) REFERENCES Roles(Rol);
Alter table notas ADD FOREIGN KEY (id_Curso) REFERENCES curso(id_Curso);
Alter table notas ADD FOREIGN KEY (id_Materia) REFERENCES materia(id_Materia);

