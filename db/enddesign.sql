CREATE DATABASE  IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `designer_info`
--

DROP TABLE IF EXISTS `designer_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `designer_info` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `age` varchar(5) DEFAULT NULL,
  `avatar` varchar(200) DEFAULT NULL,
  `realname` varchar(45) DEFAULT NULL,
  `role` int(11) NOT NULL,
  `style` varchar(60) DEFAULT NULL,
  `concept` varchar(256) DEFAULT NULL,
  `motto` varchar(128) DEFAULT NULL,
  `work` varchar(256) DEFAULT NULL,
  `period` varchar(5) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `designer_info`
--

LOCK TABLES `designer_info` WRITE;
/*!40000 ALTER TABLE `designer_info` DISABLE KEYS */;
INSERT INTO `designer_info` VALUES ('Bobo','000000','男','30',NULL,'林宝',1,NULL,NULL,NULL,NULL,NULL,NULL),('Gary','000000','男','28','images/m1.jpg','王皓',1,'欧式','室内设计首先是从空间到细节，再到灵魂。','语言代替不了行动，行动才是最响亮的语言。','三湘四季城、碧云左岸','3','武汉'),('Jack','000000','男','31','images/m2.jpg','王晶',1,'欧式','设计的纯粹吸引人的生活！','设计，应以人为本。','中华怨别墅','1','武汉'),('Kevin','000000','男','26','images/m3.jpg','陈建',1,'田园','时尚、简约、不简单。','对于顶级设计师来说，旅行时最好的灵感。','春江美庐、城上城','3','北京'),('Linda','000000','女','30','images/w1.jpg','张婷',1,'地中海','坚持实用性、个性化、艺术性和环保性四大原则。','人生的意志和劳动将创造奇迹般的奇迹。','慧芝湖、梧桐城邦','4','上海'),('Mary','000000','女','30','images/w2.jpg','胡珍',1,'中式','从业主的生活和精神需求出发，设计体现人文关怀。','生活有毒，人生添寿。','世纪城、朝阳无限、双惠小区','4','上海'),('Nancy','000000','女','30','images/w3.jpg','林丽',1,'现代简约','语言代替不了行动，行动才是最响亮的语言。','理想是人生的太阳。','旺座中心、诚品建筑','4','上海'),('Peter','000000','男','26','images/m4.jpg','徐东方',1,'地中海','平淡中创造惊喜，磨砺中打造美的经典和时尚。','人生贵知心，定交无暮早。','阳光上东、幻星家园','3','北京'),('Tom','000000','男','26','images/m5.jpg','胡星',1,'其他','设计让生活更幸福。','真实是人生的命脉，是一切价值的根基。','汇统花园、华厦花园、回龙湾小区','3','北京');
/*!40000 ALTER TABLE `designer_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `caseId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`caseId`),
  UNIQUE KEY `caseId_UNIQUE` (`caseId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='经典案例';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,4,'设计中既保留古典欧式的典雅与豪华，注重空间的合理规划，也注重典雅高贵的体现，又适应了现代生活的休闲与舒适。'),(2,5,'不论是硬朗流畅的线条，还是简单舒适的家具亦或是那些简约的现代感，都让家装变得优雅高贵。'),(3,10,'没有传统古典欧式的金碧辉煌，没有现代风格的眼花缭乱，有的只是一种质朴的生活。'),(4,13,'此设计布置格局合理拥有两室一厅一厨一卫，适合于温馨小家庭三口之家居住，也适用于年青白领居住。'),(5,22,'中式风格的古色古香与现代风格的简单素雅自然衔接，使生活的实用性和对传统文化的追求同时得到了满足。'),(6,25,'以简洁明快的设计风格为主调，简洁和实用是现代简约风格的基本特点。'),(7,32,'整体硬装色彩还是比较朴素的，色彩多而不乱；家具、软饰搭配上讲究不拘一格，更多几分随性。');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `project_view`
--

