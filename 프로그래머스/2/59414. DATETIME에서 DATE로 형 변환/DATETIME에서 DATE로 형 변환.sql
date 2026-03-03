-- 코드를 입력하세요
SELECT ANIMAL_ID, name, DATE_format(datetime,'%Y-%m-%d')as 날짜
from Animal_ins
order by ANIMAL_ID;