-- 코드를 입력하세요
-- 주문 ID, 제품 ID, 출고일자, 출고여부
SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d') as OUT_DATE, 
CASE
    WHEN OUT_DATE <= '2022-05-01' THEN '출고완료'
    WHEN OUT_DATE IS NULL THEN '출고미정'
    ELSE '출고대기'
END AS '출고여부'
from FOOD_ORDER
order by order_id;