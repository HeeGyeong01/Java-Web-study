--java 접속의 테이블 사용--

--1. 화학과를 제외하고 학과별로 학생들의 평점 평균을 검색하세요--
select major as 학과, round(avg(avr), 2) as "평점 평균"
from student
group by major
having major != '화학';


--2. 화학과를 제외한 각 학과별 평균 평점 중에 평점이 2.0 이상인 정보를 검색하세요--
select major as 학과, round(avg(avr), 2) as "평점 평균"
from student
where major != '화학'
group by major
having round(avg(avr), 2) >= 2.0;


--문제1) 송강 교수가 강의하는 과목을 검색한다
select pname, cname
from PROFESSOR F JOIN COURSE C 
USING(pno)
where pname like '송강';

--문제2) 화학 관련 과목을 강의하는 교수의 명단을 검색
select pname, cname
from PROFESSOR F JOIN COURSE C 
USING(pno)
where cname like '%화학%';

--문제3) 화학과 1학년 학생의 기말고사 성적을 검색
select sname, cname, result
from STUDENT JOIN SCORE USING(sno)
JOIN COURSE USING(cno)
where STUDENT.major = '화학' AND syear = 1
order by sname;

--문제4) 화학과 1학년 학생이 수강하는 과목을 검색
select sname, syear, cname 
from STUDENT JOIN SCORE USING(sno)
JOIN COURSE USING(cno)
where STUDENT.major = '화학' AND syear = 1
order by sname;

--문제5) 화학과 1학년 학생의 일반 화학 기말고사 점수를 검색
select sname, cname, result
from STUDENT JOIN SCORE USING(sno)
JOIN COURSE USING(cno)
where STUDENT.major = '화학' AND syear = 1 AND cname = '일반화학'
order by sname;










