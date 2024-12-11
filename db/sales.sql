-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2024 at 06:43 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sarihub`
--

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `Id` int(50) NOT NULL,
  `products_Id` int(50) NOT NULL,
  `Quantity_Sold` int(50) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`Id`, `products_Id`, `Quantity_Sold`, `Date`) VALUES
(1, 3, 0, '2024-06-10'),
(2, 2, 3, '2024-06-10'),
(3, 2, 2, '2024-12-04'),
(4, 2, 1, '2024-12-02'),
(5, 6, 1, '2024-12-07'),
(6, 6, 1, '2024-12-07'),
(7, 2, 2, '2024-12-10'),
(8, 6, 1, '2024-12-10'),
(9, 5, 1, '2024-12-10'),
(10, 6, 1, '2024-12-10'),
(11, 5, 1, '2024-12-10'),
(12, 5, 1, '2024-12-10'),
(13, 6, 1, '2024-12-10'),
(14, 2, 1, '2024-12-11'),
(15, 3, 1, '2024-12-11'),
(16, 2, 1, '2024-12-11'),
(17, 18, 1, '2024-12-11'),
(18, 2, 15, '2024-12-11'),
(19, 2, 5, '2024-12-11');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `test` (`products_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `Id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `test` FOREIGN KEY (`products_Id`) REFERENCES `product_table` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
