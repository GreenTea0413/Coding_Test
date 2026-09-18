-- 코드를 입력하세요
SELECT o.animal_id, o.name
from ANIMAL_INS i right join ANIMAL_OUTS o on i.ANIMAL_ID = o.ANIMAL_ID
where i.DATETIME is null
order by animal_id