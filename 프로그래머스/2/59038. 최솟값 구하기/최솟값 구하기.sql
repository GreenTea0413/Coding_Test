-- 코드를 입력하세요
SELECT datetime as '시간'
from ANIMAL_INS
where datetime = (select min(datetime) from ANIMAL_INS);