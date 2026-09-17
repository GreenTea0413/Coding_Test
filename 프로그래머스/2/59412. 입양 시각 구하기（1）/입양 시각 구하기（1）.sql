-- 코드를 입력하세요
SELECT Hour(DATETIME) as HOUR, count(*) as COUNT
from ANIMAL_OUTS
where Hour(DATETIME) >= 9 and Hour(DATETIME) < 20
group by Hour(DATETIME)
order by Hour(DATETIME);