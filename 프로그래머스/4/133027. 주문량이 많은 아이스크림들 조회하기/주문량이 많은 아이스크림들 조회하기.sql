-- 코드를 입력하세요
SELECT h.flavor 
from FIRST_HALF h join JULY j on h.flavor = j.flavor
group by h.flavor
order by h.TOTAL_ORDER + sum(j.TOTAL_ORDER) desc
limit 3;