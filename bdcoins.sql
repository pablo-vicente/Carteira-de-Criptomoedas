-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 07-Abr-2018 às 01:33
-- Versão do servidor: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdcoins`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `carteira`
--

CREATE TABLE `carteira` (
  `CPF_carteira` varchar(14) NOT NULL,
  `bitcoin` double DEFAULT NULL,
  `litecoin` double DEFAULT NULL,
  `bcash` double DEFAULT NULL,
  `monero` double DEFAULT NULL,
  `dogecoin` double DEFAULT NULL,
  `reais` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `carteira`
--

INSERT INTO `carteira` (`CPF_carteira`, `bitcoin`, `litecoin`, `bcash`, `monero`, `dogecoin`, `reais`) VALUES
('111.111.111-11', 0, 249.9416140127192, 0, 0, 0, 22.78000000000017),
('222.222.222-22', 11.762833062254066, 0, 0, 0, 0, 9100);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cotacao`
--

CREATE TABLE `cotacao` (
  `id_Moeda` int(11) NOT NULL,
  `tipoMoeda` varchar(11) DEFAULT NULL,
  `cotacao` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cotacao`
--

INSERT INTO `cotacao` (`id_Moeda`, `tipoMoeda`, `cotacao`) VALUES
(1, 'Bitcoin', 128.79410252629592),
(2, 'Litcoin', 131.81063026568546),
(3, 'Bcash', 216.046636008058),
(4, 'Monero', 132.0702016414732),
(5, 'Dogecoin', 0.01626045745818176);

-- --------------------------------------------------------

--
-- Estrutura da tabela `saquedeposito`
--

CREATE TABLE `saquedeposito` (
  `login` varchar(14) NOT NULL,
  `tipo` varchar(10) DEFAULT NULL,
  `agencia` varchar(10) DEFAULT NULL,
  `conta` varchar(10) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `taxa` double DEFAULT NULL,
  `liquido` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `saquedeposito`
--

INSERT INTO `saquedeposito` (`login`, `tipo`, `agencia`, `conta`, `valor`, `taxa`, `liquido`) VALUES
('111.111.111-11', 'Deposito', '1111-1', '1111-1', 1000, 90, 910),
('111.111.111-11', 'Saque', '1111-1', '1111-1', 230.29, 20.7264, 230.29),
('222.222.222-22', 'Deposito', '1111-1', '1111-1', 10000, 900, 9100);

-- --------------------------------------------------------

--
-- Estrutura da tabela `taxa`
--

CREATE TABLE `taxa` (
  `tipoTaxa` varchar(11) DEFAULT NULL,
  `valorTaxa` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `taxa`
--

INSERT INTO `taxa` (`tipoTaxa`, `valorTaxa`) VALUES
('Compra', 0.09),
('Venda', 0.09),
('Deposito', 0.09),
('Saque', 0.09);

-- --------------------------------------------------------

--
-- Estrutura da tabela `trocamoedas`
--

CREATE TABLE `trocamoedas` (
  `login` varchar(14) NOT NULL,
  `tipo` varchar(10) DEFAULT NULL,
  `moeda` varchar(10) DEFAULT NULL,
  `montante` double DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `cotacao` double DEFAULT NULL,
  `taxa` double DEFAULT NULL,
  `liquido` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `CPf` varchar(15) NOT NULL,
  `Nome` varchar(70) DEFAULT NULL,
  `DataN` varchar(30) DEFAULT NULL,
  `Telefone` varchar(30) DEFAULT NULL,
  `Senha` varchar(30) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`CPf`, `Nome`, `DataN`, `Telefone`, `Senha`, `Email`) VALUES
('111.111.111-11', '', '', '', '', ''),
('222.222.222-22', '', '', '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `carteira`
--
ALTER TABLE `carteira`
  ADD PRIMARY KEY (`CPF_carteira`);

--
-- Indexes for table `cotacao`
--
ALTER TABLE `cotacao`
  ADD PRIMARY KEY (`id_Moeda`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`CPf`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cotacao`
--
ALTER TABLE `cotacao`
  MODIFY `id_Moeda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
