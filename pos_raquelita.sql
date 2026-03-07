-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-03-2026 a las 19:07:09
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pos_raquelita`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caja_diaria`
--

CREATE TABLE `caja_diaria` (
  `id` int(11) NOT NULL,
  `base_inicial` double DEFAULT NULL,
  `fecha_apertura` datetime DEFAULT NULL,
  `fecha_cierre` datetime DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `cajero` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `caja_diaria`
--

INSERT INTO `caja_diaria` (`id`, `base_inicial`, `fecha_apertura`, `fecha_cierre`, `estado`, `cajero`) VALUES
(1, 1000, '2026-03-06 10:10:32', '2026-03-06 10:28:27', 'CERRADA', 'Mosca'),
(2, 10000, '2026-03-06 11:43:15', '2026-03-06 12:26:27', 'CERRADA', 'James'),
(3, 10000, '2026-03-06 12:29:17', '2026-03-06 12:55:45', 'CERRADA', 'Mosca');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comandas`
--

CREATE TABLE `comandas` (
  `id` int(11) NOT NULL,
  `mesa` varchar(50) DEFAULT NULL,
  `detalle` text DEFAULT NULL,
  `estado` varchar(20) DEFAULT 'PENDIENTE',
  `fecha` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comandas`
--

INSERT INTO `comandas` (`id`, `mesa`, `detalle`, `estado`, `fecha`) VALUES
(1, 'Factura de: Mesa 1', '1x Capuchino sin Torta\n1x Jugo Mango en Agua\n', 'LISTO', '2026-03-06 17:03:03'),
(2, 'Factura de: Mesa 2', '2x Jugo de Mora en Agua\n1x Café Americano\n', 'LISTO', '2026-03-06 17:03:41'),
(3, 'Factura de: Mesa 1', '1x Jugo de Mora en Agua\n', 'LISTO', '2026-03-06 17:04:12'),
(4, 'Factura de: Mesa 1', '1x Café Americano\n', 'LISTO', '2026-03-06 17:16:30'),
(5, 'Factura de: Mesa 3', '1x Café Americano\n', 'LISTO', '2026-03-06 17:17:31'),
(6, 'Factura de: Mesa 1', '1x Café Americano\n', 'LISTO', '2026-03-06 17:18:43'),
(7, 'Factura de: Mesa 5', '1x Café Americano\n', 'LISTO', '2026-03-06 17:19:37'),
(8, 'Factura de: Mesa 2', '2x Café Americano\n', 'LISTO', '2026-03-06 17:26:04'),
(9, 'Factura de: Mesa 1', '1x Café Americano\n', 'LISTO', '2026-03-06 17:29:24'),
(10, 'Factura de: Mesa 1', '1x Café Americano\n', 'PENDIENTE', '2026-03-06 17:29:29'),
(11, 'Mesa 1', '1x Aguapanela sin Queso \n', 'LISTO', '2026-03-06 17:55:19'),
(12, 'Mesa 1', '1x Aguapanela sin Queso \n', 'PENDIENTE', '2026-03-06 17:55:25');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos_temporales`
--

CREATE TABLE `pedidos_temporales` (
  `id` int(11) NOT NULL,
  `mesa` varchar(50) NOT NULL,
  `producto` varchar(100) NOT NULL,
  `precio` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `subtotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `categoria`, `precio`, `cantidad`) VALUES
(1, 'Café Americano', 'Bebidas Calientes', 3000, 3),
(2, 'Capuchino sin Torta', 'Bebidas Calientes', 6000, 18),
(4, 'Jugo de Mora en Agua', 'Bebidas Calientes', 12000, 11),
(5, 'Aguapanela sin Queso ', 'Bebidas Calientes', 6000, 18),
(6, 'Jugo Mango en Agua', 'Bebidas Calientes', 12000, 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id_factura` int(11) DEFAULT NULL,
  `producto` varchar(100) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `fecha` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id_factura`, `producto`, `cantidad`, `subtotal`, `fecha`) VALUES
(1, 'Café Americano', 2, 6000, '2026-03-06 10:10:49'),
(1, 'Jugo de Mora en Agua', 2, 24000, '2026-03-06 10:10:49'),
(1, 'Jugo Mango en Agua', 1, 12000, '2026-03-06 10:10:50'),
(2, 'Aguapanela sin Queso ', 1, 6000, '2026-03-06 10:15:06'),
(2, 'Café Americano', 1, 3000, '2026-03-06 10:15:06'),
(3, 'Capuchino sin Torta', 1, 6000, '2026-03-06 12:03:18'),
(3, 'Jugo Mango en Agua', 1, 12000, '2026-03-06 12:03:19'),
(4, 'Jugo de Mora en Agua', 1, 12000, '2026-03-06 12:05:02'),
(5, 'Jugo de Mora en Agua', 2, 24000, '2026-03-06 12:05:08'),
(5, 'Café Americano', 1, 3000, '2026-03-06 12:05:08'),
(6, 'Café Americano', 1, 3000, '2026-03-06 12:17:18'),
(7, 'Café Americano', 1, 3000, '2026-03-06 12:18:21'),
(8, 'Café Americano', 1, 3000, '2026-03-06 12:18:49'),
(9, 'Café Americano', 1, 3000, '2026-03-06 12:19:42'),
(10, 'Café Americano', 2, 6000, '2026-03-06 12:26:12'),
(11, 'Café Americano', 1, 3000, '2026-03-06 12:29:29'),
(12, 'Aguapanela sin Queso ', 1, 6000, '2026-03-06 12:55:25');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `caja_diaria`
--
ALTER TABLE `caja_diaria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `comandas`
--
ALTER TABLE `comandas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pedidos_temporales`
--
ALTER TABLE `pedidos_temporales`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `caja_diaria`
--
ALTER TABLE `caja_diaria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `comandas`
--
ALTER TABLE `comandas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `pedidos_temporales`
--
ALTER TABLE `pedidos_temporales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
