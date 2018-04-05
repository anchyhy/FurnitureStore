/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50625
 Source Host           : localhost
 Source Database       : furniturestore

 Target Server Type    : MySQL
 Target Server Version : 50625
 File Encoding         : utf-8

 Date: 03/16/2016 16:37:10 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `addressid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `auid` int(11) NOT NULL COMMENT 'user表外键',
  `province` varchar(10) NOT NULL COMMENT '省',
  `city` varchar(10) NOT NULL COMMENT '市',
  `district` varchar(10) NOT NULL COMMENT '区',
  `detail` varchar(50) NOT NULL COMMENT '详细地址',
  PRIMARY KEY (`addressid`),
  KEY `address_user_id` (`auid`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`auid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `address`
-- ----------------------------
BEGIN;
INSERT INTO `address` VALUES ('1', '1', '天津', '天津', '西青区', '天津师范大学'), ('5', '1', '浙江', '苏州', '高新区', '凯旋门'), ('7', '1', '上海', '上海', '浦东', '浦西'), ('17', '1', '12', '21', '12', '21'), ('18', '1', '请问', '我去', '请问', '我去');
COMMIT;

-- ----------------------------
--  Table structure for `brand`
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `brandid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '品牌名称',
  PRIMARY KEY (`brandid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `brand`
-- ----------------------------
BEGIN;
INSERT INTO `brand` VALUES ('1', '其他'), ('2', '美克美家'), ('3', '曲美家居'), ('4', '红苹果家具'), ('5', '欧派'), ('6', '林氏木业'), ('7', '全有家居'), ('8', '索菲亚'), ('9', '左右家私'), ('10', '皇朝家私'), ('11', '宜家家居');
COMMIT;

