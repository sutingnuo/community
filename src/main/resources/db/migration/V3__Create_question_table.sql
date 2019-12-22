 drop table question;
create  table question(
id int auto_increment primary key ,
title varchar(50),
description text,
gmt_create bigint,
gmt_modified bigint,
createor int,
comment_count int default 0,
view_count int default 0,
like_count int default 0,
tag varchar(256)
);