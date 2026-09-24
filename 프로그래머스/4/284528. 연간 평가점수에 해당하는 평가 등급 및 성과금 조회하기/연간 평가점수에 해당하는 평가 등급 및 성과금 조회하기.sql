-- 코드를 작성해주세요
select e.EMP_NO, e.EMP_NAME, 
case 
    when AVG(g.SCORE) >= 96 then 'S'
    when AVG(g.SCORE) < 96 and  AVG(g.SCORE) >= 90 then 'A'
    when  AVG(g.SCORE) < 90 and  AVG(g.SCORE) >= 80 then 'B'
    else 'C'
    end as GRADE, 
case 
    when  AVG(g.SCORE) >= 96 then SAL * 20 / 100
    when  AVG(g.SCORE) < 96 and AVG(g.SCORE) >= 90 then SAL * 15 / 100
    when  AVG(g.SCORE) < 90 and AVG(g.SCORE) >= 80 then SAL * 10 / 100
    else 0
    end as BONUS
from HR_DEPARTMENT d join HR_EMPLOYEES e on d.DEPT_ID = e.DEPT_ID 
    join HR_GRADE g on e.EMP_NO = g.EMP_NO
group by e.EMP_NO, e.EMP_NAME
order by e.EMP_NO;