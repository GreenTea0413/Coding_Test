-- 코드를 입력하세요
SELECT CAR_ID
from CAR_RENTAL_COMPANY_CAR c
where car_id in
    (select car_id
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
        where h.start_date >= '2022-10-01' and h.start_date < '2022-11-01'
    )
    and c.car_type = '세단'
order by CAR_ID DESC;