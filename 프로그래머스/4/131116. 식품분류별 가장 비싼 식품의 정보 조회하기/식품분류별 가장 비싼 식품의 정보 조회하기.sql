-- 코드를 입력하세요
WITH food_table as (
    select row_number() over(partition by CATEGORY order by PRICE desc) as rn, CATEGORY, PRICE, PRODUCT_NAME
    from food_product
    where CATEGORY in ('과자', '국', '김치', '식용유')
)

SELECT category, price as max_price, product_name
FROM food_table
where rn = 1
order by max_price desc;