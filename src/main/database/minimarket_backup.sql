CREATE DATABASE  IF NOT EXISTS `minimarket_java` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `minimarket_java`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: minimarket_java
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `cache`
--

DROP TABLE IF EXISTS `cache`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cache` (
  `key` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `value` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `expiration` int NOT NULL,
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cache`
--

LOCK TABLES `cache` WRITE;
/*!40000 ALTER TABLE `cache` DISABLE KEYS */;
INSERT INTO `cache` VALUES ('3f4f4451a27ab7d1e41f2cddbca56713','i:1;',1714964475),('3f4f4451a27ab7d1e41f2cddbca56713:timer','i:1714964475;',1714964475),('spatie.permission.cache','a:3:{s:5:\"alias\";a:4:{s:1:\"a\";s:2:\"id\";s:1:\"b\";s:4:\"name\";s:1:\"c\";s:10:\"guard_name\";s:1:\"r\";s:5:\"roles\";}s:11:\"permissions\";a:28:{i:0;a:4:{s:1:\"a\";i:1;s:1:\"b\";s:15:\"admin.dashboard\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:2:{i:0;i:1;i:1;i:2;}}i:1;a:4:{s:1:\"a\";i:2;s:1:\"b\";s:13:\"admin.contact\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:2:{i:0;i:1;i:1;i:2;}}i:2;a:4:{s:1:\"a\";i:3;s:1:\"b\";s:20:\"admin.category.index\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:2:{i:0;i:1;i:1;i:2;}}i:3;a:4:{s:1:\"a\";i:4;s:1:\"b\";s:21:\"admin.category.create\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:4;a:4:{s:1:\"a\";i:5;s:1:\"b\";s:19:\"admin.category.edit\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:5;a:4:{s:1:\"a\";i:6;s:1:\"b\";s:21:\"admin.category.delete\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:6;a:4:{s:1:\"a\";i:7;s:1:\"b\";s:19:\"admin.product.index\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:2:{i:0;i:1;i:1;i:2;}}i:7;a:4:{s:1:\"a\";i:8;s:1:\"b\";s:20:\"admin.product.create\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:8;a:4:{s:1:\"a\";i:9;s:1:\"b\";s:18:\"admin.product.edit\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:9;a:4:{s:1:\"a\";i:10;s:1:\"b\";s:20:\"admin.product.delete\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:10;a:4:{s:1:\"a\";i:11;s:1:\"b\";s:17:\"admin.users.index\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:11;a:4:{s:1:\"a\";i:12;s:1:\"b\";s:16:\"admin.users.edit\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:12;a:4:{s:1:\"a\";i:13;s:1:\"b\";s:18:\"admin.users.update\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:13;a:4:{s:1:\"a\";i:14;s:1:\"b\";s:18:\"admin.users.create\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:14;a:4:{s:1:\"a\";i:15;s:1:\"b\";s:17:\"admin.users.store\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:15;a:4:{s:1:\"a\";i:16;s:1:\"b\";s:18:\"admin.users.delete\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:16;a:4:{s:1:\"a\";i:17;s:1:\"b\";s:19:\"admin.users.destroy\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:17;a:4:{s:1:\"a\";i:18;s:1:\"b\";s:16:\"admin.sale.index\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:2:{i:0;i:1;i:1;i:2;}}i:18;a:4:{s:1:\"a\";i:19;s:1:\"b\";s:17:\"admin.sale.create\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:2:{i:0;i:1;i:1;i:2;}}i:19;a:4:{s:1:\"a\";i:20;s:1:\"b\";s:15:\"admin.sale.edit\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:20;a:4:{s:1:\"a\";i:21;s:1:\"b\";s:17:\"admin.sale.delete\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:21;a:4:{s:1:\"a\";i:22;s:1:\"b\";s:20:\"admin.supplier.index\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:2:{i:0;i:1;i:1;i:2;}}i:22;a:4:{s:1:\"a\";i:23;s:1:\"b\";s:19:\"admin.supplier.edit\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:23;a:4:{s:1:\"a\";i:24;s:1:\"b\";s:21:\"admin.supplier.update\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:24;a:4:{s:1:\"a\";i:25;s:1:\"b\";s:21:\"admin.supplier.create\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:2:{i:0;i:1;i:1;i:2;}}i:25;a:4:{s:1:\"a\";i:26;s:1:\"b\";s:20:\"admin.supplier.store\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:26;a:4:{s:1:\"a\";i:27;s:1:\"b\";s:21:\"admin.supplier.delete\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}i:27;a:4:{s:1:\"a\";i:28;s:1:\"b\";s:22:\"admin.supplier.destroy\";s:1:\"c\";s:3:\"web\";s:1:\"r\";a:1:{i:0;i:1;}}}s:5:\"roles\";a:2:{i:0;a:3:{s:1:\"a\";i:1;s:1:\"b\";s:5:\"Admin\";s:1:\"c\";s:3:\"web\";}i:1;a:3:{s:1:\"a\";i:2;s:1:\"b\";s:8:\"Employee\";s:1:\"c\";s:3:\"web\";}}}',1715047657);
/*!40000 ALTER TABLE `cache` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cache_locks`
--

DROP TABLE IF EXISTS `cache_locks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cache_locks` (
  `key` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `owner` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `expiration` int NOT NULL,
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cache_locks`
--

LOCK TABLES `cache_locks` WRITE;
/*!40000 ALTER TABLE `cache_locks` DISABLE KEYS */;
/*!40000 ALTER TABLE `cache_locks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `failed_jobs`
--

DROP TABLE IF EXISTS `failed_jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `failed_jobs` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `connection` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `queue` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `payload` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `exception` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `failed_jobs_uuid_unique` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `failed_jobs`
--

LOCK TABLES `failed_jobs` WRITE;
/*!40000 ALTER TABLE `failed_jobs` DISABLE KEYS */;
/*!40000 ALTER TABLE `failed_jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_batches`
--

DROP TABLE IF EXISTS `job_batches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_batches` (
  `id` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `total_jobs` int NOT NULL,
  `pending_jobs` int NOT NULL,
  `failed_jobs` int NOT NULL,
  `failed_job_ids` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `options` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `cancelled_at` int DEFAULT NULL,
  `created_at` int NOT NULL,
  `finished_at` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_batches`
--

LOCK TABLES `job_batches` WRITE;
/*!40000 ALTER TABLE `job_batches` DISABLE KEYS */;
/*!40000 ALTER TABLE `job_batches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobs` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `queue` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `payload` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `attempts` tinyint unsigned NOT NULL,
  `reserved_at` int unsigned DEFAULT NULL,
  `available_at` int unsigned NOT NULL,
  `created_at` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `jobs_queue_index` (`queue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `migrations`
--

DROP TABLE IF EXISTS `migrations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `migrations` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `migration` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `migrations`
--

LOCK TABLES `migrations` WRITE;
/*!40000 ALTER TABLE `migrations` DISABLE KEYS */;
INSERT INTO `migrations` VALUES (1,'0001_01_01_000000_create_users_table',1),(2,'0001_01_01_000001_create_cache_table',1),(3,'0001_01_01_000002_create_jobs_table',1),(4,'2024_04_23_215743_add_two_factor_columns_to_users_table',1),(5,'2024_04_23_215806_create_personal_access_tokens_table',1),(6,'2024_04_23_220245_create_states_table',1),(7,'2024_04_28_032128_create_category_products_table',1),(8,'2024_04_28_032210_create_products_table',1),(9,'2024_04_28_140305_create_permission_tables',1),(10,'2024_04_30_191922_create_suppliers_table',1),(11,'2024_04_30_193652_create_voucher_types_table',1),(12,'2024_04_30_193833_create_payment_methods_table',1),(13,'2024_04_30_194122_create_sales_table',1),(14,'2024_04_30_194944_create_orders_table',1),(15,'2024_04_30_195030_create_sale_details_table',1),(16,'2024_04_30_195405_create_temporary_baskets_table',1),(17,'2024_05_01_172257_create_product_and_suppliers_table',1),(18,'2024_05_04_212444_add_estado_id_to_users_table',1);
/*!40000 ALTER TABLE `migrations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model_has_permissions`
--

DROP TABLE IF EXISTS `model_has_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `model_has_permissions` (
  `permission_id` bigint unsigned NOT NULL,
  `model_type` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `model_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`permission_id`,`model_id`,`model_type`),
  KEY `model_has_permissions_model_id_model_type_index` (`model_id`,`model_type`),
  CONSTRAINT `model_has_permissions_permission_id_foreign` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model_has_permissions`
--

LOCK TABLES `model_has_permissions` WRITE;
/*!40000 ALTER TABLE `model_has_permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `model_has_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model_has_roles`
--

DROP TABLE IF EXISTS `model_has_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `model_has_roles` (
  `role_id` bigint unsigned NOT NULL,
  `model_type` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `model_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`role_id`,`model_id`,`model_type`),
  KEY `model_has_roles_model_id_model_type_index` (`model_id`,`model_type`),
  CONSTRAINT `model_has_roles_role_id_foreign` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model_has_roles`
--

LOCK TABLES `model_has_roles` WRITE;
/*!40000 ALTER TABLE `model_has_roles` DISABLE KEYS */;
INSERT INTO `model_has_roles` VALUES (1,'App\\Models\\User',3);
/*!40000 ALTER TABLE `model_has_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_reset_tokens`
--

DROP TABLE IF EXISTS `password_reset_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `password_reset_tokens` (
  `email` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_reset_tokens`
--

LOCK TABLES `password_reset_tokens` WRITE;
/*!40000 ALTER TABLE `password_reset_tokens` DISABLE KEYS */;
/*!40000 ALTER TABLE `password_reset_tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissions` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `guard_name` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `permissions_name_guard_name_unique` (`name`,`guard_name`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
INSERT INTO `permissions` VALUES (1,'admin.dashboard','web','2024-05-06 02:19:52','2024-05-06 02:19:52'),(2,'admin.contact','web','2024-05-06 02:19:52','2024-05-06 02:19:52'),(3,'admin.category.index','web','2024-05-06 02:19:52','2024-05-06 02:19:52'),(4,'admin.category.create','web','2024-05-06 02:19:52','2024-05-06 02:19:52'),(5,'admin.category.edit','web','2024-05-06 02:19:52','2024-05-06 02:19:52'),(6,'admin.category.delete','web','2024-05-06 02:19:52','2024-05-06 02:19:52'),(7,'admin.product.index','web','2024-05-06 02:19:52','2024-05-06 02:19:52'),(8,'admin.product.create','web','2024-05-06 02:19:52','2024-05-06 02:19:52'),(9,'admin.product.edit','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(10,'admin.product.delete','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(11,'admin.users.index','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(12,'admin.users.edit','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(13,'admin.users.update','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(14,'admin.users.create','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(15,'admin.users.store','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(16,'admin.users.delete','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(17,'admin.users.destroy','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(18,'admin.sale.index','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(19,'admin.sale.create','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(20,'admin.sale.edit','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(21,'admin.sale.delete','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(22,'admin.supplier.index','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(23,'admin.supplier.edit','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(24,'admin.supplier.update','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(25,'admin.supplier.create','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(26,'admin.supplier.store','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(27,'admin.supplier.delete','web','2024-05-06 02:19:53','2024-05-06 02:19:53'),(28,'admin.supplier.destroy','web','2024-05-06 02:19:53','2024-05-06 02:19:53');
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_access_tokens`
--

DROP TABLE IF EXISTS `personal_access_tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal_access_tokens` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `tokenable_type` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tokenable_id` bigint unsigned NOT NULL,
  `name` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `abilities` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `last_used_at` timestamp NULL DEFAULT NULL,
  `expires_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `personal_access_tokens_token_unique` (`token`),
  KEY `personal_access_tokens_tokenable_type_tokenable_id_index` (`tokenable_type`,`tokenable_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_access_tokens`
--

LOCK TABLES `personal_access_tokens` WRITE;
/*!40000 ALTER TABLE `personal_access_tokens` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal_access_tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `barcode` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `purchase_price` decimal(10,2) NOT NULL,
  `sale_price` decimal(10,2) NOT NULL,
  `stock` int NOT NULL,
  `category_id` bigint unsigned NOT NULL,
  `state_id` bigint unsigned NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `products_name_unique` (`name`),
  UNIQUE KEY `products_barcode_unique` (`barcode`),
  KEY `products_category_id_foreign` (`category_id`),
  KEY `products_state_id_foreign` (`state_id`),
  CONSTRAINT `products_category_id_foreign` FOREIGN KEY (`category_id`) REFERENCES `tb_categoria_producto` (`id`),
  CONSTRAINT `products_state_id_foreign` FOREIGN KEY (`state_id`) REFERENCES `tb_estado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Atún enlatado','0123456789099',3.10,3.99,50,1,1,NULL,NULL),(2,'Sopa de fideos enlatada','1234567890188',0.80,1.75,80,1,1,NULL,NULL),(3,'Maíz enlatado','2345678901277',0.95,1.49,60,1,1,NULL,NULL),(4,'Manzanas','1234567890166',1.98,2.99,50,2,1,NULL,NULL),(5,'Plátanos','2345678901255',0.97,1.75,80,2,1,NULL,NULL),(6,'Naranjas','3456789012344',0.85,1.49,60,2,1,NULL,NULL),(7,'Coca-Cola','1234567890133',1.20,1.99,100,3,1,NULL,NULL),(8,'Pepsi','2345678901222',0.94,1.75,120,3,1,NULL,NULL),(9,'Sprite','3456789012311',0.80,1.49,80,3,1,NULL,NULL),(10,'Papas Fritas','1234567890197',0.96,1.99,100,4,1,NULL,NULL),(11,'Galletas','2345678901264',0.95,1.75,120,4,1,NULL,NULL),(12,'Chocolate','3456789012331',0.60,1.49,80,4,1,NULL,NULL),(13,'Detergente líquido','1994567890123',1.63,3.99,50,5,1,NULL,NULL),(14,'Lejía','2345678901234',1.62,2.75,80,5,1,NULL,NULL),(15,'Limpiador multiusos','3886789012345',0.95,1.99,60,5,1,NULL,NULL),(16,'Mantequilla','4777890123456',1.84,2.25,90,6,1,NULL,NULL),(17,'Yogur natural','2665678901234',0.96,1.75,80,6,1,NULL,NULL),(18,'Queso fresco','3556789012345',1.67,3.99,60,6,1,NULL,NULL),(19,'Zanahorias','8441234567890',0.45,0.99,80,7,1,NULL,NULL),(20,'Tomates','7833123456789',1.10,1.49,50,7,1,NULL,NULL),(21,'Espinacas','9022345678901',0.96,1.25,70,7,1,NULL,NULL),(22,'Pilsen','1114567890123',1.21,2.99,100,8,1,NULL,NULL),(23,'Cristal','2005678901234',1.94,3.25,120,8,1,NULL,NULL),(24,'Cusqueña','3456798012345',1.84,3.49,80,8,1,NULL,NULL),(25,'Champú','1234561290123',2.61,4.99,50,9,1,NULL,NULL),(26,'Jabón de baño','2345673901234',1.60,1.75,80,9,1,NULL,NULL),(27,'Crema hidratante','3456749012345',2.63,3.49,60,9,1,NULL,NULL),(28,'Helado de vainilla','4567870123456',1.95,2.99,70,10,1,NULL,NULL),(29,'Helado de chocolate','5678081234567',2.10,3.25,80,10,1,NULL,NULL),(30,'Helado de fresa','6789010645678',1.94,3.49,90,10,1,NULL,NULL),(31,'Pan de molde','1234505890123',0.98,1.99,50,11,1,NULL,NULL),(32,'Croissants','2345678041234',0.57,1.25,60,11,1,NULL,NULL),(33,'Baguettes','3456780312345',1.21,2.49,40,11,1,NULL,NULL),(34,'Filete de pollo','4567894023456',3.58,5.99,70,12,1,NULL,NULL),(35,'Filete de salmón','5678900034567',7.12,8.25,80,12,1,NULL,NULL),(36,'Lomo de cerdo','6789011745678',5.12,6.49,90,12,1,NULL,NULL);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_has_permissions`
--

DROP TABLE IF EXISTS `role_has_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_has_permissions` (
  `permission_id` bigint unsigned NOT NULL,
  `role_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`permission_id`,`role_id`),
  KEY `role_has_permissions_role_id_foreign` (`role_id`),
  CONSTRAINT `role_has_permissions_permission_id_foreign` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`) ON DELETE CASCADE,
  CONSTRAINT `role_has_permissions_role_id_foreign` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_has_permissions`
--

LOCK TABLES `role_has_permissions` WRITE;
/*!40000 ALTER TABLE `role_has_permissions` DISABLE KEYS */;
INSERT INTO `role_has_permissions` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(20,1),(21,1),(22,1),(23,1),(24,1),(25,1),(26,1),(27,1),(28,1),(1,2),(2,2),(3,2),(7,2),(18,2),(19,2),(22,2),(25,2);
/*!40000 ALTER TABLE `role_has_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `guard_name` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `roles_name_guard_name_unique` (`name`,`guard_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Admin','web','2024-05-06 02:19:52','2024-05-06 02:19:52'),(2,'Employee','web','2024-05-06 02:19:52','2024-05-06 02:19:52');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sessions` (
  `id` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` bigint unsigned DEFAULT NULL,
  `ip_address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_agent` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `payload` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_activity` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sessions_user_id_index` (`user_id`),
  KEY `sessions_last_activity_index` (`last_activity`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
INSERT INTO `sessions` VALUES ('52bokMuQITvZBtD3SjodMIbkP6PP77t4irOUfyMQ',3,'127.0.0.1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36','YTo1OntzOjY6Il90b2tlbiI7czo0MDoiN0RmWml3VUlYZHd4N0tQc0ZIcUNZMXNGakd1eTV3MGZCa0ZLYU5KSCI7czo2OiJfZmxhc2giO2E6Mjp7czozOiJvbGQiO2E6MDp7fXM6MzoibmV3IjthOjA6e319czo5OiJfcHJldmlvdXMiO2E6MTp7czozOiJ1cmwiO3M6Mzk6Imh0dHA6Ly9taW5pbWFya2V0LWxhcmF2ZWwucGU6ODA4MC91c2VycyI7fXM6NTA6ImxvZ2luX3dlYl81OWJhMzZhZGRjMmIyZjk0MDE1ODBmMDE0YzdmNThlYTRlMzA5ODlkIjtpOjM7czoyMToicGFzc3dvcmRfaGFzaF9zYW5jdHVtIjtzOjYwOiIkMnkkMTIkVjU5Z0s2NFh4LmF3aFpVOXYwTW5VT0NTOGg4QXQ2Vlk2OWsydnpWNVVNakE0RWJXbTh0VU8iO30=',1714964133),('zleRAVuLCXsKXpEKygy9qbA3fSflUR4B2mqPmKnD',3,'127.0.0.1','Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36','YTo1OntzOjY6Il90b2tlbiI7czo0MDoiVERRWTNtSDhQWGgwNFl6TjZ1N1dHV0RWdG5rVzlOa081NmYzY2U4RCI7czo5OiJfcHJldmlvdXMiO2E6MTp7czozOiJ1cmwiO3M6NDE6Imh0dHA6Ly9taW5pbWFya2V0LWxhcmF2ZWwucGU6ODA4MC9jb250YWN0Ijt9czo2OiJfZmxhc2giO2E6Mjp7czozOiJvbGQiO2E6MDp7fXM6MzoibmV3IjthOjA6e319czo1MDoibG9naW5fd2ViXzU5YmEzNmFkZGMyYjJmOTQwMTU4MGYwMTRjN2Y1OGVhNGUzMDk4OWQiO2k6MztzOjIxOiJwYXNzd29yZF9oYXNoX3NhbmN0dW0iO3M6NjA6IiQyeSQxMiRWNTlnSzY0WHguYXdoWlU5djBNblVPQ1M4aDhBdDZWWTY5azJ2elY1VU1qQTRFYldtOHRVTyI7fQ==',1714964435);
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_categoria_producto`
--

DROP TABLE IF EXISTS `tb_categoria_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_categoria_producto` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_categoria_producto_nombre_unique` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_categoria_producto`
--

LOCK TABLES `tb_categoria_producto` WRITE;
/*!40000 ALTER TABLE `tb_categoria_producto` DISABLE KEYS */;
INSERT INTO `tb_categoria_producto` VALUES (1,'Enlatados',NULL,NULL),(2,'Frutas',NULL,NULL),(3,'Bebidas',NULL,NULL),(4,'Snacks y golosinas',NULL,NULL),(5,'Productos de limpieza',NULL,NULL),(6,'Lácteos',NULL,NULL),(7,'Verduras',NULL,NULL),(8,'Cervezas',NULL,NULL),(9,'Cuidado personal',NULL,NULL),(10,'Helados',NULL,NULL),(11,'Panadería',NULL,NULL),(12,'Carnes y pescados',NULL,NULL);
/*!40000 ALTER TABLE `tb_categoria_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cesta_temporal`
--

DROP TABLE IF EXISTS `tb_cesta_temporal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cesta_temporal` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `precio_unitario` decimal(10,2) NOT NULL,
  `cantidad` int NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `product_id` bigint unsigned NOT NULL,
  `user_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_cesta_temporal_product_id_foreign` (`product_id`),
  KEY `tb_cesta_temporal_user_id_foreign` (`user_id`),
  CONSTRAINT `tb_cesta_temporal_product_id_foreign` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `tb_cesta_temporal_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cesta_temporal`
--

LOCK TABLES `tb_cesta_temporal` WRITE;
/*!40000 ALTER TABLE `tb_cesta_temporal` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_cesta_temporal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detalle_venta`
--

DROP TABLE IF EXISTS `tb_detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_detalle_venta` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `precio_unitario` decimal(10,2) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `products_id` bigint unsigned NOT NULL,
  `sale_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_detalle_venta_products_id_foreign` (`products_id`),
  KEY `tb_detalle_venta_sale_id_foreign` (`sale_id`),
  CONSTRAINT `tb_detalle_venta_products_id_foreign` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`),
  CONSTRAINT `tb_detalle_venta_sale_id_foreign` FOREIGN KEY (`sale_id`) REFERENCES `tb_venta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detalle_venta`
--

LOCK TABLES `tb_detalle_venta` WRITE;
/*!40000 ALTER TABLE `tb_detalle_venta` DISABLE KEYS */;
INSERT INTO `tb_detalle_venta` VALUES (1,2.99,4.00,11.96,NULL,NULL,4,1),(2,1.75,1.00,1.75,NULL,NULL,11,1),(3,1.75,3.00,5.25,NULL,NULL,8,2),(4,1.75,2.00,3.50,NULL,NULL,10,2),(5,1.49,1.00,1.49,NULL,NULL,12,2);
/*!40000 ALTER TABLE `tb_detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_estado`
--

DROP TABLE IF EXISTS `tb_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_estado` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_estado_nombre_unique` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_estado`
--

LOCK TABLES `tb_estado` WRITE;
/*!40000 ALTER TABLE `tb_estado` DISABLE KEYS */;
INSERT INTO `tb_estado` VALUES (1,'Activo'),(3,'Eliminado'),(2,'Suspendido');
/*!40000 ALTER TABLE `tb_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_metodo_pago`
--

DROP TABLE IF EXISTS `tb_metodo_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_metodo_pago` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `metodo_pago` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_metodo_pago`
--

LOCK TABLES `tb_metodo_pago` WRITE;
/*!40000 ALTER TABLE `tb_metodo_pago` DISABLE KEYS */;
INSERT INTO `tb_metodo_pago` VALUES (1,'efectivo',NULL,NULL),(2,'tarjeta credito',NULL,NULL),(3,'tarjeta debito',NULL,NULL),(4,'yape',NULL,NULL);
/*!40000 ALTER TABLE `tb_metodo_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pedido`
--

DROP TABLE IF EXISTS `tb_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_pedido` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `costoTotal` decimal(10,2) NOT NULL,
  `id_usuario` bigint unsigned NOT NULL,
  `id_proveedor` bigint unsigned NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_pedido_id_usuario_foreign` (`id_usuario`),
  KEY `tb_pedido_id_proveedor_foreign` (`id_proveedor`),
  CONSTRAINT `tb_pedido_id_proveedor_foreign` FOREIGN KEY (`id_proveedor`) REFERENCES `tb_proveedor` (`id`),
  CONSTRAINT `tb_pedido_id_usuario_foreign` FOREIGN KEY (`id_usuario`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pedido`
--

LOCK TABLES `tb_pedido` WRITE;
/*!40000 ALTER TABLE `tb_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_producto_proveedor`
--

DROP TABLE IF EXISTS `tb_producto_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_producto_proveedor` (
  `producto_id` bigint unsigned NOT NULL,
  `proveedor_id` bigint unsigned NOT NULL,
  KEY `tb_producto_proveedor_producto_id_foreign` (`producto_id`),
  KEY `tb_producto_proveedor_proveedor_id_foreign` (`proveedor_id`),
  CONSTRAINT `tb_producto_proveedor_producto_id_foreign` FOREIGN KEY (`producto_id`) REFERENCES `products` (`id`),
  CONSTRAINT `tb_producto_proveedor_proveedor_id_foreign` FOREIGN KEY (`proveedor_id`) REFERENCES `tb_proveedor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_producto_proveedor`
--

LOCK TABLES `tb_producto_proveedor` WRITE;
/*!40000 ALTER TABLE `tb_producto_proveedor` DISABLE KEYS */;
INSERT INTO `tb_producto_proveedor` VALUES (1,1),(2,2),(5,1),(1,2);
/*!40000 ALTER TABLE `tb_producto_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proveedor`
--

DROP TABLE IF EXISTS `tb_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_proveedor` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ruc` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefono` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `correo` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `direccion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `estado_id` bigint unsigned NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_proveedor_name_unique` (`name`),
  UNIQUE KEY `tb_proveedor_ruc_unique` (`ruc`),
  UNIQUE KEY `tb_proveedor_telefono_unique` (`telefono`),
  UNIQUE KEY `tb_proveedor_correo_unique` (`correo`),
  UNIQUE KEY `tb_proveedor_direccion_unique` (`direccion`),
  KEY `tb_proveedor_estado_id_foreign` (`estado_id`),
  CONSTRAINT `tb_proveedor_estado_id_foreign` FOREIGN KEY (`estado_id`) REFERENCES `tb_estado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proveedor`
--

LOCK TABLES `tb_proveedor` WRITE;
/*!40000 ALTER TABLE `tb_proveedor` DISABLE KEYS */;
INSERT INTO `tb_proveedor` VALUES (1,'Distribuidora Alfa Enlatados','22345678901','Proveedor de alimentos enlatados','987954329','info@alfa.com','Calle Principal #123',1,'2024-05-06 02:19:52','2024-05-06 02:19:52'),(2,'Distribuidora frut S.A.','28768432101','Proveedor de frutas','954321987','ventas@productosfrescos.com','Avenida Central #456',1,'2024-05-06 02:19:52','2024-05-06 02:19:52'),(3,'Bebidas Refrescantes Ltda.','26789052301','Proveedor de bebidas gaseosas y aguas embotelladas','921654981','pedidos@bebidasrefrescantes.com','Calle Secundaria #789',1,'2024-05-06 02:19:52','2024-05-06 02:19:52'),(4,'PepsiCO S.A.','20987654721','Proveedor de golosinas, chocolates y snacks','989012345','contacto@dulcesygolosinas.com','Avenida Sur #234',1,'2024-05-06 02:19:52','2024-05-06 02:19:52'),(5,'Distribuidora FyN Limpieza','23456719012','Proveedor de productos de limpieza, detergentes y desinfectantes','919344678','ventas@articulosdelimpieza.com','Calle Norte #567',1,'2024-05-06 02:19:52','2024-05-06 02:19:52'),(6,'Lácteos Deliciosos S.A.','28765472109','Proveedor de productos lácteos frescos y saludables','987654321','ventas@lacteosdeliciosos.com','Avenida Norte #456',1,'2024-05-06 02:19:52','2024-05-06 02:19:52'),(7,'Verduras Orgánicas Ltda.','21934667890','Proveedor de verduras frescas y orgánicas','912395698','ventas@verdurasorganicas.com','Calle Verde #789',1,'2024-05-06 02:19:52','2024-05-06 02:19:52'),(8,'Cervecería Backus S.A.','21294567810','Proveedor de cervezas de alta calidad y variedad','992345678','contacto@cervezabackus.com','Avenida Cervecera #123',1,'2024-05-06 02:19:52','2024-05-06 02:19:52'),(9,'Productos de Higiene Personal S.A.','22375688971','Proveedor de productos de higiene personal, como jabones, champús y cremas','123456789','ventas@higienepersonal.com','Calle Higiene #456',1,'2024-05-06 02:19:52','2024-05-06 02:19:52'),(10,'Heladería Donofrio S.A.','22347618901','Proveedor de helados artesanales y postres helados','991476189','ventas@heladeriadelicias.com','Calle Principal #990',1,'2024-05-06 02:19:52','2024-05-06 02:19:52'),(11,'Panadería PanDuro S.A.','22345078501','Proveedor de productos de panadería frescos y variados','983416719','ventas@panaderiapanDulce.com','Calle del Pan #789',1,'2024-05-06 02:19:52','2024-05-06 02:19:52'),(12,'Carnes y Pescados Frescos S.A.','28795032009','Proveedor de carnes y pescados frescos y de calidad','987154821','ventas@carnespescadosfrescos.com','Avenida del Mar #789',2,'2024-05-06 02:19:52','2024-05-06 02:19:52');
/*!40000 ALTER TABLE `tb_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_comprobante`
--

DROP TABLE IF EXISTS `tb_tipo_comprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipo_comprobante` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `comprobante` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tb_tipo_comprobante_comprobante_unique` (`comprobante`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_comprobante`
--

LOCK TABLES `tb_tipo_comprobante` WRITE;
/*!40000 ALTER TABLE `tb_tipo_comprobante` DISABLE KEYS */;
INSERT INTO `tb_tipo_comprobante` VALUES (1,'factura',NULL,NULL),(2,'boleta',NULL,NULL);
/*!40000 ALTER TABLE `tb_tipo_comprobante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_venta`
--

DROP TABLE IF EXISTS `tb_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_venta` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `impuesto` decimal(10,2) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `tipo_comprobante_id` bigint unsigned NOT NULL,
  `metodo_pago_id` bigint unsigned NOT NULL,
  `users_id` bigint unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_venta_tipo_comprobante_id_foreign` (`tipo_comprobante_id`),
  KEY `tb_venta_metodo_pago_id_foreign` (`metodo_pago_id`),
  KEY `tb_venta_users_id_foreign` (`users_id`),
  CONSTRAINT `tb_venta_metodo_pago_id_foreign` FOREIGN KEY (`metodo_pago_id`) REFERENCES `tb_metodo_pago` (`id`),
  CONSTRAINT `tb_venta_tipo_comprobante_id_foreign` FOREIGN KEY (`tipo_comprobante_id`) REFERENCES `tb_tipo_comprobante` (`id`),
  CONSTRAINT `tb_venta_users_id_foreign` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_venta`
--

LOCK TABLES `tb_venta` WRITE;
/*!40000 ALTER TABLE `tb_venta` DISABLE KEYS */;
INSERT INTO `tb_venta` VALUES (1,1.50,18.99,'2024-05-06 02:19:52','2024-05-06 02:19:52',1,2,2),(2,2.20,10.24,'2024-05-06 02:19:52','2024-05-06 02:19:52',1,3,1);
/*!40000 ALTER TABLE `tb_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(191) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `two_factor_secret` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `two_factor_recovery_codes` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `two_factor_confirmed_at` timestamp NULL DEFAULT NULL,
  `remember_token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `current_team_id` bigint unsigned DEFAULT NULL,
  `profile_photo_path` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `estado_id` bigint unsigned DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_email_unique` (`email`),
  KEY `users_estado_id_foreign` (`estado_id`),
  CONSTRAINT `users_estado_id_foreign` FOREIGN KEY (`estado_id`) REFERENCES `tb_estado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Juan Perez','juan@example.com',NULL,'$2y$12$cj3/SNIEMQUqEeZjO.btxuQav0U.ySoHv35rOKb1IGcLVx3p1tkIO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2024-05-06 02:19:51','2024-05-06 02:19:51'),(2,'María García','maria@example.com',NULL,'$2y$12$6I2UKQpS/xiXtZaklYO6O.MXhLNckN67x0EeRd4G7TYNzijPEmD/m',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2024-05-06 02:19:51','2024-05-06 02:19:51'),(3,'Admin','admin@minimarketlaravel.io',NULL,'$2y$12$V59gK64Xx.awhZU9v0MnUOCS8h8At6VY69k2vzV5UMjA4EbWm8tUO',NULL,NULL,NULL,NULL,NULL,NULL,1,'2024-05-06 02:19:53','2024-05-06 02:19:53'),(4,'Brisa Homenick','mayert.austyn@example.com','2024-05-06 02:19:53','$2y$12$DdH.x.aPPtHE9mGs11iGFec2KpWVrkyjwqxTaW1npkwdlYc/2xP8G',NULL,NULL,NULL,'zksle6J61a',NULL,NULL,NULL,'2024-05-06 02:19:53','2024-05-06 02:19:53'),(5,'Luella Block','violet23@example.net','2024-05-06 02:19:53','$2y$12$DdH.x.aPPtHE9mGs11iGFec2KpWVrkyjwqxTaW1npkwdlYc/2xP8G',NULL,NULL,NULL,'XiBK1Lh1gB',NULL,NULL,NULL,'2024-05-06 02:19:53','2024-05-06 02:19:53'),(6,'Prof. Alia O\'Keefe PhD','ulebsack@example.org','2024-05-06 02:19:53','$2y$12$DdH.x.aPPtHE9mGs11iGFec2KpWVrkyjwqxTaW1npkwdlYc/2xP8G',NULL,NULL,NULL,'VvDCsAAwtL',NULL,NULL,NULL,'2024-05-06 02:19:53','2024-05-06 02:19:53'),(7,'Dr. Bryon Bernhard III','bosco.santino@example.com','2024-05-06 02:19:53','$2y$12$DdH.x.aPPtHE9mGs11iGFec2KpWVrkyjwqxTaW1npkwdlYc/2xP8G',NULL,NULL,NULL,'LvgShY75kn',NULL,NULL,NULL,'2024-05-06 02:19:53','2024-05-06 02:19:53'),(8,'Nia Thompson','langosh.meggie@example.com','2024-05-06 02:19:53','$2y$12$DdH.x.aPPtHE9mGs11iGFec2KpWVrkyjwqxTaW1npkwdlYc/2xP8G',NULL,NULL,NULL,'ijqSPd9rAY',NULL,NULL,NULL,'2024-05-06 02:19:53','2024-05-06 02:19:53'),(9,'Francesco O\'Keefe','heller.orion@example.net','2024-05-06 02:19:53','$2y$12$DdH.x.aPPtHE9mGs11iGFec2KpWVrkyjwqxTaW1npkwdlYc/2xP8G',NULL,NULL,NULL,'5Aq4anuxMZ',NULL,NULL,NULL,'2024-05-06 02:19:53','2024-05-06 02:19:53'),(10,'Marilie Braun','karl.christiansen@example.net','2024-05-06 02:19:53','$2y$12$DdH.x.aPPtHE9mGs11iGFec2KpWVrkyjwqxTaW1npkwdlYc/2xP8G',NULL,NULL,NULL,'HlOfh0sHpC',NULL,NULL,NULL,'2024-05-06 02:19:53','2024-05-06 02:19:53'),(11,'Jonas Eichmann','bradtke.earlene@example.net','2024-05-06 02:19:53','$2y$12$DdH.x.aPPtHE9mGs11iGFec2KpWVrkyjwqxTaW1npkwdlYc/2xP8G',NULL,NULL,NULL,'PJF78plRTJ',NULL,NULL,NULL,'2024-05-06 02:19:53','2024-05-06 02:19:53'),(12,'Van Marvin','kurtis41@example.net','2024-05-06 02:19:53','$2y$12$DdH.x.aPPtHE9mGs11iGFec2KpWVrkyjwqxTaW1npkwdlYc/2xP8G',NULL,NULL,NULL,'ml4gSexYX8',NULL,NULL,NULL,'2024-05-06 02:19:53','2024-05-06 02:19:53'),(13,'Prof. Willa Wiza Sr.','gleason.ralph@example.com','2024-05-06 02:19:53','$2y$12$DdH.x.aPPtHE9mGs11iGFec2KpWVrkyjwqxTaW1npkwdlYc/2xP8G',NULL,NULL,NULL,'inhcgoUvFH',NULL,NULL,NULL,'2024-05-06 02:19:53','2024-05-06 02:19:53'),(14,'Brennon Muller IV','michale62@example.net','2024-05-06 02:19:53','$2y$12$DdH.x.aPPtHE9mGs11iGFec2KpWVrkyjwqxTaW1npkwdlYc/2xP8G',NULL,NULL,NULL,'iWDQGSQy1F',NULL,NULL,NULL,'2024-05-06 02:19:53','2024-05-06 02:19:53'),(15,'Terrance Koss Sr.','easter.macejkovic@example.com','2024-05-06 02:19:53','$2y$12$DdH.x.aPPtHE9mGs11iGFec2KpWVrkyjwqxTaW1npkwdlYc/2xP8G',NULL,NULL,NULL,'xH9sjgYuNW',NULL,NULL,NULL,'2024-05-06 02:19:53','2024-05-06 02:19:53'),(16,'Reynold Mayer','quentin80@example.com','2024-05-06 02:19:53','$2y$12$DdH.x.aPPtHE9mGs11iGFec2KpWVrkyjwqxTaW1npkwdlYc/2xP8G',NULL,NULL,NULL,'yabS9Fli5X',NULL,NULL,NULL,'2024-05-06 02:19:53','2024-05-06 02:19:53'),(17,'Prof. Rosina Doyle','marcellus62@example.org','2024-05-06 02:19:53','$2y$12$DdH.x.aPPtHE9mGs11iGFec2KpWVrkyjwqxTaW1npkwdlYc/2xP8G',NULL,NULL,NULL,'JvHYz3kIOQ',NULL,NULL,NULL,'2024-05-06 02:19:53','2024-05-06 02:19:53'),(18,'Ari Hegmann MD','nharber@example.org','2024-05-06 02:19:53','$2y$12$DdH.x.aPPtHE9mGs11iGFec2KpWVrkyjwqxTaW1npkwdlYc/2xP8G',NULL,NULL,NULL,'mcIg4oo8vB',NULL,NULL,NULL,'2024-05-06 02:19:53','2024-05-06 02:19:53');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'minimarket_java'
--

--
-- Dumping routines for database 'minimarket_java'
--
/*!50003 DROP PROCEDURE IF EXISTS `LoginUsuarioActivo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8mb3_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `LoginUsuarioActivo`(IN p_email VARCHAR(40), IN p_password VARCHAR(191), OUT p_result INT)
BEGIN
    -- Verificar si existe un usuario con el email y contraseña proporcionados y que esté activo (estado_id = 1)
    SELECT COUNT(*) INTO p_result
    FROM `users`
    WHERE `email` = p_email AND `password` = p_password AND `estado_id` = 1;

    -- Si p_result es 1, entonces el login es exitoso y el usuario está activo
    -- Si p_result es 0, entonces el email o la contraseña son incorrectos, o el usuario no está activo
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_login`(
    IN p_email VARCHAR(40),
    OUT p_hashed_password VARCHAR(191),
    OUT p_user_id BIGINT,
    OUT p_is_active BOOLEAN
)
BEGIN
    DECLARE v_user_id BIGINT;
    DECLARE v_is_active BOOLEAN;
    DECLARE v_hashed_password VARCHAR(191);
    
    -- Buscar el hash de la contraseña y el estado del usuario por correo electrónico
    SELECT id, password, estado_id INTO v_user_id, v_hashed_password, v_is_active
    FROM users
    WHERE email = p_email;
    
    -- Asignar los resultados a los parámetros de salida
    SET p_user_id = v_user_id;
    SET p_hashed_password = v_hashed_password;
    SET p_is_active = v_is_active = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-09 11:14:18
