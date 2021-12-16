-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Gép: mysql.omega:3306
-- Létrehozás ideje: 2021. Okt 30. 15:24
-- Kiszolgáló verziója: 5.7.34-log
-- PHP verzió: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `datapoints`
--
CREATE DATABASE IF NOT EXISTS `datapoints` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `datapoints`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `datapoints`
--

CREATE TABLE `datapoints` (
  `id` int(6) NOT NULL,
  `plotNumber` int(5) NOT NULL,
  `entryNumber` int(3) NOT NULL,
  `standard` tinyint(1) NOT NULL,
  `name` varchar(50) NOT NULL,
  `repNumber` int(1) NOT NULL,
  `plotWeight` double NOT NULL,
  `moisture` double NOT NULL,
  `yield` double NOT NULL,
  `year` int(5) NOT NULL,
  `locations` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `datapoints`
--
ALTER TABLE `datapoints`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `datapoints`
--
ALTER TABLE `datapoints`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
