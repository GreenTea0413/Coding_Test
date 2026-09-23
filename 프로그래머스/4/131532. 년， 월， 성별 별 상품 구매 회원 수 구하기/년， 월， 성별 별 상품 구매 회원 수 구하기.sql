-- 코드를 입력하세요
--  년, 월, 성별 별
SELECT year(o.SALES_DATE) as YEAR, month(o.SALES_DATE) as MONTH, u.GENDER, 
COUNT(DISTINCT u.USER_ID) AS USERS
from USER_INFO u join ONLINE_SALE o on u.USER_ID = o.USER_ID
where u.GENDER is not null
group by YEAR, MONTH, u.GENDER
order by YEAR, MONTH, u.GENDER;