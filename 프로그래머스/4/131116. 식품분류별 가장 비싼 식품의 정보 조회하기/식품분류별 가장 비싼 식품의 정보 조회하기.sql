-- 코드를 입력하세요
-- 가격이 제일 비싼 식품의 분류, 가격, 이름
SELECT CATEGORY, PRICE as MAX_PRICE, PRODUCT_NAME
from FOOD_PRODUCT
where (category, Price) in (
    select category, max(price)
    from food_product
    where CATEGORY in ('국', '과자', '김치', '식용유')
    group by category
)
order by MAX_PRICE desc;