-- 코드를 입력하세요
SELECT CART_ID
from CART_PRODUCTS
group by CART_ID
having 
    count(case when name = 'milk' then 1 end) > 0 
        and
    count(case when name = 'yogurt' then 1 end) > 0
order by CART_ID;