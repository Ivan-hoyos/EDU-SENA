-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-06-2023 a las 09:08:05
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
CREATE DATABASE IF NOT EXISTS `colegio` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `colegio`;

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
-- RELACIONES PARA LA TABLA `admin`:
--   `Rol`
--       `roles` -> `id_Rol`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaturas`
--

CREATE TABLE `asignaturas` (
  `id_Asignatura` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `asignaturas`:
--

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
-- RELACIONES PARA LA TABLA `cursos`:
--

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
-- RELACIONES PARA LA TABLA `estudiantes`:
--   `id_Curso`
--       `cursos` -> `id_Cursos`
--   `Rol`
--       `roles` -> `id_Rol`
--

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
-- RELACIONES PARA LA TABLA `horarios`:
--   `idCurso`
--       `cursos` -> `id_Cursos`
--   `idMateria`
--       `asignaturas` -> `id_Asignatura`
--   `idProfesor`
--       `profesores` -> `id_Profesor`
--

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

--
-- RELACIONES PARA LA TABLA `notas`:
--   `id_Alumno`
--       `estudiantes` -> `id_Estudiante`
--   `id_Profesor`
--       `profesores` -> `id_Profesor`
--   `id_Asignatura`
--       `asignaturas` -> `id_Asignatura`
--   `id_Curso`
--       `cursos` -> `id_Cursos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `id_Profesor` int(11) NOT NULL,
  `Nombres` varchar(45) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
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
-- RELACIONES PARA LA TABLA `profesores`:
--   `Rol`
--       `roles` -> `id_Rol`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_Rol` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- RELACIONES PARA LA TABLA `roles`:
--

--
-- Índices para tablas volcadas
--

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
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_Rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  MODIFY `id_Asignatura` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `idhorario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `notas`
--
ALTER TABLE `notas`
  MODIFY `id_Notas` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
