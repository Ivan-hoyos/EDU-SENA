use colegio;
INSERT INTO estudiantes (id_Estudiante, Nombres, Apellidos, Fecha_Nacimiento, Direccion, Telefono, Email, Grado, Seccion, id_Curso, Contraseña, Rol) VALUES
(1, 'Juan', 'Pérez', '2005-01-15', 'Calle A, Ciudad', 123456789, 'juan@example.com', 9, 'A', '9A', '123456', 'student'),
(2, 'María', 'Gómez', '2004-07-28', 'Avenida B, Ciudad', 987654321, 'maria@example.com', 10, 'B', '10B', 'abcdef', 'student'),
(3, 'Pedro', 'López', '2006-03-10', 'Calle C, Ciudad', 555555555, 'pedro@example.com', 8, 'C', '8C', 'qwerty', 'student'),
(4, 'Ana', 'Rodríguez', '2003-11-02', 'Avenida D, Ciudad', 111111111, 'ana@example.com', 11, 'A', '11A', 'zxcvbn', 'student'),
(5, 'Luis', 'Martínez', '2005-09-18', 'Calle E, Ciudad', 222222222, 'luis@example.com', 9, 'B', '9B', 'asdfgh', 'student'),
(6, 'Sofía', 'Hernández', '2004-12-30', 'Avenida F, Ciudad', 333333333, 'sofia@example.com', 10, 'A', '10A', '12345678', 'student'),
(7, 'Carlos', 'González', '2006-06-05', 'Calle G, Ciudad', 444444444, 'carlos@example.com', 8, 'B', '8B', 'abcdefgh', 'student'),
(8, 'Laura', 'Silva', '2003-02-21', 'Avenida H, Ciudad', 777777777, 'laura@example.com', 11, 'C', '11C', 'qwertyuiop', 'student'),
(9, 'Mario', 'Herrera', '2005-04-14', 'Calle I, Ciudad', 999999999, 'mario@example.com', 9, 'C', '9C', 'zxcvbnm', 'student'),
(10, 'Carla', 'Lara', '2004-08-07', 'Avenida J, Ciudad', 888888888, 'carla@example.com', 10, 'C', '10C', 'poiuytrewq', 'student');
select * from estudiantes;


INSERT INTO Profesores (id_Profesor, Nombres, Apellidos, Direccion, Email, Telefono, Rol) VALUES
(1, 'José', 'García', 'Calle A, Ciudad', 'jose@example.com', 123456789, 'teacher'),
(2, 'María', 'López', 'Avenida B, Ciudad', 'maria@example.com', 987654321, 'teacher'),
(3, 'Carlos', 'Gómez', 'Calle C, Ciudad', 'carlos@example.com', 555555555, 'teacher'),
(4, 'Laura', 'Hernández', 'Avenida D, Ciudad', 'laura@example.com', 111111111, 'teacher'),
(5, 'Pedro', 'Martínez', 'Calle E, Ciudad', 'pedro@example.com', 222222222, 'teacher');
select * from Profesores;


INSERT INTO Cursos (id_Cursos, Grado, Seccion) VALUES
('6A', 6, 'A'),
('6B', 6, 'B'),
('6C', 6, 'C'),
('7A', 7, 'A'),
('7B', 7, 'B'),
('7C', 7, 'C'),
('8A', 8, 'A'),
('8B', 8, 'B'),
('8C', 8, 'C'),
('9A', 9, 'A'),
('9B', 9, 'B'),
('9C', 9, 'C'),
('10A', 10, 'A'),
('10B', 10, 'B'),
('10C', 10, 'C'),
('11A', 11, 'A'),
('11B', 11, 'B'),
('11C', 11, 'C');
select * from cursos;

INSERT INTO Asignaturas (Nombre) VALUES
('Matemáticas'),
('Ciencias Naturales'),
('Lenguaje y Literatura'),
('Historia'),
('Geografía'),
('Educación Física'),
('Artes'),
('Música'),
('Inglés'),
('Tecnología');
alter table notas add column promedio float not null;
select * from Asignaturas;

INSERT INTO Notas (id_Alumno, id_Profesor, id_Asignatura, id_Curso, promedio) VALUES
(1, 1, 1, '9A', 4.5),
(2, 2, 2, '10B', 3.8),
(3, 3, 3, '8C', 4.2),
(4, 4, 4, '11A', 4.0),
(5, 5, 5, '9B', 4.7);

alter table admin add column contraseña varchar(20) not null;
select * from Notas;
insert into admin (id_Admin, Rol, contraseña) values (1515,'admin','123');
insert into roles (id_Rol) values ('student'),('admin'),('teacher');
