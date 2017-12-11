-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: hmarka
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (1,'Ukraine'),(2,'Poland'),(3,'Gegmany'),(4,'Slovakia'),(5,'Hungary'),(6,'Romania');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'v1','Vasya'),(2,'qqq','Timur'),(3,'vova','Vova'),(4,'sv','Sveta'),(5,'alex','Alexander');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'qqq',7,1234567,'2017-12-08 22:00:00'),(2,'qqq',1,2,'2017-12-08 22:00:00'),(3,'sv',12,5,'2017-12-08 22:00:00'),(4,'qqq',3,25,'2017-12-08 22:00:00'),(5,'alex',4,7,'2017-12-08 22:00:00'),(6,'alex',19,777,'2017-11-30 22:00:00'),(7,'alex',10,33333,'2017-11-05 22:00:00'),(8,'qqq',2,9999,'2017-11-18 22:00:00'),(9,'qqq',20,1,'2017-12-10 22:00:00'),(10,'vova',10,123456789,'2017-11-30 22:00:00'),(11,'alex',6,1122,'2017-11-30 22:00:00'),(12,'qqq',1,1,'2017-12-08 22:00:00'),(13,'vova',2,22,'2017-11-30 22:00:00'),(14,'vova',3,33,'2017-12-10 22:00:00'),(15,'alex',5,55,'2017-12-10 22:00:00'),(16,'v1',7,77,'2017-11-05 22:00:00'),(17,'v1',3,13,'2017-12-10 22:00:00'),(18,'qqq',4,24,'2017-12-10 22:00:00'),(19,'alex',10,510,'2017-12-10 22:00:00'),(20,'vova',20,320,'2017-12-10 22:00:00'),(21,'qqq',5,25,'2017-12-11 22:00:00');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `regions`
--

LOCK TABLES `regions` WRITE;
/*!40000 ALTER TABLE `regions` DISABLE KEYS */;
INSERT INTO `regions` VALUES (1,'Kyiv',1),(2,'Bucha',1),(3,'Brovary',1),(4,'Borispol',1),(5,'Zhytomyr',1),(6,'Warszawa',2),(7,'Lublin',2),(8,'Kraków',2),(9,'Berlin',3),(10,'Nürnberg',3),(11,'Leipzig',3),(12,'Košice',4),(13,'Bratislava',4),(14,'Prešov',4),(15,'Budapest',5),(16,'Szolnok',5),(17,'Székesfehérvár',5),(18,'Bucureşti',6),(19,'Cluj-Napoca',6),(20,'Braşov',6);
/*!40000 ALTER TABLE `regions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-11  7:29:25
