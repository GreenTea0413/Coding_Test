-- 코드를 입력하세요
SELECT YEAR(o.SALES_DATE) as YEAR, MONTH(o.SALES_DATE) as MONTH, 
count(DISTINCT o.user_id) as PURCHASED_USERS, 
ROUND((count(DISTINCT o.user_id) / 
        (SELECT count(*)
        FROM USER_INFO
        WHERE date_format(JOINED, '%Y') = 2021)) , 1
     )
      as PUCHASED_RATIO
FROM ONLINE_SALE o join USER_INFO u on o.USER_ID = u.USER_ID
WHERE date_format(u.JOINED, '%Y') = 2021
GROUP BY YEAR(o.SALES_DATE), MONTH(o.SALES_DATE)
ORDER BY YEAR, MONTH;


