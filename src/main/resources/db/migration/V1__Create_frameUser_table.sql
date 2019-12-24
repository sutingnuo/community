

drop table frameUser;
create table frameUser(
      id Integer auto_increment primary key,
      account_id varchar(100),
      name varchar(50),
      token char(36),
      gmt_create bigint,
      gmt_modified bigint
      );