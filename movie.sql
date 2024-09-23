-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 03, 2024 at 03:22 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `movie`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `email` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`email`, `username`, `password`) VALUES
('bia@gmail.com', 'Habiba', '12345'),
('asmaa@gmail.com', 'asmaa', '1234567'),
('loly@gmail.com', 'Ahmed', '12345678'),
('nour@gmail.com', 'Nour', '123456789'),
('aya@gmail.com', 'Aya', '1234567890'),
('loly@gmail.com', 'loly', '15963'),
('Habiba@gmail.com', 'bia', '123456789'),
('radwa@gmail.com', 'Radwa', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(100) NOT NULL,
  `type` varchar(255) NOT NULL,
  `movieTitle` varchar(100) NOT NULL,
  `total` double NOT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `type`, `movieTitle`, `total`, `date`, `time`) VALUES
(1, 'Special Class', 'TheMarvels', 60, '2024-09-01', '02:33:01'),
(2, 'Special & Normal Class', 'Loki1', 80, '2024-09-01', '01:21:23'),
(3, 'Special Class', 'Avangers2', 90, '2024-09-02', '02:32:33'),
(4, 'Special & Normal Class', 'CaptainMarvel', 160, '2024-09-02', '05:32:00'),
(5, 'Special & Normal Class', 'AntiMan', 70, '2024-09-02', '02:21:33'),
(6, 'Special Class', 'Loki2', 150, '2024-09-02', '01:32:33'),
(7, 'Special & Normal Class', 'IronMan', 150, '2024-09-02', '05:21:12'),
(8, 'Special Class', 'guardians of the galaxy1', 180, '2024-09-02', '02:32:21'),
(9, 'Normal Class', 'DrStrange', 40, '2024-09-02', '01:57:26'),
(12, 'Normal Class', 'DrStrange', 40, '2024-09-02', '02:57:06'),
(13, 'Normal Class', 'DrStrange', 40, '2024-09-02', '02:57:32'),
(14, 'Normal Class', 'DrStrange', 40, '2024-09-02', '02:57:36'),
(15, 'Special Class', 'Avangers3', 60, '2024-09-02', '02:57:59'),
(16, 'Normal Class', 'Avangers3', 40, '2024-09-02', '02:58:18'),
(17, 'Special Class', 'MoonKnight', 60, '2024-09-02', '02:58:41'),
(18, 'Special Class', 'CaptainMarvel', 60, '2024-09-02', '03:03:14'),
(20, 'Special & Normal Class', 'guardians of the galaxy1', 170, '2024-09-03', '14:42:26'),
(21, 'Special Class', 'Avangers2', 60, '2024-09-03', '15:30:18');

-- --------------------------------------------------------

--
-- Table structure for table `customer_info`
--

