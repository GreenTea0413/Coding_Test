-- 코드를 입력하세요
-- 총주문량 내림차순 정렬
-- 총주문량이 같다면 출하번호를 기준 오름차순
SELECT FLAVOR from FIRST_HALF
order by total_order desc, shipment_id asc;