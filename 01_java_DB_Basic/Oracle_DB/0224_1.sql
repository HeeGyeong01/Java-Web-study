--DB_2일차_0224.hwp--
--문제 1--
select last_name as "이 름", salary * 12 as "연 봉"
from employees
order by 2 desc;

--문제 2--
select employee_id, concat(first_name, ' '||last_name) as name, length(concat(first_name, ' '||last_name)) as length
from employees
where substr(last_name, -1) ='n';

--문제 3--
select last_day(sysdate) - sysdate from dual; 

--문제 4--
--select last_name, to_char(hire_date, 'fmDD-MM"월" -RRRR') as hire_date
select last_name, to_char(hire_date, 'fmDD-MON -RRRR') as hire_date
from employees
where hire_date < '2005-01-01';

--문제 5--
select count(*) 
from employees
where commission_pct is null;

select count(commission_pct) from employees;

--문제 6--
select employee_id as 사원번호, last_name as 사원명,
    case 
        when salary < 10000 then '초급'
        when salary < 20000 then '중급'
        else '고급'
    end 구분
from employees
order by 3, 2 desc;


--문제 7--
select employee_id as 사원번호, last_name as 이름, salary as 급여, 
    nvl(commission_pct, 0) as 커미션, 
    to_char((nvl(salary, 0)*12) + (nvl(salary, 0)*12*nvl(commission_pct, 0)), '$9,999,999') as 연봉
from employees;


--문제 8--
select employee_id, last_name, nvl(manager_id, 1000) as manager_id
from employees;



select  employee_id,
        last_name,
        salary,
        department_id,
  row_number( ) over ( PARTITION BY department_id ORDER BY salary DESC ) rnum 
from employees ; 












