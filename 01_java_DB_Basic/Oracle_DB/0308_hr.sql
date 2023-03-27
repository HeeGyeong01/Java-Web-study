--문제 5--
select last_name as 이름, department_name as 부서명, salary as 최대급여
from employees
join departments using(department_id)
where (department_id, salary) in (select department_id, max(salary) 
from employees group by department_id);

--문제 6--
select last_name as 사원이름, department_name 부서명, to_char(연봉, 'L999,999') 연봉
from(select last_name, department_name, salary*12+(salary*12*nvl(commission_pct, 0)) as 연봉
from employees
join departments using(department_id)
order by 3)
where rownum <= 5;

