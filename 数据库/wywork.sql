/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : wywork

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-03-30 10:46:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `summary` varchar(255) DEFAULT NULL COMMENT '摘要',
  `picture` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `content` text COMMENT '正文内容',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `goods_num` int(11) DEFAULT '1' COMMENT '商品的数量',
  `status` tinyint(2) DEFAULT '0' COMMENT '0:未购买,1:已购买,2:已删除,3:不可用',
  `change_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `purchase_number` int(11) DEFAULT '0' COMMENT '商品被购买次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '商品1', '这个很甜', 'http://127.0.0.1/images/1.jpg', '这个很甜，而且买的很好', '10.77', '100', '1', '2019-03-14 09:51:30', '2019-02-11 19:49:05', '2');
INSERT INTO `goods` VALUES ('2', '商品2', '这个很苦', 'http://127.0.0.1/images/2.jpg', 'asdasdasd', '10.00', '100', '1', '2019-03-17 10:30:03', '2019-02-13 17:05:23', '4');
INSERT INTO `goods` VALUES ('3', '商品3', '修改摘要', 'http://127.0.0.1/images/1.jpg', '修改摘要yiyi', '12.35', '100', '1', '2019-03-17 10:24:50', '2019-02-13 19:10:39', '1');
INSERT INTO `goods` VALUES ('4', '商品4', '这个很香', 'http://127.0.0.1/images/4.jpg', '这个很香yiyi ', '12.34', '100', '0', '2019-03-14 09:58:28', '2019-03-03 16:49:14', '0');
INSERT INTO `goods` VALUES ('20', 'wqw', 'wqwq', 'http://127.0.0.1/images/20190312103826.jpg', 'qwq', '123.56', '1', '0', '2019-03-15 10:05:06', '2019-03-15 10:05:06', '0');

-- ----------------------------
-- Table structure for goods_order
-- ----------------------------
DROP TABLE IF EXISTS `goods_order`;
CREATE TABLE `goods_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` int(11) DEFAULT '1' COMMENT '用户id',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `summary` varchar(255) DEFAULT NULL COMMENT '摘要',
  `picture` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `content` text COMMENT '正文',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `goods_num` int(11) DEFAULT '1' COMMENT '购买的商品数量',
  `status` tinyint(2) DEFAULT '0' COMMENT '0:已完成,1:未完成,2:状态不可用',
  `change_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods_order
-- ----------------------------
INSERT INTO `goods_order` VALUES ('1', '1', '1', '商品1', '这个很甜', 'http://127.0.0.1/images/1.jpg', '这个很甜，而且买的很好', '10.77', '2', '0', '2019-03-14 09:51:30', '2019-03-14 09:51:30');
INSERT INTO `goods_order` VALUES ('2', '1', '3', '商品3', '修改摘要', 'http://127.0.0.1/images/3.jpg', '修改摘要yiyi', '12.35', '1', '0', '2019-03-14 09:51:30', '2019-03-14 09:51:30');
INSERT INTO `goods_order` VALUES ('3', '1', '2', '商品2', '这个很苦', 'http://127.0.0.1/images/6.jpg', '这个很苦，而且买的很好', '10.00', '4', '0', '2019-03-14 10:18:28', '2019-03-14 10:18:28');

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT '1' COMMENT '用户id',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `goods_num` int(11) DEFAULT '1' COMMENT '购物车中某个商品的数量',
  `status` tinyint(2) DEFAULT '0' COMMENT '0:商品在购物车,1:商品从购物车中删除,2:不可用',
  `change_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
INSERT INTO `shopping_cart` VALUES ('1', '1', '1', '2', '1', '2019-03-14 09:51:30', '2019-03-14 09:51:13');
INSERT INTO `shopping_cart` VALUES ('2', '1', '3', '1', '1', '2019-03-14 09:51:30', '2019-03-14 09:51:18');
INSERT INTO `shopping_cart` VALUES ('3', '1', '2', '4', '1', '2019-03-14 10:18:28', '2019-03-14 10:18:19');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `pwd` varchar(255) DEFAULT NULL,
  `change_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'buyer', 'waterlufei', '37254660e226ea65ce6f1efd54233424', '2019-02-11 18:41:51', '2019-02-10 19:31:48');
INSERT INTO `user` VALUES ('2', 'seller', 'wangyi', '981c57a5cfb0f868e064904b8745766f', '2019-02-11 18:42:05', '2019-02-10 19:32:35');
