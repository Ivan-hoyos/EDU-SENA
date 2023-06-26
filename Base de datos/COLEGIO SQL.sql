-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-06-2023 a las 09:39:59
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
  `Materia` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `actividades`
--

INSERT INTO `actividades` (`IdActividad`, `Titulo`, `Descripcion`, `FechaCreacion`, `ProfesorId`, `IdCurso`, `Materia`) VALUES
(4, 'HEfdsihdgdhgf', '5656565', '2023-06-25 20:23:33', 100, '11A', 'Español'),
(5, 'SISA97', '5656565', '2023-06-25 20:12:38', 100, '11A', 'Español'),
(6, 'SISA97', '5656565', '2023-06-25 20:12:38', 100, '11A', 'Español'),
(7, 'hjh', 'hjh', '2023-06-25 16:32:00', 100, '7C', 'Ingles'),
(8, 'TALLER #5 DE ARTES PLASTICAS', 'RESPONDA LAS SIGUIENTES PREGUNTAS:\n\n1) ¿CUANDO GANÓ JUNIOR SU 9° ESTRELLA?\n2) ¿QUIEN ES EL MAXIMO GOLEADOR DE JUNIOR?\n3) ¿QUIEN ES EL JUGADOR CON MAS PARTIDOS EN JUNIOR?\n4) ¿QUIEN ANOTO EL ULTIMO GOL DE LA FINAL CONTRA DIM EN 2018 ||?\n\nFRBS', '2023-06-25 20:29:43', 100, '11C', 'Arte');

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
(3, 'Español'),
(4, 'Arte');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `id_Cursos` varchar(3) NOT NULL,
  `Grado` int(11) NOT NULL,
  `Seccion` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`id_Cursos`, `Grado`, `Seccion`) VALUES
('10A', 10, 'A'),
('10B', 10, 'B'),
('10C', 10, 'C'),
('11A', 11, 'A'),
('11B', 11, 'B'),
('11C', 11, 'C'),
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
('9C', 9, 'C');

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
  `Grado` int(11) DEFAULT NULL,
  `Seccion` char(1) DEFAULT NULL,
  `id_Curso` varchar(5) DEFAULT NULL,
  `Contraseña` varchar(20) NOT NULL,
  `Rol` varchar(10) NOT NULL DEFAULT 'student',
  `Sexo` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estudiantes`
--

INSERT INTO `estudiantes` (`id_Estudiante`, `Nombres`, `Apellidos`, `Fecha_Nacimiento`, `Direccion`, `Telefono`, `Email`, `Grado`, `Seccion`, `id_Curso`, `Contraseña`, `Rol`, `Sexo`) VALUES
(1, 'Juan', 'Pérez', '2005-01-28', 'Calle A, Ciudad c', 123456789, 'juan@example.com', 9, 'A', '11C', '123', 'student', 'M'),
(1043695754, 'Luis Angel', 'Castro Cabrera', '2002-06-28', 'Calle 72 # 17-64', 3105689965, 'luis@gmail.com', NULL, NULL, '11A', '123', 'student', 'M');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `idhorario` int(11) NOT NULL,
  `Dia` varchar(10) NOT NULL,
  `HoraInicio` int(11) NOT NULL,
  `HoraFin` int(11) NOT NULL,
  `idMateria` int(11) NOT NULL,
  `idProfesor` int(11) NOT NULL,
  `idCurso` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `horarios`
--

INSERT INTO `horarios` (`idhorario`, `Dia`, `HoraInicio`, `HoraFin`, `idMateria`, `idProfesor`, `idCurso`) VALUES
(1, 'Lunes', 7, 8, 1, 100, '6A'),
(2, 'Martes', 7, 8, 1, 100, '6A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notas`
--

