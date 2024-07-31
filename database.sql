create database if not exists recruitment;
create table c方向答题
(
    studentid   char(20)    not null comment '学号'
        primary key,
    question1   varchar(50) null comment '问题1',
    score1      int         null comment '第一道题的成绩',
    total_score int         null comment '总成绩',
    constraint c方向答题_pk_2
        unique (studentid)
)
    comment 'c方向的答题和成绩';

create table user
(
    studentid char(30) not null comment '学生id'
        primary key,
    name      char(10) not null comment '姓名',
    phone     char(20) not null comment '电话号码',
    email     char(25) not null comment '邮箱',
    password  char(25) not null comment '密码',
    username  char(20) not null comment '用户名',
    constraint user_pk
        unique (password),
    constraint user_pk_2
        unique (studentid)
)
    comment '保存学生基本信息';

