-- MySQL DATABASE
-- version 5.7.17
-- Host:localhost port:3306
-- database:student_sys
-- username:root
-- password:123456
-- InnoDB引擎支持事务处理

-- 1.创建数据库student_sys
CREATE DATABASE student_sys;
USE student_sys;
-- 2.创建学生基础信息表(主键为学号)
CREATE TABLE student (
  sid   INT(8) ZEROFILL NOT NULL PRIMARY KEY
  COMMENT '学号',
  sname VARCHAR(200)    NOT NULL
  COMMENT '学生名字',
  ssex  ENUM ('男', '女') NOT NULL
  COMMENT '学生性别',
  spasswd VARCHAR(50)     NOT NULL DEFAULT 'now888'
  COMMENT '密码',
  smajor ENUM('计科','信科','信安','网络')     NOT NULL
  COMMENT '专业',
  syear INT NOT NULL
  COMMENT '入学年纪',
  sclass VARCHAR(50) NOT NULL
  COMMENT '班级',
  sdorm VARCHAR(100) NOT NULL
  COMMENT '宿舍号',
  stele VARCHAR(50) NOT NULL
  COMMENT '电话',
  spoo VARCHAR(200) NOT NULL
  COMMENT '籍贯',
  speo ENUM('汉','其他') NOT NULL
  COMMENT '民族',
  addr VARCHAR(200) NOT NULL
  COMMENT '家庭住址',
  telopm VARCHAR(50) NOT NULL
  COMMENT '父母电话',
  sresult VARCHAR(50) NOT NULL DEFAULT '在读'
  COMMENT '最终去向'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '学生基础信息表';
-- 插入一条信息,采用默认密码
INSERT INTO student (sid, sname, ssex, smajor, syear, sclass, sdorm, stele, spoo, speo, addr, telopm)
VALUES (8148888, '王大锤', '男', '计科', '2014', '2班','梅2A318','17501520888','江苏南京','汉','江苏无锡','15061880888');

-- 3.

