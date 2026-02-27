-- 코드를 작성해주세요
select e.dept_id, d.dept_name_en, round(avg(e.sal),0) as avg_sal
from HR_DEPARTMENT d
join HR_EMPLOYEES e 
    on d.DEPT_ID = e.DEPT_ID
group by e.dept_id
order by avg_sal desc;