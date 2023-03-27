 --DB_1일차.hwp--
--문제 1--
select employee_id as 사원번호 , 
    first_name ||' '|| last_name as "이  름", 
    (salary*12) ||'달러' as "연  봉" 
from employees;

--문제 2--
select last_name || ' is a ' || job_id as "Employee Detail"
from employees;

--문제 3--
select first_name||' '||last_name as 사원명, '$'||salary as 월급, department_id as 부서코드 
from employees
where (salary <= 2500  or salary > 3000) and department_id=90;

--문제 4--
select last_name as 이름, job_id as 업무ID, salary||'원' as "급  여"
from employees
where job_id in ('SA_REP', 'AD_PRES') and salary > 10000;

--문제 5--
select distinct job_id from employees;

--문제 6--
select employee_id as "사원번호",
    first_name ||' '|| last_name as "이  름",
    hire_date as "입사일"
from employees
where hire_date like '05%';
--where to_char(hire_date, 'yyyy') = '2005';