DROP TABLE IF EXISTS `project_view`;
/*!50001 DROP VIEW IF EXISTS `project_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `project_view` AS SELECT 
 1 AS `avatar`,
 1 AS `designername`,
 1 AS `description`,
 1 AS `workId`,
 1 AS `style`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `projectdetail_view`
--

DROP TABLE IF EXISTS `projectdetail_view`;
/*!50001 DROP VIEW IF EXISTS `projectdetail_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `projectdetail_view` AS SELECT 
 1 AS `workId`,
 1 AS `title`,
 1 AS `designername`,
 1 AS `time`,
 1 AS `description`,
 1 AS `state`,
 1 AS `username`,
 1 AS `style`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `projects_view`
--

DROP TABLE IF EXISTS `projects_view`;
/*!50001 DROP VIEW IF EXISTS `projects_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `projects_view` AS SELECT 
 1 AS `workId`,
 1 AS `time`,
 1 AS `title`,
 1 AS `image`,
 1 AS `state`,
 1 AS `username`,
 1 AS `designername`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `age` varchar(5) DEFAULT NULL,
  `avatar` varchar(300) DEFAULT NULL,
  `realname` varchar(30) DEFAULT NULL,
  `role` int(11) NOT NULL,
  `style` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `userId_idx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES ('admin','admin',NULL,NULL,NULL,NULL,2,NULL),('Ben','000000','男','35','images/m6.jpg ','黄家宝',0,'现代简约'),('Betty','000000','女','24','images/w5.jpg','王霞',0,'地中海'),('Dave','000000','男','24','images/m7.jpg','陈浩',0,'地中海'),('Joan','000000','女','24','images/w4.jpg','罗悦',0,'地中海'),('Joe','000000','男','20','','',0,''),('Rose','000000','女','24','images/w6.jpg','黄奕婷',0,'地中海'),('Wilben','000000','男','24','images/m8.jpg','林嵩',0,'欧式');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work`
--

DROP TABLE IF EXISTS `work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work` (
  `workId` int(11) NOT NULL AUTO_INCREMENT,
  `time` date NOT NULL,
  `title` varchar(128) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `state` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `designername` varchar(45) NOT NULL,
  `style` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`workId`),
  UNIQUE KEY `workId_UNIQUE` (`workId`),
  KEY `username_idx` (`username`),
  KEY `designername_idx` (`designername`),
  CONSTRAINT `designername` FOREIGN KEY (`designername`) REFERENCES `designer_info` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `username` FOREIGN KEY (`username`) REFERENCES `user_info` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='作品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work`
--

LOCK TABLES `work` WRITE;
/*!40000 ALTER TABLE `work` DISABLE KEYS */;
INSERT INTO `work` VALUES (1,'2016-04-05','豪逸华庭','本方案突出以欧式风格豪华、优雅、和谐、舒适、浪漫的特点，\r 结合清新素雅为主导的中国化的简约欧式风格，而其简约欧式设计更符合中国人的审美观念，让内敛的感觉显现出来。',1,'Betty','Gary','欧式'),(2,'2014-03-04','健康花城','在简欧风格中传统欧式风格的高雅被保留下来，简化了欧式风格。',2,'Ben','Gary','欧式'),(3,'2016-02-03','香晖晴园','此次设计中沿袭古典欧式风格的主元素，融入了现代的生活元素。简约欧式的居室有的不只是豪华大气，更多的是惬意和浪漫。',1,'Ben','Jack','欧式'),(4,'2015-05-11','实地璟湖城','设计中既保留古典欧式的典雅与豪华，注重空间的合理规划，也注重典雅高贵的体现，又适应了现代生活的休闲与舒适。',2,'Dave','Gary','欧式'),(5,'2015-07-02','中海翠林兰溪园','不论是硬朗流畅的线条，还是简单舒适的家具亦或是那些简约的现代感，都让家装变得优雅高贵。',2,'Betty','Jack','欧式'),(6,'2016-03-21','盛花园','',0,'Rose','Gary',''),(7,'2015-12-15','凯茵新城','地中海装修风格，整套装修以地中海的天空、海洋、沙滩，就连空气中都漂浮着悠闲味道，蓝色与白色无处不在。',1,'Wilben','Linda','地中海'),(8,'2016-03-23','日出康城','简洁明快的装饰线条，突显个性品位，展现强烈的异国情调。',1,'Rose','Peter','地中海'),(9,'2015-05-03','铭嘉花园','设计师把空间重新搭配组合，以开放式的设计，充分利用每一寸空间，把改造的重点放在精巧的拱门、窗台的设计上，使之尽显海洋气息。',2,'Ben','Linda','地中海'),(10,'2015-05-21','豪逸华庭','没有传统古典欧式的金碧辉煌，没有现代风格的眼花缭乱，有的只是一种质朴的生活。',2,'Rose','Linda','地中海'),(11,'2015-07-13','金艺大厦','地中海风格,简约，以色调为主，光影，没有城市那么华丽，有的只是安静，这就是生活，生活也就莫过于此，',2,'Betty','Peter','地中海'),(12,'2016-03-28','逛御花园','',0,'Ben','Linda',''),(13,'2015-12-05','和泰家园','此设计布置格局合理拥有两室一厅一厨一卫，适合于温馨小家庭三口之家居住，也适用于年青白领居住。',2,'Rose','Kevin','田园'),(14,'2016-02-14','丽港城','在家具的选择上选择了浅木色、及象牙色的家具；局部配以带有淡彩的，贴近自然界色彩饰品点缀。有相框、花瓶、装饰画。',1,'Wilben','Kevin','田园'),(15,'2016-01-23','金汇豪庭','田园风格大量使用实木制作，展现精致的木工技艺，充分体现休闲 自然。',2,'Wilben','Kevin','田园'),(16,'2015-05-31','罗府家园','居室装修中厅、窗、地面一般均采用原木材质，木质以涂清油为主，透出原木特有的木结构和纹理。',2,'Ben','Kevin','田园'),(17,'2015-11-28','芳星园','用原砖和拉毛处理的墙面，将一幅具有自然风格的景致图发挥的邻里尽致。',1,'Betty','Kevin','田园'),(18,'2016-03-29','永顺家园','',0,'Wilben','Kevin',''),(20,'2016-02-21','幸福一村','非常讲究空间的层次感，在需要隔绝视线的地方，则使用中式的屏风或窗棂、中式木门、工艺隔断、简约化的中式“博古架”。',1,'Joan','Mary','中式'),(21,'2016-01-30','日新家园','客厅是传统与现代居室风格的碰撞，设计师以现代的装饰手法和家具，结合古典中式的装饰元素，来呈现亦古亦今的空间氛围。',1,'Dave','Mary','中式'),(22,'2015-06-01','龙湖花园','中式风格的古色古香与现代风格的简单素雅自然衔接，使生活的实用性和对传统文化的追求同时得到了满足。',2,'Ben','Mary','中式'),(23,'2015-07-18','石榴园','居室在色彩方面秉承了传统古典风格的典雅和华贵，但与之不同的是加入了很多现代元素，呈现着时尚的特征。',2,'Wilben','Mary','中式'),(24,'2016-03-29','万柳园小区','',0,'Betty','Mary',''),(25,'2015-12-05','佳和园','以简洁明快的设计风格为主调，简洁和实用是现代简约风格的基本特点。',2,'Wilben','Nancy','现代简约'),(26,'2014-04-08','金港大厦','以简洁明快的设计风格为主调，简洁和实用是现代简约风格的基本特点。',2,'Betty','Nancy','现代简约'),(27,'2016-01-24','广华轩','在设计时考虑了家庭成员的数量，访客量和家族风格，它通过摆设家具，建立了一个稳定的区域，在所提供的空间里满足需求。',1,'Joan','Nancy','现代简约'),(28,'2015-06-21','通典铭居','光线充足、通风良好、环境洁净和使用方便是现代化厨房的装修基本要求。颜色的选择以清洁、卫生为主。',2,'Dave','Nancy','现代简约'),(29,'2015-07-28','兰花国际','简约中求艺术，化繁为简，以宁缺勿滥为精髓，合理的简化居室，从简单舒适中体现生活的精致。',-1,'Wilben','Nancy','现代简约'),(30,'2016-03-28','德盛新城','',0,'Joan','Nancy',''),(31,'2015-12-09','心怡花园','在风格选择上不拘一格，选取不同触觉、味觉、视觉、嗅觉、听觉交织融合。',1,'Betty','Tom','其他'),(32,'2014-04-23','中兴家园','整体硬装色彩还是比较朴素的，色彩多而不乱；家具、软饰搭配上讲究不拘一格，更多几分随性。',2,'Joan','Tom','其他'),(33,'2016-01-22','祥和苑','简单的线条，没有表现过多的奢华；黄、黑相间的床头背景，简易的吊灯，营造出一个方便、放松、惬意的生活环境。',1,'Dave','Tom','其他'),(34,'2015-06-21','和平苑','灵动的书房设计，显示更多的是对一种现代混搭文化的追求。',2,'Joan','Tom','其他'),(35,'2015-07-28','龙辉大厦','',-1,'Dave','Tom','');
/*!40000 ALTER TABLE `work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_info`
--

DROP TABLE IF EXISTS `work_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_info` (
  `workinfoId` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(200) NOT NULL,
  `workId` int(11) NOT NULL,
  PRIMARY KEY (`workinfoId`),
  UNIQUE KEY `workinfoId_UNIQUE` (`workinfoId`),
  KEY `workId_idx` (`workId`),
  CONSTRAINT `workId` FOREIGN KEY (`workId`) REFERENCES `work` (`workId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8 COMMENT='作品详情';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_info`
--

LOCK TABLES `work_info` WRITE;
/*!40000 ALTER TABLE `work_info` DISABLE KEYS */;
INSERT INTO `work_info` VALUES (56,'images/o11.jpg',1),(57,'images/o12.jpg',1),(58,'images/o13.jpg',1),(59,'images/o14.jpg',1),(60,'images/o15.jpg',1),(61,'images/o21.jpg',2),(62,'images/o22.jpg',2),(63,'images/o23.jpg',2),(64,'images/o24.jpg',2),(65,'images/o25.jpg',2),(66,'images/o26.jpg',2),(67,'images/o27.jpg',2),(68,'images/o31.png',3),(69,'images/o32.png',3),(70,'images/o33.png',3),(71,'images/o34.png',3),(72,'images/o35.png',3),(73,'images/o41.jpg',4),(74,'images/o42.jpg',4),(75,'images/o43.jpg',4),(76,'images/o44.jpg',4),(77,'images/o45.jpg',4),(78,'images/o46.jpg',4),(79,'images/o47.jpg',4),(80,'images/o48.jpg',4),(81,'images/o49.jpg',4),(82,'images/o51.jpg',5),(83,'images/o52.jpg',5),(84,'images/o53.jpg',5),(85,'images/o54.jpg',5),(86,'images/o55.jpg',5),(87,'images/o56.jpg',5),(88,'images/o57.jpg',5),(89,'images/o58.jpg',5),(90,'images/d11.jpg',7),(91,'images/d12.jpg',7),(92,'images/d13.jpg',7),(93,'images/d21.jpg',8),(94,'images/d22.jpg',8),(95,'images/d23.jpg',8),(96,'images/d24.jpg',8),(97,'images/d25.jpg',8),(98,'images/d31.jpg',9),(99,'images/d32.jpg',9),(100,'images/d33.jpg',9),(101,'images/d34.jpg',9),(102,'images/d35.jpg',9),(103,'images/d36.jpg',9),(104,'images/d37.jpg',9),(105,'images/d38.jpg',9),(106,'images/d39.jpg',9),(107,'images/d41.jpg',10),(108,'images/d42.jpg',10),(109,'images/d43.jpg',10),(110,'images/d44.jpg',10),(111,'images/d45.jpg',10),(112,'images/d46.jpg',10),(113,'images/d47.jpg',10),(114,'images/d48.jpg',10),(115,'images/d49.jpg',10),(116,'images/d51.jpg',11),(117,'images/d52.jpg',11),(118,'images/d53.jpg',11),(119,'images/t11.jpg',13),(120,'images/t12.jpg',13),(121,'images/t13.jpg',13),(122,'images/t14.jpg',13),(123,'images/t15.jpg',13),(124,'images/t21.jpg',14),(125,'images/t22.jpg',14),(126,'images/t23.jpg',14),(127,'images/t24.jpg',14),(128,'images/t31.jpg',17),(129,'images/t32.jpg',17),(130,'images/t33.jpg',17),(131,'images/t34.jpg',17),(132,'images/t35.jpg',17),(133,'images/t36.jpg',17),(134,'images/t41.jpg',15),(135,'images/t42.jpg',15),(136,'images/t43.jpg',15),(137,'images/t44.jpg',15),(138,'images/t45.jpg',15),(139,'images/t46.jpg',15),(140,'images/t47.jpg',15),(141,'images/t51.jpg',16),(142,'images/t52.jpg',16),(146,'images/z21.jpg',20),(147,'images/z22.jpg',20),(148,'images/z23.jpg',20),(149,'images/z24.jpg',20),(150,'images/z31.jpg',21),(151,'images/z32.jpg',21),(152,'images/z33.jpg',21),(153,'images/z34.jpg',21),(154,'images/z41.jpg',22),(155,'images/z42.jpg',22),(156,'images/z43.jpg',22),(157,'images/z44.jpg',22),(158,'images/z51.jpg',23),(159,'images/z52.jpg',23),(160,'images/z53.jpg',23),(161,'images/z54.jpg',23),(162,'images/z55.jpg',23),(163,'images/z56.jpg',23),(164,'images/x11.jpg',25),(165,'images/x12.jpg',25),(166,'images/x13.jpg',25),(167,'images/x14.jpg',25),(168,'images/x15.jpg',25),(169,'images/x16.jpg',25),(170,'images/x21.jpg',26),(171,'images/x22.jpg',26),(172,'images/x23.jpg',26),(173,'images/x24.jpg',26),(174,'images/x25.jpg',26),(175,'images/x31.jpg',27),(176,'images/x32.jpg',27),(177,'images/x41.jpg',28),(178,'images/x42.jpg',28),(179,'images/x43.jpg',28),(180,'images/x44.jpg',28),(181,'images/x45.jpg',28),(182,'images/x46.jpg',28),(183,'images/x51.jpg',29),(184,'images/x52.jpg',29),(185,'images/x53.jpg',29),(186,'images/x54.jpg',29),(187,'images/q11.jpg',31),(188,'images/q12.jpg',31),(189,'images/q13.jpg',31),(190,'images/q14.jpg',31),(191,'images/q15.jpg',31),(192,'images/q16.jpg',31),(193,'images/q17.jpg',31),(194,'images/q21.jpg',32),(195,'images/q22.jpg',32),(196,'images/q23.jpg',32),(197,'images/q24.jpg',32),(198,'images/q25.jpg',32),(199,'images/q26.jpg',32),(200,'images/q27.jpg',32),(201,'images/q28.jpg',32),(202,'images/q31.jpg',33),(203,'images/q32.jpg',33),(204,'images/q33.jpg',33),(205,'images/q41.jpg',34),(206,'images/q42.jpg',34),(207,'images/q43.jpg',34),(208,'images/q44.jpg',34),(209,'images/q45.jpg',34),(210,'images/q46.jpg',34),(211,'images/q47.jpg',34);
/*!40000 ALTER TABLE `work_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `work_view`
--

DROP TABLE IF EXISTS `work_view`;
/*!50001 DROP VIEW IF EXISTS `work_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `work_view` AS SELECT 
 1 AS `workId`,
 1 AS `title`,
 1 AS `image`,
 1 AS `designername`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `workdetail_view`
--

DROP TABLE IF EXISTS `workdetail_view`;
/*!50001 DROP VIEW IF EXISTS `workdetail_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `workdetail_view` AS SELECT 
 1 AS `workId`,
 1 AS `title`,
 1 AS `designername`,
 1 AS `time`,
 1 AS `description`,
 1 AS `state`,
 1 AS `username`,
 1 AS `style`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'test'
--

--
-- Dumping routines for database 'test'
--

--
-- Final view structure for view `project_view`
--

/*!50001 DROP VIEW IF EXISTS `project_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `project_view` AS select `a`.`avatar` AS `avatar`,`b`.`designername` AS `designername`,`c`.`description` AS `description`,`b`.`workId` AS `workId`,`b`.`style` AS `style` from ((`designer_info` `a` join `work` `b`) join `project` `c`) where ((`a`.`username` = `b`.`designername`) and (`b`.`workId` = `c`.`workId`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `projectdetail_view`
--

/*!50001 DROP VIEW IF EXISTS `projectdetail_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `projectdetail_view` AS select `a`.`workId` AS `workId`,`a`.`title` AS `title`,`a`.`designername` AS `designername`,`a`.`time` AS `time`,`a`.`description` AS `description`,`a`.`state` AS `state`,`a`.`username` AS `username`,`a`.`style` AS `style` from (`work` `a` join `work_info` `b`) where (`a`.`workId` = `b`.`workId`) group by `a`.`workId` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `projects_view`
--

/*!50001 DROP VIEW IF EXISTS `projects_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `projects_view` AS select `a`.`workId` AS `workId`,`a`.`time` AS `time`,`a`.`title` AS `title`,`b`.`image` AS `image`,`a`.`state` AS `state`,`a`.`username` AS `username`,`a`.`designername` AS `designername` from (`work` `a` join `work_info` `b`) where (`a`.`workId` = `b`.`workId`) group by `a`.`workId` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `work_view`
--

/*!50001 DROP VIEW IF EXISTS `work_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `work_view` AS select `a`.`workId` AS `workId`,`a`.`title` AS `title`,`b`.`image` AS `image`,`a`.`designername` AS `designername` from (`work` `a` join `work_info` `b`) where ((`a`.`state` = 2) and (`a`.`workId` = `b`.`workId`)) group by `a`.`workId` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `workdetail_view`
--

/*!50001 DROP VIEW IF EXISTS `workdetail_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `workdetail_view` AS select `a`.`workId` AS `workId`,`a`.`title` AS `title`,`a`.`designername` AS `designername`,`a`.`time` AS `time`,`b`.`description` AS `description`,`a`.`state` AS `state`,`a`.`username` AS `username`,`a`.`style` AS `style` from (`work` `a` join `project` `b`) where (`a`.`workId` = `b`.`workId`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-16 16:54:42
