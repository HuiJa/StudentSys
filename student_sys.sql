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
-- 默认密码为SHA-256加密的now888
CREATE TABLE student (
  sid     INT(8) ZEROFILL               NOT NULL PRIMARY KEY
  COMMENT '学号',
  sname   VARCHAR(200)                  NOT NULL
  COMMENT '学生名字',
  ssex    ENUM ('男', '女')               NOT NULL
  COMMENT '学生性别',
  spasswd VARCHAR(200)                  NOT NULL DEFAULT '163b7c5dcb682d12ebf7cac8b57f2c96dc49ebb2afe207956ea35403514fe07f'
  COMMENT '密码',
  smajor  ENUM ('计科', '信科', '信安', '网络') NOT NULL
  COMMENT '专业',
  syear   INT                           NOT NULL
  COMMENT '入学年纪',
  sclass  VARCHAR(50)                   NOT NULL
  COMMENT '班级',
  sdorm   VARCHAR(100)                  NOT NULL
  COMMENT '宿舍号',
  stele   VARCHAR(50)                   NOT NULL
  COMMENT '电话',
  spoo    VARCHAR(200)                  NOT NULL
  COMMENT '籍贯',
  speo    ENUM ('汉', '其他')              NOT NULL
  COMMENT '民族',
  addr    VARCHAR(200)                  NOT NULL
  COMMENT '家庭住址',
  telopm  VARCHAR(50)                   NOT NULL
  COMMENT '父母电话',
  sresult VARCHAR(50)                   NOT NULL DEFAULT '在读'
  COMMENT '最终去向'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '学生基础信息表';
-- 插入一条学生信息,采用默认密码
INSERT INTO student (sid, sname, ssex, smajor, syear, sclass, sdorm, stele, spoo, speo, addr, telopm)
VALUES (8148888, '王大锤', '男', '计科', 2014, '2班', '梅2A318', '17501520888', '江苏南京', '汉', '江苏无锡', '15061880888');

-- 3.创建身体健康表
CREATE TABLE fitness (
  sid    INT(8) ZEROFILL NOT NULL
  COMMENT '学号',
  fyear  INT             NOT NULL
  COMMENT '测试学年',
  fheig  DOUBLE(4, 1)    NOT NULL
  COMMENT '身高',
  fweig  DOUBLE(4, 1)    NOT NULL
  COMMENT '体重',
  frun   DOUBLE(4, 1)    NOT NULL
  COMMENT '50米',
  fjump  INT             NOT NULL
  COMMENT '跳远',
  fwalk  DOUBLE(4, 2)    NOT NULL
  COMMENT '1000米',
  fup    INT             NOT NULL
  COMMENT '引体向上',
  fahead DOUBLE(4, 1)    NOT NULL
  COMMENT '坐位体前屈',
  PRIMARY KEY (sid, fyear),
  FOREIGN KEY (sid) REFERENCES student (sid)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '学生体侧健康表';
-- 插入一条体侧信息
INSERT INTO fitness (sid, fyear, fheig, fweig, frun, fjump, fwalk, fup, fahead)
VALUES (8148888, 1, 175.0, 75.0, 7.2, 210, 3.30, 5, 7.7);

-- 4.创建课程表
CREATE TABLE course (
  cid   INT(8) ZEROFILL NOT NULL PRIMARY KEY,
  cname VARCHAR(200)    NOT NULL,
  cyear INT             NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '课程表';

-- 插入课程
INSERT INTO course (cid, cname, cyear)
VALUES (2014111, '计算机组成原理', 1), (2014112, '算法', 2),
  (2014113, '微机原理', 3), (2014114, '数据结构', 4);

-- 5.创建课程成绩表
CREATE TABLE grade (
  cid     INT(8) ZEROFILL NOT NULL,
  sid     INT(8) ZEROFILL NOT NULL,
  gresult INT             NOT NULL,
  gtime   DATE            NOT NULL,
  greply  BOOLEAN         NOT NULL DEFAULT '0',
  PRIMARY KEY (cid, sid),
  FOREIGN KEY (cid) REFERENCES course (cid),
  FOREIGN KEY (sid) REFERENCES student (sid)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '成绩表';
-- 插入王大锤的成绩
INSERT INTO grade (cid, sid, gresult, gtime)
VALUES (2014111, 8148888, 89, '2018-05-01'), (2014112, 8148888, 88, '2018-05-01'),
  (2014113, 8148888, 87, '2018-05-01'), (2014114, 8148888, 86, '2018-05-01');

-- 6.创建教师基础信息表(主键为工号)
-- 默认密码为SHA-256加密的now888
CREATE TABLE teacher (
  tid     INT(8) ZEROFILL NOT NULL PRIMARY KEY,
  tname   VARCHAR(50)     NOT NULL,
  syear   INT             NOT NULL,
  sclass  VARCHAR(50)     NOT NULL,
  tpasswd VARCHAR(200)    NOT NULL DEFAULT '163b7c5dcb682d12ebf7cac8b57f2c96dc49ebb2afe207956ea35403514fe07f',
  UNIQUE KEY (syear, sclass)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '班主任信息表';
-- 竟然忘记教师有名字..

-- 插入一条教师信息
INSERT INTO teacher (tid, tname, syear, sclass)
VALUES (8148888, "王小锤", 2014, '2班');

-- 7.创建评价表
CREATE TABLE review (
  rid   INT                     NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  sid   INT(8) ZEROFILL         NOT NULL,
  rtype ENUM ('教师', '同学', '自己') NOT NULL,
  rcont VARCHAR(200)            NOT NULL,
  rdate DATE                    NOT NULL,
  FOREIGN KEY (sid) REFERENCES student (sid)
)
  AUTO_INCREMENT = 1
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '评价表';

-- 插入几条评价
INSERT INTO review (sid, rtype, rcont, rdate)
VALUES (8148888, '教师', '该同学刻苦认真', '2018-05-01'),
  (8148888, '同学', '王同学乐于助人', '2018-05-01'),
  (8148888, '自己', '我还有很多不足', '2018-05-01');

-- 8.创建课外发展记录表extra
CREATE TABLE extra (
  eid    INT                           NOT NULL PRIMARY KEY AUTO_INCREMENT,
  sid    INT(8) ZEROFILL               NOT NULL,
  etype  ENUM ('实践', '项目', '锻炼', '社团') NOT NULL,
  ename  VARCHAR(200)                  NOT NULL,
  estime DATE                          NOT NULL,
  eetime DATE                          NOT NULL,
  FOREIGN KEY (sid) REFERENCES student (sid)
)
  AUTO_INCREMENT = 1
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '课外发展记录 表';

-- 插入几条课外发展
INSERT INTO extra (sid, etype, ename, estime, eetime)
VALUES (8148888, '实践', '大二暑假在超市做过兼职', '2015-7-1', '2015-8-30'),
  (8148888, '项目', '大三暑假跟同学参加比赛做项目拿了一等奖', '2016-7-1', '2016-8-30'),
  (8148888, '锻炼', '每天坚持晚上跑步一刻钟', '2014-9-1', '2018-6-30'),
  (8148888, '社团', '大一大二加入女生部', '2014-9-1', '2016-6-30');