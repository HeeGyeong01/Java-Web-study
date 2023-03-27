--문제 1 --
select job_id, sum(salary) as 급여합계
from employees
group by job_id;

--문제 2--
select department_id, city
from DEPARTMENTS
join LOCATIONS using(location_id); 