--
-- Database: `android`
--
DROP DATABASE android;
CREATE DATABASE android;
USE android;
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
(1, '725105003', '1234', NULL, 725105003, NULL, '3', NULL),
(2, '725105007', '1234', NULL, 725105007, NULL, '3', NULL),
(3, '725105009', '1234', NULL, 725105009, NULL, '3', NULL),
(4, '725105031', '1234', NULL, 725105031, NULL, '3', NULL),
(5, '725105039', '1234', NULL, 725105039, NULL, '3', NULL),
(6, '725105041', '1234', NULL, 725105041, NULL, '3', NULL),
(7, '725105069', '1234', NULL, 725105069, NULL, '3', NULL),
(8, '725105085', '1234', NULL, 725105085, NULL, '3', NULL),
(9, '725105042', '1234', NULL, 725105042, NULL, '3', NULL),
(10, '725105089', '1234', NULL, 725105089, NULL, '3', NULL),
(11, '725105096', '1234', NULL, 725105096, NULL, '3', NULL),
(12, '725105087', '1234', NULL, 725105087, NULL, '3', NULL),
(13, '725105088', '1234', NULL, 725105088, NULL, '3', NULL),
(14, '715105006', '1234', NULL, 715105006, NULL, '3', NULL),
(15, '715105013', '1234', NULL, 715105013, NULL, '3', NULL),
(16, '715105060', '1234', NULL, 715105060, NULL, '3', NULL),
(17, '725105025', '1234', NULL, 725105025, NULL, '3', NULL),
(18, '725105028', '1234', NULL, 725105028, NULL, '3', NULL),
(19, '725105120', '1234', NULL, 725105120, NULL, '3', NULL),
(20, '725105008', '1234', NULL, 725105008, NULL, '3', NULL),
(21, '725105102', '1234', NULL, 725105102, NULL, '3', NULL),
(22, '725105115', '1234', NULL, 725105115, NULL, '3', NULL),
(23, '725105130', '1234', NULL, 725105130, NULL, '3', NULL),
(24, '725105139', '1234', NULL, 725105139, NULL, '3', NULL),
(25, '725105013', '1234', NULL, 725105013, NULL, '3', NULL),
(26, '725105016', '1234', NULL, 725105016, NULL, '3', NULL),
(27, '725105047', '1234', NULL, 725105047, NULL, '3', NULL),
(28, '725105059', '1234', NULL, 725105059, NULL, '3', NULL),
(29, '725105105', '1234', NULL, 725105105, NULL, '3', NULL),
(30, '725105106', '1234', NULL, 725105106, NULL, '3', NULL),
(31, '725105127', '1234', NULL, 725105127, NULL, '3', NULL),
(32, '725105018', '1234', NULL, 725105018, NULL, '3', NULL),
(33, '725105019', '1234', NULL, 725105019, NULL, '3', NULL),
(34, '725105052', '1234', NULL, 725105052, NULL, '3', NULL),
(35, '725105053', '1234', NULL, 725105053, NULL, '3', NULL),
(36, '725105075', '1234', NULL, 725105075, NULL, '3', NULL),
(37, '725105014', '1234', NULL, 725105014, NULL, '3', NULL),
(38, '725105046', '1234', NULL, 725105046, NULL, '3', NULL),
(39, '725105142', '1234', NULL, 725105142, NULL, '3', NULL),
(40, '725105083', '1234', NULL, 725105083, NULL, '3', NULL),
(41, '725105060', '1234', NULL, 725105060, NULL, '3', NULL),
(42, '725105061', '1234', NULL, 725105061, NULL, '3', NULL),
(43, '725105091', '1234', NULL, 725105091, NULL, '3', NULL),
(44, '725105093', '1234', NULL, 725105093, NULL, '3', NULL),
(45, '725105049', '1234', NULL, 725105049, NULL, '3', NULL),
(46, '725105068', '1234', NULL, 725105068, NULL, '3', NULL),
(47, '725105113', '1234', NULL, 725105113, NULL, '3', NULL),
(48, '725105125', '1234', NULL, 725105125, NULL, '3', NULL),
(49, '725105146', '1234', NULL, 725105146, NULL, '3', NULL),
(50, '705105047', '1234', NULL, 705105047, NULL, '3', NULL),
(51, '705105059', '1234', NULL, 705105059, NULL, '3', NULL),
(52, '705105102', '1234', NULL, 705105102, NULL, '3', NULL),
(53, '715105129', '1234', NULL, 715105129, NULL, '3', NULL),
(54, '725105048', '1234', NULL, 725105048, NULL, '3', NULL),
(55, '725105094', '1234', NULL, 725105094, NULL, '3', NULL),
(56, '725105135', '1234', NULL, 725105135, NULL, '3', NULL),
(57, '725105145', '1234', NULL, 725105145, NULL, '3', NULL),
(58, '725105184', '1234', NULL, 725105184, NULL, '3', NULL),
(59, '725105191', '1234', NULL, 725105191, NULL, '3', NULL),
(60, '725105195', '1234', NULL, 725105195, NULL, '3', NULL),
(61, '725105197', '1234', NULL, 725105197, NULL, '3', NULL),
(62, '725105107', '1234', NULL, 725105107, NULL, '3', NULL),
(63, '725105108', '1234', NULL, 725105108, NULL, '3', NULL),
(64, '725105109', '1234', NULL, 725105109, NULL, '3', NULL),
(65, '725105114', '1234', NULL, 725105114, NULL, '3', NULL),
(66, '725105128', '1234', NULL, 725105128, NULL, '3', NULL),
(67, '725105136', '1234', NULL, 725105136, NULL, '3', NULL),
(68, '735105066', '1234', NULL, 735105066, NULL, '3', NULL),
(69, '735105069', '1234', NULL, 735105069, NULL, '3', NULL),
(70, '735105131', '1234', NULL, 735105131, NULL, '3', NULL),
(71, '735105090', '1234', NULL, 735105090, NULL, '3', NULL),
(72, '725105192', '1234', NULL, 725105192, NULL, '3', NULL),
(73, '725105158', '1234', NULL, 725105158, NULL, '3', NULL),
(74, '725105156', '1234', NULL, 725105156, NULL, '3', NULL),
(75, '725105176', '1234', NULL, 725105176, NULL, '3', NULL),
(76, '725105183', '1234', NULL, 725105183, NULL, '3', NULL),
(77, '725105193', '1234', NULL, 725105193, NULL, '3', NULL),
(78, '725105163', '1234', NULL, 725105163, NULL, '3', NULL),
(79, '725105166', '1234', NULL, 725105166, NULL, '3', NULL),
(80, '725105173', '1234', NULL, 725105173, NULL, '3', NULL),
(81, '725105179', '1234', NULL, 725105179, NULL, '3', NULL),
(82, '725105189', '1234', NULL, 725105189, NULL, '3', NULL),
(83, '725105165', '1234', NULL, 725105165, NULL, '3', NULL),
(84, '725105168', '1234', NULL, 725105168, NULL, '3', NULL),
(85, '725105185', '1234', NULL, 725105185, NULL, '3', NULL),
(86, '725105180', '1234', NULL, 725105180, NULL, '3', NULL),
(87, '725105198', '1234', NULL, 725105198, NULL, '3', NULL),
(88, '725105192', '1234', NULL, 725105192, NULL, '3', NULL),
(89, '725105102', '1234', NULL, 725105102, NULL, '3', NULL),
(90, 'student', '1234', NULL, 725105187, NULL, '3', NULL),	-- tài khoản test
(91, 'teacher', '1234', NULL, NULL, 1001, '2', NULL),	-- tài khoản test
(92, 'teacher2', '1234', NULL, NULL, 1002, '2', NULL),
(93, 'teacher3', '1234', NULL, NULL, 1003, '2', NULL),
(94, 'teacher4', '1234', NULL, NULL, 1004, '2', NULL),
(95, 'teacher5', '1234', NULL, NULL, 1005, '2', NULL),
(96, 'teacher6', '1234', NULL, NULL, 1006, '2', NULL),
(97, 'teacher7', '1234', NULL, NULL, 1007, '2', NULL),
(98, 'teacher8', '1234', NULL, NULL, 1008, '2', NULL),
(99, 'teacher9', '1234', NULL, NULL, 1009, '2', NULL),
(100, 'teacher10', '1234', NULL, NULL, 1010, '2', NULL),
(101, 'teacher11', '1234', NULL, NULL, 1011, '2', NULL),
(102, 'teacher12', '1234', NULL, NULL, 1012, '2', NULL);

