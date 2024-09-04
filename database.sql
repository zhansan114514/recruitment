DROP database if exists recruitment;
create database if not exists recruitment;
drop user if exists 'newuser'@'%';
CREATE USER 'newuser'@'%' IDENTIFIED BY 'newpassword';
GRANT ALL PRIVILEGES ON recruitment.* TO 'newuser'@'%';
use recruitment;
create table c方向答题
(
    studentid   char(20)    not null comment '学号'
        primary key,
    username    char(20)    not null comment '用户名',
    question1   varchar(255) null DEFAULT -1 comment '问题1',
    score1      int         null DEFAULT -1 comment '第一道题的成绩',
    question2   varchar(255) null DEFAULT -1 comment '问题2',
    score2      int         null DEFAULT -1 comment '第二道题的成绩',
    question3   varchar(255) null DEFAULT -1 comment '问题3',
    score3      int         null DEFAULT -1 comment '第三道题的成绩',
    question4   varchar(255) null DEFAULT -1 comment '问题4',
    score4      int         null DEFAULT -1 comment '第四道题的成绩',
    question5   varchar(255) null DEFAULT -1 comment '问题5',
    score5      int         null DEFAULT -1 comment '第五道题的成绩',
    question6   varchar(255) null DEFAULT -1 comment '问题6',
    score6      int         null DEFAULT -1 comment '第六道题的成绩',
    question7   varchar(255) null DEFAULT -1 comment '问题7',
    score7      int         null DEFAULT -1 comment '第七道题的成绩',
    question8   varchar(255) null DEFAULT -1 comment '问题8',
    score8      int         null DEFAULT -1 comment '第八道题的成绩',
    question9   varchar(255) null DEFAULT -1 comment '问题9',
    score9      int         null DEFAULT -1 comment '第九道题的成绩',
    question10  varchar(255) null DEFAULT -1 comment '问题10',
    score10     int         null DEFAULT -1 comment '第十道题的成绩',
    question11  varchar(255) null DEFAULT -1 comment '问题11',
    score11     int         null DEFAULT -1 comment '第十一道题的成绩',
    question12  varchar(255) null DEFAULT -1 comment '问题12',
    score12     int         null DEFAULT -1 comment '第十二道题的成绩',
    tests       int         null DEFAULT -1 comment '过题数',
    total_score int         null DEFAULT 0 comment '总成绩',
    constraint c方向答题_pk_2
        unique (studentid)
)
    comment 'c方向的答题和成绩';

create table Java方向答题
(
    studentid   char(20)    not null comment '学号'
        primary key,
    username    char(20)    not null comment '用户名',
    question1   varchar(255) null DEFAULT -1 comment '问题1',
    score1      int         null DEFAULT -1 comment '第一道题的成绩',
    question2   varchar(255) null DEFAULT -1 comment '问题2',
    score2      int         null DEFAULT -1 comment '第二道题的成绩',
    question3   varchar(255) null DEFAULT -1 comment '问题3',
    score3      int         null DEFAULT -1 comment '第三道题的成绩',
    question4   varchar(255) null DEFAULT -1 comment '问题4',
    score4      int         null DEFAULT -1 comment '第四道题的成绩',
    question5   varchar(255) null DEFAULT -1 comment '问题5',
    score5      int         null DEFAULT -1 comment '第五道题的成绩',
    question6   varchar(255) null DEFAULT -1 comment '问题6',
    score6      int         null DEFAULT -1 comment '第六道题的成绩',
    question7   varchar(255) null DEFAULT -1 comment '问题7',
    score7      int         null DEFAULT -1 comment '第七道题的成绩',
    question8   varchar(255) null DEFAULT -1 comment '问题8',
    score8      int         null DEFAULT -1 comment '第八道题的成绩',
    question9   varchar(255) null DEFAULT -1 comment '问题9',
    score9      int         null DEFAULT -1 comment '第九道题的成绩',
    question10  varchar(255) null DEFAULT -1 comment '问题10',
    score10     int         null DEFAULT -1 comment '第十道题的成绩',
    question11  varchar(255) null DEFAULT -1 comment '问题11',
    score11     int         null DEFAULT -1 comment '第十一道题的成绩',
    question12  varchar(255) null DEFAULT -1 comment '问题12',
    score12     int         null DEFAULT -1 comment '第十二道题的成绩',
    tests       int         null DEFAULT -1 comment '过题数',
    total_score int         null DEFAULT 0 comment '总成绩',
    constraint Java方向答题_pk_2
        unique (studentid)
)
    comment 'Java方向的答题和成绩';

