-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 10, 2017 at 06:06 AM
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
(33, '2017-12-10 05:05:11', 'EL4230', 'U1-F1-P1-1', 5, 'Analisis & Perancangan IC Digital', 'Analisis & Perancangan IC Digital-A', 3),
(33, '2017-12-10 05:05:12', 'MB4045', 'U1-F1-P1-1', 10, 'Manajemen Investasi', 'Manajemen Investasi-A', 3),
(27, '2017-12-09 09:09:59', 'ECM103', 'U1-F1-P1-1', 11, 'Pengantar Akuntansi 1', 'Pengantar Akuntansi 1-A', 4),
(29, '2017-12-09 09:14:35', 'ECM103', 'U1-F1-P1-1', 11, 'Pengantar Akuntansi 1', 'Pengantar Akuntansi 1-A', 4),
(31, '2017-12-09 09:14:35', 'ECM103', 'U1-F1-P1-1', 11, 'Pengantar Akuntansi 1', 'Pengantar Akuntansi 1-A', 4),
(26, '2017-12-09 18:14:07', ' PSO105A', 'U1-F1-P1-1', 12, 'Kode Etik Psikologi', 'Kode Etik Psikologi', 2),
(28, '2017-12-09 18:15:04', ' PSO105A', 'U1-F1-P1-1', 12, 'Kode Etik Psikologi', 'Kode Etik Psikologi', 2),
(27, '2017-12-09 09:09:59', 'MB4045', 'U1-F1-P1-1', 13, 'Manajemen Investasi', 'Manajemen Investasi', 3),
(29, '2017-12-09 09:14:35', 'MB4045', 'U1-F1-P1-1', 13, 'Manajemen Investasi', 'Manajemen Investasi', 3),
(31, '2017-12-09 09:14:35', 'MB4045', 'U1-F1-P1-1', 13, 'Manajemen Investasi', 'Manajemen Investasi', 3),
(26, '2017-12-09 18:14:07', 'MA1101', 'U1-F1-P1-1', 14, 'Matematika IA', 'Matematika IA-A', 4),
(28, '2017-12-09 18:15:04', 'MA1101', 'U1-F1-P1-1', 14, 'Matematika IA', 'Matematika IA-A', 4),
(30, '2017-12-09 18:17:46', 'MA1101', 'U1-F1-P1-1', 14, 'Matematika IA', 'Matematika IA-A', 4),
(26, '2017-12-09 18:14:07', 'MA1201', 'U1-F1-P1-1', 15, 'Matematika IIA', 'Matematika IIA-A', 4),
(30, '2017-12-09 18:17:46', 'MA1201', 'U1-F1-P1-1', 15, 'Matematika IIA', 'Matematika IIA-A', 4),
(27, '2017-12-09 09:09:59', 'KU1072', 'U1-F1-P1-1', 16, 'Pengenalan Teknologi Informasi', 'Pengenalan Teknologi Informasi A', 2),
(29, '2017-12-09 09:14:35', 'KU1072', 'U1-F1-P1-1', 16, 'Pengenalan Teknologi Informasi', 'Pengenalan Teknologi Informasi A', 2);

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
('987654321', 'Badu', 'username1', 1, 1, 1, 2016),
('987654322', 'Budi', 'username2', 1, 1, 1, 2016),
('987654323', 'Ayu', 'username3', 1, 1, 1, 2016);

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
(26, 0, '987654321', '2016-17', 1),
(27, 0, '987654321', '2016-17', 2),
(28, 0, '987654322', '2016-17', 1),
(29, 0, '987654322', '2016-17', 2),
(30, 0, '987654323', '2016-17', 1),
(31, 0, '987654323', '2016-17', 2),
(33, 0, '987654321', '2017-18', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `enabled`) VALUES
('username1', 'password1', 1),
('username2', 'password2', 1),
('username3', 'password3', 1),
('username4', 'password4', 1),
('username5', 'password5', 1);

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
('username1', 'ROLE_MAHASISWA'),
('username2', 'ROLE_MAHASISWA'),
('username3', 'ROLE_MAHASISWA'),
('username4', 'ROLE_SEKRETARIAT'),
('username5', 'ROLE_SEKRETARIAT');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
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