-- --------------------------------------------------------
--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `class_id` int(11) NOT NULL,
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
-- Chỉ cod dữ liệu khi học sinh quét QR
('COMP301', 'Phân tích thiết kế hệ thống', 1, 725105187, '2025-03-02 17:02:12', '1');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `class_id` varchar(10) NOT NULL,
  `class_name` varchar(50) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `class_time` datetime NOT NULL,
  `total_student` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`class_id`, `class_name`, `teacher_id`, `class_time`, `total_student`) VALUES
('COMP301', 'Phân tích thiết kế hệ thống', 1001, '2025-02-23 12:00:00', 10),
('COMP302', 'Cơ sở dữ liệu', 1001, '2025-02-24 14:00:00', 4),
('COMP303', 'Lập trình Java', 1002, '2025-02-25 08:30:00', 10),
('COMP304', 'Mạng máy tính', 1003, '2025-02-26 10:00:00', 8),
('COMP305', 'Lập trình C#', 1003, '2025-02-27 09:00:00', 4),
('COMP306', 'Nguyên lý hệ điều hành', 1005, '2025-02-28 15:00:00', 8),
('COMP307', 'Cấu trúc dữ liệu và giải thuật', 1005, '2025-02-28 15:00:00', 5),
('COMP308', 'Toán rời rạc', 1006, '2025-02-28 15:00:00', 6),
('COMP309', 'Nhập môn lý thuyết ma trận', 1008, '2025-02-28 15:00:00', 6),
('COMP310', 'Lập trình hướng đối tượng', 1011, '2025-02-28 15:00:00', 11),
('COMP311', 'Kiến trúc máy tính', 1001, '2025-02-28 15:00:00', 5),
('COMP312', 'Trí tuệ nhân tạo', 1003, '2025-02-28 15:00:00', 11);

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
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `student_name`, `student_birth`, `student_gender`, `student_mail`, `student_phone`, `student_image`, `status`) VALUES
(725105187, 'Đặng Xuân Tùng', '2004-12-05', 'nam', 'random@email.com', '(555) 123-4567', 'th.jpg', 'active'),	-- Tài khoản test
(725105003, 'ĐỒNG TRẦN VÂN ANH', '2004-06-28', 'Nữ', 'anhvan@gmail.com', '901234567', NULL, 'active'),
(725105007, 'HOÀNG THỊ VÂN ANH', '2004-09-11', 'Nữ', 'hoanganh@gmail.com', '912345678', NULL, 'active'),
(725105009, 'NGUYỄN LAN ANH', '2004-01-27', 'Nữ', 'lannguyen@gmail.com', '933456789', NULL, 'active'),
(725105031, 'NGUYỄN NGỌC CHUNG', '2004-11-22', 'Nữ', 'chungnguyen@gmail.com', '964567890', NULL, 'active'),
(725105039, 'NGUYỄN VÂN ĐOAN DỤC', '2004-05-20', 'Nam', 'ducnguyen@gmail.com', '975678901', NULL, 'active'),
(725105041, 'NGUYỄN TRƯỜNG DỤC', '2004-01-01', 'Nam', 'ducnguyen@gmail.com', '986789012', NULL, 'active'),
(725105069, 'LÊ NGUYỄN VÂN HIẾN', '2005-04-23', 'Nữ', 'hienle@gmail.com', '867890123', NULL, 'active'),
(725105085, 'NGUYỄN ĐÌNH HIẾU', '2005-12-26', 'Nam', 'hieunguyen@gmail.com', '888901234', NULL, 'active'),
(725105042, 'LÊ QUANG HUY', '2005-03-04', 'Nam', 'huyle@gmail.com', '909012345', NULL, 'active'),
(725105089, 'PHẠM XUÂN HUY', '2004-11-21', 'Nam', 'huypham@gmail.com', '910123456', NULL, 'active'),
(725105096, 'ĐOÀN DUY KHÁNH', '2004-01-14', 'Nam', 'khanhdoan@gmail.com', '931234567', NULL, 'active'),
(725105087, 'NGUYỄN HỰU KHÁNH', '2004-06-06', 'Nam', 'khanhnguyen@gmail.com', '962345678', NULL, 'active'),
(725105088, 'NGUYỄN VIỆT HUY', '2004-11-27', 'Nam', 'huynguyen@gmail.com', '973456789', NULL, 'active'),
(715105006, 'NGUYỄN ĐỨC PHƯƠNG ANH', '2003-10-05', 'Nữ', 'anhnguyen@gmail.com', '984567890', NULL, 'active'),
(715105013, 'ĐỖNG KHƯƠNG DUY', '2003-10-30', 'Nam', 'duydong@gmail.com', '865678901', NULL, 'active'),
(715105060, 'VIỆT THƯỜNG THẢO', '2004-04-19', 'Nữ', 'thaoviet@gmail.com', '886789012', NULL, 'active'),
(725105025, 'TRẦN VÂN CAO', '2004-12-07', 'Nữ', 'caotran@gmail.com', '907890123', NULL, 'active'),
(725105028, 'NGUYỄN THỊ LINH CHÂU', '2004-04-16', 'Nữ', 'chaunguyen@gmail.com', '918901234', NULL, 'active'),
(725105120, 'ĐÌNH THỊ LƯU', '2004-10-21', 'Nữ', 'luudinh@gmail.com', '939012345', NULL, 'active'),
(725105008, 'NGUYỄN HỒNG LÂM', '2004-03-20', 'Nam', 'lamnguyen@gmail.com', '960123456', NULL, 'active'),
(725105102, 'LÊ ĐỨC TUẤN LINH', '2004-01-13', 'Nam', 'linhle@gmail.com', '971234567', NULL, 'active'),
(725105115, 'TRẦN ĐỨC LINH', '2004-10-06', 'Nam', 'linhtran@gmail.com', '982345678', NULL, 'active'),
(725105130, 'KHUẤT THỊ NGỌC', '2004-10-10', 'Nữ', 'ngockhuat@gmail.com', '863456789', NULL, 'active'),
(725105139, 'NGÔ HỒNG QUÂN', '2003-09-25', 'Nam', 'quanngo@gmail.com', '884567890', NULL, 'active'),
(725105013, 'NGUYỄN VIỆT ANH', '2004-07-04', 'Nam', 'anhnguyen@gmail.com', '905678901', NULL, 'active'),
(725105016, 'TRẦN QUỐC ANH', '2004-06-21', 'Nam', 'anhtran@gmail.com', '916789012', NULL, 'active'),
(725105047, 'VŨ QUỐC ĐỒNG', '2004-06-16', 'Nam', 'dongvu@gmail.com', '937890123', NULL, 'active'),
(725105059, 'NGUYỄN MỸ HÀI', '2004-11-10', 'Nữ', 'hainguyen@gmail.com', '968901234', NULL, 'active'),
(725105105, 'NGUYỄN THỊ LAN', '2004-02-10', 'Nữ', 'lannguyen@gmail.com', '979012345', NULL, 'active'),
(725105106, 'NGUYỄN THỊ NGÂN', '2004-07-23', 'Nữ', 'ngannguyen@gmail.com', '980123456', NULL, 'active'),
(725105127, 'NGUYỄN THỊ NGỌC PHÚ', '2004-10-29', 'Nữ', 'phunguyen@gmail.com', '861234567', NULL, 'active'),
(725105018, 'ĐỖ THỊ NGỌC ÁNH', '2004-04-22', 'Nữ', 'anhdo@gmail.com', '882345678', NULL, 'active'),
(725105019, 'NGUYỄN NGỌC ÁNH', '2004-10-23', 'Nữ', 'anhnguyen@gmail.com', '903456789', NULL, 'active'),
(725105052, 'NGUYỄN VÂN DUY', '2004-03-24', 'Nam', 'duynguyen@gmail.com', '914567890', NULL, 'active'),
(725105053, 'PHẠM TRỌNG DAN', '2004-08-28', 'Nam', 'danpham@gmail.com', '935678901', NULL, 'active'),
(725105075, 'TRẦN ĐỨC HIẾU', '2004-02-22', 'Nam', 'hieutran@gmail.com', '966789012', NULL, 'active'),
(725105014, 'TRƯỜNG MINH ANH', '2004-12-25', 'Nam', 'anhtruong@gmail.com', '977890123', NULL, 'active'),
(725105046, 'NGUYỄN TRUNG ĐÔNG', '2004-07-04', 'Nam', 'dongnguyen@gmail.com', '988901234', NULL, 'active'),
(725105142, 'LÝ QUANG', '2004-06-28', 'Nam', 'quangly@gmail.com', '869012345', NULL, 'active'),
(725105083, 'NGUYỄN GIA CHÂU GIANG', '2004-03-14', 'Nữ', 'giangnguyen@gmail.com', '880123456', NULL, 'active'),
(725105060, 'NGUYỄN TẤN HÀI', '2004-10-16', 'Nam', 'hainguyen@gmail.com', '901234567', NULL, 'active'),
(725105061, 'TRẦN THỊ HOÀI HUYỀN', '2004-02-25', 'Nữ', 'huyentran@gmail.com', '912345678', NULL, 'active'),
(725105091, 'LÊ HỒ KHÁNH HUYỀN', '2004-12-24', 'Nữ', 'huyenle@gmail.com', '933456789', NULL, 'active'),
(725105093, 'VŨ ĐÌNH MỸ HUYỀN', '2004-03-02', 'Nữ', 'huyenvu@gmail.com', '964567890', NULL, 'active'),
(725105049, 'VŨ THƯỜNG DUYÊN', '2004-04-19', 'Nữ', 'duyenvu@gmail.com', '975678901', NULL, 'active'),
(725105068, 'VŨ THANH LINH', '2004-03-21', 'Nữ', 'linhvu@gmail.com', '986789012', NULL, 'active'),
(725105113, 'NGUYỄN LAI NGUỒN LINH', '2004-09-29', 'Nữ', 'linhnguyen@gmail.com', '867890123', NULL, 'active'),
(725105125, 'ĐỖ THỊ TRÀ MY QUỲNH', '2004-07-04', 'Nữ', 'quynhdo@gmail.com', '888901234', NULL, 'active'),
(725105146, 'NGUYỄN HỒ MY QUỲNH', '2004-10-26', 'Nữ', 'quynhnguyen@gmail.com', '909012345', NULL, 'active'),
(705105047, 'KIỀU TUẤN KIÊN', '2002-12-15', 'Nam', 'kienkieu@gmail.com', '910123456', NULL, 'active'),
(705105059, 'NGUYỄN VÂN SƠN', '2002-03-10', 'Nam', 'sonnguyen@gmail.com', '931234567', NULL, 'active'),
(705105102, 'NGUYỄN QUÝ TRUNG', '2002-02-02', 'Nam', 'trungnguyen@gmail.com', '962345678', NULL, 'active'),
(715105129, 'LÊ ĐỨC MINH', '2003-05-19', 'Nam', 'minhle@gmail.com', '973456789', NULL, 'active'),
(725105048, 'LÊ VIỆT TRUNG', '2003-04-21', 'Nam', 'trungle@gmail.com', '984567890', NULL, 'active'),
(725105094, 'HOÀNG THÁI LÂM', '2004-01-13', 'Nam', 'lamhoang@gmail.com', '865678901', NULL, 'active'),
(725105135, 'BÙI MINH PHƯỚC', '2004-04-12', 'Nam', 'phuocbui@gmail.com', '886789012', NULL, 'active'),
(725105145, 'NGUYỄN KIÊN QUYẾT', '2004-02-15', 'Nam', 'quyetnguyen@gmail.com', '907890123', NULL, 'active'),
(725105184, 'PHẠM THANH TÚ', '2004-06-18', 'Nam', 'tupham@gmail.com', '918901234', NULL, 'active'),
(725105191, 'NGUYỄN TRỌNG VIỆT', '2004-08-19', 'Nam', 'vietnguyen@gmail.com', '939012345', NULL, 'active'),
(725105195, 'LÊ ANH VŨ', '2004-10-30', 'Nam', 'vule@gmail.com', '960123456', NULL, 'active'),
(725105197, 'VŨ HÀ VY', '2004-02-17', 'Nam', 'vyvu@gmail.com', '971234567', NULL, 'active'),
(725105107, 'VŨ TRỌNG LÂN', '2004-10-23', 'Nam', 'lanvu@gmail.com', '982345678', NULL, 'active'),
(725105108, 'ĐÀM PHƯỢNG LINH', '2004-04-23', 'Nữ', 'linhdam@gmail.com', '863456789', NULL, 'active'),
(725105109, 'ĐINH THỊ LINH', '2003-04-20', 'Nữ', 'linhdinh@gmail.com', '884567890', NULL, 'active'),
(725105114, 'NGUYỄN THỊ DIỀU LINH', '2004-09-21', 'Nữ', 'linhnguyen@gmail.com', '905678901', NULL, 'active'),
(725105128, 'LƯƠNG ĐỨC NGHĨA', '2004-06-17', 'Nữ', 'nghialuong@gmail.com', '916789012', NULL, 'active'),
(725105136, 'HOÀNG MY PHƯỚC', '2005-10-12', 'Nam', 'phuochoang@gmail.com', '937890123', NULL, 'active'),
(735105066, 'NGÔ KHANH LY', '2005-04-16', 'Nam', 'lyngo@gmail.com', '968901234', NULL, 'active'),
(735105069, 'NGUYỄN THỊ HỒNG NGỌC', '2005-06-23', 'Nam', 'ngocnguyen@gmail.com', '979012345', NULL, 'active'),
(735105131, 'PHẠM PHÚC LÊ QUYỀN', '2004-08-03', 'Nam', 'quyenpham@gmail.com', '980123456', NULL, 'active'),
(735105090, 'NGUYỄN THỊ THÙY VÂN', '2005-11-02', 'Nam', 'vannguyen@gmail.com', '861234567', NULL, 'active'),
(725105158, 'NGUYỄN ANH SƠN', '2004-09-10', 'Nam', 'sonnguyen@gmail.com', '903456789', NULL, 'active'),
(725105156, 'NGUYỄN ĐỨC THẮNG', '2004-04-23', 'Nam', 'thangnguyen@gmail.com', '914567890', NULL, 'active'),
(725105176, 'ĐẶM QUỐC TRUNG', '2004-02-19', 'Nam', 'trungdam@gmail.com', '935678901', NULL, 'active'),
(725105183, 'PHẠM QUANG VINH', '2004-03-12', 'Nam', 'vinhpham@gmail.com', '966789012', NULL, 'active'),
(725105193, 'NGUYỄN QUÝ THẮNG', '2003-10-12', 'Nam', 'thangnguyen@gmail.com', '977890123', NULL, 'active'),
(725105163, 'CẢO ĐỨC THIÊN', '2004-01-11', 'Nam', 'thiencao@gmail.com', '988901234', NULL, 'active'),
(725105166, 'TRƯỜNG CÔNG THỤC', '2004-09-04', 'Nam', 'thuctruong@gmail.com', '869012345', NULL, 'active'),
(725105173, 'BÙI VĂN TRIẾU', '2004-01-02', 'Nam', 'trieubui@gmail.com', '880123456', NULL, 'active'),
(725105179, 'NGUYỄN HỮU TRƯỜNG', '2004-09-03', 'Nam', 'truongnguyen@gmail.com', '901234567', NULL, 'active'),
(725105189, 'PHÙNG ĐÌNH TUẤN', '2004-12-05', 'Nam', 'tuanphung@gmail.com', '912345678', NULL, 'active'),
(725105165, 'NGUYỄN THỊ MINH THU', '2004-11-29', 'Nữ', 'thunguyen@gmail.com', '933456789', NULL, 'active'),
(725105168, 'NGUYỄN THỊ TRÂN', '2004-12-08', 'Nam', 'trannguyen@gmail.com', '964567890', NULL, 'active'),
(725105185, 'NGUYỄN VIỆT TUẤN', '2004-12-25', 'Nam', 'tuann guyen@gmail.com', '975678901', NULL, 'active'),
(725105180, 'CHU ANH TÚ', '2004-11-29', 'Nam', 'tuchu@gmail.com', '986789012', NULL, 'active'),
(725105198, 'LÊ ANH TÚ', '2004-10-04', 'Nam', 'tule@gmail.com', '867890123', NULL, 'active'),
(725105192, 'NGUYỄN ANH TÚ', '2004-12-02', 'Nam', 'tunguyen@gmail.com', '888901234', NULL, 'active');

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
(705105047, 'COMP308'),
(705105059, 'COMP303'),
(705105102, 'COMP302'),
(715105006, 'COMP311'),
(715105013, 'COMP310'),
(715105060, 'COMP303'),
(715105129, 'COMP308'),
(725105003, 'COMP306'),
(725105007, 'COMP309'),
(725105008, 'COMP301'),
(725105009, 'COMP305'),
(725105013, 'COMP303'),
(725105014, 'COMP310'),
(725105016, 'COMP303'),
(725105018, 'COMP304'),
(725105019, 'COMP312'),
(725105025, 'COMP312'),
(725105028, 'COMP312'),
(725105031, 'COMP309'),
(725105039, 'COMP306'),
(725105041, 'COMP306'),
(725105042, 'COMP301'),
(725105046, 'COMP312'),
(725105047, 'COMP301'),
(725105048, 'COMP309'),
(725105049, 'COMP304'),
(725105052, 'COMP306'),
(725105053, 'COMP308'),
(725105059, 'COMP311'),
(725105060, 'COMP311'),
(725105061, 'COMP302'),
(725105068, 'COMP310'),
(725105069, 'COMP308'),
(725105075, 'COMP305'),
(725105083, 'COMP311'),
(725105085, 'COMP312'),
(725105087, 'COMP301'),
(725105088, 'COMP301'),
(725105089, 'COMP308'),
(725105091, 'COMP307'),
(725105093, 'COMP301'),
(725105094, 'COMP312'),
(725105096, 'COMP303'),
(725105102, 'COMP310'),
(725105105, 'COMP306'),
(725105106, 'COMP301'),
(725105107, 'COMP306'),
(725105108, 'COMP312'),
(725105109, 'COMP302'),
(725105113, 'COMP305'),
(725105114, 'COMP312'),
(725105115, 'COMP312'),
(725105120, 'COMP304'),
(725105125, 'COMP310'),
(725105127, 'COMP303'),
(725105128, 'COMP304'),
(725105130, 'COMP306'),
(725105135, 'COMP301'),
(725105136, 'COMP309'),
(725105139, 'COMP301'),
(725105142, 'COMP307'),
(725105145, 'COMP307'),
(725105146, 'COMP301'),
(725105156, 'COMP307'),
(725105158, 'COMP305'),
(725105163, 'COMP303'),
(725105165, 'COMP306'),
(725105166, 'COMP310'),
(725105168, 'COMP302'),
(725105173, 'COMP312'),
(725105176, 'COMP309'),
(725105179, 'COMP307'),
(725105180, 'COMP303'),
(725105183, 'COMP310'),
(725105184, 'COMP310'),
(725105185, 'COMP303'),
(725105187, 'COMP310'),
(725105189, 'COMP309'),
(725105191, 'COMP308'),
(725105192, 'COMP311'),
(725105193, 'COMP304'),
(725105195, 'COMP303'),
(725105197, 'COMP310'),
(725105198, 'COMP310'),
(735105066, 'COMP312'),
(735105069, 'COMP304'),
(735105090, 'COMP304'),
(735105131, 'COMP304');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL,
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
(1001, 'Nguyễn Đức Thắng', '2004-05-23', 'nam', 'random_1_@email.com', '+8486 7977 105', 'th.jpg', NULL),
(1002, 'Teacher_2', '2004-05-23', 'nữ', 'random_2_@email.com', '+8486 7977 105', NULL, NULL),
(1003, 'Teacher_3', '2004-05-23', 'nam', 'random_3_@email.com', '+8486 7977 105', NULL, NULL),
(1004, 'Teacher_4', '2004-05-23', 'nam', 'random_4_@email.com', '+8486 7977 105', NULL, NULL),
(1005, 'Teacher_5', '2004-05-23', 'nam', 'random_5_@email.com', '+8486 7977 105', NULL, NULL),
(1006, 'Teacher_6', '2004-05-23', 'nữ', 'random_6_@email.com', '+8486 7977 105', NULL, NULL),
(1007, 'Teacher_7', '2004-05-23', 'nữ', 'random_7_@email.com', '+8486 7977 105', NULL, NULL),
(1008, 'Teacher_8', '2004-05-23', 'nam', 'random_8_@email.com', '+8486 7977 105', NULL, NULL),
(1009, 'Teacher_9', '2004-05-23', 'nam', 'random_9_@email.com', '+8486 7977 105', NULL, NULL),
(1010, 'Teacher_10', '2004-05-23', 'nữ', 'random_10_@email.com', '+8486 7977 105', NULL, NULL),
(1011, 'Teacher_11', '2004-05-23', 'nam', 'random_11_@email.com', '+8486 7977 105', NULL, NULL),
(1012, 'Teacher_12', '2004-05-23', 'nữ', 'random_12_@email.com', '+8486 7977 105', NULL, NULL);

