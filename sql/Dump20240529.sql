-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: smatrentalpro
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `applicants`
--

DROP TABLE IF EXISTS `applicants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applicants` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `deleted` bit(1) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` int DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `id_number` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `ssn` varchar(255) DEFAULT NULL,
  `property_id` bigint DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKchdcx802o2tyx6iecnqocrb1j` (`property_id`),
  CONSTRAINT `FKchdcx802o2tyx6iecnqocrb1j` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicants`
--

LOCK TABLES `applicants` WRITE;
/*!40000 ALTER TABLE `applicants` DISABLE KEYS */;
INSERT INTO `applicants` VALUES (1,_binary '\0',NULL,0,NULL,0,'10/05/12','','63-2107275Z42','0786258832','87656',1,'Panashe','Mugomba','Software developer'),(2,_binary '\0',NULL,0,NULL,0,'10/05/12',NULL,'63-2107275Z42','0786258832','87656',1,'Panashe','Mugomba','Software developer'),(3,_binary '\0',NULL,0,NULL,0,'10/05/12',NULL,'63-2107275Z42','0786258832','87656',1,'Panashe','Mugomba','Software developer');
/*!40000 ALTER TABLE `applicants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facilities`
--

DROP TABLE IF EXISTS `facilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facilities` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bathrooms` int NOT NULL,
  `bedrooms` int NOT NULL,
  `parking` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilities`
--

LOCK TABLES `facilities` WRITE;
/*!40000 ALTER TABLE `facilities` DISABLE KEYS */;
INSERT INTO `facilities` VALUES (1,1,1,1),(2,1,1,1);
/*!40000 ALTER TABLE `facilities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `property` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `description` longtext,
  `image` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `facilities_id` bigint DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` int DEFAULT NULL,
  `property_type` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3y6nbw1t8m4t2lgo7sqg5oior` (`facilities_id`),
  CONSTRAINT `FK3y6nbw1t8m4t2lgo7sqg5oior` FOREIGN KEY (`facilities_id`) REFERENCES `facilities` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (1,'Greendale, Harare East','Greendale, Harare East','Zimbabwe','Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatibus, sequi. Adipisci, eligendi. Quas qui, optio exercitationem in facilis nam eveniet dicta, ex tenetur laudantium ducimus dolorem ullam saepe excepturi magni molestiae quidem dolore quaerat ipsum. Deserunt eos, debitis blanditiis, voluptatibus laudantium minus ea impedit deleniti, incidunt officiis alias dignissimos ipsum nam dolor? Atque laudantium odit corporis pariatur, exercitationem aperiam eius earum at. Necessitatibus alias tenetur numquam provident dolores voluptatum odit laboriosam labore quos reiciendis eos expedita saepe, deleniti commodi aut in minus at ea beatae quasi eligendi nobis esse sint. Iure, accusamus. Labore harum rerum laboriosam laborum dolorem quam? Quam quidem repellat sint soluta labore omnis. Aliquam ex pariatur sapiente reiciendis consequatur voluptatum atque doloribus quis, ratione, cum dolores esse impedit delectus voluptate hic totam magni excepturi iusto cupiditate a fuga! Incidunt, accusantium alias. Aliquid asperiores hic quisquam alias porro eligendi sed adipisci natus illo iusto libero, minus deserunt beatae inventore numquam ab necessitatibus repellat voluptates, iure, maxime impedit. Ipsa totam voluptatum corporis, nesciunt error repellat provident minus iusto quam laudantium, veritatis quo alias fuga! Aliquid nisi nemo illo ut voluptate necessitatibus culpa dolorum vero reprehenderit accusamus earum neque tempora eligendi, alias fuga, tenetur incidunt commodi! Ea ipsam ducimus illum','image',2500,'3 Bedroom Townhouse/Clutser to rent Greendale',1,_binary '\0','2024-05-28 19:46:06.641448',1,NULL,0,'House','Ref: PB-GAT177989','USD'),(2,'Borrowdale,Harare North, Harare','Borrowdale,Harare North, Harare','Zimbabwe','Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatibus, sequi. Adipisci, eligendi. Quas qui, optio exercitationem in facilis nam eveniet dicta, ex tenetur laudantium ducimus dolorem ullam saepe excepturi magni molestiae quidem dolore quaerat ipsum. Deserunt eos, debitis blanditiis, voluptatibus laudantium minus ea impedit deleniti, incidunt officiis alias dignissimos ipsum nam dolor? Atque laudantium odit corporis pariatur, exercitationem aperiam eius earum at. Necessitatibus alias tenetur numquam provident dolores voluptatum odit laboriosam labore quos reiciendis eos expedita saepe, deleniti commodi aut in minus at ea beatae quasi eligendi nobis esse sint. Iure, accusamus. Labore harum rerum laboriosam laborum dolorem quam? Quam quidem repellat sint soluta labore omnis. Aliquam ex pariatur sapiente reiciendis consequatur voluptatum atque doloribus quis, ratione, cum dolores esse impedit delectus voluptate hic totam magni excepturi iusto cupiditate a fuga! Incidunt, accusantium alias. Aliquid asperiores hic quisquam alias porro eligendi sed adipisci natus illo iusto libero, minus deserunt beatae inventore numquam ab necessitatibus repellat voluptates, iure, maxime impedit. Ipsa totam voluptatum corporis, nesciunt error repellat provident minus iusto quam laudantium, veritatis quo alias fuga! Aliquid nisi nemo illo ut voluptate necessitatibus culpa dolorum vero reprehenderit accusamus earum neque tempora eligendi, alias fuga, tenetur incidunt commodi! Ea ipsam ducimus illum','image',3489,'Full House to rent Borrowdale',2,_binary '\0','2024-05-28 19:54:00.728585',1,NULL,0,'House','Ref: PB-GAT177989','ZIG');
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `role_description` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'USER','USER'),(2,'ADMIN','ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `deleted` bit(1) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` int DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(60) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,_binary '\0',NULL,0,NULL,0,'pmugomba@cimas.co.zw',_binary '','$2a$10$0gzwVyUUrAlNSQSRdpXD7uYuFfwMMiMxmtp37B3PxKZqdK15uoKtm','Panashe','Panashe','Mugomba'),(2,_binary '\0',NULL,0,NULL,0,'panashemugomba99@gmail.com',_binary '','$2a$10$0gzwVyUUrAlNSQSRdpXD7uYuFfwMMiMxmtp37B3PxKZqdK15uoKtm','Obrien','Panashe','Mugomba'),(3,_binary '\0',NULL,0,NULL,0,'panashemugomba99@gmail.com',_binary '','$2a$10$RmnT8GvMjXtlE2ErlfsOJOnWHSRkQcEEPVeod2kHNCGA.rFZC77z6','Ngoni','Panashe Obrien Mugomba','Mugomba');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (3,1),(1,2),(2,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verification_token`
--

DROP TABLE IF EXISTS `verification_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `verification_token` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `expiration_time` datetime(6) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_USER_VERIFY_TOKEN` (`user_id`),
  CONSTRAINT `FK_USER_VERIFY_TOKEN` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verification_token`
--

LOCK TABLES `verification_token` WRITE;
/*!40000 ALTER TABLE `verification_token` DISABLE KEYS */;
INSERT INTO `verification_token` VALUES (1,'2024-05-28 23:49:33.540000','06d3102a-0f03-4f20-ae7d-d81b3f2faac6',2),(2,'2024-05-29 14:25:17.509000','dd588a98-7186-4862-892b-ba13154ed8dd',3);
/*!40000 ALTER TABLE `verification_token` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-29 14:48:24
