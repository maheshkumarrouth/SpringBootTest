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

-- Dumping database structure for cultagent4
CREATE DATABASE IF NOT EXISTS `cultagent4` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cultagent4`;


-- Dumping structure for table cultagent4.tokenData
CREATE TABLE IF NOT EXISTS `tokenData` (
  `cardData` char(32) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `lastUpdated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cardData`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table cultagent4.tokenData: ~1 rows (approximately)
DELETE FROM `tokenData`;
/*!40000 ALTER TABLE `tokenData` DISABLE KEYS */;
INSERT INTO `tokenData` (`cardData`, `token`, `lastUpdated`) VALUES
	('mahesh', 'mahesh', '2017-05-05 11:22:34');
/*!40000 ALTER TABLE `tokenData` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
