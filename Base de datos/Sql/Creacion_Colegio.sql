Create database colegio;
use colegio;

-- -----------------------------------------------------
-- Table estudiantes
-- -----------------------------------------------------
CREATE TABLE estudiantes (
  `id_Estudiante` INT NOT NULL,
  `Nombres` VARCHAR(50) NOT NULL,
  `Apellidos` VARCHAR(50) NOT NULL,
  `Fecha_Nacimiento` DATE NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `Telefono` BIGINT NOT NULL,
  `Email` VARCHAR(45) NULL,
  `Grado` INT NOT NULL,
  `Seccion` CHAR(1) NOT NULL,
  `id_Curso` VARCHAR(5) NOT NULL,
  `Contraseña` VARCHAR(20) NOT NULL,
  `Rol` VARCHAR(10) NOT NULL DEFAULT 'student',
   PRIMARY KEY (`id_Estudiante`),
   foreign key (id_Curso) references Cursos (id_Cursos),
   foreign key (Rol) references Roles (id_Rol)); 

-- -----------------------------------------------------
-- Table Profesores
-- -----------------------------------------------------
  CREATE TABLE Profesores (
  `id_Profesor` INT NOT NULL,
  `Nombres` VARCHAR(45) NOT NULL,
  `Apellidos` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Telefono` BIGINT NOT NULL,
  `Rol` VARCHAR(10) NOT NULL DEFAULT 'teacher',
  PRIMARY KEY (`id_Profesor`),
  foreign key (Rol) references Roles (id_Rol)); 
  
-- -----------------------------------------------------
-- Table Cursos
-- -----------------------------------------------------
CREATE TABLE Cursos (
  `id_Cursos` VARCHAR(3) NOT NULL,
  `Grado` INT NOT NULL,
  `Seccion` CHAR(1) NOT NULL,
  PRIMARY KEY (`id_Cursos`));
  
-- -----------------------------------------------------
-- Table Asignaturas
-- -----------------------------------------------------
CREATE TABLE Asignaturas (
  `id_Asignatura` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_Asignatura`));
  
-- -----------------------------------------------------
-- Table `colegio`.`Notas`
-- -----------------------------------------------------
  CREATE TABLE Notas (
  `id_Notas` INT NOT NULL AUTO_INCREMENT,
  `id_Alumno` INT NOT NULL,
  `id_Profesor` INT NOT NULL,
  `id_Asignatura` INT NOT NULL,
  `id_Curso` VARCHAR(3) NOT NULL,
  promedio float not null,
  PRIMARY KEY (`id_Notas`),
  foreign key (id_Alumno) references estudiantes (id_Estudiante), 
  foreign key (id_Profesor) references Profesores (id_Profesor), 
  foreign key (id_Asignatura) references Asignaturas (id_Asignatura), 
  foreign key (id_Curso) references Cursos (id_Cursos));
  
-- -----------------------------------------------------
-- Table `colegio`.`Admin`
-- -----------------------------------------------------
CREATE TABLE Admin (
  `id_Admin` INT NOT NULL,
  `Rol` VARCHAR(10) NOT NULL DEFAULT 'admin',
  contraseña varchar(20) not null,
  PRIMARY KEY (`id_Admin`),
  foreign key (Rol) references Roles (id_Rol) );
  
-- -----------------------------------------------------
-- Table `colegio`.`Roles`
-- -----------------------------------------------------
CREATE TABLE Roles (
  `id_Rol` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_Rol`));
  
-- Relacion estudiantes - Roles
  
	ALTER TABLE estudiantes 
	add CONSTRAINT `Rol_estudiante`
    FOREIGN KEY (`Rol`)
    REFERENCES `colegio`.`Roles` (`id_Rol`);
-- Relacion estudiantes - cursos
ALTER TABLE estudiantes 
	add CONSTRAINT `curso_estudiante`
    FOREIGN KEY (`id_Curso`)
    REFERENCES `colegio`.`cursos` (`id_Cursos`);
    
    
-- Relacion profesores - Roles
  
	ALTER TABLE profesores 
	add CONSTRAINT `Rol_profesor`
    FOREIGN KEY (`Rol`)
    REFERENCES `colegio`.`Roles` (`id_Rol`);
    
    
-- Relacion Notas - estudiantes, profesores, cursos, asignaturas
	ALTER TABLE estudiantes
	ADD INDEX idx_id_Estudiantes (id_Estudiante);
	ALTER TABLE notas
	ADD CONSTRAINT notas_estudiante
	FOREIGN KEY (id_Alumno)
	REFERENCES estudiantes (id_Estudiantes);

	ALTER TABLE profesores
	ADD INDEX idx_id_Profesor (id_Profesor);
	ALTER TABLE notas
	ADD CONSTRAINT notas_Profesor
	FOREIGN KEY (id_Profesor)
	REFERENCES profesores (id_Profesor);
    
    ALTER TABLE cursos
	ADD INDEX idx_id_Cursos (id_Cursos);
	ALTER TABLE notas
	ADD CONSTRAINT notas_Cursos
	FOREIGN KEY (id_Curso)
	REFERENCES cursos (id_Cursos);
    
    ALTER TABLE Asignaturas
	ADD INDEX idx_id_Asignatura (id_Asignatura);
	ALTER TABLE notas
	ADD CONSTRAINT notas_Asignaturas
	FOREIGN KEY (id_Asignatura)
	REFERENCES asignaturas (id_Asignatura);
    
    -- Relacion admin - Roles
  
	ALTER TABLE admin add FOREIGN KEY (`Rol`) REFERENCES `colegio`.`Roles` (`id_Rol`);
    
    DESCRIBE asignaturas;

