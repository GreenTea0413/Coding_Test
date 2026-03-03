-- 코드를 입력하세요
SELECT hour(datetime) as hour, count(*) as count
from ANIMAL_OUTS
where hour(datetime) >= 09 and hour(datetime) <20
group by hour(datetime)
order by hour(datetime);