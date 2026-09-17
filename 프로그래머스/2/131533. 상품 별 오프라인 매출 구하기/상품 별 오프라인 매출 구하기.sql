-- 코드를 입력하세요
-- 의류 쇼핑몰에서 판매중인 상품들의 상품 정보를 담은 PRODUCT
-- 오프라인 상품 판매 정보를 담은 OFFLINE_SALE

SELECT p.PRODUCT_CODE, sum(p.PRICE * o.SALES_AMOUNT) as SALES
from PRODUCT p join OFFLINE_SALE o on p.PRODUCT_ID = o.PRODUCT_ID
group by p.PRODUCT_CODE
order by SALES desc, p.PRODUCT_CODE;