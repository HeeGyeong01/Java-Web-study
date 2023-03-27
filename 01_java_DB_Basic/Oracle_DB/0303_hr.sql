--문제 1--
select first_name, salary
from employees
where salary = (select min(salary) from employees);

--문제 2--
select department_name, sum(salary)
from employees 
join departments using(department_id)
group by department_name
having sum(salary) = (select max(sum(salary)) from employees
group by department_id);

--문제 3--(1달러=1302원)
select first_name, job_id, to_char(salary * 1302, '999,999,999')||'원' as 급여
from employees
where job_id in ('FI_ACCOUNT', 'SA_REP') and
salary >all (select salary from employees
where job_id = 'IT_PROG')
order by salary desc;


--문제 4--
select last_name, job_id, job_title, to_char(salary, '$999,999') as 급여
from employees join jobs using(job_id)

where (job_id, salary) in (select job_id, trunc(avg(salary), -3) from employees
group by job_id)

order by salary;

select department_name, job_title, round(avg(salary), 2) as "Avg_sal"
from employees
join departments using(department_id)
join jobs using(job_id)
group by cube(department_name, job_title); 

select job_title, round(avg(salary), 2) as "Avg_sal"
from employees
join departments using(department_id)
join jobs using(job_id)
group by grouping sets((job_title), ()); 

