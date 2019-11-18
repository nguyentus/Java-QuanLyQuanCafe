-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: localhost    Database: CoffeeProgramManager
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `idAccount` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `displayName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`idAccount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('admin','1','Nguyen Tu',1),('user','1','Luu Minh',0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `idBill` int(11) NOT NULL,
  `dateCheckIn` datetime NOT NULL,
  `dateCheckOut` datetime NOT NULL,
  `statusBill` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `discountBill` int(11) NOT NULL,
  `totalPrices` decimal(12,3) NOT NULL,
  `idOrderTable` int(11) NOT NULL,
  PRIMARY KEY (`idBill`),
  KEY `idOrderTable_idx` (`idOrderTable`),
  CONSTRAINT `idOrderTable` FOREIGN KEY (`idOrderTable`) REFERENCES `ordertable` (`idOrderTable`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billinfo`
--

DROP TABLE IF EXISTS `billinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billinfo` (
  `idBillInfo` int(11) NOT NULL,
  `idBill` int(11) NOT NULL,
  `idDrink` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`idBillInfo`),
  KEY `idBill_idx` (`idBill`),
  KEY `idDrink_idx` (`idDrink`),
  CONSTRAINT `idBill` FOREIGN KEY (`idBill`) REFERENCES `bill` (`idBill`),
  CONSTRAINT `idDrink` FOREIGN KEY (`idDrink`) REFERENCES `drink` (`idDrink`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billinfo`
--

LOCK TABLES `billinfo` WRITE;
/*!40000 ALTER TABLE `billinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `billinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drink`
--

DROP TABLE IF EXISTS `drink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drink` (
  `idDrink` int(11) NOT NULL,
  `nameDrink` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `priceDrink` decimal(9,3) NOT NULL,
  `idDrinkCategory` int(11) NOT NULL,
  PRIMARY KEY (`idDrink`),
  KEY `idDrinkCategory_idx` (`idDrinkCategory`),
  CONSTRAINT `idDrinkCategory` FOREIGN KEY (`idDrinkCategory`) REFERENCES `drinkcategory` (`idDrinkCategory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drink`
--

LOCK TABLES `drink` WRITE;
/*!40000 ALTER TABLE `drink` DISABLE KEYS */;
INSERT INTO `drink` VALUES (1,'Coffee with milk',68000.000,1),(2,'Coffee mocha',70000.000,1),(3,'Cold brew',67000.000,1),(4,'Lemon tea',60000.000,2),(5,'Green tea',72000.000,2),(6,'Matcha latte',77000.000,2),(7,'Strawberry',75000.000,3),(8,'Banana',57000.000,3),(9,'Kiwi',60000.000,3);
/*!40000 ALTER TABLE `drink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drinkcategory`
--

DROP TABLE IF EXISTS `drinkcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drinkcategory` (
  `idDrinkCategory` int(11) NOT NULL,
  `nameDrinkCategory` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idDrinkCategory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drinkcategory`
--

LOCK TABLES `drinkcategory` WRITE;
/*!40000 ALTER TABLE `drinkcategory` DISABLE KEYS */;
INSERT INTO `drinkcategory` VALUES (1,'Coffee'),(2,'Tea'),(3,'Smoothie'),(4,'Milk Tea');
/*!40000 ALTER TABLE `drinkcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordertable`
--

DROP TABLE IF EXISTS `ordertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordertable` (
  `idOrderTable` int(11) NOT NULL,
  `nameOrderTable` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `statusOrderTable` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`idOrderTable`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordertable`
--

LOCK TABLES `ordertable` WRITE;
/*!40000 ALTER TABLE `ordertable` DISABLE KEYS */;
INSERT INTO `ordertable` VALUES (1,'Table 1','emty'),(2,'Table 2','emty'),(3,'Table 3','emty'),(4,'Table 4','emty'),(5,'Table 5','emty'),(6,'Table 6','emty'),(7,'Table 7','emty'),(8,'Table 8','emty'),(9,'Table 9','emty'),(10,'Table 10','emty');
/*!40000 ALTER TABLE `ordertable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'CoffeeProgramManager'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-18  9:01:33
