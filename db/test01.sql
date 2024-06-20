-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.4.0 - MySQL Community Server - GPL
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 test01 的数据库结构
CREATE DATABASE IF NOT EXISTS `test01` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `test01`;

-- 导出  表 test01.log 结构
DROP TABLE IF EXISTS `log`;
CREATE TABLE IF NOT EXISTS `log` (
  `time` timestamp NOT NULL,
  `desc` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  test01.log 的数据：~25 rows (大约)
DELETE FROM `log`;
INSERT INTO `log` (`time`, `desc`) VALUES
	('2024-06-20 08:25:18', 'addUser'),
	('2024-06-20 08:26:05', 'getAllUsers'),
	('2024-06-20 08:26:13', 'deleteUser'),
	('2024-06-20 08:26:15', 'deleteUser'),
	('2024-06-20 08:26:17', 'deleteUser'),
	('2024-06-20 08:27:30', 'deleteUser'),
	('2024-06-20 08:27:31', 'deleteUser'),
	('2024-06-20 08:28:10', 'deleteUser'),
	('2024-06-20 08:28:11', 'deleteUser'),
	('2024-06-20 08:28:19', 'deleteUser'),
	('2024-06-20 08:28:45', 'getAllUsers'),
	('2024-06-20 08:28:46', 'deleteUser'),
	('2024-06-20 08:28:47', 'getAllUsers'),
	('2024-06-20 08:28:49', 'deleteUser'),
	('2024-06-20 08:28:49', 'getAllUsers'),
	('2024-06-20 08:28:50', 'deleteUser'),
	('2024-06-20 08:28:50', 'getAllUsers'),
	('2024-06-20 08:28:50', 'deleteUser'),
	('2024-06-20 08:28:50', 'getAllUsers'),
	('2024-06-20 08:28:51', 'deleteUser'),
	('2024-06-20 08:28:51', 'getAllUsers'),
	('2024-06-20 08:28:51', 'deleteUser'),
	('2024-06-20 08:28:51', 'getAllUsers'),
	('2024-06-20 08:31:13', 'getAllUsers'),
	('2024-06-20 08:31:14', 'getAllUsers'),
	('2024-06-20 08:59:22', 'deleteUser'),
	('2024-06-20 08:59:23', 'deleteUser');

-- 导出  表 test01.skill 结构
DROP TABLE IF EXISTS `skill`;
CREATE TABLE IF NOT EXISTS `skill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `uid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `skill_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  test01.skill 的数据：~16 rows (大约)
DELETE FROM `skill`;
INSERT INTO `skill` (`id`, `name`, `uid`) VALUES
	(49, 'skill A', 24),
	(50, 'skill B', 24),
	(51, 'skill A', 25),
	(52, 'skill B', 25),
	(53, 'skill A', 26),
	(54, 'skill B', 26),
	(55, 'skill A', 27),
	(56, 'skill B', 27),
	(57, 'skill B', 28),
	(58, 'skill A', 28),
	(59, 'skill B', 29),
	(60, 'skill A', 29),
	(61, 'skill B', 30),
	(62, 'skill A', 30),
	(65, 'skill A', 31),
	(66, 'skill B', 31);

-- 导出  表 test01.user 结构
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 正在导出表  test01.user 的数据：~8 rows (大约)
DELETE FROM `user`;
INSERT INTO `user` (`id`, `name`, `sex`) VALUES
	(24, 'ccc', 'girl'),
	(25, 'ccc', 'girl'),
	(26, 'ccc', 'girl'),
	(27, 'ccc', 'girl'),
	(28, 'ccc', 'girl'),
	(29, 'ccc', 'girl'),
	(30, 'ccc', 'girl'),
	(31, 'fff', 'girl');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
