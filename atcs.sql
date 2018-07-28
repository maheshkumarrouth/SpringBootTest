-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.47-0ubuntu0.14.04.1 - (Ubuntu)
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             9.0.0.4865
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for ATCS
CREATE DATABASE IF NOT EXISTS `ATCS` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ATCS`;


-- Dumping structure for table ATCS.ACSize
CREATE TABLE IF NOT EXISTS `ACSize` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(50) NOT NULL,
  `lastupdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table ATCS.ACSize: ~0 rows (approximately)
DELETE FROM `ACSize`;
/*!40000 ALTER TABLE `ACSize` DISABLE KEYS */;
INSERT INTO `ACSize` (`id`, `size`, `lastupdate`) VALUES
	(1, 'large', '2018-07-28 19:03:57'),
	(2, 'small', '2018-07-28 19:04:04');
/*!40000 ALTER TABLE `ACSize` ENABLE KEYS */;


-- Dumping structure for table ATCS.Ac_InComing_OutGoing_History
CREATE TABLE IF NOT EXISTS `Ac_InComing_OutGoing_History` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acId` varchar(50) NOT NULL,
  `size` int(11) NOT NULL,
  `priority` int(11) NOT NULL,
  `checkIn` datetime NOT NULL,
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `acId` (`acId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ATCS.Ac_InComing_OutGoing_History: ~0 rows (approximately)
DELETE FROM `Ac_InComing_OutGoing_History`;
/*!40000 ALTER TABLE `Ac_InComing_OutGoing_History` DISABLE KEYS */;
/*!40000 ALTER TABLE `Ac_InComing_OutGoing_History` ENABLE KEYS */;


-- Dumping structure for table ATCS.Aircraft_X_CheckIn
CREATE TABLE IF NOT EXISTS `Aircraft_X_CheckIn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acId` varchar(50) NOT NULL,
  `size` int(11) NOT NULL,
  `priority` int(11) NOT NULL,
  `checkIn` datetime NOT NULL,
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `acId` (`acId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table ATCS.Aircraft_X_CheckIn: ~0 rows (approximately)
DELETE FROM `Aircraft_X_CheckIn`;
/*!40000 ALTER TABLE `Aircraft_X_CheckIn` DISABLE KEYS */;
INSERT INTO `Aircraft_X_CheckIn` (`id`, `acId`, `size`, `priority`, `checkIn`, `lastUpdate`) VALUES
	(1, 'x', 1, 1, '2018-07-28 19:04:22', '2018-07-28 19:04:23'),
	(2, 'y', 1, 1, '2018-07-28 19:18:44', '2018-07-28 19:18:45');
/*!40000 ALTER TABLE `Aircraft_X_CheckIn` ENABLE KEYS */;


-- Dumping structure for table ATCS.PriorityTypes
CREATE TABLE IF NOT EXISTS `PriorityTypes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table ATCS.PriorityTypes: ~0 rows (approximately)
DELETE FROM `PriorityTypes`;
/*!40000 ALTER TABLE `PriorityTypes` DISABLE KEYS */;
INSERT INTO `PriorityTypes` (`id`, `type`, `lastUpdate`) VALUES
	(1, 'Emergency', '2018-07-28 19:02:19'),
	(2, 'VIP', '2018-07-28 19:02:33'),
	(3, 'Passenger', '2018-07-28 19:03:05');
/*!40000 ALTER TABLE `PriorityTypes` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
