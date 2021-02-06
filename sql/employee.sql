CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES
	(1,'Emily','John','emily@example.com'),
	(2,'Fen-Yu','Huang','fenyu@example.com'),
	(3,'Jie-Hua','Wang','jiehua@example.com'),
	(4,'Peng','Lin','peng@example.com'),
	(5,'Jack','Sparrow','jack@example.com');
