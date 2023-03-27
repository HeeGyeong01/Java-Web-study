create table locations2 as select * from locations;
select * from locations;
select * from locations2;
alter table locations2 rename column location_id to loc_id;
select * from locations2; 


--문제 3--
select last_name as 사원이름, city as "도  시", department_name as 부서이름
from EMPLOYEES
join DEPARTMENTS d using(department_id)
join LOCATIONS2 l on(d.location_id = l.loc_id)
where l.city in ('Seattle', 'Oxford')
order by city;



--문제 4--
select employee_id as 사원번호, last_name as 사원이름, department_name as 부서이름
    ,city as 도시, street_address as 도시주소, country_name as 나라이름
from EMPLOYEES
left join DEPARTMENTS using(department_id)
join LOCATIONS2 on(location_id = loc_id)
join COUNTRIES using(country_id)
where street_address Like '%Ch%' or street_address Like '%Sh%' or street_address Like '%Rd%'
order by country_name, city;


