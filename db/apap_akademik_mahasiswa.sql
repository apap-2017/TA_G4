-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 23, 2017 at 01:38 PM
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
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `npm` char(9) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `id_universitas` int(6) NOT NULL,
  `id_fakultas` int(6) NOT NULL,
  `id_prodi` int(6) NOT NULL,
  `angkatan` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `matakuliah_yg_diambil_mahasiswa`
--

CREATE TABLE `matakuliah_yg_diambil_mahasiswa` (
  `id_riwayat_perkuliahan` int(11) NOT NULL,
  `tanggal_pengisian` date NOT NULL,
  `kode_mata_kuliah` varchar(50) NOT NULL,
  `kode_kurikulum` varchar(50) NOT NULL,
  `id_kelas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `riwayat_perkuliahan`
--

CREATE TABLE `riwayat_perkuliahan` (
  `id` int(11) NOT NULL,
  `status_irs` tinyint(1) NOT NULL,
  `npm` char(9) NOT NULL,
  `tahun_ajar` varchar(50) NOT NULL,
  `term` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`npm`),
  ADD KEY `mahasiswa_username_idx` (`username`);

--
-- Indexes for table `matakuliah_yg_diambil_mahasiswa`
--
ALTER TABLE `matakuliah_yg_diambil_mahasiswa`
  ADD PRIMARY KEY (`id_kelas`),
  ADD KEY `id_riwayat_perkuliahan` (`id_riwayat_perkuliahan`);

--
-- Indexes for table `riwayat_perkuliahan`
--
ALTER TABLE `riwayat_perkuliahan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `riwayat_perkuliahan_npm_term_thn_idx` (`npm`,`term`,`tahun_ajar`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `matakuliah_yg_diambil_mahasiswa`
--
ALTER TABLE `matakuliah_yg_diambil_mahasiswa`
  ADD CONSTRAINT `matakuliah_yg_diambil_mahasiswa_ibfk_1` FOREIGN KEY (`id_riwayat_perkuliahan`) REFERENCES `riwayat_perkuliahan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `riwayat_perkuliahan`
--
ALTER TABLE `riwayat_perkuliahan`
  ADD CONSTRAINT `riwayat_perkuliahan_ibfk_1` FOREIGN KEY (`npm`) REFERENCES `mahasiswa` (`npm`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
