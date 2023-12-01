-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2023 a las 23:36:50
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `doppler`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bean`
--

CREATE TABLE `bean` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `origin_region` varchar(255) DEFAULT NULL,
  `scientific_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bean`
--

INSERT INTO `bean` (`id`, `name`, `origin_region`, `scientific_name`) VALUES
(1, 'Frijol Negro', 'América Latina', 'Phaseolus vulgaris'),
(2, 'Frijol Pinto', 'América Latina', 'Phaseolus vulgaris'),
(3, 'Frijol Rojo', 'América Latina', 'Phaseolus vulgaris'),
(4, 'Frijol Adzuki', 'Asia', 'Vigna angularis'),
(5, 'Frijol Cannellini', 'Italia', 'Phaseolus vulgaris'),
(6, 'Frijol Lima', 'América Latina', 'Phaseolus lunatus'),
(7, 'Frijol Mungo', 'Asia', 'Vigna radiata'),
(8, 'Frijol Garbanzo', 'Oriente Medio', 'Cicer arietinum'),
(9, 'Frijol Azuki', 'Asia', 'Vigna angularis'),
(10, 'Frijol Canario', 'América Latina', 'Phaseolus vulgaris');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partner`
--

CREATE TABLE `partner` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `partner`
--

INSERT INTO `partner` (`id`, `name`, `type`, `description`) VALUES
(1, 'AgroIndustrias S.A.', 'JURIDICA', NULL),
(2, 'Juan Pérez Agricultor', 'NATURAL', NULL),
(3, 'Fundación para la Investigación Agrícola', 'JURIDICA', NULL),
(4, 'Banco Agrario Internacional', 'JURIDICA', NULL),
(5, 'María Rodríguez Empresaria', 'NATURAL', NULL),
(6, 'Cooperativa de Agricultores Unidos', 'JURIDICA', NULL),
(7, 'Carlos Gómez Inversionista', 'NATURAL', NULL),
(8, 'Instituto de Desarrollo Rural', 'JURIDICA', NULL),
(9, 'Elena Vargas Financiera', 'NATURAL', NULL),
(10, 'Fondo Nacional de Agricultura Sostenible', 'JURIDICA', NULL),
(11, 'Compañía Agroquímica Innovadora', 'JURIDICA', NULL),
(12, 'Pedro Navarro Inversionista', 'NATURAL', NULL),
(13, 'Ana López Agricultora', 'NATURAL', NULL),
(14, 'Asociación de Empresas Agroalimentarias', 'JURIDICA', NULL),
(15, 'Fundación para la Investigación Ambiental', 'JURIDICA', NULL),
(16, 'Nuevo Partner SAS', 'JURIDICA', 'Nos gusta ayudar al medio ambiente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `project`
--

CREATE TABLE `project` (
  `id` int(11) NOT NULL,
  `bean_id` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `project`
--

INSERT INTO `project` (`id`, `bean_id`, `description`, `name`, `status`) VALUES
(1, '0', 'Implementación de prácticas agrícolas sostenibles para aumentar la productividad del frijol.', 'Prácticas Agrícolas Sostenibles', 'Aprobación'),
(2, '2', 'Desarrollo de variedades de frijol resistentes a enfermedades comunes en la región.', 'Variedades Resistentes', 'Ejecución'),
(3, '3', 'Investigación sobre la optimización del uso de fertilizantes para mejorar la calidad del suelo y aumentar el rendimiento.', 'Optimización de Fertilizantes', 'Financiamiento'),
(4, '1', 'Estudio de la influencia del clima en el rendimiento del frijol y desarrollo de estrategias de adaptación.', 'Adaptación al Clima', 'Planificación'),
(5, '2', 'Estudio de microorganismos beneficiosos para promover la salud del suelo y aumentar la resistencia de los frijoles.', 'Microbioma del Suelo', 'Aprobación'),
(6, '4', 'Investigación sobre técnicas de riego eficientes para optimizar el uso del agua en el cultivo de frijol.', 'Riego Eficiente', 'Ejecución'),
(7, '3', 'Desarrollo de tecnologías de monitoreo remoto para evaluar el estado de los cultivos de frijol y tomar decisiones informadas.', 'Monitoreo Remoto', 'Evaluación'),
(8, '2', 'Estudio de la interacción entre diferentes cultivos y su impacto en el rendimiento del frijol en sistemas de cultivo mixto.', 'Cultivos Asociados', 'Informe Intermedio'),
(9, '3', 'Investigación sobre prácticas de manejo integrado de plagas para reducir el impacto de insectos y enfermedades en los cultivos de frijol.', 'Manejo Integrado de Plagas', 'Informe Intermedio'),
(10, '1', 'Desarrollo de estrategias de polinización para mejorar la producción de frijoles mediante el aumento de la polinización.', 'Estrategias de Polinización', 'Archivado'),
(11, '1', 'Investigación sobre la adaptación de variedades de frijol a diferentes altitudes para promover el cultivo en diversas regiones.', 'Adaptación a la Altitud', 'Financiamiento'),
(12, '3', 'Estudio de la influencia de la luz artificial en el crecimiento y rendimiento de los frijoles en invernaderos.', 'Iluminación en Invernaderos', 'Monitoreo'),
(17, '1', 'Trabajando en mejorar las cosas, con la nueva versión', 'Versión 2.0 Del Proyecto', 'Evaluación'),
(18, '1', 'Trabajando en mejorar las cosas, con la nueva versión definitiva', 'Versión 3.0 Del Proyecto', 'Monitoreo'),
(20, '1', 'Prueba 2 -Deberia aparecer una nueva descripción si la modificación fue un éxito', 'Versión 4.0 Del Proyecto', 'Monitoreo'),
(21, '6', 'Descripción Perrona', 'Probando', 'Ejecución'),
(22, '5', 'Testeando elementos visibles', 'Test Partners_ID', 'Ejecución'),
(23, '6', 'Buscamos la mejora continua de las necesidad sociales, a tráves de nuestros asociados en el CIAT', 'Probando proyecto de trabajao', 'Monitoreo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `project_partners_id`
--

CREATE TABLE `project_partners_id` (
  `project_id` int(11) NOT NULL,
  `partners_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `project_partners_id`
--

INSERT INTO `project_partners_id` (`project_id`, `partners_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 1),
(1, 4),
(1, 5),
(22, 2),
(22, 5),
(22, 15),
(23, 3),
(23, 4),
(23, 5),
(11, 3),
(11, 4),
(11, 6);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bean`
--
ALTER TABLE `bean`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `partner`
--
ALTER TABLE `partner`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `project_partners_id`
--
ALTER TABLE `project_partners_id`
  ADD KEY `FKmxds5vxf6gb7teika8lk58vh2` (`project_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bean`
--
ALTER TABLE `bean`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `partner`
--
ALTER TABLE `partner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `project`
--
ALTER TABLE `project`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `project_partners_id`
--
ALTER TABLE `project_partners_id`
  ADD CONSTRAINT `FKmxds5vxf6gb7teika8lk58vh2` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
