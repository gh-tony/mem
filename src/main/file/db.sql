##mysqkl创建用户
CREATE USER 'mem'@'localhost' IDENTIFIED BY 'mem321';
GRANT ALL ON mem.* TO 'mem'@'%';
GRANT ALL ON mem.* TO 'mem'@'localhost';

SET PASSWORD FOR 'mem'@'localhost' = PASSWORD('mem321');

##########创建数据库
create database mem default character set='utf8';

#########建表
create table mem.t_tk_task(
  task_id varchar(32) primary key,
  task_name varchar(100) comment '任务名称',
  statu char(1) comment '任务状态(在审：0；通过：1；未通过：2)',
  description varchar(1000) comment '任务描述',
  create_time TIMESTAMP comment '创建时间',
  create_id varchar(32) comment '创建人',
  modify_time TIMESTAMP comment '最后一次修改时间',
  modify_id varchar(32) comment '修改人',
  is_del char(1) comment '逻辑标识',
  audit_no varchar(100) comment '审核人',
  audit_time TIMESTAMP comment '审核时间',
  audit_opinion varchar(100) comment '审核意见'
) comment='任务信息表';
create table mem.t_mb_member(
  id varchar(32) primary key,
  name varchar(100) comment '姓名',
  pwd varchar(500) comment '密码',
  telephone varchar(20) comment '电话',
  profession varchar(100) comment '职业',
  weiXinNum varchar(500) comment '微信号',
  inviter_name varchar(100) comment '邀请人姓名',
  create_time TIMESTAMP comment '创建时间',
  modify_time TIMESTAMP comment '最后一次修改时间',
  create_id varchar(32) comment '创建人',
  modify_id varchar(32) comment '修改人',
  is_del char(1) comment '逻辑标识',
  bak1 varchar(100) comment '备份字段'
) comment='成员信息表';

create table mem.t_tk_image(
  img_id varchar(32) primary key,
  task_id varchar(32) comment '任务id',
  img_name varchar(100) comment '图片名称',
  img_url varchar(500) comment '图片URL',
  img_flag char(1) comment '标识',
  create_time TIMESTAMP comment '创建时间',
  modify_time TIMESTAMP comment '最后一次修改时间'
) comment='图片信息表';

create table mem.t_tk_accumulate(
  accumulate_id varchar(32) primary key,
  task_id varchar(32) comment '任务id',
  accumulate_no integer comment '积分值',
  create_time TIMESTAMP comment '创建时间',
  modify_time TIMESTAMP comment '最后一次修改时间',
  create_id varchar(32) comment '创建人',
  modify_id varchar(32) comment '修改人'
) comment='积分信息表';


######insert sql
insert into  mem.t_tk_task(task_id,task_name,statu,description,create_time,create_id,is_del) values('tst22222','test','1','this is just test',now(),'admin','0');