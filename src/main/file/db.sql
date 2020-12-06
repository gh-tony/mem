create table t_tk_task(
  task_id varchar,
  task_name varchar,
  statu varchar,
  description varchar,
  create_time time,
  create_id varchar,
  modify_time time,
  modify_id varchar,
  is_del char(1),
  audit_no varchar,
  audit_time time,
  audit_opinion varchar
);
create table t_mb_member(
  id varchar,
  name varchar,
  telephone varchar,
  profession varchar,
  weiXinNum varchar,
  inviter_name varchar,
  create_time time,
  modify_time time,
  create_id varchar,
  modify_id varchar,
  bak1 varchar
);

create table t_tk_image(
  img_id varchar,
  task_id varchar,
  img_name varchar,
  img_url varchar,
  img_flag varchar,
  create_time time,
  modify_time time
);

create table t_tk_accumulate(
  accumulate_id varchar,
  task_id varchar,
  accumulate_no integer,
  create_time time,
  modify_time time,
  create_id varchar,
  modify_id varchar
)