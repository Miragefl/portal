
--  表名称:栏目信息表
--  适用数据库：MySql
--  表名称：consultation_info
--  字段前缀 ：
--  最后修改人：
--  最后修改日期：

DROP TABLE IF EXISTS consultation_info;

CREATE TABLE consultation_info (
  consulId			int(11) 		  NOT NULL AUTO_INCREMENT 	comment 'id',
  columnId			int(11)			  NOT NULL					        comment '关联栏目',
  title				  varchar(200)	NOT NULL 					      comment '标题',
  consuDesc         varchar(200) NOT NULL                 comment  '描述',
  consuType   char(2)       NOT NULL                 comment '类型 00:手动编辑 01：外链',
  consuPlace  char(2)      NOT NULL                  comment '位置',
  consuClass  char(2)      NOT NULL                  comment '类别',
  images  varchar(2000)      NOT NULL                  comment '图片地址',
  context 			blob	 		   NOT NULL					         comment '文章内容',
  consuLink   varchar(200)    DEFAULT NULL           comment '链接地址',
  isDel        char(1)     NOT NULL DEFAULT '0'      comment '是否删除 0：否 1：是',
  remarks			  varchar(200)    DEFAULT NULL				   comment '备注',
  createTime      DATETIME          DEFAULT CURRENT_TIMESTAMP     COMMENT '创建时间',
  modifyTime      DATETIME          DEFAULT CURRENT_TIMESTAMP     COMMENT '修改时间',
  PRIMARY KEY (consulId)
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 comment '栏目信息表';