-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 29, 2025 at 02:20 AM
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
-- Database: `empdirectory`
--

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `dep_id` varchar(10) NOT NULL,
  `dep_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`dep_id`, `dep_name`) VALUES
('', ''),
('D_0001', 'Marketing'),
('D_0003', 'Research and Development'),
('D_002', 'Accounting');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `emp_id` varchar(10) NOT NULL,
  `empName` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  `hiringDate` date NOT NULL,
  `isManager` tinyint(1) NOT NULL,
  `isActive` tinyint(1) NOT NULL,
  `isAgreement` tinyint(1) NOT NULL,
  `dep_id` varchar(10) NOT NULL,
  `post_id` varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_id`, `empName`, `phone`, `email`, `hiringDate`, `isManager`, `isActive`, `isAgreement`, `dep_id`, `post_id`, `password`) VALUES
('E_0001', 'Thin Zar', '09787654123', 'thinzar123@gmail.com', '2025-01-07', 1, 1, 1, 'D_0001', 'P_0001', 'tzh12345'),
('E_0002', 'Mr.John', '09987654121', 'john123@gmail.com', '2023-04-07', 0, 1, 1, 'D_0002', 'P_0002', 'john12345'),
('E_0003', 'Mr.Smith', '09987654128', 'smith123@gmail.com', '2021-04-07', 0, 1, 1, 'D_0002', 'P_0002', 'smith12345'),
('E_0004', 'Mr.Yamada', '09987654126', 'yamada123@gmail.com', '2019-04-07', 0, 1, 1, 'D_0003', 'P_0002', 'yamada12345'),
('E_0005', 'Mr.Anny', '09987654122', 'anny123@gmail.com', '2012-04-07', 1, 1, 1, 'D_0003', 'P_0001', 'anny12345'),
('E_0006', 'Mr.Elka', '09987654135', 'elka123@gmail.com', '2009-04-07', 0, 1, 1, 'D_0002', 'P_0002', 'elka12345'),
('E_0007', 'Mr.Rose', '09987654187', 'rose123@gmail.com', '2012-04-07', 1, 1, 1, 'D_0002', 'P_0001', 'rose12345');

-- --------------------------------------------------------

--
-- Table structure for table `position`
--

CREATE TABLE `position` (
  `post_id` varchar(10) NOT NULL,
  `postName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `position`
--

INSERT INTO `position` (`post_id`, `postName`) VALUES
('P_0001', 'Manager'),
('P_0002', 'HR');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`dep_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `position`
--
ALTER TABLE `position`
  ADD PRIMARY KEY (`post_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
