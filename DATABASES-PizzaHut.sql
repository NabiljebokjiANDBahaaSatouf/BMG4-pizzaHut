-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.12-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table pizzahot.bank
CREATE TABLE IF NOT EXISTS `bank` (
  `bank_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `payments_id` int(11) unsigned NOT NULL,
  `amount` int(11) NOT NULL,
  `credit_card_type` varchar(50) NOT NULL,
  PRIMARY KEY (`bank_id`),
  KEY `FK_bank_payments` (`payments_id`),
  CONSTRAINT `FK_bank_payments` FOREIGN KEY (`payments_id`) REFERENCES `payments` (`payments_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzahot.bank: ~3 rows (approximately)
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
INSERT INTO `bank` (`bank_id`, `payments_id`, `amount`, `credit_card_type`) VALUES
	(1, 1, 20, 'ziraat'),
	(2, 4, 30, 'ziraat'),
	(3, 5, 23, 'ziraat');
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;

-- Dumping structure for table pizzahot.cash
CREATE TABLE IF NOT EXISTS `cash` (
  `cash_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `payments_id` int(11) unsigned NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`cash_id`),
  KEY `FK_cash_payments` (`payments_id`),
  CONSTRAINT `FK_cash_payments` FOREIGN KEY (`payments_id`) REFERENCES `payments` (`payments_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzahot.cash: ~3 rows (approximately)
/*!40000 ALTER TABLE `cash` DISABLE KEYS */;
INSERT INTO `cash` (`cash_id`, `payments_id`, `amount`) VALUES
	(1, 2, 22),
	(2, 3, 30),
	(3, 6, 25);
/*!40000 ALTER TABLE `cash` ENABLE KEYS */;

-- Dumping structure for table pizzahot.contact
CREATE TABLE IF NOT EXISTS `contact` (
  `contact_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `restaurant_id` int(11) unsigned DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` int(11) NOT NULL,
  PRIMARY KEY (`contact_id`),
  UNIQUE KEY `restaurant_id` (`restaurant_id`),
  CONSTRAINT `restaurant_id` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`restaurant_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzahot.contact: ~3 rows (approximately)
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` (`contact_id`, `restaurant_id`, `name`, `address`, `phone`) VALUES
	(1, 1, 'nabil', 'nabil mahalesi', 58520),
	(2, 2, 'yusuf', 'yusuf mahalesi', 89745622),
	(3, 3, 'samir', 'samir mahalesi', 98765431);
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;

-- Dumping structure for table pizzahot.customer_home
CREATE TABLE IF NOT EXISTS `customer_home` (
  `customer_home_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Restaurant_id` int(11) unsigned NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `phone` int(11) NOT NULL,
  PRIMARY KEY (`customer_home_id`),
  KEY `FK_customer_home_restaurant` (`Restaurant_id`),
  CONSTRAINT `FK_customer_home_restaurant` FOREIGN KEY (`Restaurant_id`) REFERENCES `restaurant` (`restaurant_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23223324 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzahot.customer_home: ~3 rows (approximately)
/*!40000 ALTER TABLE `customer_home` DISABLE KEYS */;
INSERT INTO `customer_home` (`customer_home_id`, `Restaurant_id`, `Name`, `Address`, `Email`, `phone`) VALUES
	(1, 1, 'joud', 'joud mahalesi', 'joud.com', 12345),
	(2, 2, 'wasim', 'wasim mahalesi', 'wasim.com', 852741),
	(3, 3, 'dania', 'dania mahalesi', 'dania.com', 3949494);
/*!40000 ALTER TABLE `customer_home` ENABLE KEYS */;

-- Dumping structure for table pizzahot.customer_table
CREATE TABLE IF NOT EXISTS `customer_table` (
  `Customer_table_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Restaurant_id` int(10) unsigned NOT NULL,
  `Name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Customer_table_id`),
  KEY `FK_customer_table_restaurant` (`Restaurant_id`),
  CONSTRAINT `FK_customer_table_restaurant` FOREIGN KEY (`Restaurant_id`) REFERENCES `restaurant` (`restaurant_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzahot.customer_table: ~3 rows (approximately)
/*!40000 ALTER TABLE `customer_table` DISABLE KEYS */;
INSERT INTO `customer_table` (`Customer_table_id`, `Restaurant_id`, `Name`) VALUES
	(1, 1, 'nabil'),
	(2, 2, 'sara'),
	(3, 3, 'dania');
/*!40000 ALTER TABLE `customer_table` ENABLE KEYS */;

-- Dumping structure for table pizzahot.delivery
CREATE TABLE IF NOT EXISTS `delivery` (
  `delivery_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `orderr_id` int(11) unsigned NOT NULL,
  `delivery_pickup` varchar(50) NOT NULL DEFAULT '',
  `time_deliverd` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`delivery_id`),
  KEY `FK_delivery_orderr` (`orderr_id`),
  CONSTRAINT `FK_delivery_orderr` FOREIGN KEY (`orderr_id`) REFERENCES `orderr` (`orderr_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzahot.delivery: ~2 rows (approximately)
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
INSERT INTO `delivery` (`delivery_id`, `orderr_id`, `delivery_pickup`, `time_deliverd`) VALUES
	(1, 1, '2', '3'),
	(2, 2, '6', '7');
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;

-- Dumping structure for table pizzahot.deliveryorder_to_homeaddress
CREATE TABLE IF NOT EXISTS `deliveryorder_to_homeaddress` (
  `delivery_id` int(11) unsigned NOT NULL,
  `to_home_id` int(11) unsigned NOT NULL,
  UNIQUE KEY `customer_home_id` (`delivery_id`),
  UNIQUE KEY `to_home_id` (`to_home_id`),
  CONSTRAINT `FK_deliveryOrder_to_homeAddress_to_home` FOREIGN KEY (`to_home_id`) REFERENCES `to_home` (`to_home_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_delivery_and_tohome_customer_home` FOREIGN KEY (`delivery_id`) REFERENCES `customer_home` (`customer_home_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT=' ';

-- Dumping data for table pizzahot.deliveryorder_to_homeaddress: ~3 rows (approximately)
/*!40000 ALTER TABLE `deliveryorder_to_homeaddress` DISABLE KEYS */;
INSERT INTO `deliveryorder_to_homeaddress` (`delivery_id`, `to_home_id`) VALUES
	(1, 1),
	(2, 2),
	(3, 3);
/*!40000 ALTER TABLE `deliveryorder_to_homeaddress` ENABLE KEYS */;

-- Dumping structure for table pizzahot.delivery_and_customerhome
CREATE TABLE IF NOT EXISTS `delivery_and_customerhome` (
  `customer_home_id` int(11) unsigned NOT NULL,
  `delivery_id` int(11) unsigned NOT NULL,
  UNIQUE KEY `customer_home_id` (`customer_home_id`),
  UNIQUE KEY `delivery_id` (`delivery_id`),
  CONSTRAINT `FK_delivery_and_customerhome_customer_home` FOREIGN KEY (`customer_home_id`) REFERENCES `customer_home` (`customer_home_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_delivery_and_customerhome_delivery` FOREIGN KEY (`delivery_id`) REFERENCES `delivery` (`delivery_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table pizzahot.delivery_and_customerhome: ~2 rows (approximately)
/*!40000 ALTER TABLE `delivery_and_customerhome` DISABLE KEYS */;
INSERT INTO `delivery_and_customerhome` (`customer_home_id`, `delivery_id`) VALUES
	(1, 1),
	(2, 2);
/*!40000 ALTER TABLE `delivery_and_customerhome` ENABLE KEYS */;

-- Dumping structure for table pizzahot.orderr
CREATE TABLE IF NOT EXISTS `orderr` (
  `orderr_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `restaurant_id` int(11) unsigned NOT NULL,
  `pizza_kind` varchar(50) NOT NULL,
  `pizza_size` varchar(50) NOT NULL,
  `pizza_price` int(11) NOT NULL,
  `drink_kind` varchar(50) NOT NULL,
  `drink_size` varchar(50) NOT NULL,
  `drink_price` int(11) NOT NULL,
  PRIMARY KEY (`orderr_id`),
  KEY `FK_orderr_restaurant` (`restaurant_id`),
  CONSTRAINT `FK_orderr_restaurant` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`restaurant_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzahot.orderr: ~3 rows (approximately)
/*!40000 ALTER TABLE `orderr` DISABLE KEYS */;
INSERT INTO `orderr` (`orderr_id`, `restaurant_id`, `pizza_kind`, `pizza_size`, `pizza_price`, `drink_kind`, `drink_size`, `drink_price`) VALUES
	(1, 1, 'margarita', 'larg', 15, 'sprite', 'big', 4),
	(2, 2, 'cheese', 'normal', 7, 'pepsi', 'small', 2),
	(3, 3, 'cheese', 'normal', 7, 'pepsi', 'small', 2);
/*!40000 ALTER TABLE `orderr` ENABLE KEYS */;

-- Dumping structure for table pizzahot.payments
CREATE TABLE IF NOT EXISTS `payments` (
  `payments_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `to_home_id` int(11) unsigned DEFAULT NULL,
  `table_id` int(11) unsigned DEFAULT NULL,
  `bankOrCash` varchar(50) NOT NULL,
  PRIMARY KEY (`payments_id`),
  KEY `FK_payments_to_home` (`to_home_id`),
  KEY `FK_payments_table_order` (`table_id`),
  CONSTRAINT `FK_payments_table_order` FOREIGN KEY (`table_id`) REFERENCES `table_order` (`table_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_payments_to_home` FOREIGN KEY (`to_home_id`) REFERENCES `to_home` (`to_home_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzahot.payments: ~6 rows (approximately)
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` (`payments_id`, `to_home_id`, `table_id`, `bankOrCash`) VALUES
	(1, 1, NULL, 'bank'),
	(2, 2, NULL, 'cash'),
	(3, 3, NULL, 'cash'),
	(4, NULL, 1, 'bank'),
	(5, NULL, 2, 'bank'),
	(6, NULL, 3, 'cash');
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;

-- Dumping structure for table pizzahot.restaurant
CREATE TABLE IF NOT EXISTS `restaurant` (
  `restaurant_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `branch` varchar(50) NOT NULL,
  PRIMARY KEY (`restaurant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzahot.restaurant: ~3 rows (approximately)
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` (`restaurant_id`, `branch`) VALUES
	(1, 'mezitli'),
	(2, 'istanbul'),
	(3, 'malatya');
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;

-- Dumping structure for table pizzahot.tablecustomer_to_tableorder
CREATE TABLE IF NOT EXISTS `tablecustomer_to_tableorder` (
  `table_id` int(11) unsigned NOT NULL,
  `customer_table_id` int(11) unsigned NOT NULL,
  KEY `FK_TableCustomer_to_TableOrder_customer_table` (`customer_table_id`),
  KEY `FK_TableCustomer_to_TableOrder_table_order` (`table_id`),
  CONSTRAINT `FK_TableCustomer_to_TableOrder_customer_table` FOREIGN KEY (`customer_table_id`) REFERENCES `customer_table` (`Customer_table_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TableCustomer_to_TableOrder_table_order` FOREIGN KEY (`table_id`) REFERENCES `table_order` (`table_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table pizzahot.tablecustomer_to_tableorder: ~2 rows (approximately)
/*!40000 ALTER TABLE `tablecustomer_to_tableorder` DISABLE KEYS */;
INSERT INTO `tablecustomer_to_tableorder` (`table_id`, `customer_table_id`) VALUES
	(1, 1),
	(2, 2);
/*!40000 ALTER TABLE `tablecustomer_to_tableorder` ENABLE KEYS */;

-- Dumping structure for table pizzahot.table_order
CREATE TABLE IF NOT EXISTS `table_order` (
  `table_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `orderr_id` int(11) unsigned NOT NULL,
  `table_number` int(11) NOT NULL,
  PRIMARY KEY (`table_id`),
  KEY `FK_table_order_orderr` (`orderr_id`),
  CONSTRAINT `FK_table_order_orderr` FOREIGN KEY (`orderr_id`) REFERENCES `orderr` (`orderr_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzahot.table_order: ~3 rows (approximately)
/*!40000 ALTER TABLE `table_order` DISABLE KEYS */;
INSERT INTO `table_order` (`table_id`, `orderr_id`, `table_number`) VALUES
	(1, 1, 1),
	(2, 2, 2),
	(3, 3, 33);
/*!40000 ALTER TABLE `table_order` ENABLE KEYS */;

-- Dumping structure for table pizzahot.to_home
CREATE TABLE IF NOT EXISTS `to_home` (
  `to_home_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` int(11) NOT NULL,
  PRIMARY KEY (`to_home_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table pizzahot.to_home: ~3 rows (approximately)
/*!40000 ALTER TABLE `to_home` DISABLE KEYS */;
INSERT INTO `to_home` (`to_home_id`, `name`, `address`, `email`, `phone`) VALUES
	(1, 'joud', 'joud mahalesi', 'joud.com', 741852963),
	(2, 'wasim', 'wasim mahalesi', 'wasim.com', 65432197),
	(3, 'dania', 'daina mahalesi', 'dania .com', 9865354);
/*!40000 ALTER TABLE `to_home` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
