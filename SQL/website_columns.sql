
--  表名称:栏目表
--  适用数据库：MySql
--  表名称：website_columns
--  字段前缀 ：
--  最后修改人：
--  最后修改日期：

DROP TABLE IF EXISTS website_columns;

CREATE TABLE website_columns (
  columnId			int(11) 		NOT NULL AUTO_INCREMENT 	comment '栏目id',
  columnName 		varchar(20)	 	NOT NULL					comment '栏目名称',
  columnLevel 		char(2) 		NOT NULL DEFAULT '00'		comment '栏目等级 00:一级栏目 01:二级栏目',
  columnParent 		int(11) 		DEFAULT NULL				comment '父栏目编号',
  isJump			char(1) 		NOT NULL DEFAULT '0'		comment '是否配置跳转链接 0:否 1:是',
  columnLink		varchar(200) 	DEFAULT NULL				comment '栏目跳转链接',
  isShow			char(1) 		NOT NULL DEFAULT '0'		comment '是否展示 0:是 1:否',
  isDel				char(1)			NOT NULL DEFAULT '0'		comment '是否删除 0:否 1:是',
  remarks			varchar(200)    DEFAULT NULL				comment '备注',
  PRIMARY KEY (columnId),
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment '栏目表';