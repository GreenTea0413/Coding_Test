-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_OF_BIRTH
from MEMBER_PROFILE
where month(date_of_birth) = 3 and TLNO is not null and gender = 'W'
order by member_id;