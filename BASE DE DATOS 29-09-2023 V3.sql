-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-09-2023 a las 02:57:40
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
-- Base de datos: `reservas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `accesorios`
--

CREATE TABLE `accesorios` (
  `fk_salon` int(5) NOT NULL,
  `interlock` tinyint(1) NOT NULL,
  `vga` tinyint(1) NOT NULL,
  `hdmi` tinyint(1) NOT NULL,
  `audio` tinyint(1) NOT NULL,
  `adp_conversor` tinyint(1) NOT NULL,
  `tv` tinyint(1) NOT NULL,
  `proyector` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `accesorios`
--

INSERT INTO `accesorios` (`fk_salon`, `interlock`, `vga`, `hdmi`, `audio`, `adp_conversor`, `tv`, `proyector`) VALUES
(1, 0, 0, 0, 0, 0, 0, 0),
(2, 0, 0, 0, 0, 0, 0, 0),
(3, 0, 0, 0, 0, 0, 0, 0),
(4, 0, 0, 1, 0, 0, 1, 0),
(5, 0, 0, 1, 0, 0, 1, 0),
(6, 0, 0, 1, 0, 0, 1, 0),
(7, 1, 0, 1, 0, 0, 0, 1),
(8, 1, 0, 1, 0, 0, 0, 1),
(9, 0, 0, 0, 0, 0, 0, 0),
(10, 0, 0, 0, 0, 0, 0, 0),
(11, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras`
--

