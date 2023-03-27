--문제1) 모든 교수의 명단과 담당 과목을 검색하시오
--테이블명 : PROFESSOR, COURSE
--필드명 : PNO, PNAME, SECTION, CNO, CNAME
select PNO, PNAME, SECTION, CNO, CNAME
from PROFESSOR
left join COURSE using(pno);



--문제2) 이번 학기 등록된 모든 과목과 담당 교수의 학점 순으로 검색하시오
--테이블명 : PROFESSOR, COURSE
--필드명 : CNO, CNAME, ST_NUM, PNO, PNAME
select CNO, CNAME, ST_NUM, PNO, PNAME
from COURSE
left join PROFESSOR using(pno)
order by st_num;





--문제3) 화학과 학생이 수강하는 과목을 담당하는 교수의 명단을 검색하시오
--테이블명 : STUDENT, SCORE, COURSE, PROFESSOR
--필드명 : SNO, SNAME, MAJOR, SYEAR, CNO, CNAME, PNO, PNAME
select SNO, SNAME, MAJOR, SYEAR, CNO, CNAME, PNO, PNAME 교수명
from student 
join score using(sno)
join course using(cno)
join professor using(pno)
where major = '화학';


--문제4) 학생중에 동명이인을 검색한다 (SELF JOIN)
--테이블명 : STUDENT
--필드명 : SNO, SNAME
select s.SNO, s.SNAME, t.SNO, t.SNAME
from student s, student t 
where s.sname = t.sname and s.sno != t.sno;


--[테이블 작성]
create table guestbook(
seq   number primary key, -- 시퀀스 객체로부터 값을 얻어온다
name  varchar2(30),
email  varchar2(30),
homepage  varchar2(35),
subject  varchar2(500) not null,
content  varchar2(4000) not null,
logtime  date);

--[시퀀스]
create sequence seq_guestbook nocycle nocache;
