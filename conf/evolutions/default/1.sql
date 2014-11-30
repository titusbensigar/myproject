# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table User (
  id                        bigint auto_increment not null,
  email                     varchar(255),
  username                  varchar(255),
  password                  varchar(255),
  firstname                 varchar(255),
  lastname                  varchar(255),
  is_active                 tinyint(1) default 0,
  is_admin                  tinyint(1) default 0,
  is_tcaccepted             tinyint(1) default 0,
  created_on                datetime,
  modified_on               datetime,
  constraint pk_User primary key (id))
;

create table VerifyCode (
  id                        bigint auto_increment not null,
  code                      varchar(255),
  type                      varchar(255),
  data1                     varchar(255),
  data2                     varchar(255),
  email_address             varchar(255),
  created_on                datetime,
  modified_on               datetime,
  timestamp                 TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  constraint pk_VerifyCode primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table User;

drop table VerifyCode;

SET FOREIGN_KEY_CHECKS=1;

