-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 27, 2024 at 04:18 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `liza_2210010347`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `ID` int(8) NOT NULL,
  `Nama_barang` varchar(50) NOT NULL,
  `Stok` int(10) NOT NULL,
  `Satuan` varchar(50) NOT NULL,
  `Jenis` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`ID`, `Nama_barang`, `Stok`, `Satuan`, `Jenis`) VALUES
(1, 'Susu Sapi', 100, 'Liter', 'Dairy'),
(2, 'aair', 10, '12', 'Comberan');

-- --------------------------------------------------------

--
-- Table structure for table `catatan_keuangan`
--

CREATE TABLE `catatan_keuangan` (
  `ID` int(8) NOT NULL,
  `Tanggal` date NOT NULL,
  `pengeluaran` varchar(50) NOT NULL,
  `Harga` varchar(50) NOT NULL,
  `Keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `catatan_keuangan`
--

INSERT INTO `catatan_keuangan` (`ID`, `Tanggal`, `pengeluaran`, `Harga`, `Keterangan`) VALUES
(1, '2024-06-06', '50000.0', '10000.0', 'Penjualan Susu');

-- --------------------------------------------------------

--
-- Table structure for table `jenis`
--

CREATE TABLE `jenis` (
  `ID` int(8) NOT NULL,
  `Nama_jenis` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `keluar_harian`
--

CREATE TABLE `keluar_harian` (
  `ID` int(8) NOT NULL,
  `Nama_barang` int(50) NOT NULL,
  `Tanggal` date NOT NULL,
  `Keterangan` varchar(50) NOT NULL,
  `Jumlah_keluar` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `ID` int(8) NOT NULL,
  `Nama_barang` varchar(50) NOT NULL,
  `Jumlah_masuk` varchar(50) NOT NULL,
  `Tanggal` date NOT NULL,
  `Supplier` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`ID`, `Nama_barang`, `Jumlah_masuk`, `Tanggal`, `Supplier`) VALUES
(1, 'Pakan Ternak', '50', '2024-06-06', 'Supplier A');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `ID` int(8) NOT NULL,
  `Nama_barang` varchar(50) NOT NULL,
  `Jumlah_keluar` varchar(50) NOT NULL,
  `Tanggal_keluar` date NOT NULL,
  `Nama_pembeli` varchar(50) NOT NULL,
  `Alamat` varchar(150) NOT NULL,
  `Nama_sopir` varchar(50) NOT NULL,
  `Nopol` varchar(20) NOT NULL,
  `Berat_netto` int(10) NOT NULL,
  `Rata_rata` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`ID`, `Nama_barang`, `Jumlah_keluar`, `Tanggal_keluar`, `Nama_pembeli`, `Alamat`, `Nama_sopir`, `Nopol`, `Berat_netto`, `Rata_rata`) VALUES
(1, 'Susu Sapi', '100', '2024-06-06', 'Pembeli A', 'Jl. Kebon Jeruk', 'Sopir A', 'B1234XYZ', 96, 11),
(2, 'barang1', '100000', '2001-01-01', 'Kali', 'kdtahu', 'Mamang Supir', '12a', 12, 7);

-- --------------------------------------------------------

--
-- Table structure for table `satuan`
--

CREATE TABLE `satuan` (
  `ID` int(8) NOT NULL,
  `Nama_satuan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `ID` int(8) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `No_telp` int(13) NOT NULL,
  `Alamat` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `uji`
--

CREATE TABLE `uji` (
  `nik` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `telp` varchar(15) NOT NULL,
  `alamat` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID` int(8) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `Username` varchar(50) DEFAULT NULL,
  `Email` varchar(50) NOT NULL,
  `No_telp` varchar(50) NOT NULL,
  `Role` varchar(50) NOT NULL,
  `Password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `catatan_keuangan`
--
ALTER TABLE `catatan_keuangan`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `jenis`
--
ALTER TABLE `jenis`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `keluar_harian`
--
ALTER TABLE `keluar_harian`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `satuan`
--
ALTER TABLE `satuan`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `uji`
--
ALTER TABLE `uji`
  ADD PRIMARY KEY (`nik`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `catatan_keuangan`
--
ALTER TABLE `catatan_keuangan`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pembelian`
--
ALTER TABLE `pembelian`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `ID` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
