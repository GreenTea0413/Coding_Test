-- 코드를 입력하세요
with recursive hours as (
    select 0 as hour
    
    union all
    
    select hour + 1
    from hours
    where hour < 23
)
SELECT h.hour, count(o.ANIMAL_ID) as COUNT
from hours h left join ANIMAL_OUTS o on h.HOUR = hour(o.datetime)
group by HOUR
order by HOUR;