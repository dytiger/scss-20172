-- 数据库脚本
DROP DATABASE IF EXISTS  scss;
CREATE DATABASE scss DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

use scss;

CREATE TABLE course
(
  id bigint(19) PRIMARY KEY COMMENT '唯一标识',
  name VARCHAR(80) NOT NULL COMMENT '课程名称',
  teacher VARCHAR(30) NOT NULL COMMENT '任课老师',
  intro VARCHAR(200) NOT NULL COMMENT '课程简介',
  service_teacher VARCHAR(30) NOT NULL COMMENT '班主任',
  service_teacher_tel VARCHAR(20) NOT NULL COMMENT '班主任电话',
  begin_teach_time DATETIME NOT NULL COMMENT '开始上课时间',
  end_teach_time DATETIME NOT NULL COMMENT '结束上课时间',
  begin_select_time DATETIME NOT NULL COMMENT '开始选课时间',
  end_select_time DATETIME NOT NULL COMMENT '结束选课时间',
  classroom VARCHAR(20) NOT NULL COMMENT '教室',
  max_amount int(4) DEFAULT 30 NOT NULL COMMENT '上课人数上限',
  current_amount int(4) DEFAULT 0 NOT NULL COMMENT '当前已选人数',
  credit int(2) DEFAULT 3 NOT NULL COMMENT '学分',
  status CHAR(2) DEFAULT 'AC' NOT NULL COMMENT '状态：AC可选；CM完成；PS备选'
);