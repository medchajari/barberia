-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-05-2025 a las 13:25:21
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
-- Base de datos: `barberia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen`
--

CREATE TABLE `almacen` (
  `idAlmacen` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `almacen`
--

INSERT INTO `almacen` (`idAlmacen`, `nombre`, `direccion`) VALUES
(1, 'Agustin Rivero CC', 'Av. Belgrano 1497');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `barbero`
--

CREATE TABLE `barbero` (
  `idBarbero` int(11) NOT NULL,
  `nombreBarbero` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `barbero`
--

INSERT INTO `barbero` (`idBarbero`, `nombreBarbero`) VALUES
(4, 'Juan Perez'),
(6, 'Agustin Rivero'),
(7, 'Matias Barreto'),
(9, 'Ximena Lopez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cajabarbero`
--

CREATE TABLE `cajabarbero` (
  `idCajaBarbero` int(11) NOT NULL,
  `idBarbero` int(11) NOT NULL,
  `saldo` decimal(10,2) NOT NULL DEFAULT 0.00,
  `fecha` date DEFAULT NULL,
  `idCajaGeneral` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cajabarbero`
--

INSERT INTO `cajabarbero` (`idCajaBarbero`, `idBarbero`, `saldo`, `fecha`, `idCajaGeneral`) VALUES
(6, 6, 0.00, '2024-08-29', 12),
(7, 7, 433.00, '2024-08-29', 12),
(8, 7, 3950.00, '2024-08-30', 13),
(9, 7, 3950.00, '2024-08-30', 13),
(10, 6, 3950.00, '2024-08-30', 13),
(11, 4, 7902.00, '2024-08-30', 13),
(12, 7, 7900.00, '2024-08-31', 14),
(13, 7, 3950.00, '2024-09-02', 15),
(14, 6, 7800.00, '2024-09-02', 15),
(15, 4, 1000.00, '2024-09-02', 15),
(17, 9, 3000.00, '2024-09-02', 15),
(18, 6, 100.00, '2024-10-07', 16),
(19, 4, 33.00, '2025-04-12', 17),
(20, 4, 22.00, '2025-04-12', 17),
(21, 4, 0.00, '2025-04-12', 17),
(22, 9, 1400.00, '2025-04-12', 17);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cajageneral`
--

CREATE TABLE `cajageneral` (
  `idCajaGeneral` int(11) NOT NULL,
  `saldo` decimal(10,2) NOT NULL DEFAULT 0.00,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cajageneral`
--

INSERT INTO `cajageneral` (`idCajaGeneral`, `saldo`, `fecha`) VALUES
(12, 10002.00, '2024-08-29'),
(13, 32240.00, '2024-08-30'),
(14, 3950.00, '2024-08-31'),
(15, 13850.00, '2024-09-02'),
(16, 100.00, '2024-10-07'),
(17, 1433.00, '2025-04-12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nombre`, `direccion`, `telefono`) VALUES
(3, 'Martin De Los Santos', 'Pablo stampa 3325', '3456468873'),
(4, 'Margarita de los santos', 'Pablo Stampa 3325', '3456468874'),
(5, 'Consumidor Final', 'Sin especificar', 'Sin especificar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentacorriente`
--

CREATE TABLE `cuentacorriente` (
  `idCuentaCorriente` int(11) NOT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `saldo` decimal(10,2) DEFAULT 0.00,
  `idBarbero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuentacorriente`
--

INSERT INTO `cuentacorriente` (`idCuentaCorriente`, `idCliente`, `saldo`, `idBarbero`) VALUES
(4, 3, 30.00, 6),
(5, 4, 558.00, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecaja`
--

CREATE TABLE `detallecaja` (
  `idDetalleCaja` int(11) NOT NULL,
  `idMovimiento` int(11) NOT NULL,
  `idTipoPago` int(11) NOT NULL,
  `monto` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecuentacorriente`
--

CREATE TABLE `detallecuentacorriente` (
  `idDetalleCuentaCorriente` int(11) NOT NULL,
  `idCuentaCorriente` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `monto` decimal(10,2) DEFAULT NULL,
  `esCredito` tinyint(1) DEFAULT NULL,
  `fechaMovimiento` date DEFAULT NULL,
  `idBarbero` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detallecuentacorriente`
--

INSERT INTO `detallecuentacorriente` (`idDetalleCuentaCorriente`, `idCuentaCorriente`, `fecha`, `descripcion`, `monto`, `esCredito`, `fechaMovimiento`, `idBarbero`) VALUES
(2, 4, NULL, 'prueba 2', 22.00, NULL, '2024-08-31', NULL),
(3, 4, NULL, 'prueba 3', 100.00, NULL, '2024-08-31', NULL),
(4, 4, NULL, 'prueba 4', 50.00, NULL, '2024-09-01', NULL),
(5, 4, NULL, 'prueba 5', 77.00, NULL, '2024-09-01', NULL),
(6, 4, NULL, 'prueba 6', 81.00, NULL, '2024-09-01', NULL),
(7, 5, NULL, 'prueba 7', 91.00, NULL, '2024-09-01', 6),
(8, 5, NULL, 'prueba 7', 10.00, NULL, '2024-09-01', 7),
(9, 5, NULL, 'prueba 12', 123.00, NULL, '2024-09-01', 4),
(10, 5, NULL, 'prueba 12', 134.00, NULL, '2024-09-01', 6),
(11, 5, NULL, 'prueba 12', 150.00, NULL, '2024-09-01', 7),
(12, 5, NULL, 'prueba 13', 50.00, NULL, '2024-09-01', 6),
(13, 5, NULL, 'prueba cifras monto', 10000.00, NULL, '2024-09-01', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `local`
--

CREATE TABLE `local` (
  `idLocal` int(11) NOT NULL,
  `nombreLocal` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `local`
--

INSERT INTO `local` (`idLocal`, `nombreLocal`) VALUES
(2, 'La Barberia'),
(3, 'AR Belgrano'),
(9, 'Licencias');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientocaja`
--

CREATE TABLE `movimientocaja` (
  `idMovimiento` int(11) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp(),
  `esIngreso` tinyint(1) NOT NULL,
  `idCajaGeneral` int(11) DEFAULT NULL,
  `idCajaBarbero` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `movimientocaja`
--

INSERT INTO `movimientocaja` (`idMovimiento`, `descripcion`, `monto`, `fecha`, `esIngreso`, `idCajaGeneral`, `idCajaBarbero`) VALUES
(19, 'Abono de Martin De Los Santos', 6000.00, '2024-08-29 00:00:00', 1, 12, 7),
(20, 'Abono de Margarita de los santos', 10000.00, '2024-08-29 00:00:00', 1, 12, 6),
(21, 'Abono de Martin De Los Santos', 2.00, '2024-08-29 00:00:00', 1, 12, 7),
(22, 'Abono de Martin De Los Santos', 2.00, '2024-08-30 00:00:00', 1, 13, 8),
(23, 'Abono de Martin De Los Santos', 2.00, '2024-08-30 00:00:00', 1, 13, 8),
(24, 'Abono de Martin De Los Santos', 2.00, '2024-08-30 00:00:00', 1, 13, 8),
(25, 'Abono de Martin De Los Santos', 800.00, '2024-08-30 00:00:00', 1, 13, 8),
(26, 'Abono de Martin De Los Santos', 8000.00, '2024-08-30 00:00:00', 1, 13, 8),
(27, 'Abono de Martin De Los Santos', 6200.00, '2024-08-30 00:00:00', 1, 13, 8),
(28, 'Abono de Martin De Los Santos', 3950.00, '2024-08-30 00:00:00', 1, 13, 8),
(29, 'Abono de Margarita de los santos', 1000.00, '2024-08-30 00:00:00', 1, 13, 8),
(30, 'Abono de Margarita de los santos', 100.00, '2024-08-30 00:00:00', 1, 13, 8),
(31, 'Abono de Martin De Los Santos', 333.00, '2024-08-30 00:00:00', 1, 13, 8),
(32, 'Abono de Consumidor Final', 3950.00, '2024-08-30 00:00:00', 1, 13, 8),
(33, 'Abono de Consumidor Final', 3950.00, '2024-08-30 00:00:00', 1, 13, 10),
(34, 'Abono de Consumidor Final', 3951.00, '2024-08-30 00:00:00', 1, 13, 11),
(35, 'Abono de Consumidor Final', 3950.00, '2024-08-31 00:00:00', 1, 14, 12),
(36, 'Abono de Martin De Los Santos', 3950.00, '2024-09-02 00:00:00', 1, 15, 13),
(37, 'Abono de Consumidor Final', 3900.00, '2024-09-02 00:00:00', 1, 15, 14),
(38, 'Abono de Martin De Los Santos', 1000.00, '2024-09-02 00:00:00', 1, 15, 15),
(40, 'Abono de Martin De Los Santos', 2000.00, '2024-09-02 00:00:00', 1, 15, 17),
(41, 'Abono de Martin De Los Santos', 1000.00, '2024-09-02 00:00:00', 1, 15, 17),
(42, 'Abono de Consumidor Final', 100.00, '2024-10-07 00:00:00', 1, 16, 18),
(43, 'Abono de Consumidor Final', 11.00, '2025-04-12 00:00:00', 1, 17, 19),
(44, 'Abono de Martin De Los Santos', 22.00, '2025-04-12 00:00:00', 1, 17, 19),
(45, 'Abono de Martin De Los Santos', 200.00, '2025-04-12 00:00:00', 1, 17, 22),
(46, 'Abono de Consumidor Final', 800.00, '2025-04-12 00:00:00', 1, 17, 22),
(47, 'Abono de Consumidor Final', 400.00, '2025-04-12 00:00:00', 1, 17, 22);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientostock`
--

CREATE TABLE `movimientostock` (
  `idMovimiento` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `idAlmacenOrigen` int(11) DEFAULT NULL,
  `idSucursalOrigen` int(11) DEFAULT NULL,
  `idAlmacenDestino` int(11) DEFAULT NULL,
  `idLocalDestino` int(11) DEFAULT NULL,
  `cantidad` int(11) NOT NULL,
  `fechaMovimiento` date NOT NULL,
  `tipoMovimiento` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `movimientostock`
--

INSERT INTO `movimientostock` (`idMovimiento`, `idProducto`, `idAlmacenOrigen`, `idSucursalOrigen`, `idAlmacenDestino`, `idLocalDestino`, `cantidad`, `fechaMovimiento`, `tipoMovimiento`) VALUES
(26, 12, 1, NULL, NULL, 9, 50, '2025-04-12', 'Abastecimiento');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago_cuenta_corriente`
--

CREATE TABLE `pago_cuenta_corriente` (
  `idPago` int(11) NOT NULL,
  `idCuentaCorriente` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `pago` double NOT NULL,
  `idBarbero` int(11) NOT NULL,
  `fechaPago` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pago_cuenta_corriente`
--

INSERT INTO `pago_cuenta_corriente` (`idPago`, `idCuentaCorriente`, `idCliente`, `pago`, `idBarbero`, `fechaPago`) VALUES
(2, 4, 3, 300, 6, '2024-09-02'),
(3, 5, 4, 10000, 6, '2024-09-02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `codigo_barra` varchar(50) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `precio` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `codigo_barra`, `nombre`, `descripcion`, `precio`) VALUES
(12, '1111', 'aaaa', 'aaaa1', 100.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `idServicio` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `descripcion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`idServicio`, `nombre`, `precio`, `descripcion`) VALUES
(1, 'Corte Caballero', 8000.00, 'Cortes con detalles'),
(2, 'Tintura', 10000.00, 'Tintura Para caballo corto'),
(3, 'Barba', 5000.00, 'recorte de barba');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock`
--

CREATE TABLE `stock` (
  `idStock` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `idAlmacen` int(11) DEFAULT NULL,
  `idLocal` int(11) DEFAULT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `stock`
--

INSERT INTO `stock` (`idStock`, `idProducto`, `idAlmacen`, `idLocal`, `cantidad`) VALUES
(44, 12, NULL, 2, 0),
(45, 12, NULL, 3, 0),
(46, 12, NULL, 9, 36),
(47, 12, 1, NULL, 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

CREATE TABLE `sucursal` (
  `idSucursal` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipopago`
--

CREATE TABLE `tipopago` (
  `idTipoPago` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipopago`
--

INSERT INTO `tipopago` (`idTipoPago`, `nombre`) VALUES
(1, 'Efectivo'),
(2, 'Transferencia'),
(3, 'Cuenta Corriente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turnos`
--

CREATE TABLE `turnos` (
  `idTurno` int(11) NOT NULL,
  `idLocal` int(11) NOT NULL,
  `idBarbero` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `servicio` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `turnos`
--

INSERT INTO `turnos` (`idTurno`, `idLocal`, `idBarbero`, `idCliente`, `servicio`, `fecha`, `hora`) VALUES
(1, 2, 4, 3, 'Corte Caballero', '2024-08-20', '00:00:08'),
(2, 2, 4, 4, 'Tintura', '2024-08-21', '09:30:00'),
(4, 2, 4, 3, 'Barba', '2024-08-21', '10:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombreUsuario` varchar(50) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `rol` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombreUsuario`, `contrasena`, `rol`) VALUES
(1, 'agustin', 'medchajari', 'principal'),
(2, '1', '1', 'secundario'),
(3, 'Licencias', 'licencias', 'terciario');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD PRIMARY KEY (`idAlmacen`);

--
-- Indices de la tabla `barbero`
--
ALTER TABLE `barbero`
  ADD PRIMARY KEY (`idBarbero`);

--
-- Indices de la tabla `cajabarbero`
--
ALTER TABLE `cajabarbero`
  ADD PRIMARY KEY (`idCajaBarbero`),
  ADD KEY `idBarbero` (`idBarbero`),
  ADD KEY `fk_idCajaGeneral` (`idCajaGeneral`);

--
-- Indices de la tabla `cajageneral`
--
ALTER TABLE `cajageneral`
  ADD PRIMARY KEY (`idCajaGeneral`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `cuentacorriente`
--
ALTER TABLE `cuentacorriente`
  ADD PRIMARY KEY (`idCuentaCorriente`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `fk_cuentacorriente_barbero` (`idBarbero`);

--
-- Indices de la tabla `detallecaja`
--
ALTER TABLE `detallecaja`
  ADD PRIMARY KEY (`idDetalleCaja`),
  ADD KEY `idMovimiento` (`idMovimiento`),
  ADD KEY `idTipoPago` (`idTipoPago`);

--
-- Indices de la tabla `detallecuentacorriente`
--
ALTER TABLE `detallecuentacorriente`
  ADD PRIMARY KEY (`idDetalleCuentaCorriente`),
  ADD KEY `idCuentaCorriente` (`idCuentaCorriente`),
  ADD KEY `fk_detalle_barbero` (`idBarbero`);

--
-- Indices de la tabla `local`
--
ALTER TABLE `local`
  ADD PRIMARY KEY (`idLocal`);

--
-- Indices de la tabla `movimientocaja`
--
ALTER TABLE `movimientocaja`
  ADD PRIMARY KEY (`idMovimiento`),
  ADD KEY `idCajaGeneral` (`idCajaGeneral`),
  ADD KEY `idCajaBarbero` (`idCajaBarbero`);

--
-- Indices de la tabla `movimientostock`
--
ALTER TABLE `movimientostock`
  ADD PRIMARY KEY (`idMovimiento`),
  ADD KEY `idProducto` (`idProducto`),
  ADD KEY `idAlmacenOrigen` (`idAlmacenOrigen`),
  ADD KEY `idSucursalOrigen` (`idSucursalOrigen`),
  ADD KEY `idAlmacenDestino` (`idAlmacenDestino`),
  ADD KEY `fk_movimientostock_local` (`idLocalDestino`);

--
-- Indices de la tabla `pago_cuenta_corriente`
--
ALTER TABLE `pago_cuenta_corriente`
  ADD PRIMARY KEY (`idPago`),
  ADD KEY `idCuentaCorriente` (`idCuentaCorriente`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `idBarbero` (`idBarbero`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`idServicio`);

--
-- Indices de la tabla `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`idStock`),
  ADD KEY `idProducto` (`idProducto`),
  ADD KEY `idAlmacen` (`idAlmacen`),
  ADD KEY `stock_ibfk_3` (`idLocal`);

--
-- Indices de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD PRIMARY KEY (`idSucursal`);

--
-- Indices de la tabla `tipopago`
--
ALTER TABLE `tipopago`
  ADD PRIMARY KEY (`idTipoPago`);

--
-- Indices de la tabla `turnos`
--
ALTER TABLE `turnos`
  ADD PRIMARY KEY (`idTurno`),
  ADD KEY `idLocal` (`idLocal`),
  ADD KEY `idBarbero` (`idBarbero`),
  ADD KEY `idCliente` (`idCliente`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombreUsuario` (`nombreUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `almacen`
--
ALTER TABLE `almacen`
  MODIFY `idAlmacen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `barbero`
--
ALTER TABLE `barbero`
  MODIFY `idBarbero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `cajabarbero`
--
ALTER TABLE `cajabarbero`
  MODIFY `idCajaBarbero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `cajageneral`
--
ALTER TABLE `cajageneral`
  MODIFY `idCajaGeneral` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `cuentacorriente`
--
ALTER TABLE `cuentacorriente`
  MODIFY `idCuentaCorriente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `detallecaja`
--
ALTER TABLE `detallecaja`
  MODIFY `idDetalleCaja` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detallecuentacorriente`
--
ALTER TABLE `detallecuentacorriente`
  MODIFY `idDetalleCuentaCorriente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `local`
--
ALTER TABLE `local`
  MODIFY `idLocal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `movimientocaja`
--
ALTER TABLE `movimientocaja`
  MODIFY `idMovimiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT de la tabla `movimientostock`
--
ALTER TABLE `movimientostock`
  MODIFY `idMovimiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `pago_cuenta_corriente`
--
ALTER TABLE `pago_cuenta_corriente`
  MODIFY `idPago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `idServicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `stock`
--
ALTER TABLE `stock`
  MODIFY `idStock` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  MODIFY `idSucursal` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipopago`
--
ALTER TABLE `tipopago`
  MODIFY `idTipoPago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `turnos`
--
ALTER TABLE `turnos`
  MODIFY `idTurno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cajabarbero`
--
ALTER TABLE `cajabarbero`
  ADD CONSTRAINT `cajabarbero_ibfk_1` FOREIGN KEY (`idBarbero`) REFERENCES `barbero` (`idBarbero`),
  ADD CONSTRAINT `fk_idCajaGeneral` FOREIGN KEY (`idCajaGeneral`) REFERENCES `cajageneral` (`idCajaGeneral`);

--
-- Filtros para la tabla `cuentacorriente`
--
ALTER TABLE `cuentacorriente`
  ADD CONSTRAINT `cuentacorriente_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  ADD CONSTRAINT `fk_barbero` FOREIGN KEY (`idBarbero`) REFERENCES `barbero` (`idBarbero`),
  ADD CONSTRAINT `fk_cuentacorriente_barbero` FOREIGN KEY (`idBarbero`) REFERENCES `barbero` (`idBarbero`);

--
-- Filtros para la tabla `detallecaja`
--
ALTER TABLE `detallecaja`
  ADD CONSTRAINT `detallecaja_ibfk_1` FOREIGN KEY (`idMovimiento`) REFERENCES `movimientocaja` (`idMovimiento`),
  ADD CONSTRAINT `detallecaja_ibfk_2` FOREIGN KEY (`idTipoPago`) REFERENCES `tipopago` (`idTipoPago`);

--
-- Filtros para la tabla `detallecuentacorriente`
--
ALTER TABLE `detallecuentacorriente`
  ADD CONSTRAINT `detallecuentacorriente_ibfk_1` FOREIGN KEY (`idCuentaCorriente`) REFERENCES `cuentacorriente` (`idCuentaCorriente`),
  ADD CONSTRAINT `fk_detalle_barbero` FOREIGN KEY (`idBarbero`) REFERENCES `barbero` (`idBarbero`);

--
-- Filtros para la tabla `movimientocaja`
--
ALTER TABLE `movimientocaja`
  ADD CONSTRAINT `movimientocaja_ibfk_1` FOREIGN KEY (`idCajaGeneral`) REFERENCES `cajageneral` (`idCajaGeneral`),
  ADD CONSTRAINT `movimientocaja_ibfk_2` FOREIGN KEY (`idCajaBarbero`) REFERENCES `cajabarbero` (`idCajaBarbero`);

--
-- Filtros para la tabla `movimientostock`
--
ALTER TABLE `movimientostock`
  ADD CONSTRAINT `fk_movimientostock_local` FOREIGN KEY (`idLocalDestino`) REFERENCES `local` (`idLocal`),
  ADD CONSTRAINT `movimientostock_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
  ADD CONSTRAINT `movimientostock_ibfk_2` FOREIGN KEY (`idAlmacenOrigen`) REFERENCES `almacen` (`idAlmacen`),
  ADD CONSTRAINT `movimientostock_ibfk_3` FOREIGN KEY (`idSucursalOrigen`) REFERENCES `sucursal` (`idSucursal`),
  ADD CONSTRAINT `movimientostock_ibfk_4` FOREIGN KEY (`idAlmacenDestino`) REFERENCES `almacen` (`idAlmacen`);

--
-- Filtros para la tabla `pago_cuenta_corriente`
--
ALTER TABLE `pago_cuenta_corriente`
  ADD CONSTRAINT `pago_cuenta_corriente_ibfk_1` FOREIGN KEY (`idCuentaCorriente`) REFERENCES `cuentacorriente` (`idCuentaCorriente`),
  ADD CONSTRAINT `pago_cuenta_corriente_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  ADD CONSTRAINT `pago_cuenta_corriente_ibfk_3` FOREIGN KEY (`idBarbero`) REFERENCES `barbero` (`idBarbero`);

--
-- Filtros para la tabla `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
  ADD CONSTRAINT `stock_ibfk_2` FOREIGN KEY (`idAlmacen`) REFERENCES `almacen` (`idAlmacen`),
  ADD CONSTRAINT `stock_ibfk_3` FOREIGN KEY (`idLocal`) REFERENCES `local` (`idLocal`);

--
-- Filtros para la tabla `turnos`
--
ALTER TABLE `turnos`
  ADD CONSTRAINT `turnos_ibfk_1` FOREIGN KEY (`idLocal`) REFERENCES `local` (`idLocal`),
  ADD CONSTRAINT `turnos_ibfk_2` FOREIGN KEY (`idBarbero`) REFERENCES `barbero` (`idBarbero`),
  ADD CONSTRAINT `turnos_ibfk_3` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
