drop table question;
create  table question(
id int auto_increment primary key ,
title varchar(50),
description text,
gmt_create bigint,
gmt_modified bigint,
creator Integer,
comment_count Integer default 0,
view_count Integer default 0,
like_count Integer default 0,
tag varchar(256)
);
