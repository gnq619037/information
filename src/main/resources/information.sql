/*
SQLyog Trial v12.3.3 (64 bit)
MySQL - 5.6.26-log : Database - information
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`information` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `t_information` */

DROP TABLE IF EXISTS `t_information`;

CREATE TABLE `t_information` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `code_batch` varchar(20) DEFAULT NULL,
  `expert_code` varchar(20) DEFAULT NULL,
  `expert_name` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `birth_date` varchar(20) DEFAULT NULL,
  `card_type` varchar(20) DEFAULT NULL,
  `card_number` varchar(20) DEFAULT NULL,
  `country` varchar(10) DEFAULT NULL,
  `outside` varchar(2) DEFAULT NULL,
  `cn_name` varchar(20) DEFAULT NULL,
  `inside_home` varchar(20) DEFAULT NULL,
  `inside_live_reach_day` varchar(20) DEFAULT NULL,
  `bank_account_name` varchar(20) DEFAULT NULL,
  `bank_code` varchar(30) DEFAULT NULL,
  `bank_name` varchar(64) DEFAULT NULL,
  `union_bank_code` varchar(64) DEFAULT NULL,
  `tel_phone` varchar(11) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `school_code` varchar(32) DEFAULT NULL,
  `school_name` varchar(64) DEFAULT NULL,
  `pay_amount` varchar(32) DEFAULT NULL,
  `tax` varchar(32) DEFAULT NULL,
  `real_pay_amount` varchar(32) DEFAULT NULL,
  `current_status` varchar(32) DEFAULT NULL,
  `review_num` varchar(32) DEFAULT NULL,
  `settlement_status` varchar(32) DEFAULT NULL,
  `fail_status` varchar(32) DEFAULT NULL,
  `publish_time` varchar(32) DEFAULT NULL,
  `publish_batch` varchar(32) DEFAULT NULL,
  `publish_result` varchar(32) DEFAULT NULL,
  `publish_num` varchar(32) DEFAULT NULL,
  `fund_type` varchar(32) DEFAULT NULL,
  `info_flag` varchar(32) DEFAULT NULL,
  `back_account_verify` varchar(32) DEFAULT NULL,
  `publish_fail_msg` varchar(32) DEFAULT NULL,
  `publish_fail_use_flag` varchar(32) DEFAULT NULL,
  `past_batch` varchar(32) DEFAULT NULL,
  `message_status` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_information` */

/*Table structure for table `t_permission` */

DROP TABLE IF EXISTS `t_permission`;

CREATE TABLE `t_permission` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `per_code` varchar(10) NOT NULL COMMENT '操作',
  `per_desc` varchar(10) DEFAULT NULL COMMENT '操作描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_permission` */

insert  into `t_permission`(`id`,`per_code`,`per_desc`) values (1,'query','查询权限');
insert  into `t_permission`(`id`,`per_code`,`per_desc`) values (2,'export','导出权限');
insert  into `t_permission`(`id`,`per_code`,`per_desc`) values (3,'upload','上传权限');

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(10) NOT NULL COMMENT '角色',
  `role_desc` varchar(10) NOT NULL COMMENT '角色名中文描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`role_code`,`role_desc`) values (1,'admin','管理员');
insert  into `t_role`(`id`,`role_code`,`role_desc`) values (2,'user','一般用户');

/*Table structure for table `t_role_permission` */

DROP TABLE IF EXISTS `t_role_permission`;

CREATE TABLE `t_role_permission` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `role_id` int(5) DEFAULT NULL,
  `permission_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_role_permission` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`) values (2,'guonanqing','e09c0c83a32989dbe646e2491a89b77c');

/*Table structure for table `t_user_permission` */

DROP TABLE IF EXISTS `t_user_permission`;

CREATE TABLE `t_user_permission` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `permission_id` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_user_permission` */

insert  into `t_user_permission`(`id`,`user_id`,`permission_id`) values (1,2,1);

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(10) NOT NULL,
  `role_id` bigint(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
