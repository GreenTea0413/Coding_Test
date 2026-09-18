-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.NAME
from ANIMAL_INS i left join ANIMAL_OUTS o on i.ANIMAL_ID = o.ANIMAL_ID
where o.ANIMAL_ID is not null
order by o.DATETIME - i.DATETIME DESC
limit 2;