create table 机器学习方向答题
(
    studentid   char(20)    not null comment '学号'
        primary key,
    username    char(20)    not null comment '用户名',
    question1   varchar(255) null DEFAULT -1 comment '问题1',
    score1      int         null DEFAULT -1 comment '第一道题的成绩',
    question2   varchar(255) null DEFAULT -1 comment '问题2',
    score2      int         null DEFAULT -1 comment '第二道题的成绩',
    question3   varchar(255) null DEFAULT -1 comment '问题3',
    score3      int         null DEFAULT -1 comment '第三道题的成绩',
    question4   varchar(255) null DEFAULT -1 comment '问题4',
    score4      int         null DEFAULT -1 comment '第四道题的成绩',
    question5   varchar(255) null DEFAULT -1 comment '问题5',
    score5      int         null DEFAULT -1 comment '第五道题的成绩',
    question6   varchar(255) null DEFAULT -1 comment '问题6',
    score6      int         null DEFAULT -1 comment '第六道题的成绩',
    question7   varchar(255) null DEFAULT -1 comment '问题7',
    score7      int         null DEFAULT -1 comment '第七道题的成绩',
    question8   varchar(255) null DEFAULT -1 comment '问题8',
    score8      int         null DEFAULT -1 comment '第八道题的成绩',
    question9   varchar(255) null DEFAULT -1 comment '问题9',
    score9      int         null DEFAULT -1 comment '第九道题的成绩',
    question10  varchar(255) null DEFAULT -1 comment '问题10',
    score10     int         null DEFAULT -1 comment '第十道题的成绩',
    question11  varchar(255) null DEFAULT -1 comment '问题11',
    score11     int         null DEFAULT -1 comment '第十一道题的成绩',
    question12  varchar(255) null DEFAULT -1 comment '问题12',
    score12     int         null DEFAULT -1 comment '第十二道题的成绩',
    tests       int         null DEFAULT -1 comment '过题数',
    total_score int         null DEFAULT 0 comment '总成绩',
    constraint 机器学习方向答题_pk_2
        unique (studentid)
)
    comment '机器学习方向的答题和成绩';

create table 前端方向答题
(
    studentid   char(20)    not null comment '学号'
        primary key,
    username    char(20)    not null comment '用户名',
    question1   varchar(255) null DEFAULT -1 comment '问题1',
    score1      int         null DEFAULT -1 comment '第一道题的成绩',
    question2   varchar(255) null DEFAULT -1 comment '问题2',
    score2      int         null DEFAULT -1 comment '第二道题的成绩',
    question3   varchar(255) null DEFAULT -1 comment '问题3',
    score3      int         null DEFAULT -1 comment '第三道题的成绩',
    question4   varchar(255) null DEFAULT -1 comment '问题4',
    score4      int         null DEFAULT -1 comment '第四道题的成绩',
    question5   varchar(255) null DEFAULT -1 comment '问题5',
    score5      int         null DEFAULT -1 comment '第五道题的成绩',
    question6   varchar(255) null DEFAULT -1 comment '问题6',
    score6      int         null DEFAULT -1 comment '第六道题的成绩',
    question7   varchar(255) null DEFAULT -1 comment '问题7',
    score7      int         null DEFAULT -1 comment '第七道题的成绩',
    question8   varchar(255) null DEFAULT -1 comment '问题8',
    score8      int         null DEFAULT -1 comment '第八道题的成绩',
    question9   varchar(255) null DEFAULT -1 comment '问题9',
    score9      int         null DEFAULT -1 comment '第九道题的成绩',
    question10  varchar(255) null DEFAULT -1 comment '问题10',
    score10     int         null DEFAULT -1 comment '第十道题的成绩',
    question11  varchar(255) null DEFAULT -1 comment '问题11',
    score11     int         null DEFAULT -1 comment '第十一道题的成绩',
    question12  varchar(255) null DEFAULT -1 comment '问题12',
    score12     int         null DEFAULT -1 comment '第十二道题的成绩',
    tests       int         null DEFAULT -1 comment '过题数',
    total_score int         null DEFAULT 0 comment '总成绩',
    constraint 前端方向答题_pk_2
        unique (studentid)
)
    comment '前端方向的答题和成绩';

create table user
(
    studentid char(30) not null comment '学生id'
        primary key,
    name      char(10) not null comment '姓名',
    email     char(25) not null comment '邮箱',
    password  char(25) not null comment '密码',
    username  char(20) not null comment '用户名',
    constraint user_pk
        unique (username),
    constraint user_pk_2
        unique (studentid)
)
    comment '保存学生基本信息';

create table registercode
(
    registercode char(10) not null comment '验证码'
)
    comment '验证码';