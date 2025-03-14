-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 14, 2025 at 04:09 PM
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
-- Database: `android`
--
CREATE DATABASE IF NOT EXISTS `android` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `android`;

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `class_id` varchar(10) NOT NULL,
  `class_name` varchar(50) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `attendance_time` datetime NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`class_id`, `class_name`, `teacher_id`, `student_id`, `attendance_time`, `status`) VALUES
('COMP301', 'Philosophy', 1, 725105187, '2025-03-02 17:02:12', '1');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `class_id` varchar(10) NOT NULL,
  `class_name` varchar(50) NOT NULL,
  `teacher_id` varchar(50) NOT NULL,
  `class_time` datetime NOT NULL,
  `total_student` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`class_id`, `class_name`, `teacher_id`, `class_time`, `total_student`) VALUES
('COMP301', 'Phân tích thiết kế hệ thống', 'Nguyễn Thị Thanh Huyền', '2025-02-23 12:00:00', 30);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `student_name` varchar(50) NOT NULL,
  `student_birth` date NOT NULL,
  `student_gender` varchar(10) NOT NULL,
  `student_mail` varchar(50) DEFAULT NULL,
  `student_phone` varchar(50) DEFAULT NULL,
  `student_image` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `student_bclass` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `student_name`, `student_birth`, `student_gender`, `student_mail`, `student_phone`, `student_image`, `status`, `student_bclass`) VALUES
(725105187, 'Đặng Xuân Tùng', '2004-12-05', 'nam', 'random@email.com', '862714328', '725105187.jpg', NULL, 'E4');

-- --------------------------------------------------------

--
-- Table structure for table `student_class`
--

CREATE TABLE `student_class` (
  `student_id` int(11) NOT NULL,
  `class_id` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_class`
--

INSERT INTO `student_class` (`student_id`, `class_id`) VALUES
(725105187, 'COMP301');

-- --------------------------------------------------------

--
-- Table structure for table `student_schedule`
--

CREATE TABLE `student_schedule` (
  `s_id` varchar(30) NOT NULL,
  `s_name` varchar(50) NOT NULL,
  `s_tstart` time NOT NULL,
  `s_tend` time NOT NULL,
  `s_daybegin` date NOT NULL,
  `s_dayend` date NOT NULL,
  `student_id` int(11) NOT NULL,
  `s_location` varchar(50) NOT NULL,
  `teacher_id` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_schedule`
--

INSERT INTO `student_schedule` (`s_id`, `s_name`, `s_tstart`, `s_tend`, `s_daybegin`, `s_dayend`, `student_id`, `s_location`, `teacher_id`) VALUES
('COMP301-K72CNTT.02_LT', 'Phân tích thiết kế hệ thống', '09:00:00', '11:50:00', '2025-01-01', '2025-04-23', 725105187, 'C-305', 'Nguyễn Thị Thanh Huyền');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subject_id` varchar(10) NOT NULL,
  `subject_name` varchar(50) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `day_of_week` date NOT NULL,
  `time` time NOT NULL,
  `total_student` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `teacher_id` varchar(50) NOT NULL,
  `teacher_name` varchar(50) NOT NULL,
  `teacher_birth` date NOT NULL,
  `teacher_gender` varchar(50) NOT NULL,
  `teacher_mail` varchar(50) DEFAULT NULL,
  `teacher_phone` varchar(50) DEFAULT NULL,
  `teacher_image` varchar(10) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`teacher_id`, `teacher_name`, `teacher_birth`, `teacher_gender`, `teacher_mail`, `teacher_phone`, `teacher_image`, `status`) VALUES
('Nguyễn Thị Thanh Huyền', 'DT', '2000-03-23', 'nam', NULL, NULL, 'anh1.jpg', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` text NOT NULL,
  `oldpass` text DEFAULT NULL,
  `i_student` int(11) DEFAULT NULL,
  `i_teacher` int(11) DEFAULT NULL,
  `i_role` varchar(50) NOT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `oldpass`, `i_student`, `i_teacher`, `i_role`, `status`) VALUES
(2, 'teacher', '1234', NULL, NULL, 1, '2', NULL),
(3, 'admin', '1234', NULL, NULL, NULL, '1', NULL),
(725105187, 'student', '1234', '1234', 725105187, NULL, '3', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`class_id`,`attendance_time`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`class_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `student_class`
--
ALTER TABLE `student_class`
  ADD PRIMARY KEY (`student_id`,`class_id`);

--
-- Indexes for table `student_schedule`
--
ALTER TABLE `student_schedule`
  ADD PRIMARY KEY (`s_id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacher_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=725105189;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
