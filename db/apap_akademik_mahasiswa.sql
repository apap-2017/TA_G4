-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 05, 2017 at 01:18 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apap_akademik_mahasiswa`
--

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE `kelas` (
  `id_riwayat_perkuliahan` int(11) NOT NULL,
  `tanggal_pengisian` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `kode_mata_kuliah` varchar(50) NOT NULL,
  `kode_kurikulum` varchar(50) NOT NULL,
  `id_kelas` int(11) NOT NULL,
  `nama_mata_kuliah` varchar(250) NOT NULL,
  `nama_kelas` varchar(50) NOT NULL,
  `sks` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`id_riwayat_perkuliahan`, `tanggal_pengisian`, `kode_mata_kuliah`, `kode_kurikulum`, `id_kelas`, `nama_mata_kuliah`, `nama_kelas`, `sks`) VALUES
(1, '2017-12-03 14:35:17', 'SI1', '2016.2017', 1, 'Bisnis Aja', 'BA1', 3),
(2, '2017-12-03 14:35:17', 'SI1', '2016.2017', 1, 'Bisnis Aja', 'BA1', 3),
(4, '2017-12-03 14:35:17', 'SI1', '2016.2017', 1, 'Bisnis Aja', 'BA1', 3),
(6, '2017-12-03 14:35:17', 'SI1', '2016.2017', 1, 'Bisnis Aja', 'BA1', 3),
(9, '2017-12-03 14:35:17', 'SI1', '2016.2017', 1, 'Bisnis Aja', 'BA1', 3),
(11, '2017-12-04 07:19:02', 'FI1101', 'U1-F1-P1-2', 1, 'Fisika Dasar IA', 'Fisika Dasar IA-A', 4),
(12, '2017-12-05 04:20:07', 'CS124', '2016.2017', 1, 'Kombistek', 'Fisika Dasar IA-A', 4),
(1, '2017-12-03 14:35:17', 'SI2', '2016.2017', 2, 'Bisnis Itu', 'BI1', 4),
(2, '2017-12-03 14:35:17', 'SI2', '2016.2017', 2, 'Bisnis Itu', 'BI1', 4),
(4, '2017-12-03 14:35:17', 'SI2', '2016.2017', 2, 'Bisnis Itu', 'BI1', 4),
(6, '2017-12-03 14:35:17', 'SI2', '2016.2017', 2, 'Bisnis Itu', 'BI1', 4),
(9, '2017-12-03 14:35:17', 'SI2', '2016.2017', 2, 'Bisnis Itu', 'BI1', 4),
(1, '2017-12-03 14:35:17', 'SI3', '2016.2017', 3, 'Bisnis Sana', 'BS1', 3),
(3, '2017-12-03 14:35:17', 'SI3', '2016.2017', 3, 'Bisnis Sana', 'BS1', 3),
(5, '2017-12-03 14:35:17', 'SI3', '2016.2017', 3, 'Bisnis Sana', 'BS1', 3),
(7, '2017-12-03 14:35:17', 'SI3', '2016.2017', 3, 'Bisnis Sana', 'BS1', 3),
(9, '2017-12-03 14:35:17', 'SI3', '2016.2017', 3, 'Bisnis Sana', 'BS1', 3),
(1, '2017-12-03 14:35:17', 'SI4', '2016.2017', 4, 'Bisnis Lagi', 'BL1', 4),
(3, '2017-12-03 14:35:17', 'SI4', '2016.2017', 4, 'Bisnis Lagi', 'BL1', 4),
(5, '2017-12-03 14:35:17', 'SI4', '2016.2017', 4, 'Bisnis Lagi', 'BL1', 4),
(7, '2017-12-03 14:35:17', 'SI4', '2016.2017', 4, 'Bisnis Lagi', 'BL1', 4),
(10, '2017-12-03 14:35:17', 'SI4', '2016.2017', 4, 'Bisnis Lagi', 'BL1', 4),
(2, '2017-12-03 14:35:17', 'SI5', '2016.2017', 5, 'Bisnis Admin', 'BAA1', 3),
(3, '2017-12-03 14:35:17', 'SI5', '2016.2017', 5, 'Bisnis Admin', 'BAA1', 3),
(5, '2017-12-03 14:35:17', 'SI5', '2016.2017', 5, 'Bisnis Admin', 'BAA1', 3),
(7, '2017-12-03 14:35:17', 'SI5', '2016.2017', 5, 'Bisnis Admin', 'BAA1', 3),
(10, '2017-12-03 14:35:17', 'SI5', '2016.2017', 5, 'Bisnis Admin', 'BAA1', 3),
(2, '2017-12-03 14:35:17', 'SI6', '2016.2017', 6, 'Coding Aja', 'CA1', 5),
(4, '2017-12-03 14:35:17', 'SI6', '2016.2017', 6, 'Coding Aja', 'CA1', 5),
(5, '2017-12-03 14:35:17', 'SI6', '2016.2017', 6, 'Coding Aja', 'CA1', 5),
(8, '2017-12-03 14:35:17', 'SI6', '2016.2017', 6, 'Coding Aja', 'CA1', 5),
(10, '2017-12-03 14:35:17', 'SI6', '2016.2017', 6, 'Coding Aja', 'CA1', 5),
(2, '2017-12-03 14:35:17', 'SI7', '2016.2017', 7, 'Coding Bgt', 'CB1', 3),
(4, '2017-12-03 14:35:17', 'SI7', '2016.2017', 7, 'Coding Bgt', 'CB1', 3),
(6, '2017-12-03 14:35:17', 'SI7', '2016.2017', 7, 'Coding Bgt', 'CB1', 3),
(8, '2017-12-03 14:35:17', 'SI7', '2016.2017', 7, 'Coding Bgt', 'CB1', 3),
(10, '2017-12-03 14:35:17', 'SI7', '2016.2017', 7, 'Coding Bgt', 'CB1', 3),
(11, '2017-12-04 07:19:02', 'FI1201', 'U1-F1-P1-2', 13, 'Fisika Dasar IIA', 'Fisika Dasar IIA-A', 4),
(11, '2017-12-04 07:19:02', 'TI4204', 'U1-F1-P1-2', 42, 'Manajemen Sumber Daya Manusis', 'Manajemen Sumber Daya Manusis-B', 3);

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `npm` char(9) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `username` varchar(100) NOT NULL,
  `id_universitas` int(6) NOT NULL,
  `id_fakultas` int(6) NOT NULL,
  `id_prodi` int(6) NOT NULL,
  `angkatan` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`npm`, `nama`, `username`, `id_universitas`, `id_fakultas`, `id_prodi`, `angkatan`) VALUES
('123456781', 'nama1', 'username1', 1, 1, 1, 2015),
('123456782', 'nama2', 'username2', 1, 1, 1, 2015),
('123456783', 'nama3', 'username3', 1, 1, 1, 2016),
('123456784', 'nama4', 'username4', 1, 1, 1, 2018),
('123456785', 'nama5', 'username5', 1, 1, 1, 2018),
('123456786', 'nama6', 'username6', 1, 1, 1, 2018),
('123456787', 'nama7', 'username7', 1, 1, 1, 2018),
('1302', 'jokowi', 'jokowi', 1, 1, 1, 2015);

-- --------------------------------------------------------

--
-- Table structure for table `riwayat_perkuliahan`
--

CREATE TABLE `riwayat_perkuliahan` (
  `id` int(11) NOT NULL,
  `status_irs` tinyint(1) NOT NULL DEFAULT '0',
  `npm` char(9) NOT NULL,
  `tahun_ajar` varchar(50) NOT NULL,
  `term` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `riwayat_perkuliahan`
--

INSERT INTO `riwayat_perkuliahan` (`id`, `status_irs`, `npm`, `tahun_ajar`, `term`) VALUES
(1, 0, '123456781', '2015-16', 1),
(2, 0, '123456781', '2017-16', 2),
(3, 0, '123456781', '2015-16', 2),
(4, 0, '123456781', '2017-16', 1),
(5, 0, '123456782', '2016-17', 1),
(6, 0, '123456782', '2015-16', 2),
(7, 0, '123456782', '2015-16', 1),
(8, 0, '123456782', '2016-17', 2),
(9, 0, '123456783', '2016-17', 1),
(10, 0, '123456783', '2016-17', 2),
(11, 0, '123456781', '2017-18', 1),
(12, 0, '1302', '2017-18', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`) VALUES
('jokowi', 'jokowipassword'),
('username1', 'password1'),
('username10', 'password10'),
('username2', 'password2'),
('username3', 'password3'),
('username4', 'password4'),
('username5', 'password5'),
('username6', 'password6'),
('username7', 'password7'),
('username8', 'password8'),
('username9', 'password9');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `username` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`username`, `role`) VALUES
('jokowi', 'ROLE_MAHASISWA'),
('username1', 'ROLE_MAHASISWA'),
('username10', 'ROLE_SEKRETARIAT'),
('username2', 'ROLE_MAHASISWA'),
('username3', 'ROLE_MAHASISWA'),
('username4', 'ROLE_MAHASISWA'),
('username5', 'ROLE_MAHASISWA'),
('username6', 'ROLE_MAHASISWA'),
('username7', 'ROLE_MAHASISWA'),
('username8', 'ROLE_SEKRETARIAT'),
('username9', 'ROLE_SEKRETARIAT');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`id_kelas`,`id_riwayat_perkuliahan`),
  ADD KEY `id_riwayat_perkuliahan` (`id_riwayat_perkuliahan`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`npm`),
  ADD KEY `mahasiswa_username_idx` (`username`);

--
-- Indexes for table `riwayat_perkuliahan`
--
ALTER TABLE `riwayat_perkuliahan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `riwayat_perkuliahan_npm_term_thn_idx` (`npm`,`term`,`tahun_ajar`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `riwayat_perkuliahan`
--
ALTER TABLE `riwayat_perkuliahan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `kelas`
--
ALTER TABLE `kelas`
  ADD CONSTRAINT `kelas_ibfk_1` FOREIGN KEY (`id_riwayat_perkuliahan`) REFERENCES `riwayat_perkuliahan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD CONSTRAINT `mahasiswa_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `riwayat_perkuliahan`
--
ALTER TABLE `riwayat_perkuliahan`
  ADD CONSTRAINT `riwayat_perkuliahan_ibfk_1` FOREIGN KEY (`npm`) REFERENCES `mahasiswa` (`npm`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
