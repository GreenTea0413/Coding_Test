-- 코드를 작성해주세요

select SUM(g.SCORE) as SCORE, e.EMP_NO, e.EMP_NAME, e.POSITION, e.EMAIL
from HR_EMPLOYEES e 
left join HR_GRADE g on e.EMP_NO = g.EMP_NO
group by e.EMP_NO, e.EMP_NAME, e.POSITION, e.EMAIL
order by SCORE DESC
limit 1;