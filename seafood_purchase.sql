-- MySQL dump 10.13  Distrib 5.6.23, for osx10.8 (x86_64)
--
-- Host: localhost    Database: seafood_purchase
-- ------------------------------------------------------
-- Server version	5.6.23

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
-- Current Database: `seafood_purchase`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `seafood_purchase` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `seafood_purchase`;

--
-- Table structure for table `TBL_ADDRESS`
--

DROP TABLE IF EXISTS `TBL_ADDRESS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TBL_ADDRESS` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `real_name` varchar(32) DEFAULT NULL COMMENT '收件人真实姓名',
  `address` varchar(128) DEFAULT NULL COMMENT '收件人地址',
  `phone` varchar(32) DEFAULT NULL COMMENT '收件人手机号',
  `post_code` int(11) DEFAULT NULL COMMENT '收件人邮编',
  `email` varchar(32) DEFAULT NULL COMMENT '收件人邮箱',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户地址表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_ADDRESS`
--

LOCK TABLES `TBL_ADDRESS` WRITE;
/*!40000 ALTER TABLE `TBL_ADDRESS` DISABLE KEYS */;
/*!40000 ALTER TABLE `TBL_ADDRESS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL_CART_ITEM`
--

DROP TABLE IF EXISTS `TBL_CART_ITEM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TBL_CART_ITEM` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `commodity_number` int(11) DEFAULT NULL COMMENT '加入购物车商品数量',
  `commodity_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_CART_ITEM`
--

LOCK TABLES `TBL_CART_ITEM` WRITE;
/*!40000 ALTER TABLE `TBL_CART_ITEM` DISABLE KEYS */;
/*!40000 ALTER TABLE `TBL_CART_ITEM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL_CATEGORY`
--

DROP TABLE IF EXISTS `TBL_CATEGORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TBL_CATEGORY` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) DEFAULT NULL COMMENT '类别名称',
  `desc` varchar(25) DEFAULT NULL COMMENT '类别描述',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父类别id',
  `category_is_hot` smallint(6) DEFAULT NULL COMMENT '是否是热销类别',
  `category_is_sale` smallint(6) DEFAULT NULL COMMENT '是否是打折的类别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_CATEGORY`
--

LOCK TABLES `TBL_CATEGORY` WRITE;
/*!40000 ALTER TABLE `TBL_CATEGORY` DISABLE KEYS */;
/*!40000 ALTER TABLE `TBL_CATEGORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL_COMMODITY`
--

DROP TABLE IF EXISTS `TBL_COMMODITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TBL_COMMODITY` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `commodity_name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `icon_url` varchar(25) DEFAULT NULL COMMENT '图片地址',
  `desc` varchar(25) DEFAULT NULL COMMENT '商品描述',
  `in_price` decimal(25,2) DEFAULT NULL COMMENT '商品进价格',
  `commodity_is_hot` smallint(6) DEFAULT NULL COMMENT '是否是热销商品',
  `remainder_count` int(11) DEFAULT NULL COMMENT '商品剩余数量',
  `total_count` int(11) DEFAULT NULL COMMENT '商品进数量',
  `commodity_is_sale` smallint(6) DEFAULT NULL COMMENT '是否是打折的商品',
  `customer_number` varchar(25) DEFAULT NULL COMMENT '商品是从哪家商户进的',
  `out_price` decimal(25,2) DEFAULT NULL COMMENT '商品出价格',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '商品创建时间',
  `update_last_time` timestamp NULL DEFAULT NULL COMMENT '商品最后更新时间',
  `sale_time` timestamp NULL DEFAULT NULL COMMENT '商品售出时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_COMMODITY`
--

LOCK TABLES `TBL_COMMODITY` WRITE;
/*!40000 ALTER TABLE `TBL_COMMODITY` DISABLE KEYS */;
/*!40000 ALTER TABLE `TBL_COMMODITY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL_COMMODITY_CATEGORY_RELATION`
--

DROP TABLE IF EXISTS `TBL_COMMODITY_CATEGORY_RELATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TBL_COMMODITY_CATEGORY_RELATION` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `commodity_id` bigint(20) DEFAULT NULL,
  `catetory_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品类别关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_COMMODITY_CATEGORY_RELATION`
--

LOCK TABLES `TBL_COMMODITY_CATEGORY_RELATION` WRITE;
/*!40000 ALTER TABLE `TBL_COMMODITY_CATEGORY_RELATION` DISABLE KEYS */;
/*!40000 ALTER TABLE `TBL_COMMODITY_CATEGORY_RELATION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL_MERCHANT`
--

DROP TABLE IF EXISTS `TBL_MERCHANT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TBL_MERCHANT` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `merchant_no` varchar(32) DEFAULT NULL COMMENT '商户编号',
  `merchant_name` varchar(100) DEFAULT NULL COMMENT '商户名称',
  `merchant_tel` varchar(32) DEFAULT NULL COMMENT '商户座机电话',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `merchant_address` varchar(128) DEFAULT NULL COMMENT '商户地址',
  `home_page` varchar(300) DEFAULT NULL COMMENT '公司官方网站',
  `link_name` varchar(32) DEFAULT NULL COMMENT '联系人姓名',
  `link_phone` varchar(32) DEFAULT NULL COMMENT '联系人手机号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_merchant_no` (`merchant_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_MERCHANT`
--

LOCK TABLES `TBL_MERCHANT` WRITE;
/*!40000 ALTER TABLE `TBL_MERCHANT` DISABLE KEYS */;
/*!40000 ALTER TABLE `TBL_MERCHANT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL_ORDER`
--

DROP TABLE IF EXISTS `TBL_ORDER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TBL_ORDER` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_sn` varchar(32) DEFAULT NULL COMMENT '订单号',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `status` varchar(32) DEFAULT NULL COMMENT '订单状态',
  `total_price` decimal(25,2) DEFAULT NULL COMMENT '订单总价格',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `address_id` bigint(20) DEFAULT NULL COMMENT '下单地址ID',
  `merchant_no` varchar(32) DEFAULT NULL COMMENT '商户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_ORDER`
--

LOCK TABLES `TBL_ORDER` WRITE;
/*!40000 ALTER TABLE `TBL_ORDER` DISABLE KEYS */;
/*!40000 ALTER TABLE `TBL_ORDER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL_USER`
--

DROP TABLE IF EXISTS `TBL_USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TBL_USER` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `login_name` varchar(50) NOT NULL COMMENT '登陆名称',
  `name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `email` varchar(50) NOT NULL COMMENT '邮件',
  `pwd_error_counts` int(11) DEFAULT NULL COMMENT '密码输入错误次数',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_login_time` timestamp NULL DEFAULT NULL COMMENT '最后的登录时间',
  `last_login_ip` varchar(39) DEFAULT NULL COMMENT '最后登录IP',
  `last_login_ip_location` varchar(20) DEFAULT NULL COMMENT '最后登录位置',
  `status` varchar(20) DEFAULT NULL COMMENT '使用状态',
  `trade_password` varchar(128) DEFAULT NULL COMMENT '交易密码',
  `sex` varchar(4) DEFAULT NULL COMMENT '性别',
  `accumulate_score` decimal(6,2) DEFAULT '0.00' COMMENT '用户累计积分',
  `default_is_address` bigint(20) DEFAULT NULL COMMENT '默认地址id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_name_unique` (`login_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL_USER`
--

LOCK TABLES `TBL_USER` WRITE;
/*!40000 ALTER TABLE `TBL_USER` DISABLE KEYS */;
/*!40000 ALTER TABLE `TBL_USER` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-02 13:18:46
