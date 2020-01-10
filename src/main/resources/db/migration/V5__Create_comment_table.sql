drop table comment;
create table comment(
id bigint auto_increment primary key ,
parent_id bigint not null ,
com_type int not null ,
commentator int  not null ,
gmt_create bigint,
gmt_modified bigint,
like_count bigint default 0
)