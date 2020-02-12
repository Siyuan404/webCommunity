CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `token` char(36) DEFAULT NULL,
  `gmt_create` BIGINT(20) DEFAULT NULL,
  `gmt_modify` BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
)