CREATE TABLE `carreras` (
  `id_carrera` int(5) NOT NULL,
  `nombre_carrera` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `carreras`
--

INSERT INTO `carreras` (`id_carrera`, `nombre_carrera`) VALUES
(1, 'Educación Primaria'),
(2, 'Educación Física'),
(3, 'Lengua y Literatura'),
(4, 'Enfermería'),
(5, 'Analista en Sistemas'),
(6, 'Admin. Agropecuaria'),
(999, 'Varias');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos`
--

CREATE TABLE `permisos` (
  `id_permiso` int(2) NOT NULL,
  `nombre_permiso` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `permisos`
--

INSERT INTO `permisos` (`id_permiso`, `nombre_permiso`) VALUES
(1, 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `dni` int(9) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `fk_id_carrera` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`dni`, `nombre`, `apellido`, `fk_id_carrera`) VALUES
(11180730, 'Oscar', 'Zudaire', 4),
(12150373, 'Rosa Gladys', 'Saparrat', 1),
(12401165, 'Sergio', 'Ortega', 5),
(14751994, 'Rosana', 'Romano', 1),
(16303912, 'Esther Beatriz', 'Dublanc', 4),
(17210364, 'Maria Gabriela', 'Deltell', 1),
(17480487, 'Carlos', 'Barragan', 4),
(21325322, 'Juan Hector Salomón', 'Medina', 4),
(21448043, 'Natalia', 'Fuentes', 1),
(21448097, 'Maria Alesandra', 'Carregado', 4),
(21590705, 'Alejandra Gabriela', 'Patane', 4),
(21674310, 'Jose Alejandro', 'Albello', 2),
(22024664, 'Marcos', 'Sayavedra', 1),
(22292579, 'Diana Raquel', 'Bacigalupe', 4),
(22551187, 'Christian', 'Barth', 2),
(22922273, 'Romina', 'Calmet', 4),
(23209200, 'Ruben Emilio', 'Aboy', 2),
(23219047, 'Romina', 'Lorenzetti', 4),
(23485863, 'Enzo', 'Aguirre Sanchez', 2),
(23555726, 'Jose Luis', 'Soria', 999),
(23698591, 'Victor Alfredo', 'Davancens', 2),
(23698611, 'Roberto Hector Gaston', 'Rivero', 4),
(24695708, 'Viviana', 'Rey', 999),
(24914542, 'Maria Elva', 'Kehler Diviasi', 1),
(25509032, 'Marina Emilce', 'Mandrini', 999),
(25509169, 'Mercedes', 'Dumon', 1),
(25739626, 'Raimundo', 'Harguindequy', 2),
(25930710, 'Maria Soledad', 'Chavez', 999),
(26729110, 'Paula', 'Pollio', 1),
(26775522, 'Fabiola', 'Armani', 1),
(27116527, 'Carlos', 'Alessandro', 1),
(27388852, 'Daniela Marcela', 'Silva', 1),
(27802094, 'Analia', 'Gerez', 2),
(27830954, 'Sebastián', 'Esains', 5),
(28289409, 'Laura', 'Valenzuela', 4),
(28741807, 'Maria Pia', 'Hourcade', 2),
(28741842, 'Santiago', 'Diaz', 2),
(28936312, 'Cristian', 'Disanto', 5),
(29375390, 'Maricel', 'Etchemendy', 999),
(29549226, 'Maria Juliana', 'Juriorena', 1),
(29885868, 'Daniela', 'Rabainera', 4),
(30698728, 'Gerardo', 'Landaburu', 2),
(31237389, 'Maria Soledad', 'Di Candilo', 2),
(31237456, 'Elba Haydee', 'Irungaray', 999),
(31779221, 'Maria Belen', 'Celiberti', 2),
(31779310, 'Maria Florencia', 'Miquelarena De Fabio', 6),
(31779373, 'Celeste', 'Calandria', 6),
(32362211, 'José Daniel', 'Molfesa', 2),
(32768712, 'Carolina', 'Harkes', 1),
(32815113, 'Rocio', 'Landaburu', 4),
(32815118, 'Jorge Norberto', 'Dulce', 1),
(33328381, 'Facundo Nicolas', 'Caballero', 1),
(33328430, 'Fabián', 'Goro', 2),
(33917951, 'Jimena Gisela', 'Mandrini', 6),
(33917959, 'Agustina', 'Dotras', 4),
(34466183, 'Gabriela', 'Zudaire', 5),
(35540445, 'Maria Lujan', 'Vergez', 5),
(35797720, 'Yanil', 'Fernandez', 1),
(36933068, 'Angelina', 'Corsi', 5),
(36933195, 'Roxana', 'Feller', 999),
(37380262, 'Lucrecia Mabel', 'Benencia', 6),
(37871053, 'Luciana', 'Guzman', 999),
(38658533, 'Juliana', 'Echeconanea', 6),
(38658649, 'Juan Manuel', 'Eguia', 2),
(39278793, 'Maria Victoria', 'Bouzas', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `id_reserva` int(5) NOT NULL,
  `fk_usuario` int(5) NOT NULL,
  `fk_salon` int(5) NOT NULL,
  `fecha_reserva` varchar(10) NOT NULL,
  `horario` varchar(11) NOT NULL,
  `carrera` int(5) NOT NULL,
  `profesor` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`id_reserva`, `fk_usuario`, `fk_salon`, `fecha_reserva`, `horario`, `carrera`, `profesor`) VALUES
(39, 4, 1, '25/09/2023', '08:00-10:00', 5, 28936312),
(40, 4, 1, '26/09/2023', '08:00-10:00', 2, 22551187),
(41, 4, 1, '27/09/2023', '18:00-20:00', 2, 33328430),
(42, 4, 1, '28/09/2023', '16:00-18:00', 5, 35540445),
(43, 4, 1, '29/09/2023', '20:00-22:00', 5, 36933068),
(44, 4, 1, '29/09/2023', '18:00-20:00', 5, 36933068),
(45, 4, 1, '29/09/2023', '10:00-12:00', 5, 36933068);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salones`
--

CREATE TABLE `salones` (
  `id_salon` int(5) NOT NULL,
  `nombre_salon` varchar(255) NOT NULL,
  `tamaño` varchar(500) NOT NULL,
  `observaciones` varchar(400) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `salones`
--

INSERT INTO `salones` (`id_salon`, `nombre_salon`, `tamaño`, `observaciones`) VALUES
(1, 'Salon 1', 'Normal', ''),
(2, 'Salon 2', 'Pequeño', ''),
(3, 'Salon 3', 'Pequeño', ''),
(4, 'Salon 4', 'Mediano', ''),
(5, 'Salon 5', 'Mediano', ''),
(6, 'Salon 6', 'Mediano', ''),
(7, 'Salon 7', 'Grande', ''),
(8, 'Salon 8', 'Grande', ''),
(9, 'Computacion', 'Pequeño', ''),
(10, 'Biblioteca', 'Mediano', '0'),
(11, 'Laboratorio', 'Mediano', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `ID_usuario` int(5) NOT NULL,
  `fk_permiso` int(2) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `contraseña` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID_usuario`, `fk_permiso`, `nombre`, `contraseña`) VALUES
(3, 1, 'Ayrton', '123456'),
(4, 1, 'Karina', 'Kari123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `accesorios`
--
ALTER TABLE `accesorios`
  ADD KEY `fk_salon` (`fk_salon`);

--
-- Indices de la tabla `carreras`
--
ALTER TABLE `carreras`
  ADD PRIMARY KEY (`id_carrera`);

--
-- Indices de la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD PRIMARY KEY (`id_permiso`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`dni`),
  ADD KEY `fk_id_carrera` (`fk_id_carrera`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`id_reserva`),
  ADD KEY `fk_usuario` (`fk_usuario`,`fk_salon`,`carrera`,`profesor`),
  ADD KEY `fk_salon` (`fk_salon`),
  ADD KEY `carrera` (`carrera`),
  ADD KEY `profesor` (`profesor`);

--
-- Indices de la tabla `salones`
--
ALTER TABLE `salones`
  ADD PRIMARY KEY (`id_salon`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`ID_usuario`),
  ADD KEY `fk_permiso` (`fk_permiso`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carreras`
--
ALTER TABLE `carreras`
  MODIFY `id_carrera` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1003;

--
-- AUTO_INCREMENT de la tabla `permisos`
--
ALTER TABLE `permisos`
  MODIFY `id_permiso` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `id_reserva` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT de la tabla `salones`
--
ALTER TABLE `salones`
  MODIFY `id_salon` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `ID_usuario` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `accesorios`
--
ALTER TABLE `accesorios`
  ADD CONSTRAINT `accesorios_ibfk_1` FOREIGN KEY (`fk_salon`) REFERENCES `salones` (`id_salon`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD CONSTRAINT `profesores_ibfk_1` FOREIGN KEY (`fk_id_carrera`) REFERENCES `carreras` (`id_carrera`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`fk_usuario`) REFERENCES `usuarios` (`ID_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`fk_salon`) REFERENCES `salones` (`id_salon`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservas_ibfk_3` FOREIGN KEY (`carrera`) REFERENCES `carreras` (`id_carrera`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservas_ibfk_4` FOREIGN KEY (`profesor`) REFERENCES `profesores` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_2` FOREIGN KEY (`fk_permiso`) REFERENCES `permisos` (`id_permiso`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
