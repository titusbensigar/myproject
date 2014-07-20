# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user (
  email                     varchar(255),
  username                  varchar(255),
  password                  varchar(255),
  is_admin                  tinyint(1) default 0,
  is_tcaccepted             tinyint(1) default 0)
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

