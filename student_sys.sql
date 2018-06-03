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
-- 8.创建班级表
CREATE TABLE classes (
  xid   INT(8) ZEROFILL NOT NULL PRIMARY KEY,
  xyear VARCHAR(50)     NOT NULL,
  xnum  INT             NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '课程表';

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
  xid     INT(8) ZEROFILL               NOT NULL
  COMMENT '班级id',
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
  COMMENT '最终去向',
  FOREIGN KEY (xid) REFERENCES classes (xid)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '学生基础信息表';

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

-- 4.创建课程表
CREATE TABLE course (
  cid   INT(8) ZEROFILL NOT NULL PRIMARY KEY,
  cname VARCHAR(200)    NOT NULL,
  cyear INT             NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '课程表';

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

-- 6.创建教师基础信息表(主键为工号)
-- 默认密码为SHA-256加密的now888
CREATE TABLE teacher (
  tid     INT(8) ZEROFILL NOT NULL PRIMARY KEY,
  tname   VARCHAR(50)     NOT NULL,
  xid     INT(8) ZEROFILL NOT NULL
  COMMENT '班级id',
  ttele   VARCHAR(50)     NOT NULL,
  tpasswd VARCHAR(200)    NOT NULL DEFAULT '163b7c5dcb682d12ebf7cac8b57f2c96dc49ebb2afe207956ea35403514fe07f',
  FOREIGN KEY (xid) REFERENCES classes (xid)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '班主任信息表';
-- 竟然忘记教师有名字..


-- 7.创建评价表
CREATE TABLE review (
  rid   INT                     NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  sid   INT(8) ZEROFILL         NOT NULL,
  rtype ENUM ('教师', '同学', '自己','家长') NOT NULL,
  rcont VARCHAR(200)            NOT NULL,
  rdate DATE                    NOT NULL,
  FOREIGN KEY (sid) REFERENCES student (sid)
)
  AUTO_INCREMENT = 1
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '评价表';

-- 8.创建课外发展记录表extra
CREATE TABLE extra (
  eid    INT                                       NOT NULL PRIMARY KEY AUTO_INCREMENT,
  sid    INT(8) ZEROFILL                           NOT NULL,
  etype  ENUM ('实践', '项目', '锻炼', '社团', '奖惩', '学习') NOT NULL,
  ename  VARCHAR(200)                              NOT NULL,
  estime DATE                                      NOT NULL,
  eetime DATE                                      NOT NULL,
  FOREIGN KEY (sid) REFERENCES student (sid)
)
  AUTO_INCREMENT = 1
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '课外发展记录 表';

-- 9.创建家长表
CREATE TABLE parent (
  pid     INT(8) ZEROFILL PRIMARY KEY  NOT NULL,
  sid     INT(8) ZEROFILL              NOT NULL,
  ppasswd VARCHAR(200)                 NOT NULL DEFAULT '163b7c5dcb682d12ebf7cac8b57f2c96dc49ebb2afe207956ea35403514fe07f',
  pname   VARCHAR(50)                  NOT NULL,
  FOREIGN KEY (sid) REFERENCES student (sid)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '课外发展记录 表';

-- 数据模拟(3个学生，3个家长,1个老师,22门课程)
INSERT INTO classes (xid, xyear, xnum) VALUES (1, '2014', 2);
-- 插入学生及家长信息,采用默认密码
INSERT INTO student (sid, sname, ssex, smajor, xid, sdorm, stele, spoo, speo, addr, telopm)
VALUES (8148888, '庄某人', '男', '计科', 1, '梅2A318', '17501520888', '江苏南京', '汉', '江苏无锡', '15061880888'),
  (8147777, '柴某人', '男', '网络', 1, '梅2A318', '17501520777', '湖北武汉', '汉', '江苏徐州', '15061880777'),
  (8146666, '胡某人', '女', '信科', 1, '梅2A318', '17501520666', '北京', '汉', '陕西西安', '15061880666');
INSERT INTO parent (pid, sid,pname) VALUES
  (8141111, 8146666,'胡大胆'), (8142222, 8147777,'柴大个'), (8143333,8148888,'庄大头');
-- 插入体侧信息
INSERT INTO fitness (sid, fyear, fheig, fweig, frun, fjump, fwalk, fup, fahead)
VALUES (8148888, 1, 175.0, 68.0, 7.2, 210, 3.30, 5, 7.7),
(8148888, 2, 175.0, 70.0, 7.3, 205, 4.00, 3, 8.7),
(8148888, 3, 175.0, 73.0, 7.2, 203, 4.20, 0, 9.7),
(8148888, 4, 175.0, 75.0, 8.0, 200, 4.30, 0, 10.7),
(8147777, 1, 180.0, 68.0, 6.8, 211, 3.30, 5, 7.7),
(8147777, 2, 180.0, 70.0, 7.0, 213, 3.45, 6, 8.7),
(8147777, 3, 180.0, 71.0, 7.2, 211, 3.50, 6, 7.7),
(8147777, 4, 180.0, 72.0, 7.5, 212, 3.44, 6, 8.7),
(8146666, 1, 181.0, 72.0, 7.1, 222, 3.44, 6, 8.7),
(8146666, 2, 181.0, 73.0, 7.2, 225, 3.41, 7, 5.7),
(8146666, 3, 181.0, 72.0, 7.3, 228, 3.46, 8, 3.7),
(8146666, 4, 181.0, 71.0, 7.5, 222, 3.41, 11, 10.7);
-- 插入课程
INSERT INTO course (cid, cname, cyear)
VALUES (2014111, '大学英语', 1),
  (2014112, '高等数学(上)', 1),
  (2014113, '大学物理(上)', 1),
  (2014114, 'C语言程序设计', 1),
  (2014115, '思想道德修养与法律基础', 1),
  (2014116, '线性代数', 1),
  (2015111, '算法', '2'),
  (2015112, '微机原理', '2'),
  (2015113, '离散数学', '2'),
  (2015114, '数据结构', '2'),
  (2015115, '高等数学(下)', '2'),
  (2015116, '大学物理(下)', '2'),
  (2016111, '计算机网络', '3'),
  (2016112, '数据库原理', '3'),
  (2016113, '编程语言设计', '3'),
  (2016114, '软件工程', '3'),
  (2016115, '计算机组成原理', '3'),
  (2016116, '编译原理', '3'),
  (2017111, 'Web程序设计', '4'),
  (2017112, 'Linux操作系统', '4'),
  (2017113, '安卓程序开发', '4'),
  (2017114, '信息安全技术', '4');
-- 插入成绩
INSERT INTO grade (cid, sid, gresult, gtime)
VALUES (2014111, 8148888, 89, '2014-05-01'), (2014112, 8148888, 88, '2014-05-01'), (2014113, 8148888, 87, '2014-05-01'),
  (2014114, 8148888, 86, '2014-05-01'), (2014115, 8148888, 66, '2014-05-01'), (2014116, 8148888, 60, '2014-05-01'),
  (2015111, 8148888, 79, '2015-05-01'), (2015112, 8148888, 78, '2015-05-01'), (2015113, 8148888, 77, '2015-05-01'),
  (2015114, 8148888, 77, '2015-05-01'), (2015115, 8148888, 88, '2015-05-01'), (2015116, 8148888, 99, '2015-05-01'),
  (2016111, 8148888, 85, '2016-05-01'), (2016112, 8148888, 88, '2016-05-01'), (2016113, 8148888, 84, '2016-05-01'),
  (2016114, 8148888, 86, '2016-05-01'), (2016115, 8148888, 68, '2016-05-01'), (2016116, 8148888, 63, '2016-05-01'),
  (2017111, 8148888, 97, '2017-05-01'), (2017112, 8148888, 94, '2017-05-01'), (2017113, 8148888, 92, '2017-05-01'),
  (2017114, 8148888, 91, '2017-05-01'),
  (2014111, 8147777, 89, '2014-05-01'), (2014112, 8147777, 88, '2014-05-01'), (2014113, 8147777, 87, '2014-05-01'),
  (2014114, 8147777, 86, '2014-05-01'), (2014115, 8147777, 99, '2014-05-01'), (2014116, 8147777, 90, '2014-05-01'),
  (2015111, 8147777, 89, '2015-05-01'), (2015112, 8147777, 88, '2015-05-01'), (2015113, 8147777, 87, '2015-05-01'),
  (2015114, 8147777, 87, '2015-05-01'), (2015115, 8147777, 99, '2016-05-01'), (2015116, 8147777, 94, '2016-05-01'),
  (2016111, 8147777, 85, '2016-05-01'), (2016112, 8147777, 88, '2016-05-01'), (2016113, 8147777, 84, '2016-05-01'),
  (2016114, 8147777, 86, '2016-05-01'), (2016115, 8147777, 88, '2016-05-01'), (2016116, 8147777, 93, '2016-05-01'),
  (2017111, 8147777, 97, '2017-05-01'), (2017112, 8147777, 94, '2017-05-01'), (2017113, 8147777, 92, '2017-05-01'),
  (2017114, 8147777, 91, '2017-05-01'),
  (2014111, 8146666, 69, '2014-05-01'), (2014112, 8146666, 68, '2014-05-01'), (2014113, 8146666, 67, '2014-05-01'),
  (2014114, 8146666, 66, '2014-05-01'), (2014115, 8146666, 80, '2014-05-01'), (2014116, 8146666, 66, '2014-05-01'),
  (2015111, 8146666, 79, '2015-05-01'), (2015112, 8146666, 78, '2015-05-01'), (2015113, 8146666, 77, '2015-05-01'),
  (2015114, 8146666, 77, '2015-05-01'), (2015115, 8146666, 68, '2016-05-01'), (2015116, 8146666, 64, '2016-05-01'),
  (2016111, 8146666, 65, '2016-05-01'), (2016112, 8146666, 68, '2016-05-01'), (2016113, 8146666, 64, '2016-05-01'),
  (2016114, 8146666, 66, '2016-05-01'), (2016115, 8146666, 68, '2016-05-01'), (2016116, 8146666, 73, '2016-05-01'),
  (2017111, 8146666, 77, '2017-05-01'), (2017112, 8146666, 74, '2017-05-01'), (2017113, 8146666, 72, '2017-05-01'),
  (2017114, 8146666, 71, '2017-05-01');
-- 插入教师信息
INSERT INTO teacher (tid, tname, xid, ttele)
VALUES (8149999, '王大锤', 1, '15605213888');
-- 插入评价
INSERT INTO review (sid, rtype, rcont, rdate)
VALUES (8148888, '教师', '该同学动手能力强', '2018-05-01'),
  (8148888, '教师', '该同学纪律性差', '2018-05-03'),
  (8148888, '同学', '庄同学乐于助人', '2018-05-01'),
  (8148888, '同学', '庄同学比较爱玩', '2018-05-03'),
  (8148888, '自己', '我还有很多不足', '2018-05-01'),
  (8147777, '教师', '该同学刻苦认真', '2018-05-01'),
  (8147777, '教师', '该同学尊师重道', '2018-05-01'),
  (8147777, '同学', '柴同学学习优秀', '2018-05-01'),
  (8147777, '同学', '柴同学很虚伪', '2018-05-01'),
  (8147777, '自己', '我只想安静学霸', '2018-05-01'),
  (8146666, '教师', '该同学调皮捣蛋', '2018-05-01'),
  (8146666, '教师', '该同学需要引导', '2018-05-01'),
  (8146666, '同学', '胡同学心地善良', '2018-05-01'),
  (8146666, '同学', '胡同学脾气不好', '2018-05-01'),
  (8146666, '自己', '我自制力比较差', '2018-05-01');
-- 插入课外发展
INSERT INTO extra (sid, etype, ename, estime, eetime)
VALUES (8148888, '实践', '大二暑假在超市做过兼职', '2015-7-1', '2015-8-30'),
  (8148888, '项目', '大三暑假跟同学参加比赛做项目拿了一等奖', '2016-7-1', '2016-8-30'),
  (8148888, '锻炼', '每天坚持晚上跑步一刻钟', '2014-9-1', '2018-6-30'),
  (8148888, '社团', '大一大二加入女生部', '2014-9-1', '2016-6-30'),
  (8147777, '项目', '大三暑假跟同学参加比赛做项目拿了一等奖', '2016-7-1', '2016-8-30'),
  (8147777, '奖惩', '大学四年每年国奖', '2014-9-1', '2018-6-30'),
  (8147777, '学习', '每周坚持去图书馆一下午', '2014-9-1', '2018-6-30'),
  (8147777, '社团', '大一大二加入科技部', '2014-9-1', '2016-6-30'),
  (8146666, '实践', '大二暑假帮中学生补习功课', '2015-7-1', '2015-8-30'),
  (8146666, '项目', '自己兴趣下作了小车玩', '2016-7-1', '2016-8-30'),
  (8146666, '锻炼', '每隔两天都要去健身房锻炼', '2014-9-1', '2018-6-30');