
--centent center内容中心

DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `id` varchar(32) NOT NULL COMMENT 'UUID',
  `content` varchar(512) NOT NULL COMMENT '内容',
  `display` BOOLEAN DEFAULT true COMMENT '是否展示 不能使用show为mysql关键字' ,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公告表';

INSERT INTO announcement (id, content, display) VALUES ('5c1144f927b00d372037af8a', '联迪商用是一家集研发、生产、销售和服务于一体的高新技术企业，经过十余年的发展，已成为具有世界领先水平的电子支付完整解决方案供应商。', true);

DROP TABLE IF EXISTS `content`; 
CREATE TABLE `content` (   
	`id` varchar(32) NOT NULL COMMENT 'UUID',   
	`user_id` varchar(32) NOT NULL COMMENT '用户ID',
	`title` varchar(512) NOT NULL COMMENT '标题',   
	`type` varchar(512) NOT NULL COMMENT '方式',   
	`original` BOOLEAN COMMENT '是否原创',   
	`author` varchar(512) NOT NULL COMMENT '作者',   
	`cover` varchar(512) NOT NULL COMMENT '页面URL',   
	`summary` varchar(512) NOT NULL COMMENT '简介',   
	`price` int(11) DEFAULT '0' COMMENT '价格',   
	`buy_count` int(11) DEFAULT '0' COMMENT '购买数量',   
	`audit_status` varchar(512) NOT NULL COMMENT '审计状态',
	`display` BOOLEAN DEFAULT true COMMENT '是否展示' ,   
	`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',   
	`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间', 
	PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='内容信息表';

INSERT INTO content (id, user_id, title, type, original, author, cover, summary, price, buy_count, audit_status, display) VALUES ('1', '5c1144f927b00d372037af8a', 'APOS A9', 'share', true, 'landi', 'imgs/a9.jpeg', 'APOS A9是一款全新设计的智能台式终端，集全支付、多应用、易管理于一体。产品搭载高通四核处理器，性能强劲；', 10000, 10, 'PASS', true);
INSERT INTO content (id, user_id, title, type, original, author, cover, summary, price, buy_count, audit_status, display) VALUES ('2', '5c1144f927b00d372037af8a', 'QM600', 'share', true, 'landi', 'imgs/QM600.jpeg', '扫码非接终端QM600采用键盘与主机分离的设计，能够支持高低柜台、食堂、餐厅等等有隔离窗口的收银场景。', 10000, 10, 'PASS', true);


--bonus center积分中心
DROP TABLE IF EXISTS `user_bonus`;
CREATE TABLE `user_bonus` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `bonus` int(11) DEFAULT '0' COMMENT '总积分数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户积分信息';

INSERT INTO user_bonus (user_id, bonus) VALUES ('5c1144f927b00d372037af8a', 100);

DROP TABLE IF EXISTS `bonus_log`;
CREATE TABLE `bonus_log` (
  `id` varchar(32) NOT NULL COMMENT 'UUID',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `event` varchar(32) COMMENT '事件动作 BUY兑换  SIGN签到  CONTRIBUTE投稿  FORWARD转发',
  `bonus` int(11) DEFAULT '0' COMMENT '积分数',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户积分流水';

INSERT INTO bonus_log (id, user_id, event, bonus) VALUES ('1', '5c1144f927b00d372037af8a', 'SIGN', 1);
INSERT INTO bonus_log (id, user_id, event, bonus) VALUES ('2', '5c1144f927b00d372037af8a', 'SIGN', 1);
INSERT INTO bonus_log (id, user_id, event, bonus) VALUES ('3', '5c1144f927b00d372037af8a', 'BUY', -5);


--user center用户中心
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `open_id` varchar(64) NOT NULL COMMENT '微信用户的唯一标识',
  `union_id` varchar(64) NOT NULL COMMENT '用户在开放平台的唯一标识符',
  `session_key` varchar(64) NOT NULL COMMENT '会话密钥',
  `nick_name` varchar(512) NOT NULL COMMENT '昵称',
  `mobile` varchar(11) NOT NULL COMMENT '电话',
  `email` varchar(32) NOT NULL COMMENT '邮箱',
  `address` varchar(512) NOT NULL COMMENT '地址',
  `avatar_url` varchar(256) NOT NULL COMMENT '头像地址',
  `code` varchar(32) NOT NULL COMMENT '代码描述',
  `gender` varchar(10) NOT NULL COMMENT '性别 1男 0女',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

INSERT INTO user (user_id,open_id,union_id, session_key,nick_name, mobile, email, address,
avatar_url, code, gender, create_time, update_time) VALUES ('5c1144f927b00d372037af8a','5c1144f927b0
0d372037af8a','5c1144f927b00d372037af8a','5c1144f927b00d372037af8a', 'zzwy', '13012345678',
'zzwy@163.com', '软件大道A区', 'www.baidu.com', '1', '1', '2019-03-30 05:58:30', '2019-03-30 05:58:30');

