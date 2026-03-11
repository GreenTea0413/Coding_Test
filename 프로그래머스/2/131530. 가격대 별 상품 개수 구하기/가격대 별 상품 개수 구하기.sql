-- 코드를 입력하세요
-- 가격대 별
-- 10000 단위로 나눠야함
SELECT  Floor(price / 10000) * 10000 as PRICE_GROUP, count(PRODUCT_CODE) as PRODUCTS
from PRODUCT
group by price_group
order by price_group;