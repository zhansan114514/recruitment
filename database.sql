create database if not exists recruitment;
create table c方向答题
(
    studentid   char(20)    not null comment '学号'
        primary key,
    username    char(20)    not null comment '用户名',
    question1   varchar(50) null comment '问题1',
    score1      int         null comment '第一道题的成绩',
    question2   varchar(50) null comment '问题2',
    score2      int         null comment '第二道题的成绩',
    question3   varchar(50) null comment '问题3',
    score3      int         null comment '第三道题的成绩',
    question4   varchar(50) null comment '问题4',
    score4      int         null comment '第四道题的成绩',
    question5   varchar(50) null comment '问题5',
    score5      int         null comment '第五道题的成绩',
    question6   varchar(50) null comment '问题6',
    score6      int         null comment '第六道题的成绩',
    question7   varchar(50) null comment '问题7',
    score7      int         null comment '第七道题的成绩',
    question8   varchar(50) null comment '问题8',
    score8      int         null comment '第八道题的成绩',
    tests       int         null comment '过题数',
    total_score int         null comment '总成绩',
    constraint c方向答题_pk_2
        unique (studentid)
)
    comment 'c方向的答题和成绩';

create table Java方向答题
(
    studentid   char(20)    not null comment '学号'
        primary key,
    username    char(20)    not null comment '用户名',
    question1   varchar(50) null comment '问题1',
    score1      int         null comment '第一道题的成绩',
    question2   varchar(50) null comment '问题2',
    score2      int         null comment '第二道题的成绩',
    question3   varchar(50) null comment '问题3',
    score3      int         null comment '第三道题的成绩',
    question4   varchar(50) null comment '问题4',
    score4      int         null comment '第四道题的成绩',
    question5   varchar(50) null comment '问题5',
    score5      int         null comment '第五道题的成绩',
    question6   varchar(50) null comment '问题6',
    score6      int         null comment '第六道题的成绩',
    question7   varchar(50) null comment '问题7',
    score7      int         null comment '第七道题的成绩',
    question8   varchar(50) null comment '问题8',
    score8      int         null comment '第八道题的成绩',
    question9   varchar(50) null comment '问题9',
    score9      int         null comment '第九道题的成绩',
    question10  varchar(50) null comment '问题10',
    score10     int         null comment '第十道题的成绩',
    question11  varchar(50) null comment '问题11',
    score11     int         null comment '第十一道题的成绩',
    tests       int         null comment '过题数',
    total_score int         null comment '总成绩',
    constraint Java方向答题_pk_2
        unique (studentid)
)
    comment 'Java方向的答题和成绩';

create table 机器学习方向答题
(
    studentid   char(20)    not null comment '学号'
        primary key,
    username    char(20)    not null comment '用户名',
    question1   varchar(50) null comment '问题1',
    score1      int         null comment '第一道题的成绩',
    question2   varchar(50) null comment '问题2',
    score2      int         null comment '第二道题的成绩',
    question3   varchar(50) null comment '问题3',
    score3      int         null comment '第三道题的成绩',
    question4   varchar(50) null comment '问题4',
    score4      int         null comment '第四道题的成绩',
    question5   varchar(50) null comment '问题5',
    score5      int         null comment '第五道题的成绩',
    question6   varchar(50) null comment '问题6',
    score6      int         null comment '第六道题的成绩',
    question7   varchar(50) null comment '问题7',
    score7      int         null comment '第七道题的成绩',
    question8   varchar(50) null comment '问题8',
    score8      int         null comment '第八道题的成绩',
    question9   varchar(50) null comment '问题9',
    score9      int         null comment '第九道题的成绩',
    question10  varchar(50) null comment '问题10',
    score10     int         null comment '第十道题的成绩',
    tests       int         null comment '过题数',
    total_score int         null comment '总成绩',
    constraint 机器学习方向答题_pk_2
        unique (studentid)
)
    comment '机器学习方向的答题和成绩';

create table 前端方向答题
(
    studentid   char(20)    not null comment '学号'
        primary key,
    username    char(20)    not null comment '用户名',
    question1   varchar(50) null comment '问题1',
    score1      int         null comment '第一道题的成绩',
    question2   varchar(50) null comment '问题2',
    score2      int         null comment '第二道题的成绩',
    question3   varchar(50) null comment '问题3',
    score3      int         null comment '第三道题的成绩',
    question4   varchar(50) null comment '问题4',
    score4      int         null comment '第四道题的成绩',
    question5   varchar(50) null comment '问题5',
    score5      int         null comment '第五道题的成绩',
    question6   varchar(50) null comment '问题6',
    score6      int         null comment '第六道题的成绩',
    question7   varchar(50) null comment '问题7',
    score7      int         null comment '第七道题的成绩',
    question8   varchar(50) null comment '问题8',
    score8      int         null comment '第八道题的成绩',
    question9   varchar(50) null comment '问题9',
    score9      int         null comment '第九道题的成绩',
    question10  varchar(50) null comment '问题10',
    score10     int         null comment '第十道题的成绩',
    tests       int         null comment '过题数',
    total_score int         null comment '总成绩',
    constraint 前端方向答题_pk_2
        unique (studentid)
)
    comment '前端方向的答题和成绩';

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
        unique (username),
    constraint user_pk_2
        unique (studentid)
)
    comment '保存学生基本信息';

