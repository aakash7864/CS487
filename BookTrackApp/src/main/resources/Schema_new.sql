-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: booktrack
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

CREATE SCHEMA `booktrack`;
USE `booktrack`;
DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `book_number` varchar(45) NOT NULL,
  `book_name` varchar(45) DEFAULT NULL,
  `book_author` varchar(45) DEFAULT NULL,
  `book_price` varchar(45) DEFAULT NULL,
  `book_publication` varchar(45) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `ava_quantity` int(11) DEFAULT NULL,
  `alloc_quantity` int(11) DEFAULT NULL,
  `courseId` varchar(45) DEFAULT NULL,
  `requested` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`book_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('101','Software Engineeting','Omar','20.00','pub1','2017-04-16','20','20','CS487','0'),
('102','Cloud Computing','Murthi','10.00','pub2','2017-04-16','20','20','CS535','0'),
('103','Networking','Sagar','12.00','pub3','2017-04-12','20','20','CS550','0');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `courseId` varchar(45) NOT NULL,
  `courseName` varchar(45) DEFAULT NULL,
  `profId` varchar(45) DEFAULT NULL,
  `studentId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('CS487','Software Engg',NULL,NULL),('CS535','DAA',NULL,NULL),('CS550','Cloud Computing',NULL,NULL);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` varchar(100) NOT NULL,
  `passowrd` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phoneNo` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `studentId` varchar(45) DEFAULT NULL,
  `profId` varchar(45) DEFAULT NULL,
  `ParentName` varchar(45) DEFAULT NULL,
  `parentsAddress` varchar(255) DEFAULT NULL,
  `parentsContant` varchar(45) DEFAULT NULL,
  `courseId` varchar(45) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','admin','Admin','admin@admin.com','3127227560',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,''),
('teach1','teach1','Teacher','t1@gmail.com','3127227560','Miller street','Chicago','2017-04-17','Michael','Large','United States',NULL,'401',NULL,NULL,NULL,'CS487,CS535'),
('teach2','teach2','Teacher','t2@gmail.com','3127227560','Oberoi street','Chicago','2017-04-17','Noel','Siki','United States',NULL,'402',NULL,NULL,NULL,'CS550'),
('stud1','stud1','Student','s1@iit.com','3127227560','fashion street','Los Angles','2017-04-17','Aishwarya','Anand','United States','301',NULL,'John','fashion street','3127227560','CS487,CS535'),
('stud2','stud2','Student','s2@iit.com','3127227560','Carter road','Chicago','2017-04-17','Talor','Swift','United States','302',NULL,'James','Carter road','3127227560','CS550');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_book`
--

DROP TABLE IF EXISTS `user_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_book` (
  `studentId` varchar(45) NOT NULL,
  `bookId` varchar(45) NOT NULL,
  `allocationDate` varchar(45) DEFAULT NULL,
  `returnDate` varchar(45) DEFAULT NULL,
  `requested` varchar(45) DEFAULT NULL,
  `requestedDate` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_book`
--

LOCK TABLES `user_book` WRITE;
/*!40000 ALTER TABLE `user_book` DISABLE KEYS */;
INSERT INTO `user_book` VALUES ('ash','101','Tue Apr 18 08:43:29 CDT 2017','Tue Apr 25 08:43:29 CDT 2017','0',NULL),
('ash','102',NULL,NULL,'1','Tue Apr 18 02:29:36 CDT 2017');
/*!40000 ALTER TABLE `user_book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-18  9:04:38
