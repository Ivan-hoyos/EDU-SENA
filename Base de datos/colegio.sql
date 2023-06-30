-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-06-2023 a las 02:36:11
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `colegio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividades`
--

CREATE TABLE `actividades` (
  `IdActividad` int(11) NOT NULL,
  `Titulo` varchar(255) NOT NULL,
  `Descripcion` longtext NOT NULL,
  `FechaCreacion` datetime NOT NULL,
  `ProfesorId` int(11) NOT NULL,
  `IdCurso` varchar(4) NOT NULL,
  `IdAsignatura` int(11) NOT NULL,
  `Materia` varchar(60) NOT NULL,
  `Periodo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admin`
--

CREATE TABLE `admin` (
  `id_Admin` int(11) NOT NULL,
  `Rol` varchar(10) NOT NULL DEFAULT 'admin',
  `contraseña` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `admin`
--

INSERT INTO `admin` (`id_Admin`, `Rol`, `contraseña`) VALUES
(1, 'admin', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaturas`
--

CREATE TABLE `asignaturas` (
  `id_Asignatura` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `asignaturas`
--

INSERT INTO `asignaturas` (`id_Asignatura`, `Nombre`) VALUES
(1, 'Ingles'),
(2, 'Historia'),
(3, 'Español'),
(4, 'Arte'),
(5, 'Matemáticas'),
(6, 'Biología'),
(7, 'Geografía'),
(8, 'Física'),
(9, 'Química'),
(10, 'Educación Física');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `id_Cursos` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`id_Cursos`) VALUES
('10A'),
('10B'),
('10C'),
('11A'),
('11B'),
('11C'),
('6A'),
('6B'),
('6C'),
('7A'),
('7B'),
('7C'),
('8A'),
('8B'),
('8C'),
('9A'),
('9B'),
('9C'),
('No');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

CREATE TABLE `estudiantes` (
  `id_Estudiante` int(11) NOT NULL,
  `Nombres` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `Fecha_Nacimiento` date NOT NULL,
  `Direccion` varchar(45) NOT NULL,
  `Telefono` bigint(20) NOT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `id_Curso` varchar(5) NOT NULL DEFAULT 'No',
  `Contraseña` varchar(20) NOT NULL,
  `Rol` varchar(10) NOT NULL DEFAULT 'student',
  `Sexo` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estudiantes`
--

INSERT INTO `estudiantes` (`id_Estudiante`, `Nombres`, `Apellidos`, `Fecha_Nacimiento`, `Direccion`, `Telefono`, `Email`, `id_Curso`, `Contraseña`, `Rol`, `Sexo`) VALUES
(1, 'Juan', 'Perez', '2002-06-05', 'Calle A, Ciudad', 1234567890, 'juan.perez@example.com', '6A', '123', 'student', 'M'),
(2, 'Maria', 'Lopez', '1992-02-02', 'Calle B, Ciudad', 987654321, 'maria.lopez@example.com', '6B', 'password2', 'student', 'F'),
(3, 'Pedro', 'Gomez', '1994-03-03', 'Calle C, Ciudad', 111222333, 'pedro.gomez@example.com', '6C', 'password3', 'student', 'M'),
(4, 'Ana', 'Rodriguez', '1995-04-04', 'Calle D, Ciudad', 444555666, 'ana.rodriguez@example.com', '7A', 'password4', 'student', 'F'),
(5, 'Luis', 'Hernandez', '1997-05-05', 'Calle E, Ciudad', 777888999, 'luis.hernandez@example.com', '7B', 'password5', 'student', 'M'),
(6, 'Laura', 'Gonzalez', '1999-06-06', 'Calle F, Ciudad', 222333444, 'laura.gonzalez@example.com', '7C', 'password6', 'student', 'F'),
(7, 'Carlos', 'Sanchez', '2001-07-07', 'Calle G, Ciudad', 555666777, 'carlos.sanchez@example.com', '8A', 'password7', 'student', 'M'),
(8, 'Sofia', 'Romero', '2003-08-08', 'Calle H, Ciudad', 999000111, 'sofia.romero@example.com', '8B', 'password8', 'student', 'F'),
(9, 'David', 'Ramirez', '2005-09-09', 'Calle I, Ciudad', 888999000, 'david.ramirez@example.com', '8C', 'password9', 'student', 'M'),
(10, 'Valentina', 'Torres', '2007-10-10', 'Calle J, Ciudad', 222333444, 'valentina.torres@example.com', '9A', 'password10', 'student', 'F'),
(11, 'Daniel', 'Luna', '1993-11-11', 'Calle K, Ciudad', 444555666, 'daniel.luna@example.com', '9B', 'password11', 'student', 'M'),
(12, 'Camila', 'Martinez', '1995-12-12', 'Calle L, Ciudad', 777888999, 'camila.martinez@example.com', '9C', 'password12', 'student', 'F'),
(13, 'Javier', 'Castro', '1997-01-13', 'Calle M, Ciudad', 222333444, 'javier.castro@example.com', '10C', 'password13', 'student', 'M'),
(14, 'Isabella', 'Vargas', '1999-02-14', 'Calle N, Ciudad', 555666777, 'isabella.vargas@example.com', '10B', 'password14', 'student', 'F'),
(15, 'Mateo', 'Rojas', '2001-03-15', 'Calle O, Ciudad', 999000111, 'mateo.rojas@example.com', '10C', 'password15', 'student', 'M'),
(16, 'Gabriela', 'Navarro', '2003-04-16', 'Calle P, Ciudad', 888999000, 'gabriela.navarro@example.com', '11A', 'password16', 'student', 'F'),
(17, 'Diego', 'Ortega', '2005-05-17', 'Calle Q, Ciudad', 222333444, 'diego.ortega@example.com', '11B', 'password17', 'student', 'M'),
(18, 'Sara', 'Guerrero', '2007-06-18', 'Calle R, Ciudad', 444555666, 'sara.guerrero@example.com', '11C', 'password18', 'student', 'F'),
(19, 'Andres', 'Mendoza', '1992-07-19', 'Calle S, Ciudad', 777888999, 'andres.mendoza@example.com', '11C', 'password19', 'student', 'M'),
(20, 'Juliana', 'Pacheco', '1994-08-20', 'Calle T, Ciudad', 222333444, 'juliana.pacheco@example.com', '6B', 'password20', 'student', 'F'),
(21, 'Felipe', 'Silva', '1996-09-21', 'Calle U, Ciudad', 555666777, 'felipe.silva@example.com', '6C', 'password21', 'student', 'M'),
(22, 'Antonia', 'Rios', '1998-10-22', 'Calle V, Ciudad', 999000111, 'antonia.rios@example.com', '7A', 'password22', 'student', 'F'),
(23, 'Ricardo', 'Lara', '2000-11-23', 'Calle W, Ciudad', 888999000, 'ricardo.lara@example.com', '7B', 'password23', 'student', 'M'),
(24, 'Catalina', 'Orozco', '2002-12-24', 'Calle X, Ciudad', 222333444, 'catalina.orozco@example.com', '7C', 'password24', 'student', 'F'),
(25, 'Sebastian', 'Diaz', '2004-01-25', 'Calle Y, Ciudad', 444555666, 'sebastian.diaz@example.com', '8A', 'password25', 'student', 'M'),
(26, 'Valeria', 'Cordova', '2006-02-26', 'Calle Z, Ciudad', 777888999, 'valeria.cordova@example.com', '8B', 'password26', 'student', 'F'),
(27, 'Roberto', 'Gutierrez', '2008-03-27', 'Calle AA, Ciudad', 555666777, 'roberto.gutierrez@example.com', '8C', 'password27', 'student', 'M'),
(28, 'Daniela', 'Santos', '2010-04-28', 'Calle BB, Ciudad', 999000111, 'daniela.santos@example.com', '9A', 'password28', 'student', 'F'),
(29, 'Miguel', 'Vega', '1993-05-29', 'Calle CC, Ciudad', 888999000, 'miguel.vega@example.com', '9B', 'password29', 'student', 'M'),
(30, 'Elena', 'Molina', '1995-06-30', 'Calle DD, Ciudad', 222333444, 'elena.molina@example.com', '9C', 'password30', 'student', 'F'),
(31, 'Jorge', 'Herrera', '1997-07-01', 'Calle EE, Ciudad', 444555666, 'jorge.herrera@example.com', '10A', 'password31', 'student', 'M'),
(32, 'Natalia', 'Fuentes', '1999-08-02', 'Calle FF, Ciudad', 777888999, 'natalia.fuentes@example.com', '10B', 'password32', 'student', 'F'),
(33, 'Alejandro', 'Miranda', '2001-09-03', 'Calle GG, Ciudad', 222333444, 'alejandro.miranda@example.com', '10C', 'password33', 'student', 'M'),
(34, 'Carolina', 'Valencia', '2003-10-04', 'Calle HH, Ciudad', 555666777, 'carolina.valencia@example.com', '11C', 'password34', 'student', 'F'),
(35, 'Hector', 'Soto', '2005-11-05', 'Calle II, Ciudad', 999000111, 'hector.soto@example.com', '11B', 'password35', 'student', 'M');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notas`
--

CREATE TABLE `notas` (
  `id_Notas` int(11) NOT NULL,
  `IdActividad` int(11) NOT NULL,
  `Periodo` int(11) NOT NULL,
  `Titulo` varchar(255) NOT NULL,
  `IdRespuesta` int(11) NOT NULL,
  `id_Alumno` int(11) DEFAULT NULL,
  `id_Profesor` int(11) NOT NULL,
  `id_Asignatura` int(11) NOT NULL,
  `Materia` varchar(50) NOT NULL,
  `id_Curso` varchar(3) NOT NULL,
  `Nota` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `id_Profesor` int(11) NOT NULL,
  `Nombres` varchar(45) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `FechaNacimiento` date DEFAULT NULL,
  `Sexo` varchar(3) NOT NULL DEFAULT 'NA',
  `Direccion` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Telefono` bigint(20) NOT NULL,
  `Contraseña` varchar(20) NOT NULL,
  `Rol` varchar(10) NOT NULL DEFAULT 'teacher',
  `id_Materia` int(3) NOT NULL,
  `Profesion` varchar(50) NOT NULL,
  `id_Curso` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`id_Profesor`, `Nombres`, `Apellidos`, `FechaNacimiento`, `Sexo`, `Direccion`, `Email`, `Telefono`, `Contraseña`, `Rol`, `id_Materia`, `Profesion`, `id_Curso`) VALUES
(1031842069, 'Natalia', 'Gómez', '1994-02-14', 'F', 'Avenida 12', 'Natalia@example.com', 3141234567, 'natalia123', 'teacher', 6, 'Biología', NULL),
(1041681623, 'Ana', 'Martínez', '1990-09-18', 'F', 'Carrera 30', 'ana@example.com', 3179876543, 'ana123', 'teacher', 2, 'Historia', NULL),
(1042653642, 'Luis', 'Ramírez', '1988-05-12', 'M', 'Calle 20', 'luis@example.com', 3101234567, 'luis123', 'teacher', 1, 'Inglés', NULL),
(1042680641, 'Javier', 'Pérez', '1987-08-15', 'M', 'Avenida 15', 'javier@example.com', 3126789012, 'javier123', 'teacher', 5, 'Matemáticas', NULL),
(1042681647, 'Laura', 'Rodríguez', '1991-06-04', 'F', 'Calle 50', 'laura@example.com', 3157894562, 'laura123', 'teacher', 6, 'Biología', NULL),
(1042681650, 'Sergio', 'Chávez', '1989-11-27', 'M', 'Calle 70', 'sergio@example.com', 3170123456, 'sergio123', 'teacher', 9, 'Química', NULL),
(1042681651, 'Julia', 'Lara', '1995-04-17', 'F', 'Carrera 20', 'julia@example.com', 3141234567, 'julia123', 'teacher', 10, 'Educación Física', NULL),
(1043681648, 'Gabriel', 'Sánchez', '1986-09-23', 'M', 'Carrera 25', 'gabriel@example.com', 3209876543, 'gabriel123', 'teacher', 7, 'Geografía', NULL),
(1045681614, 'Pedro', 'López', '1985-03-07', 'M', 'Avenida 10', 'pedro@example.com', 3146543210, 'pedro123', 'teacher', 3, 'Español', NULL),
(1048681640, 'María', 'González', '1992-12-01', 'F', 'Calle 40', 'maria@example.com', 3195678901, 'maria123', 'teacher', 4, 'Arte', NULL),
(1048682649, 'Carolina', 'Hernández', '1993-02-10', 'F', 'Avenida 12', 'carolina@example.com', 3136789012, 'carolina123', 'teacher', 8, 'Física', NULL),
(1053102468, 'Sebastián', 'Acosta', '1989-03-18', 'M', 'Calle 70', 'Sebastian@example.com', 3170123456, 'sebastian123', 'teacher', 3, 'Español', NULL),
(1234567890, 'Carlos Andres', 'Méndez González', '1993-01-29', 'M', 'Calle 100', 'Carlos@example.com', 3105642349, 'carlos123', 'teacher', 1, 'Ingles', NULL),
(1357924680, 'Isabella', 'Martínez', '1992-12-07', 'F', 'Calle 50', 'Isabella@example.com', 3176549870, 'isabella123', 'teacher', 2, 'Historia', NULL),
(1372058419, 'Andrés', 'Castro', '1984-11-25', 'M', 'Calle 80', 'Andres@example.com', 3136789012, 'andres123', 'teacher', 9, 'Química', NULL),
(2147483647, 'Laura', 'González', '1985-06-15', 'F', 'Avenida 5', 'Laura@example.com', 3157894562, 'laura123', 'teacher', 5, 'Matemáticas', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestas`
--

CREATE TABLE `respuestas` (
  `IdRespuesta` int(11) NOT NULL,
  `IdActividad` int(11) NOT NULL,
  `Titulo` varchar(255) NOT NULL,
  `IdEstudiante` int(11) DEFAULT NULL,
  `NombreEstudiante` varchar(60) NOT NULL,
  `IdCurso` varchar(4) NOT NULL,
  `Respuesta` longtext NOT NULL,
  `FechaEnvio` datetime NOT NULL,
  `Periodo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_Rol` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id_Rol`) VALUES
('admin'),
('student'),
('teacher');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD PRIMARY KEY (`IdActividad`),
  ADD KEY `IdCurso` (`IdCurso`),
  ADD KEY `ProfesorId` (`ProfesorId`),
  ADD KEY `IdAsignatura` (`IdAsignatura`);

--
-- Indices de la tabla `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_Admin`),
  ADD KEY `Rol` (`Rol`);

--
-- Indices de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  ADD PRIMARY KEY (`id_Asignatura`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`id_Cursos`);

--
-- Indices de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD PRIMARY KEY (`id_Estudiante`),
  ADD KEY `id_Curso` (`id_Curso`),
  ADD KEY `Rol` (`Rol`);

--
-- Indices de la tabla `notas`
--
ALTER TABLE `notas`
  ADD PRIMARY KEY (`id_Notas`),
  ADD KEY `notas_ibfk_2` (`id_Profesor`),
  ADD KEY `notas_ibfk_3` (`id_Asignatura`),
  ADD KEY `notas_ibfk_4` (`id_Curso`),
  ADD KEY `notas_ibfk_5` (`IdActividad`),
  ADD KEY `IdRespuesta` (`IdRespuesta`),
  ADD KEY `notas_estudiantes` (`id_Alumno`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`id_Profesor`),
  ADD KEY `Rol` (`Rol`);

--
-- Indices de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD PRIMARY KEY (`IdRespuesta`),
  ADD KEY `IdCurso` (`IdCurso`),
  ADD KEY `IdEstudiante` (`IdEstudiante`),
  ADD KEY `respuestas_ibfk_1` (`IdActividad`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_Rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividades`
--
ALTER TABLE `actividades`
  MODIFY `IdActividad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  MODIFY `id_Asignatura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `notas`
--
ALTER TABLE `notas`
  MODIFY `id_Notas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  MODIFY `IdRespuesta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD CONSTRAINT `actividades_ibfk_1` FOREIGN KEY (`IdCurso`) REFERENCES `cursos` (`id_Cursos`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `actividades_ibfk_2` FOREIGN KEY (`ProfesorId`) REFERENCES `profesores` (`id_Profesor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `actividades_ibfk_3` FOREIGN KEY (`IdAsignatura`) REFERENCES `asignaturas` (`id_Asignatura`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`Rol`) REFERENCES `roles` (`id_Rol`);

--
-- Filtros para la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD CONSTRAINT `estudiantes_ibfk_1` FOREIGN KEY (`id_Curso`) REFERENCES `cursos` (`id_Cursos`),
  ADD CONSTRAINT `estudiantes_ibfk_2` FOREIGN KEY (`Rol`) REFERENCES `roles` (`id_Rol`);

--
-- Filtros para la tabla `notas`
--
ALTER TABLE `notas`
  ADD CONSTRAINT `notas_ibfk_2` FOREIGN KEY (`id_Profesor`) REFERENCES `profesores` (`id_Profesor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `notas_ibfk_3` FOREIGN KEY (`id_Asignatura`) REFERENCES `asignaturas` (`id_Asignatura`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `notas_ibfk_4` FOREIGN KEY (`id_Curso`) REFERENCES `cursos` (`id_Cursos`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `notas_ibfk_5` FOREIGN KEY (`IdActividad`) REFERENCES `actividades` (`IdActividad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `notas_ibfk_6` FOREIGN KEY (`IdRespuesta`) REFERENCES `respuestas` (`IdRespuesta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD CONSTRAINT `profesores_ibfk_1` FOREIGN KEY (`Rol`) REFERENCES `roles` (`id_Rol`);

--
-- Filtros para la tabla `respuestas`
--
ALTER TABLE `respuestas`
  ADD CONSTRAINT `respuestas_ibfk_1` FOREIGN KEY (`IdActividad`) REFERENCES `actividades` (`IdActividad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `respuestas_ibfk_2` FOREIGN KEY (`IdCurso`) REFERENCES `cursos` (`id_Cursos`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `respuestas_ibfk_3` FOREIGN KEY (`IdEstudiante`) REFERENCES `estudiantes` (`id_Estudiante`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
