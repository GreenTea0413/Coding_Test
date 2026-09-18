-- 코드를 입력하세요
-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문
SELECT o.ANIMAL_ID, o.NAME
from ANIMAL_OUTS o join ANIMAL_INS i on o.ANIMAL_ID = i.ANIMAL_ID
where o.DATETIME < i.DATETIME
order by i.DATETIME;