-- --------------------------------------------------------
--
-- Table structure for table `schedules`
--
CREATE TABLE `student_schedule` (
  `s_id` int(11) NOT NULL,
  `s_name` varchar(100) NOT NULL,
  `s_tstart` time NOT NULL,
  `s_tend` time NOT NULL,
  `s_daybegin` date NOT NULL,
  `s_dayend` date NOT NULL,
  `student_id` int(11) NOT NULL,
  `s_location` varchar(255) DEFAULT NULL,
  `teacher_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `schedule`
--
INSERT INTO `student_schedule` (`s_id`, `s_name`, `s_tstart`, `s_tend`, `s_daybegin`, `s_dayend`, `student_id`, `s_location`, `teacher_id`) VALUES
-- COMP301 - Phân tích thiết kế hệ thống (Giáo viên: Nguyễn Đức Thắng - 1001)
-- (1, 'Phân tích thiết kế hệ thống', '07:30:00', '09:30:00', '2025-02-24', '2025-06-20', NULL, 'Phòng A301', 1001),
(1, 'Phân tích thiết kế hệ thống', '07:30:00', '09:30:00', '2025-02-24', '2025-06-20', 725105008, 'Phòng A301', 1001),
(2, 'Phân tích thiết kế hệ thống', '07:30:00', '09:30:00', '2025-02-24', '2025-06-20', 725105042, 'Phòng A301', 1001),
(3, 'Phân tích thiết kế hệ thống', '07:30:00', '09:30:00', '2025-02-24', '2025-06-20', 725105047, 'Phòng A301', 1001),
(4, 'Phân tích thiết kế hệ thống', '07:30:00', '09:30:00', '2025-02-24', '2025-06-20', 725105087, 'Phòng A301', 1001),
(5, 'Phân tích thiết kế hệ thống', '09:45:00', '11:45:00', '2025-02-24', '2025-06-20', 725105088, 'Phòng A301', 1001),
(6, 'Phân tích thiết kế hệ thống', '09:45:00', '11:45:00', '2025-02-24', '2025-06-20', 725105093, 'Phòng A301', 1001),
(7, 'Phân tích thiết kế hệ thống', '09:45:00', '11:45:00', '2025-02-24', '2025-06-20', 725105106, 'Phòng A301', 1001),
(8, 'Phân tích thiết kế hệ thống', '13:30:00', '15:30:00', '2025-02-24', '2025-06-20', 725105135, 'Phòng A301', 1001),
(9, 'Phân tích thiết kế hệ thống', '13:30:00', '15:30:00', '2025-02-24', '2025-06-20', 725105139, 'Phòng A301', 1001),
(10, 'Phân tích thiết kế hệ thống', '13:30:00', '15:30:00', '2025-02-24', '2025-06-20', 725105146, 'Phòng A301', 1001),
-- COMP302 - Cơ sở dữ liệu (Giáo viên: Nguyễn Đức Thắng - 1001)
-- (2, 'Cơ sở dữ liệu', '07:30:00', '09:30:00', '2025-02-25', '2025-06-21', NULL, 'Phòng B201', 1001),
(11, 'Cơ sở dữ liệu', '07:30:00', '09:30:00', '2025-02-25', '2025-06-21', 705105102, 'Phòng B201', 1001),
(12, 'Cơ sở dữ liệu', '07:30:00', '09:30:00', '2025-02-25', '2025-06-21', 725105061, 'Phòng B201', 1001),
(13, 'Cơ sở dữ liệu', '07:30:00', '09:30:00', '2025-02-25', '2025-06-21', 725105109, 'Phòng B201', 1001),
(14, 'Cơ sở dữ liệu', '07:30:00', '09:30:00', '2025-02-25', '2025-06-21', 725105168, 'Phòng B201', 1001),
-- COMP303 - Lập trình Java (Giáo viên: Teacher_2 - 1002)
-- (3, 'Lập trình Java', '08:30:00', '10:30:00', '2025-02-26', '2025-06-22', NULL, 'Phòng C103', 1002),
(15, 'Lập trình Java', '08:30:00', '10:30:00', '2025-02-26', '2025-06-22', 705105059, 'Phòng C103', 1002),
(16, 'Lập trình Java', '08:30:00', '10:30:00', '2025-02-26', '2025-06-22', 715105060, 'Phòng C103', 1002),
(17, 'Lập trình Java', '08:30:00', '10:30:00', '2025-02-26', '2025-06-22', 725105013, 'Phòng C103', 1002),
(18, 'Lập trình Java', '08:30:00', '10:30:00', '2025-02-26', '2025-06-22', 725105016, 'Phòng C103', 1002),
(19, 'Lập trình Java', '13:30:00', '15:30:00', '2025-02-26', '2025-06-22', 725105096, 'Phòng C103', 1002),
(20, 'Lập trình Java', '13:30:00', '15:30:00', '2025-02-26', '2025-06-22', 725105127, 'Phòng C103', 1002),
(21, 'Lập trình Java', '13:30:00', '15:30:00', '2025-02-26', '2025-06-22', 725105163, 'Phòng C103', 1002),
(22, 'Lập trình Java', '13:30:00', '15:30:00', '2025-02-26', '2025-06-22', 725105180, 'Phòng C103', 1002),
(23, 'Lập trình Java', '13:30:00', '15:30:00', '2025-02-26', '2025-06-22', 725105185, 'Phòng C103', 1002),
(24, 'Lập trình Java', '13:30:00', '15:30:00', '2025-02-26', '2025-06-22', 725105195, 'Phòng C103', 1002),
-- COMP304 - Mạng máy tính (Giáo viên: Teacher_3 - 1003)
-- (4, 'Mạng máy tính', '10:00:00', '12:00:00', '2025-02-27', '2025-06-23', NULL, 'Phòng D104', 1003),
(25, 'Mạng máy tính', '10:00:00', '12:00:00', '2025-02-27', '2025-06-23', 725105018, 'Phòng D104', 1003),
(26, 'Mạng máy tính', '10:00:00', '12:00:00', '2025-02-27', '2025-06-23', 725105049, 'Phòng D104', 1003),
(27, 'Mạng máy tính', '10:00:00', '12:00:00', '2025-02-27', '2025-06-23', 725105120, 'Phòng D104', 1003),
(28, 'Mạng máy tính', '10:00:00', '12:00:00', '2025-02-27', '2025-06-23', 725105128, 'Phòng D104', 1003),
(29, 'Mạng máy tính', '15:00:00', '17:00:00', '2025-02-27', '2025-06-23', 725105193, 'Phòng D104', 1003),
(30, 'Mạng máy tính', '15:00:00', '17:00:00', '2025-02-27', '2025-06-23', 735105069, 'Phòng D104', 1003),
(31, 'Mạng máy tính', '15:00:00', '17:00:00', '2025-02-27', '2025-06-23', 735105090, 'Phòng D104', 1003),
(32, 'Mạng máy tính', '15:00:00', '17:00:00', '2025-02-27', '2025-06-23', 735105131, 'Phòng D104', 1003),
-- COMP305 - Lập trình C# (Giáo viên: Teacher_3 - 1003)
-- (5, 'Lập trình C#', '09:00:00', '11:00:00', '2025-02-28', '2025-06-24', NULL, 'Phòng E205', 1003),
(33, 'Lập trình C#', '09:00:00', '11:00:00', '2025-02-28', '2025-06-24', 725105009, 'Phòng E205', 1003),
(34, 'Lập trình C#', '09:00:00', '11:00:00', '2025-02-28', '2025-06-24', 725105075, 'Phòng E205', 1003),
(35, 'Lập trình C#', '09:00:00', '11:00:00', '2025-02-28', '2025-06-24', 725105113, 'Phòng E205', 1003),
(36, 'Lập trình C#', '09:00:00', '11:00:00', '2025-02-28', '2025-06-24', 725105158, 'Phòng E205', 1003),
-- COMP306 - Nguyên lý hệ điều hành (Giáo viên: Teacher_5 - 1005)
-- (6, 'Nguyên lý hệ điều hành', '15:00:00', '17:00:00', '2025-03-03', '2025-06-25', NULL, 'Phòng F106', 1005),
(37, 'Nguyên lý hệ điều hành', '15:00:00', '17:00:00', '2025-03-03', '2025-06-25', 725105003, 'Phòng F106', 1005),
(38, 'Nguyên lý hệ điều hành', '15:00:00', '17:00:00', '2025-03-03', '2025-06-25', 725105039, 'Phòng F106', 1005),
(39, 'Nguyên lý hệ điều hành', '15:00:00', '17:00:00', '2025-03-03', '2025-06-25', 725105041, 'Phòng F106', 1005),
(40, 'Nguyên lý hệ điều hành', '15:00:00', '17:00:00', '2025-03-03', '2025-06-25', 725105052, 'Phòng F106', 1005),
(41, 'Nguyên lý hệ điều hành', '07:30:00', '09:30:00', '2025-03-04', '2025-06-25', 725105105, 'Phòng F106', 1005),
(42, 'Nguyên lý hệ điều hành', '07:30:00', '09:30:00', '2025-03-04', '2025-06-25', 725105107, 'Phòng F106', 1005),
(43, 'Nguyên lý hệ điều hành', '07:30:00', '09:30:00', '2025-03-04', '2025-06-25', 725105130, 'Phòng F106', 1005),
(44, 'Nguyên lý hệ điều hành', '07:30:00', '09:30:00', '2025-03-04', '2025-06-25', 725105165, 'Phòng F106', 1005),
-- COMP307 - Cấu trúc dữ liệu và giải thuật (Giáo viên: Teacher_5 - 1005)
-- (7, 'Cấu trúc dữ liệu và giải thuật', '15:00:00', '17:00:00', '2025-03-05', '2025-06-26', NULL, 'Phòng G207', 1005),
(45, 'Cấu trúc dữ liệu và giải thuật', '15:00:00', '17:00:00', '2025-03-05', '2025-06-26', 725105091, 'Phòng G207', 1005),
(46, 'Cấu trúc dữ liệu và giải thuật', '15:00:00', '17:00:00', '2025-03-05', '2025-06-26', 725105142, 'Phòng G207', 1005),
(47, 'Cấu trúc dữ liệu và giải thuật', '15:00:00', '17:00:00', '2025-03-05', '2025-06-26', 725105145, 'Phòng G207', 1005),
(48, 'Cấu trúc dữ liệu và giải thuật', '15:00:00', '17:00:00', '2025-03-05', '2025-06-26', 725105156, 'Phòng G207', 1005),
(49, 'Cấu trúc dữ liệu và giải thuật', '15:00:00', '17:00:00', '2025-03-05', '2025-06-26', 725105179, 'Phòng G207', 1005),
-- COMP308 - Toán rời rạc (Giáo viên: Teacher_6 - 1006)
-- (8, 'Toán rời rạc', '15:00:00', '17:00:00', '2025-03-06', '2025-06-27', NULL, 'Phòng H108', 1006),
(50, 'Toán rời rạc', '15:00:00', '17:00:00', '2025-03-06', '2025-06-27', 705105047, 'Phòng H108', 1006),
(51, 'Toán rời rạc', '15:00:00', '17:00:00', '2025-03-06', '2025-06-27', 715105129, 'Phòng H108', 1006),
(52, 'Toán rời rạc', '15:00:00', '17:00:00', '2025-03-06', '2025-06-27', 725105053, 'Phòng H108', 1006),
(53, 'Toán rời rạc', '15:00:00', '17:00:00', '2025-03-06', '2025-06-27', 725105069, 'Phòng H108', 1006),
(54, 'Toán rời rạc', '15:00:00', '17:00:00', '2025-03-06', '2025-06-27', 725105089, 'Phòng H108', 1006),
(55, 'Toán rời rạc', '15:00:00', '17:00:00', '2025-03-06', '2025-06-27', 725105191, 'Phòng H108', 1006),
-- COMP309 - Nhập môn lý thuyết ma trận (Giáo viên: Teacher_8 - 1008)
-- (9, 'Nhập môn lý thuyết ma trận', '15:00:00', '17:00:00', '2025-03-07', '2025-06-28', NULL, 'Phòng I209', 1008),
(56, 'Nhập môn lý thuyết ma trận', '15:00:00', '17:00:00', '2025-03-07', '2025-06-28', 725105007, 'Phòng I209', 1008),
(57, 'Nhập môn lý thuyết ma trận', '15:00:00', '17:00:00', '2025-03-07', '2025-06-28', 725105031, 'Phòng I209', 1008),
(58, 'Nhập môn lý thuyết ma trận', '15:00:00', '17:00:00', '2025-03-07', '2025-06-28', 725105048, 'Phòng I209', 1008),
(59, 'Nhập môn lý thuyết ma trận', '15:00:00', '17:00:00', '2025-03-07', '2025-06-28', 725105136, 'Phòng I209', 1008),
(60, 'Nhập môn lý thuyết ma trận', '15:00:00', '17:00:00', '2025-03-07', '2025-06-28', 725105176, 'Phòng I209', 1008),
(61, 'Nhập môn lý thuyết ma trận', '15:00:00', '17:00:00', '2025-03-07', '2025-06-28', 725105189, 'Phòng I209', 1008),
-- COMP310 - Lập trình hướng đối tượng (Giáo viên: Teacher_11 - 1011)
-- (10, 'Lập trình hướng đối tượng', '15:00:00', '17:00:00', '2025-03-10', '2025-06-29', NULL, 'Phòng J110', 1011),
(62, 'Lập trình hướng đối tượng', '15:00:00', '17:00:00', '2025-03-10', '2025-06-29', 715105013, 'Phòng J110', 1011),
(63, 'Lập trình hướng đối tượng', '15:00:00', '17:00:00', '2025-03-10', '2025-06-29', 725105014, 'Phòng J110', 1011),
(64, 'Lập trình hướng đối tượng', '15:00:00', '17:00:00', '2025-03-10', '2025-06-29', 725105068, 'Phòng J110', 1011),
(65, 'Lập trình hướng đối tượng', '15:00:00', '17:00:00', '2025-03-10', '2025-06-29', 725105102, 'Phòng J110', 1011),
(66, 'Lập trình hướng đối tượng', '15:00:00', '17:00:00', '2025-03-10', '2025-06-29', 725105125, 'Phòng J110', 1011),
(67, 'Lập trình hướng đối tượng', '09:00:00', '11:00:00', '2025-03-11', '2025-06-29', 725105166, 'Phòng J110', 1011),
(68, 'Lập trình hướng đối tượng', '09:00:00', '11:00:00', '2025-03-11', '2025-06-29', 725105183, 'Phòng J110', 1011),
(69, 'Lập trình hướng đối tượng', '09:00:00', '11:00:00', '2025-03-11', '2025-06-29', 725105184, 'Phòng J110', 1011),
(70, 'Lập trình hướng đối tượng', '09:00:00', '11:00:00', '2025-03-11', '2025-06-29', 725105187, 'Phòng J110', 1011),
(71, 'Lập trình hướng đối tượng', '09:00:00', '11:00:00', '2025-03-11', '2025-06-29', 725105197, 'Phòng J110', 1011),
(72, 'Lập trình hướng đối tượng', '09:00:00', '11:00:00', '2025-03-11', '2025-06-29', 725105198, 'Phòng J110', 1011),
-- COMP311 - Kiến trúc máy tính (Giáo viên: Nguyễn Đức Thắng - 1001)
-- (11, 'Kiến trúc máy tính', '15:00:00', '17:00:00', '2025-03-12', '2025-06-30', NULL, 'Phòng K211', 1001),
(73, 'Kiến trúc máy tính', '15:00:00', '17:00:00', '2025-03-12', '2025-06-30', 715105006, 'Phòng K211', 1001),
(74, 'Kiến trúc máy tính', '15:00:00', '17:00:00', '2025-03-12', '2025-06-30', 725105059, 'Phòng K211', 1001),
(75, 'Kiến trúc máy tính', '15:00:00', '17:00:00', '2025-03-12', '2025-06-30', 725105060, 'Phòng K211', 1001),
(76, 'Kiến trúc máy tính', '15:00:00', '17:00:00', '2025-03-12', '2025-06-30', 725105083, 'Phòng K211', 1001),
(77, 'Kiến trúc máy tính', '15:00:00', '17:00:00', '2025-03-12', '2025-06-30', 725105192, 'Phòng K211', 1001),
-- COMP312 - Trí tuệ nhân tạo (Giáo viên: Teacher_3 - 1003)
-- (12, 'Trí tuệ nhân tạo', '15:00:00', '17:00:00', '2025-03-13', '2025-07-01', NULL, 'Phòng L112', 1003);
(78, 'Trí tuệ nhân tạo', '15:00:00', '17:00:00', '2025-03-13', '2025-07-01', 725105019, 'Phòng L112', 1003),
(79, 'Trí tuệ nhân tạo', '15:00:00', '17:00:00', '2025-03-13', '2025-07-01', 725105025, 'Phòng L112', 1003),
(80, 'Trí tuệ nhân tạo', '15:00:00', '17:00:00', '2025-03-13', '2025-07-01', 725105028, 'Phòng L112', 1003),
(81, 'Trí tuệ nhân tạo', '15:00:00', '17:00:00', '2025-03-13', '2025-07-01', 725105046, 'Phòng L112', 1003),
(82, 'Trí tuệ nhân tạo', '15:00:00', '17:00:00', '2025-03-13', '2025-07-01', 725105085, 'Phòng L112', 1003),
(83, 'Trí tuệ nhân tạo', '09:00:00', '11:00:00', '2025-03-14', '2025-07-01', 725105094, 'Phòng L112', 1003),
(84, 'Trí tuệ nhân tạo', '09:00:00', '11:00:00', '2025-03-14', '2025-07-01', 725105108, 'Phòng L112', 1003),
(85, 'Trí tuệ nhân tạo', '09:00:00', '11:00:00', '2025-03-14', '2025-07-01', 725105114, 'Phòng L112', 1003),
(86, 'Trí tuệ nhân tạo', '09:00:00', '11:00:00', '2025-03-14', '2025-07-01', 725105115, 'Phòng L112', 1003),
(87, 'Trí tuệ nhân tạo', '09:00:00', '11:00:00', '2025-03-14', '2025-07-01', 725105173, 'Phòng L112', 1003),
(88, 'Trí tuệ nhân tạo', '09:00:00', '11:00:00', '2025-03-14', '2025-07-01', 735105066, 'Phòng L112', 1003);

-- --------------------------------------------------------
--
-- Table structure for table `schedules`
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
-- Indexes for table `schedule`
--
ALTER TABLE `student_schedule`
  ADD PRIMARY KEY (`s_id`),
  ADD KEY `teacher_id` (`teacher_id`);

--
-- AUTO_INCREMENT for dumped tables
--

-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `student_schedule`
  MODIFY `s_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Foreign key constraint
--
-- ALTER TABLE `schedule`
--   ADD CONSTRAINT `schedule_teacher_fk` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE CASCADE;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `teacher_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

COMMIT;
-- Dọc các bảng và giải thích luồng dữ liệu liên kết sau:
-- CREATE TABLE `users` (
--   `id` int(11) NOT NULL,
--   `username` varchar(50) NOT NULL,
--   `password` text NOT NULL,
--   `oldpass` text DEFAULT NULL,
--   `i_student` int(11) DEFAULT NULL,
--   `i_teacher` int(11) DEFAULT NULL,
--   `i_role` varchar(50) NOT NULL,
--   `status` varchar(50) DEFAULT NULL
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- CREATE TABLE `attendance` (
--   `class_id` int(11) NOT NULL,
--   `class_name` varchar(50) NOT NULL,
--   `teacher_id` int(11) NOT NULL,
--   `student_id` int(11) NOT NULL,
--   `attendance_time` datetime NOT NULL,
--   `status` varchar(50) NOT NULL
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- CREATE TABLE `class` (
--   `class_id` varchar(10) NOT NULL,
--   `class_name` varchar(50) NOT NULL,
--   `teacher_id` int(11) NOT NULL,
--   `class_time` datetime NOT NULL,
--   `total_student` int(11) NOT NULL
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- CREATE TABLE `student` (
--   `student_id` int(11) NOT NULL,
--   `student_name` varchar(50) NOT NULL,
--   `student_birth` date NOT NULL,
--   `student_gender` varchar(10) NOT NULL,
--   `student_mail` varchar(50) DEFAULT NULL,
--   `student_phone` varchar(50) DEFAULT NULL,
--   `student_image` varchar(50) DEFAULT NULL,
--   `status` varchar(50) DEFAULT NULL
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- CREATE TABLE `student_class` (
--   `student_id` int(11) NOT NULL,
--   `class_id` varchar(10) NOT NULL
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- CREATE TABLE `teacher` (
--   `teacher_id` int(11) NOT NULL,
--   `teacher_name` varchar(50) NOT NULL,
--   `teacher_birth` date NOT NULL,
--   `teacher_gender` varchar(50) NOT NULL,
--   `teacher_mail` varchar(50) DEFAULT NULL,
--   `teacher_phone` varchar(50) DEFAULT NULL,
--   `teacher_image` varchar(10) DEFAULT NULL,
--   `status` varchar(50) DEFAULT NULL
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- CREATE TABLE `student_schedule` (
--   `s_id` int(11) NOT NULL,
--   `s_name` varchar(100) NOT NULL,
--   `s_tstart` time NOT NULL,
--   `s_tend` time NOT NULL,
--   `s_daybegin` date NOT NULL,
--   `s_dayend` date NOT NULL,
--   `student_id` int(11) NOT NULL,
--   `s_location` varchar(255) DEFAULT NULL,
--   `teacher_id` int(11) NOT NULL
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ALTER TABLE `attendance`
--   ADD PRIMARY KEY (`class_id`,`attendance_time`);
-- ALTER TABLE `class`
--   ADD PRIMARY KEY (`class_id`);
-- ALTER TABLE `student`
--   ADD PRIMARY KEY (`student_id`);
-- ALTER TABLE `student_class`
--   ADD PRIMARY KEY (`student_id`,`class_id`);
-- ALTER TABLE `teacher`
--   ADD PRIMARY KEY (`teacher_id`);
-- ALTER TABLE `users`
--   ADD PRIMARY KEY (`id`);
-- ALTER TABLE `student_schedule`
--   ADD PRIMARY KEY (`s_id`),
--   ADD KEY `teacher_id` (`teacher_id`);
-- ALTER TABLE `student_schedule`
--   MODIFY `s_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
-- ALTER TABLE `teacher`
--   MODIFY `teacher_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
-- ALTER TABLE `users`
--   MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
-- COMMIT;