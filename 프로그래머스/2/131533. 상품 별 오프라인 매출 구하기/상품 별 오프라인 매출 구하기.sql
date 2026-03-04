-- 코드를 입력하세요
SELECT PRODUCT_CODE, sum(sales_amount * price) as SALES
from OFFLINE_SALE o
left join PRODUCT p on p.product_id = o.product_id
group by PRODUCT_CODE
order by SALES desc, PRODUCT_CODE;