CREATE TABLE `customer_info` (
  `id` int(100) NOT NULL,
  `customer_id` int(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `total` double NOT NULL,
  `movieTitle` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer_info`
--

INSERT INTO `customer_info` (`id`, `customer_id`, `type`, `total`, `movieTitle`) VALUES
(1, 1, 'Special Class', 90, 'Loki'),
(2, 2, 'Normal Class', 180, 'Avangers1'),
(3, 3, 'Special Class', 90, 'MoonKnight'),
(4, 4, 'Special & Normal Class', 160, 'Avangers1'),
(5, 5, 'Special & Normal Class', 70, 'Loki'),
(6, 6, 'Special Class', 150, 'Avangers1'),
(7, 7, 'Special & Normal Class', 150, 'CaptainAmerica1'),
(8, 8, 'Special Class', 180, 'Avangers2'),
(9, 9, 'Normal Class', 40, 'DrStrange'),
(10, 10, 'Special & Normal Class', 170, 'guardians of the galaxy2'),
(11, 11, 'Normal Class', 40, 'guardians of the galaxy2'),
(12, 12, 'Normal Class', 40, 'DrStrange'),
(13, 13, 'Normal Class', 40, 'DrStrange'),
(14, 14, 'Normal Class', 40, 'DrStrange'),
(15, 15, 'Special Class', 60, 'Avangers3'),
(16, 16, 'Normal Class', 40, 'Avangers3'),
(17, 17, 'Special Class', 60, 'MoonKnight'),
(18, 18, 'Special Class', 60, 'CaptainMarvel'),
(19, 19, 'Special & Normal Class', 150, 'AntiMan'),
(20, 20, 'Special & Normal Class', 170, 'guardians of the galaxy1'),
(21, 21, 'Special Class', 60, 'Avangers2');

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `id` int(255) NOT NULL,
  `movieTitle` varchar(100) NOT NULL,
  `genre` varchar(100) NOT NULL,
  `duration` varchar(100) NOT NULL,
  `image` varchar(500) NOT NULL,
  `date` date DEFAULT NULL,
  `current` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`id`, `movieTitle`, `genre`, `duration`, `image`, `date`, `current`) VALUES
(1, 'Avangers1', 'Action', '3:00:23', 'C:\\Users\\Dell\\Documents\\JavaFXApplication9\\src\\javafxapplication9\\image\\cf41f89b434e68864d0e3360d87d1cbf.jpg', '2024-03-11', 'Showing'),
(2, 'Loki', 'Action', '3:00:09', 'C:\\\\Users\\\\Dell\\\\Documents\\\\JavaFXApplication9\\\\src\\\\javafxapplication9\\\\image\\\\aaeeba9b73aef0f2dc12237718577fcf.jpg', '2024-09-03', 'End Showing'),
(3, 'MoonKnight', 'Adventure', '3:00:21', 'C:\\Users\\Dell\\Documents\\JavaFXApplication9\\src\\javafxapplication9\\image\\3d4a775637efc2d83c220740ac5df328.jpg', '2024-09-02', 'Showing'),
(4, 'SpiderMan2', 'Adventure', '2:46:33', 'C:\\\\Users\\\\Dell\\\\Documents\\\\JavaFXApplication9\\\\src\\\\javafxapplication9\\\\image\\\\4854994674c2da4bc8ca3878c62a1546.jpg', '2018-09-05', 'Showing'),
(5, 'guardians of the galaxy2', 'Fantasy', '3:22:23', 'C:\\\\Users\\\\Dell\\\\Documents\\\\JavaFXApplication9\\\\src\\\\javafxapplication9\\\\image\\\\8cd1ea9ac6ac5969df2163d7056ba4f3.jpg', '2024-09-03', 'Showing'),
(6, 'CaptainAmerica1', 'Action', '2:22:00', 'C:\\\\Users\\\\Dell\\\\Documents\\\\JavaFXApplication9\\\\src\\\\javafxapplication9\\\\image\\\\c4785dd26c5ebb05e1a43a66c254acdc.jpg', '2024-09-03', 'Showing'),
(7, 'Avangers2', 'Action', '3:55:00', 'C:\\\\Users\\\\Dell\\\\Documents\\\\JavaFXApplication9\\\\src\\\\javafxapplication9\\\\image\\\\83d08c728d0f96bf3c49c83fbd1931f5.jpg', '2024-09-01', 'Showing'),
(8, 'DrStrange', 'Adventure', '2:34:00', 'C:\\\\Users\\\\Dell\\\\Documents\\\\JavaFXApplication9\\\\src\\\\javafxapplication9\\\\image\\\\bdac43c6538706992da09ca02bc5120e.jpg', '2020-07-08', 'Showing'),
(10, 'AntiMan', 'Fantasy', '3:24:00', 'C:\\\\Users\\\\Dell\\\\Documents\\\\JavaFXApplication9\\\\src\\\\javafxapplication9\\\\image\\\\62a3aa6f15a1aa3711db560b6b7024c0.jpg', '2020-09-10', 'Showing'),
(11, 'guardians of the galaxy1', 'Adventure', '2:12:45', 'C:\\\\Users\\\\Dell\\\\Documents\\\\JavaFXApplication9\\\\src\\\\javafxapplication9\\\\image\\\\6cbace8478b4d2aa8712161d9d56cf01.jpg', '2020-09-09', 'Showing'),
(12, 'Avangers3', 'Action', '4:12:00', 'C:\\\\Users\\\\Dell\\\\Documents\\\\JavaFXApplication9\\\\src\\\\javafxapplication9\\\\image\\\\83d08c728d0f96bf3c49c83fbd1931f5.jpg', '2024-09-17', 'Showing'),
(13, 'CaptainMarvel', 'Adventure', '3:32:00', 'C:\\\\Users\\\\Dell\\\\Documents\\\\JavaFXApplication9\\\\src\\\\javafxapplication9\\\\image\\\\b1ec3d3bc2e918b50191082a2bed4ca0.jpg', '2024-09-04', 'Showing');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer_info`
--
ALTER TABLE `customer_info`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `customer_info`
--
ALTER TABLE `customer_info`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