CREATE TABLE `notas` (
  `id_Notas` int(11) NOT NULL,
  `id_Alumno` int(11) NOT NULL,
  `id_Profesor` int(11) NOT NULL,
  `id_Asignatura` int(11) NOT NULL,
  `id_Curso` varchar(3) NOT NULL,
  `promedio` float NOT NULL
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
  `Sexo` varchar(3) DEFAULT NULL,
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
(100, 'angel', 'cabrera', '2002-06-25', 'M', 'calle 50', 'angel@gmail.com', 321, 'xxx', 'teacher', 6, 'Artes', '6A'),
(4464, 'ddjljl', 'jlfjlj', NULL, NULL, 'fljlfj', 'ljfljfl', 64464, 'fsfs64', 'teacher', 3, 'Historia', '6A'),
(1046426, 'Juan', 'Gomez', NULL, NULL, 'Calle 20', 'juan@gmail.com', 310464, '123', 'teacher', 6, 'Artes', '11A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuestas`
--

CREATE TABLE `respuestas` (
  `IdRespuesta` int(11) NOT NULL,
  `IdActividad` int(11) NOT NULL,
  `IdEstudiante` int(11) NOT NULL,
  `NombreEstudiante` varchar(60) NOT NULL,
  `IdCurso` varchar(4) NOT NULL,
  `Respuesta` longtext NOT NULL,
  `FechaEnvio` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `respuestas`
--

INSERT INTO `respuestas` (`IdRespuesta`, `IdActividad`, `IdEstudiante`, `NombreEstudiante`, `IdCurso`, `Respuesta`, `FechaEnvio`) VALUES
(2, 8, 1, 'Juan', '11C', 'holhs ', '2023-06-26 02:28:33'),
(3, 8, 1, 'Juan', '11C', 'lllll', '2023-06-26 02:33:14');

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
  ADD KEY `ProfesorId` (`ProfesorId`);

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
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`idhorario`),
  ADD KEY `idCurso` (`idCurso`),
  ADD KEY `idMateria` (`idMateria`),
  ADD KEY `idProfesor` (`idProfesor`);

--
-- Indices de la tabla `notas`
--
ALTER TABLE `notas`
  ADD PRIMARY KEY (`id_Notas`),
  ADD KEY `id_Alumno` (`id_Alumno`),
  ADD KEY `id_Profesor` (`id_Profesor`),
  ADD KEY `id_Asignatura` (`id_Asignatura`),
  ADD KEY `id_Curso` (`id_Curso`);

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
  MODIFY `IdActividad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  MODIFY `id_Asignatura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `idhorario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `notas`
--
ALTER TABLE `notas`
  MODIFY `id_Notas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `respuestas`
--
ALTER TABLE `respuestas`
  MODIFY `IdRespuesta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD CONSTRAINT `actividades_ibfk_1` FOREIGN KEY (`IdCurso`) REFERENCES `cursos` (`id_Cursos`),
  ADD CONSTRAINT `actividades_ibfk_2` FOREIGN KEY (`ProfesorId`) REFERENCES `profesores` (`id_Profesor`);

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
-- Filtros para la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD CONSTRAINT `horarios_ibfk_1` FOREIGN KEY (`idCurso`) REFERENCES `cursos` (`id_Cursos`),
  ADD CONSTRAINT `horarios_ibfk_2` FOREIGN KEY (`idMateria`) REFERENCES `asignaturas` (`id_Asignatura`),
  ADD CONSTRAINT `horarios_ibfk_3` FOREIGN KEY (`idProfesor`) REFERENCES `profesores` (`id_Profesor`);

--
-- Filtros para la tabla `notas`
--
ALTER TABLE `notas`
  ADD CONSTRAINT `notas_ibfk_1` FOREIGN KEY (`id_Alumno`) REFERENCES `estudiantes` (`id_Estudiante`),
  ADD CONSTRAINT `notas_ibfk_2` FOREIGN KEY (`id_Profesor`) REFERENCES `profesores` (`id_Profesor`),
  ADD CONSTRAINT `notas_ibfk_3` FOREIGN KEY (`id_Asignatura`) REFERENCES `asignaturas` (`id_Asignatura`),
  ADD CONSTRAINT `notas_ibfk_4` FOREIGN KEY (`id_Curso`) REFERENCES `cursos` (`id_Cursos`);

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
  ADD CONSTRAINT `respuestas_ibfk_2` FOREIGN KEY (`IdCurso`) REFERENCES `cursos` (`id_Cursos`),
  ADD CONSTRAINT `respuestas_ibfk_3` FOREIGN KEY (`IdEstudiante`) REFERENCES `estudiantes` (`id_Estudiante`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