-- ----------------------------
--  Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cartid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cuid` int(11) NOT NULL COMMENT 'user表外键',
  `ctid` int(11) NOT NULL COMMENT 'type表外键',
  PRIMARY KEY (`cartid`),
  KEY `cuid` (`cuid`),
  KEY `ctid` (`ctid`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`cuid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`ctid`) REFERENCES `type` (`typeid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `cart`
-- ----------------------------
BEGIN;
INSERT INTO `cart` VALUES ('30', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `collect`
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `collectid` int(11) NOT NULL AUTO_INCREMENT,
  `cgid` int(11) NOT NULL,
  `cuid` int(11) NOT NULL,
  PRIMARY KEY (`collectid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `collect`
-- ----------------------------
BEGIN;
INSERT INTO `collect` VALUES ('3', '1', '1'), ('5', '3', '1');
COMMIT;

-- ----------------------------
--  Table structure for `communicate`
-- ----------------------------
DROP TABLE IF EXISTS `communicate`;
CREATE TABLE `communicate` (
  `communicateid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cuid` int(11) NOT NULL COMMENT 'user表外键',
  `ask` varchar(500) NOT NULL COMMENT 'user提问',
  `answer` varchar(500) DEFAULT NULL COMMENT '管理员回答',
  `flag` int(11) NOT NULL COMMENT '1:正在受理2：已受理',
  `subject` varchar(50) DEFAULT NULL COMMENT '主题',
  PRIMARY KEY (`communicateid`),
  KEY `cuid` (`cuid`),
  CONSTRAINT `communicate_ibfk_1` FOREIGN KEY (`cuid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `communicate`
-- ----------------------------
BEGIN;
INSERT INTO `communicate` VALUES ('1', '1', 'kk', 'll', '2', 'jj'), ('3', '1', '可以退款吗？', '可以退款的亲╭(╯3╰)╮', '2', '退款问题'), ('4', '1', '运费问题', '可以退款！', '2', '运费问题');
COMMIT;

-- ----------------------------
--  Table structure for `first`
-- ----------------------------
DROP TABLE IF EXISTS `first`;
CREATE TABLE `first` (
  `firstid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '一级分类名',
  PRIMARY KEY (`firstid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `first`
-- ----------------------------
BEGIN;
INSERT INTO `first` VALUES ('1', '厨房'), ('2', '客厅'), ('3', '卧室'), ('6', '书房'), ('8', '阳台摆设'), ('9', '浴室'), ('10', '衣帽间'), ('11', '餐厅');
COMMIT;

-- ----------------------------
--  Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '名字',
  `info` varchar(200) NOT NULL COMMENT '简介',
  `detail` varchar(1000) NOT NULL COMMENT '详情',
  `material` varchar(100) NOT NULL COMMENT '原料',
  `color` varchar(100) NOT NULL COMMENT '颜色',
  `style` varchar(100) NOT NULL COMMENT '风格',
  `brand` varchar(20) NOT NULL COMMENT '品牌',
  `guid` int(11) NOT NULL COMMENT 'user外键',
  `gtid` int(11) NOT NULL COMMENT '三级分类id',
  `oriprice` double(10,2) DEFAULT '0.00' COMMENT '原价',
  `preprice` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '现价',
  `photo` varchar(500) NOT NULL COMMENT '图片',
  `transport` double(10,2) NOT NULL DEFAULT '0.00',
  `flag` int(11) NOT NULL DEFAULT '0' COMMENT '0:未经管理员审核 ；1：已经管理员审核',
  `message` varchar(150) DEFAULT NULL,
  `gmid` int(11) NOT NULL,
  `gsid` int(11) NOT NULL,
  `gbid` int(11) NOT NULL,
  `times` int(11) NOT NULL DEFAULT '0',
  `evaluate` int(11) NOT NULL DEFAULT '0' COMMENT '评价等级',
  PRIMARY KEY (`goodsid`),
  KEY `guid` (`guid`),
  KEY `gtid` (`gtid`),
  KEY `gmid` (`gmid`),
  KEY `gsid` (`gsid`),
  KEY `gbid` (`gbid`),
  KEY `gmid_2` (`gmid`),
  KEY `gsid_2` (`gsid`),
  KEY `gbid_2` (`gbid`),
  KEY `gmid_3` (`gmid`),
  KEY `gsid_3` (`gsid`),
  KEY `gbid_3` (`gbid`),
  KEY `gmid_4` (`gmid`),
  KEY `gsid_4` (`gsid`),
  KEY `gbid_4` (`gbid`),
  KEY `gmid_5` (`gmid`),
  KEY `gsid_5` (`gsid`),
  KEY `gbid_5` (`gbid`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`guid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `goods_ibfk_2` FOREIGN KEY (`gtid`) REFERENCES `third` (`thirdid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `goods`
-- ----------------------------
BEGIN;
INSERT INTO `goods` VALUES ('1', '客厅整体沙发双人沙发d', 'dvavdadvavadvfbhmfhl.jnnnb', '啦啦啦', '纯棉', '灰色', '灰色空间', 'hello', '1', '10', '6000.00', '2000.00', 'p1.jpg;ss2.jpg;ss1.jpg;ss4.jpg;', '0.00', '1', null, '1', '12', '11', '0', '2'), ('2', '客厅整体沙发', 'dvavdadvavadvfbhmfhl.jnnnb', '啦啦啦', '纯棉', '灰色', '灰色空间', 'hello', '1', '10', '8000.00', '6000.00', 'p2.jpg;ss2.jpg;ss1.jpg;ss4.jpg;', '100.00', '1', null, '2', '1', '2', '0', '0'), ('3', '客厅整体沙发', 'www', 'www', 'ww', 'ww', 'ww', 'ww', '1', '10', '10000.00', '2000.00', 'p9.jpg;ss2.jpg;ss1.jpg;ss4.jpg;', '123.00', '1', null, '2', '2', '3', '0', '0'), ('4', '客厅整体沙发', 'qq', 'qqq', 'qqq', 'qqq', 'qqq', 'qqq', '1', '10', '23000.00', '10000.00', 'p4.jpg;ss2.jpg;ss1.jpg;ss4.jpg;', '99.00', '1', null, '3', '3', '4', '0', '0'), ('5', '客厅整体沙发', 'bb', 'bbb', 'bbb', 'bbb', 'bbb', 'bb', '1', '10', '6000.00', '5000.00', 'p5.jpg;ss2.jpg;ss1.jpg;ss4.jpg;', '99.00', '1', null, '4', '6', '5', '0', '0'), ('6', '客厅整体沙发', 'yyy', 'yyy', 'yyy', 'yy', 'yyy', 'yyy', '1', '10', '25000.00', '18000.00', 'p6.jpg;ss2.jpg;ss1.jpg;ss4.jpg;', '88.00', '1', null, '1', '5', '9', '0', '0'), ('7', '客厅整体沙发', 'qq', 'q', 'qq', 'qqq', 'qqq', 'qqq', '1', '10', '11.00', '111.00', 'p7.jpg;ss2.jpg;ss1.jpg;ss4.jpg;', '11.00', '1', null, '2', '11', '8', '0', '0'), ('8', '客厅整体沙发', 'ShiliShili', 'ShiliShiliShili', '实木', 'Shili', '日式风格', '美克美家', '1', '10', '0.00', '12000.00', 'p8.jpg;ss2.jpg;ss1.jpg;ss4.jpg;', '1000.00', '1', null, '6', '6', '2', '0', '0'), ('9', '客厅整体沙发', '时尚简单', '红色时尚简单沙发', '亮皮质', '红色', '时尚简约', '美克美家', '4', '10', '2800.00', '1800.00', 'p9.jpg;ss2.jpg;ss1.jpg;ss4.jpg;', '200.00', '1', null, '1', '10', '2', '0', '0'), ('10', 'qw', 'wq', 'wq', 'wq', 'www', 'www', 'wewewewe', '1', '1', '0.00', '123.00', 'image1458117167860.png;', '12.00', '0', null, '2', '10', '1', '0', '0'), ('11', 'rt', 'tr', 'rt', 'tr', 'rt', 'rt', 'tr', '1', '32', '0.00', '5666.00', 'image1458117202556.png;', '100.00', '0', null, '6', '6', '11', '0', '0');
COMMIT;

-- ----------------------------
--  Table structure for `material`
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `materialid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`materialid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `material`
-- ----------------------------
BEGIN;
INSERT INTO `material` VALUES ('1', '其他'), ('2', '人造板材'), ('3', '金属'), ('4', '藤编'), ('5', '软体'), ('6', '实木');
COMMIT;

-- ----------------------------
--  Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `newsid` int(11) NOT NULL AUTO_INCREMENT COMMENT '新闻序号',
  `title` varchar(20) NOT NULL COMMENT '标题',
  `time` varchar(200) NOT NULL COMMENT '时间',
  `content` varchar(1000) NOT NULL COMMENT '新闻内容',
  PRIMARY KEY (`newsid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `news`
-- ----------------------------
BEGIN;
INSERT INTO `news` VALUES ('3', 'as', '2016-03-08', 'sa');
COMMIT;

-- ----------------------------
--  Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `otid` int(11) NOT NULL COMMENT 'cart表外键',
  `oaid` int(11) NOT NULL COMMENT 'address表外键',
  `flag` int(11) NOT NULL COMMENT '订单状态（0:未审核 1：已审核，未发货 2：发货中 3：成交，未评论4：已评论）',
  `ouid` int(11) NOT NULL COMMENT 'user表外键',
  `message` varchar(200) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`orderid`),
  KEY `ocid` (`otid`),
  KEY `oaid` (`oaid`),
  KEY `ouid` (`ouid`),
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`oaid`) REFERENCES `address` (`addressid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_ibfk_3` FOREIGN KEY (`ouid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `order`
-- ----------------------------
BEGIN;
INSERT INTO `order` VALUES ('19', '1', '1', '3', '1', '', '1'), ('20', '2', '1', '3', '1', '哈哈哈', '1');
COMMIT;

-- ----------------------------
--  Table structure for `second`
-- ----------------------------
DROP TABLE IF EXISTS `second`;
CREATE TABLE `second` (
  `secondid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '名称',
  `sfid` int(11) NOT NULL COMMENT '一级分类外键',
  PRIMARY KEY (`secondid`),
  KEY `sfid` (`sfid`),
  CONSTRAINT `second_ibfk_1` FOREIGN KEY (`sfid`) REFERENCES `first` (`firstid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `second`
-- ----------------------------
BEGIN;
INSERT INTO `second` VALUES ('1', '抽烟机', '1'), ('2', '橱柜', '1'), ('3', '沙发', '2'), ('5', '电视柜', '2'), ('12', '茶几', '2'), ('13', '床', '3'), ('14', '床头柜', '3'), ('15', '梳妆台', '3'), ('17', '图书柜', '6'), ('18', '书桌', '6'), ('19', '饭桌', '11'), ('23', '花架', '8'), ('24', '晒衣杆', '8'), ('25', '洗手池', '9'), ('26', '淋浴', '9'), ('27', '马桶', '9'), ('28', '衣柜', '10');
COMMIT;

-- ----------------------------
--  Table structure for `seen`
-- ----------------------------
DROP TABLE IF EXISTS `seen`;
CREATE TABLE `seen` (
  `seenid` int(11) NOT NULL AUTO_INCREMENT,
  `suid` int(11) NOT NULL COMMENT '外键',
  `sgid` int(11) NOT NULL COMMENT '外键',
  PRIMARY KEY (`seenid`),
  KEY `suid` (`suid`),
  KEY `sgid` (`sgid`),
  CONSTRAINT `seen_ibfk_1` FOREIGN KEY (`suid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `seen_ibfk_2` FOREIGN KEY (`sgid`) REFERENCES `goods` (`goodsid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `seen`
-- ----------------------------
BEGIN;
INSERT INTO `seen` VALUES ('1', '1', '1'), ('2', '1', '2'), ('3', '4', '1'), ('5', '1', '3'), ('7', '1', '5'), ('8', '1', '4'), ('9', '1', '6'), ('11', '1', '7'), ('12', '1', '8');
COMMIT;

-- ----------------------------
--  Table structure for `seller`
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `sellerid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `suid` int(11) NOT NULL COMMENT 'user的外键',
  `photo1` varchar(50) NOT NULL COMMENT '个人照片',
  `photo2` varchar(50) NOT NULL COMMENT '身份证正面',
  `photo3` varchar(50) NOT NULL COMMENT '身份证背面',
  `flag` int(11) NOT NULL COMMENT '1:未通过管理员审核 2：已通过管理员审核',
  `message` varchar(150) DEFAULT NULL,
  `times` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`sellerid`),
  KEY `suid` (`suid`),
  CONSTRAINT `seller_ibfk_1` FOREIGN KEY (`suid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `seller`
-- ----------------------------
BEGIN;
INSERT INTO `seller` VALUES ('13', '1', 'image1454409016643.png', 'image1454409016662.png', 'image1454409016663.png', '2', '', '0'), ('14', '4', 'image1457324569271.png', 'image1457324569274.png', 'image1457324569275.png', '2', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `slide`
-- ----------------------------
DROP TABLE IF EXISTS `slide`;
CREATE TABLE `slide` (
  `slideid` int(11) NOT NULL AUTO_INCREMENT COMMENT '轮播图主键',
  `photo` varchar(50) NOT NULL COMMENT '主页图片',
  `saying` varchar(300) DEFAULT NULL COMMENT '主页图片搭配的文字',
  PRIMARY KEY (`slideid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `slide`
-- ----------------------------
BEGIN;
INSERT INTO `slide` VALUES ('1', 'banner1.jpg', '潮流有我，搭配有范儿，色彩衣五衣十！'), ('2', 'banner2.jpg', '当东方的神秘邂逅西方的经典，只为你呈现——与时俱进的美丽——最独特的我愿成为你的私人衣橱.'), ('3', 'banner3.jpg', '亲，全场包邮哦！');
COMMIT;

-- ----------------------------
--  Table structure for `style`
-- ----------------------------
DROP TABLE IF EXISTS `style`;
CREATE TABLE `style` (
  `styleid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '风格名称',
  PRIMARY KEY (`styleid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `style`
-- ----------------------------
BEGIN;
INSERT INTO `style` VALUES ('1', '其他'), ('2', '田园风格'), ('3', '美式风格'), ('4', '欧式风格'), ('5', '东南亚风格'), ('6', '日式风格'), ('7', '中式风格'), ('8', '非洲风格'), ('9', '古典风格'), ('10', '简约风格'), ('11', '流行风格'), ('12', '地中海风格');
COMMIT;

-- ----------------------------
--  Table structure for `third`
-- ----------------------------
DROP TABLE IF EXISTS `third`;
CREATE TABLE `third` (
  `thirdid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `tsid` int(11) NOT NULL,
  PRIMARY KEY (`thirdid`),
  KEY `tsid` (`tsid`),
  CONSTRAINT `third_ibfk_1` FOREIGN KEY (`tsid`) REFERENCES `second` (`secondid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `third`
-- ----------------------------
BEGIN;
INSERT INTO `third` VALUES ('1', '平顶抽烟机', '1'), ('2', '斜顶抽烟机', '1'), ('5', '整体橱柜', '2'), ('9', '单件橱柜', '2'), ('10', '整体沙发', '3'), ('11', '单件沙发', '3'), ('12', '伸缩电视柜', '5'), ('13', '伸缩茶几', '12'), ('14', '单人床', '13'), ('15', '双人床', '13'), ('16', '上下床', '13'), ('17', '婴儿床', '13'), ('18', '床头柜', '14'), ('19', '梳妆台', '15'), ('20', '书架', '17'), ('21', '学习桌', '18'), ('22', '电脑桌', '18'), ('23', '折叠餐桌', '19'), ('24', '阳台花架', '23'), ('25', '升降晾衣架', '24'), ('26', '普通衣架', '24'), ('27', '方形洗手池', '25'), ('28', '圆形洗手池', '25'), ('29', '淋浴', '26'), ('30', '浴缸', '26'), ('31', '马桶', '27'), ('32', '衣柜', '28');
COMMIT;

-- ----------------------------
--  Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `typeid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tgid` int(11) NOT NULL COMMENT 'goods表外键',
  `kind` varchar(20) NOT NULL COMMENT '种类（颜色、大小）',
  `photo` varchar(50) NOT NULL COMMENT '每个种类的一张照片',
  `number` int(11) NOT NULL COMMENT '数量',
  PRIMARY KEY (`typeid`),
  KEY `tgid` (`tgid`),
  CONSTRAINT `type_ibfk_1` FOREIGN KEY (`tgid`) REFERENCES `goods` (`goodsid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `type`
-- ----------------------------
BEGIN;
INSERT INTO `type` VALUES ('1', '1', '红色', 'ss33.jpg', '32'), ('2', '1', '白色单人', 'ss44.jpg', '48'), ('3', '1', '黄色双人', 'ss33.jpg', '0'), ('4', '2', 'qwe', 'ss33.jpg', '100'), ('5', '1', '黑色经典', 'ss33.jpg', '983');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `truename` varchar(20) NOT NULL COMMENT '真实姓名',
  `nickname` varchar(20) NOT NULL COMMENT '昵称',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `phone` varchar(20) NOT NULL COMMENT '手机号码',
  `flag` int(11) NOT NULL COMMENT '判断类型（1：买主2：卖主3：管理员）',
  `gender` int(11) NOT NULL COMMENT '性别（1：男2：女）',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '激活属性（0：未激活；1：已激活）',
  `validateCode` varchar(100) NOT NULL COMMENT '激活码',
  `registerTime` varchar(100) NOT NULL COMMENT '注册时间',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '邵安琪', 'anchy', '1', '182783387@qq.com', '1234567890000', '2', '2', '1', '', 'Fri Feb 05 16:07:40 CST 2016'), ('4', '田浩扬', '田田', '123456', '390113531@qq.com', '12345678910', '2', '1', '1', '', 'Fri Feb 05 16:07:40 CST 2016'), ('5', '管理员', 'admin', 'admin', 'admin', '111111', '3', '1', '1', '', 'Fri Feb 05 16:07:40 CST 2016'), ('26', 'ygh', 'hh', '111', 'saq1994@126.com', '123', '1', '2', '1', 'AC5A2CF72813D7D7713634781B037191', 'Fri Feb 05 16:07:40 CST 2016'), ('28', 'qw', 'qwwwww', 'qw', 'wq@126.com', '0000000', '1', '2', '0', '90F49736106DF219E47D0A242EF059A7', 'Tue Feb 23 16:50:04 CST 2016');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
