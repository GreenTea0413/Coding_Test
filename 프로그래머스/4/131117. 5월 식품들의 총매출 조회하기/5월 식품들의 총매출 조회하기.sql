-- 코드를 입력하세요
-- 생산일자가 2022년 5월
SELECT o.PRODUCT_ID, p.PRODUCT_NAME, sum(p.price * o.amount) as TOTAL_SALES
from FOOD_ORDER o join FOOD_PRODUCT p on o.PRODUCT_ID = p.PRODUCT_ID
where date_format(o.PRODUCE_DATE, "%Y-%m") = '2022-05'
group by o.product_id
order by TOTAL_SALES desc, p.PRODUCT_ID;