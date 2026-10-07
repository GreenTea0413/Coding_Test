-- 코드를 입력하세요
-- 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능
-- 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차
SELECT c.car_id, c.car_type, 
floor(c.DAILY_FEE * 30 * (100 - ifnull(d.DISCOUNT_RATE, 0)) / 100) as FEE
from CAR_RENTAL_COMPANY_CAR c left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN d 
on c.car_type = d.car_type and d.DURATION_TYPE = '30일 이상'
where d.car_type in ('세단', 'SUV') and
c.car_id not in (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where start_date <= '2022-11-30' and end_date >= '2022-11-01'
)
having fee >= 500000 and fee <= 2000000
order by FEE desc, car_type, car_id desc;
