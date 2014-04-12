/*
MySQL Data Transfer
Source Host: localhost
Source Database: library
Target Host: localhost
Target Database: library
Date: 2013-1-14 18:10:18
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_assignroles
-- ----------------------------
CREATE TABLE `t_assignroles` (
  `assign_id` int(11) NOT NULL auto_increment COMMENT '角色分配id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY  (`assign_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
CREATE TABLE `t_book` (
  `book_id` varchar(20) collate utf8_unicode_ci NOT NULL COMMENT '书籍编号',
  `book_name` varchar(40) collate utf8_unicode_ci NOT NULL COMMENT '书籍名称',
  `book_imageurl` varchar(40) collate utf8_unicode_ci default NULL COMMENT '书籍图片url',
  `book_author` varchar(20) collate utf8_unicode_ci NOT NULL COMMENT '作者',
  `book_publish` varchar(40) collate utf8_unicode_ci NOT NULL COMMENT '出版社名称',
  `book_douban` varchar(40) collate utf8_unicode_ci NOT NULL default 'http://www.douban.com/' COMMENT '豆瓣url地址',
  `type_id` tinyint(4) NOT NULL COMMENT '书籍类别id',
  `book_checkflag` tinyint(4) NOT NULL COMMENT '借书状态：0/1是否在架',
  `book_isorder` tinyint(4) default '0' COMMENT '是否可以预定0/1 默认为零，表示可预订',
  `book_addtime` date default NULL COMMENT '书籍上架时间',
  PRIMARY KEY  (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_booktype
-- ----------------------------
CREATE TABLE `t_booktype` (
  `type_id` int(11) NOT NULL auto_increment COMMENT '图书类别id',
  `type_name` varchar(20) collate utf8_unicode_ci NOT NULL COMMENT '类别名称',
  `type_fathertypeid` int(11) NOT NULL COMMENT '父类别id',
  `type_desc` varchar(20) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_borrow
-- ----------------------------
CREATE TABLE `t_borrow` (
  `check_id` int(11) NOT NULL auto_increment COMMENT '主键标识',
  `user_id` int(11) NOT NULL,
  `book_id` varchar(20) collate utf8_unicode_ci NOT NULL COMMENT '书籍编号',
  `check_flag` tinyint(4) NOT NULL COMMENT '借阅标示：0审批未通过、1申请中、2审批通过、3已还书、4还书超期',
  `check_requesttime` date NOT NULL COMMENT '借书请求时间',
  `check_starttime` date default NULL COMMENT '借书开始时间也是借书审核通过时间',
  `check_endtime` date default NULL COMMENT '还书时间',
  `check_mailtime` int(11) NOT NULL default '5' COMMENT '用户邮件提醒时间：默认是提前5天还书',
  `check_overdue` tinyint(4) NOT NULL default '0' COMMENT '逾期天数',
  `check_renew` tinyint(4) NOT NULL default '0' COMMENT '续借次数：0/1',
  PRIMARY KEY  (`check_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_divisionpower
-- ----------------------------
CREATE TABLE `t_divisionpower` (
  `division_id` int(11) NOT NULL auto_increment COMMENT '限权分配id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `fun_id` int(11) NOT NULL COMMENT '功能id',
  PRIMARY KEY  (`division_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_function
-- ----------------------------
CREATE TABLE `t_function` (
  `fun_id` int(11) NOT NULL auto_increment COMMENT '功能id',
  `fun_name` varchar(20) collate utf8_unicode_ci NOT NULL COMMENT '功能名称',
  `fun_fatherid` int(11) NOT NULL,
  `fun_seq` tinyint(4) default '0' COMMENT '对统计功能的排序',
  `fun_url` varchar(40) collate utf8_unicode_ci default NULL COMMENT '能功url地址',
  `fun_level` tinyint(4) default '1' COMMENT '功能层级',
  PRIMARY KEY  (`fun_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_mail
-- ----------------------------
CREATE TABLE `t_mail` (
  `mail_id` int(11) NOT NULL auto_increment,
  `mail_from` varchar(20) collate utf8_unicode_ci NOT NULL COMMENT '发信人',
  `mail_to` varchar(20) collate utf8_unicode_ci NOT NULL COMMENT '收信人：',
  `mail_title` varchar(40) collate utf8_unicode_ci NOT NULL COMMENT '邮件主题',
  `mail_content` varchar(100) collate utf8_unicode_ci NOT NULL COMMENT '内容',
  `mail_fileurl` varchar(40) collate utf8_unicode_ci NOT NULL COMMENT '附件url',
  `mail_time` date NOT NULL COMMENT '发送时间',
  PRIMARY KEY  (`mail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_orderbook
-- ----------------------------
CREATE TABLE `t_orderbook` (
  `order_id` int(11) NOT NULL auto_increment COMMENT '主键标识',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `book_id` varchar(20) collate utf8_unicode_ci NOT NULL COMMENT '书籍编号',
  `order_time` date NOT NULL COMMENT '预定时间',
  PRIMARY KEY  (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_procure
-- ----------------------------
CREATE TABLE `t_procure` (
  `pro_id` int(11) NOT NULL auto_increment COMMENT '键主标示',
  `book_id` varchar(20) collate utf8_unicode_ci NOT NULL COMMENT '籍编号书',
  `pro_price` float(5,0) NOT NULL COMMENT '单价',
  `pro_num` tinyint(4) NOT NULL COMMENT '本数：默认1',
  PRIMARY KEY  (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_recommend
-- ----------------------------
CREATE TABLE `t_recommend` (
  `rec_id` int(11) NOT NULL auto_increment COMMENT '推荐表主键标识',
  `user_id` int(11) NOT NULL COMMENT '户用id',
  `book_name` varchar(40) collate utf8_unicode_ci NOT NULL,
  `book_author` varchar(40) collate utf8_unicode_ci default NULL,
  `book_publish` varchar(40) collate utf8_unicode_ci NOT NULL,
  `book_douban` varchar(40) collate utf8_unicode_ci NOT NULL,
  `type_id` tinyint(4) NOT NULL COMMENT '书籍类别',
  `rec_flag` tinyint(4) NOT NULL default '0' COMMENT '是否采纳推荐书籍：0未处理1处理中,2未通过,3审核通过购买中,4购买成功,5购买失败 ,6已入库',
  `rec_time` date default NULL COMMENT '推荐时间',
  `rec_resaon` varchar(40) collate utf8_unicode_ci NOT NULL COMMENT '推荐理由',
  `rec_url` varchar(40) collate utf8_unicode_ci NOT NULL COMMENT '网购地址ulr',
  `rec_num` tinyint(4) default NULL COMMENT '推荐书籍数量：默认0',
  PRIMARY KEY  (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL auto_increment COMMENT '角色id',
  `role_name` varchar(20) collate utf8_unicode_ci NOT NULL COMMENT '角色名称',
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL auto_increment COMMENT '用户id 主键标识',
  `user_num` varchar(30) collate utf8_unicode_ci NOT NULL COMMENT '员工编号：sx1618',
  `user_password` varchar(40) collate utf8_unicode_ci NOT NULL default 'e10adc3949ba59abbe56e057f20f883e' COMMENT '登录密码：默认e10adc3949ba59abbe56e057f20f883e',
  `user_mail` varchar(40) collate utf8_unicode_ci default NULL,
  `user_realname` varchar(30) collate utf8_unicode_ci NOT NULL COMMENT '用户真实姓名',
  `user_department` varchar(20) collate utf8_unicode_ci NOT NULL COMMENT '用户部门',
  `user_borrownum` tinyint(4) NOT NULL default '3' COMMENT '用户最大借阅书籍数量，默认为最大值3',
  `user_ordernum` tinyint(4) NOT NULL default '3' COMMENT '用户最大预订书籍数量：默认为3',
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_assignroles` VALUES ('77', '103', '12');
INSERT INTO `t_assignroles` VALUES ('78', '104', '14');
INSERT INTO `t_assignroles` VALUES ('82', '104', '13');
INSERT INTO `t_assignroles` VALUES ('83', '104', '12');
INSERT INTO `t_assignroles` VALUES ('84', '105', '13');
INSERT INTO `t_assignroles` VALUES ('85', '106', '14');
INSERT INTO `t_assignroles` VALUES ('86', '107', '12');
INSERT INTO `t_assignroles` VALUES ('87', '108', '13');
INSERT INTO `t_assignroles` VALUES ('88', '109', '12');
INSERT INTO `t_assignroles` VALUES ('89', '110', '13');
INSERT INTO `t_assignroles` VALUES ('91', '112', '13');
INSERT INTO `t_assignroles` VALUES ('92', '106', '13');
INSERT INTO `t_assignroles` VALUES ('94', '111', '14');
INSERT INTO `t_assignroles` VALUES ('95', '102', '14');
INSERT INTO `t_book` VALUES ('sx20', '书0', null, 'a0', 'bbb', 'www.baidu.com', '0', '0', '1', null);
INSERT INTO `t_book` VALUES ('sx21', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx210', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx211', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx212', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx213', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx214', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx215', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx216', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx217', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx218', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx219', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx22', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx220', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx221', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx222', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx223', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx224', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx225', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx226', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx227', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx228', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx229', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx23', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx230', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx231', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx232', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx233', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx234', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx235', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx236', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx237', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx238', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx239', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx24', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx240', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx241', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx242', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx243', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx244', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx245', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx246', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx247', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx248', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx249', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx25', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx250', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx251', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx252', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx253', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx254', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx255', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx256', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx257', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx258', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx259', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx26', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx260', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx261', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx262', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx263', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx264', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx265', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx266', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx267', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx268', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx269', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx27', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx270', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx271', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx272', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx273', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx274', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx275', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx276', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx277', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx278', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx279', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx28', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx280', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx281', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx282', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx283', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx284', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx285', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx286', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx287', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx288', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx289', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx29', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx290', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx291', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx292', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx293', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx294', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx295', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx296', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx297', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx298', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_book` VALUES ('sx299', '书0', null, 'a0', 'bbb', 'www.baidu.com', '1', '0', '0', null);
INSERT INTO `t_booktype` VALUES ('1', '技术', '0', 'fd');
INSERT INTO `t_booktype` VALUES ('2', '策划', '0', 'fd');
INSERT INTO `t_booktype` VALUES ('3', 'java', '1', 'fd');
INSERT INTO `t_booktype` VALUES ('4', 'c++', '1', 'fd');
INSERT INTO `t_booktype` VALUES ('5', '需求', '2', 'fd');
INSERT INTO `t_booktype` VALUES ('6', '功能', '2', 'fd');
INSERT INTO `t_divisionpower` VALUES ('3', '14', '22');
INSERT INTO `t_divisionpower` VALUES ('5', '14', '33');
INSERT INTO `t_divisionpower` VALUES ('8', '13', '25');
INSERT INTO `t_divisionpower` VALUES ('9', '13', '26');
INSERT INTO `t_divisionpower` VALUES ('10', '13', '27');
INSERT INTO `t_divisionpower` VALUES ('13', '14', '31');
INSERT INTO `t_divisionpower` VALUES ('14', '14', '25');
INSERT INTO `t_divisionpower` VALUES ('15', '14', '26');
INSERT INTO `t_divisionpower` VALUES ('24', '12', '32');
INSERT INTO `t_divisionpower` VALUES ('29', '12', '23');
INSERT INTO `t_divisionpower` VALUES ('30', '12', '28');
INSERT INTO `t_divisionpower` VALUES ('31', '12', '29');
INSERT INTO `t_divisionpower` VALUES ('32', '12', '30');
INSERT INTO `t_divisionpower` VALUES ('33', '13', '22');
INSERT INTO `t_divisionpower` VALUES ('34', '13', '31');
INSERT INTO `t_divisionpower` VALUES ('35', '13', '32');
INSERT INTO `t_function` VALUES ('20', '系统功能', '0', '0', '', '1');
INSERT INTO `t_function` VALUES ('21', '普通用户功能', '0', '1', '', '1');
INSERT INTO `t_function` VALUES ('22', '个人中心', '21', '0', '', '2');
INSERT INTO `t_function` VALUES ('23', '书籍管理', '20', '0', '', '2');
INSERT INTO `t_function` VALUES ('24', '我的借阅历史', '21', '0', '', '2');
INSERT INTO `t_function` VALUES ('25', '图书列表', '21', '0', '', '2');
INSERT INTO `t_function` VALUES ('26', '新书推荐', '21', '0', '', '2');
INSERT INTO `t_function` VALUES ('27', '推荐购书', '21', '0', '', '2');
INSERT INTO `t_function` VALUES ('28', '用户管理', '20', '0', '', '2');
INSERT INTO `t_function` VALUES ('29', '邮件管理', '20', '0', '', '2');
INSERT INTO `t_function` VALUES ('30', '数据统计', '20', '0', '', '2');
INSERT INTO `t_function` VALUES ('31', '密码修改', '22', '0', '', '3');
INSERT INTO `t_function` VALUES ('32', '我的借书记录', '22', '0', '', '3');
INSERT INTO `t_function` VALUES ('33', '我的推荐书', '22', '0', 'http://www.baidu.com', '3');
INSERT INTO `t_orderbook` VALUES ('9', '48', 'sx20', '2013-01-07');
INSERT INTO `t_role` VALUES ('12', '用户');
INSERT INTO `t_role` VALUES ('13', '管理员');
INSERT INTO `t_role` VALUES ('14', '图书管理员');
INSERT INTO `t_user` VALUES ('102', 'sx1618', 'e10adc3949ba59abbe56e057f20f883e', 'lirefdsafdfdsafdsafdafdsa@cyou-inc.com', '李仁奎', '技术中部', '3', '3');
INSERT INTO `t_user` VALUES ('103', 'sx0000', 'e10adc3949ba59abbe56e057f20f883e', 'linglinglign@cyou-inc.com', '铃铃铃', '策划中部', '3', '3');
INSERT INTO `t_user` VALUES ('104', 'sx1619', 'e10adc3949ba59abbe56e057f20f883e', 'liuqi_nad@cyou-inc.com', '刘琦', '技术中部', '3', '3');
INSERT INTO `t_user` VALUES ('105', 'sx1567', 'e10adc3949ba59abbe56e057f20f883e', 'lire@cyou-inc.com', '地方萨芬', '测试中部', '3', '3');
INSERT INTO `t_user` VALUES ('106', 'sx1621', 'e10adc3949ba59abbe56e057f20f883e', 'lirenkui@cyou-inc.com', '李仁奎', '技术中部', '3', '3');
INSERT INTO `t_user` VALUES ('107', 'sx1617', 'e10adc3949ba59abbe56e057f20f883e', 'fdsafdsafdsafdsafdsafdsaf@cyou-inc.com', '李范德萨放到', '技术中部', '3', '3');
INSERT INTO `t_user` VALUES ('108', 'sx1615', 'e10adc3949ba59abbe56e057f20f883e', 'fdsfds@cyou-inc.com', '高祥', '技术中部', '3', '3');
INSERT INTO `t_user` VALUES ('109', 'sx4321', 'e10adc3949ba59abbe56e057f20f883e', 'lirenkui@cyou-inc.com', '高祥', '技术中部', '3', '3');
INSERT INTO `t_user` VALUES ('110', 'sx1690', 'e10adc3949ba59abbe56e057f20f883e', 'lirenkui@cyou-inc.com', '高祥', '技术中部', '3', '3');
INSERT INTO `t_user` VALUES ('111', 'sx1691', 'e10adc3949ba59abbe56e057f20f883e', 'lirenkui@cyou-inc.com', '高祥', '技术中部', '3', '3');
INSERT INTO `t_user` VALUES ('113', 'cy4561', 'e10adc3949ba59abbe56e057f20f883e', 'lire@cyou-inc.com', '放到范德萨方', '技术中部', '3', '3');
