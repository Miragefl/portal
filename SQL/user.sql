CREATE TABLE USER(
  USERID    INT           AUTO_INCREMENT ,
  USERNAME  VARCHAR(32)   NOT NULL ,
  PASSWORD  VARCHAR(32)   NOT NULL,
  PRIMARY KEY (USERID)
);

INSERT INTO USER (USERNAME,PASSWORD) VALUES ('admin','123456');

alter  table USER add userPhone varchar(20);
alter  table USER add sex varchar(8);
alter  table USER add age varchar(20);
alter  table USER add userStatus varchar(10) default '0';
