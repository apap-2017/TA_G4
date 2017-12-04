-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 04 Des 2017 pada 14.33
-- Versi Server: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Struktur dari tabel `kelas`
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
-- Dumping data untuk tabel `kelas`
--

INSERT INTO `kelas` (`id_riwayat_perkuliahan`, `tanggal_pengisian`, `kode_mata_kuliah`, `kode_kurikulum`, `id_kelas`, `nama_mata_kuliah`, `nama_kelas`, `sks`) VALUES
(1, '2017-12-03 14:35:17', 'SI1', '2016.2017', 1, 'Bisnis Aja', 'BA1', 3),
(2, '2017-12-03 14:35:17', 'SI1', '2016.2017', 1, 'Bisnis Aja', 'BA1', 3),
(4, '2017-12-03 14:35:17', 'SI1', '2016.2017', 1, 'Bisnis Aja', 'BA1', 3),
(6, '2017-12-03 14:35:17', 'SI1', '2016.2017', 1, 'Bisnis Aja', 'BA1', 3),
(9, '2017-12-03 14:35:17', 'SI1', '2016.2017', 1, 'Bisnis Aja', 'BA1', 3),
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
(10, '2017-12-03 14:35:17', 'SI7', '2016.2017', 7, 'Coding Bgt', 'CB1', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `mahasiswa`
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
-- Dumping data untuk tabel `mahasiswa`
--

INSERT INTO `mahasiswa` (`npm`, `nama`, `username`, `id_universitas`, `id_fakultas`, `id_prodi`, `angkatan`) VALUES
('123456781', 'nama1', 'username1', 1, 1, 1, 2015),
('123456782', 'nama2', 'username2', 1, 1, 1, 2015),
('123456783', 'nama3', 'username3', 1, 1, 1, 2016),
('123456784', 'nama4', 'username4', 1, 1, 1, 2018),
('123456785', 'nama5', 'username5', 1, 1, 1, 2018),
('123456786', 'nama6', 'username6', 1, 1, 1, 2018),
('123456787', 'nama7', 'username7', 1, 1, 1, 2018);

-- --------------------------------------------------------

--
-- Struktur dari tabel `riwayat_perkuliahan`
--

CREATE TABLE `riwayat_perkuliahan` (
  `id` int(11) NOT NULL,
  `status_irs` tinyint(1) NOT NULL DEFAULT '0',
  `npm` char(9) NOT NULL,
  `tahun_ajar` varchar(50) NOT NULL,
  `term` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `riwayat_perkuliahan`
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
(10, 0, '123456783', '2016-17', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(4) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`username`, `password`, `enabled`) VALUES
('username1', 'password1', 1),
('username10', 'password10', 1),
('username2', 'password2', 1),
('username3', 'password3', 1),
('username4', 'password4', 1),
('username5', 'password5', 1),
('username6', 'password6', 1),
('username7', 'password7', 1),
('username8', 'password8', 1),
('username9', 'password9', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user_role`
--

CREATE TABLE `user_role` (
  `username` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user_role`
--

INSERT INTO `user_role` (`username`, `role`) VALUES
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `kelas`
--
ALTER TABLE `kelas`
  ADD CONSTRAINT `kelas_ibfk_1` FOREIGN KEY (`id_riwayat_perkuliahan`) REFERENCES `riwayat_perkuliahan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD CONSTRAINT `mahasiswa_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `riwayat_perkuliahan`
--
ALTER TABLE `riwayat_perkuliahan`
  ADD CONSTRAINT `riwayat_perkuliahan_ibfk_1` FOREIGN KEY (`npm`) REFERENCES `mahasiswa` (`npm`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
