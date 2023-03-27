--DB_6일차.hwp--
create table user1(
idx     number  primary key,
id      varchar2(10) unique,
name    varchar2(10) not null,
phone   varchar2(15),
address varchar2(50),
score   number(6,2)  check(score >= 0 and score <= 100),
subject_code  number(5),
hire_date  date default sysdate,
marriage   char(1)  default 'N'  check(marriage in('Y', 'N')));

select constraint_name, constraint_type
from user_constraints
where table_name='USER1';

select *
from user_constraints
where table_name='USER1';

select * from user_sequences;




create table user2(
idx     number        constraint PKIDX primary key,
id      varchar2(10)  constraint UNID unique,
name    varchar2(10)  constraint NOTNAME not null,
phone   varchar2(15),
address varchar2(50),
score   number(6,2)   constraint CKSCORE check(score >= 0 and score <= 100),
subject_code  number(5),
hire_date  date default sysdate,
marriage   char(1)  default 'N' constraint CKMARR check(marriage in('Y','N')));

select constraint_name, constraint_type
from user_constraints
where table_name='USER2';

desc user1; 

--ex)11 ~ 19--
alter table test rename to user3;

alter table user3 add phone varchar2(15);
desc user3;

alter table user3 add constraint UID2 unique(id);
select constraint_name, constraint_type
from user_constraints
where table_name='USER3';

alter table user3 drop constraint UID2;

alter table user3 add no number primary key;
desc user3;

alter table user3 modify name varchar2(10);
desc user3;

alter table user3 drop column no;

drop table user3;
select * from tab;
purge recyclebin;

show recyclebin;
select * from recyclebin;

create sequence idx_sql increment by 2 start with 1 maxvalue 9 cycle nocache;
select idx_sql.nextval from dual;

--ex)20 ~ 25--
create  table  book(
no  number primary key,
subject  varchar2(50),
price number,
year date);

create sequence no_seq increment by 1 start with 1 nocycle nocache;

insert into book(no, subject, price, year)
values(no_seq.nextval, '오라클 무작정 따라하기', 10000, sysdate);

insert into book(no, subject, price, year)
values(no_seq.nextval, '자바 3일 완성', 15000, '2007-03-01');

insert into book values(no_seq.nextval, 'JSP 달인 되기', 18000, '2010-01-01');

select * from book;

create table user3 as select * from user2 where 1=0;
desc user3;

select constraint_name, constraint_type, search_condition
from user_constraints
where table_name='USER2'; 
