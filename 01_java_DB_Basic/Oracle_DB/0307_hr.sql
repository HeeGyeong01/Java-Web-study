--문제 1--
create or replace view v_view2
as select employee_id, last_name, salary, department_id from employees
where salary between 5000 and 10000;

select * from v_view2;

--문제 2--
create or replace view v_view3
as select employee_id, last_name, department_name from employees
join departments using(department_id)
where department_id in (10, 90)
order by employee_id;

select * from v_view3;

--문제 3--
create or replace view v_view4(사원번호,사원명,급여,입사일,부서명,부서위치)
as select employee_id, last_name, to_char(trunc(salary, -3), '$999,999')||'원', 
to_char(hire_date, 'YYYY"년 "MM"월 "DD"일"'), department_id,  city
from employees
join departments using(department_id)
join locations using(location_id)
order by employee_id;

select * from v_view4;


--문제 4--
create table bookshop(
isbn      varchar2(10) constraint pisbn primary key,
title       varchar2(50) constraint ctit not null,
author    varchar2(50),  -- 저자 
price      number,      -- 금액
company  varchar2(30));  -- 출판사

insert into bookshop
values('is001', '자바3일완성', '김자바',  25000,   '야메루출판사');
insert into bookshop
values('pa002',  'JSP달인되기',           '이달인',  28000,   '공갈닷컴');
insert into bookshop
values('or003',  '오라클무작정따라하기',   '박따라',  23500,   '야메루출판사');

create table bookorder(
idx   number primary key,   -- 일련번호         
isbn  varchar2(10),  -- 외래키 (제약조건명 : FKISBN), bookshop의 isbn의 자식키
qty   number,       -- 수량
constraint FKISBN foreign key(isbn) references bookshop(isbn));

create sequence idx_seq 
increment by 1 start with 1 nocache nocycle;

insert into bookorder values
(idx_seq.nextval, 'is001', 2);
insert into bookorder values
(idx_seq.nextval, 'or003', 3);
insert into bookorder values
(idx_seq.nextval, 'pa002', 5);
insert into bookorder values
(idx_seq.nextval, 'is001', 3);
insert into bookorder values
(idx_seq.nextval, 'or003', 10);


create or replace view bs_view("책제목", "저자", "총판매금액")
as select title, author, to_char(price*qty, '999,999') from bookshop
join bookorder using(isbn)
group by title
with read only;




























