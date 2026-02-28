SELECT 
    MONTH(start_date) AS month,
    car_id,
    COUNT(*) AS records
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE start_date >= '2022-08-01'
  AND start_date < '2022-11-01'
  AND car_id IN (
        SELECT car_id
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE start_date >= '2022-08-01'
          AND start_date < '2022-11-01'
        GROUP BY car_id
        HAVING COUNT(*) >= 5
  )
GROUP BY MONTH(start_date), car_id
ORDER BY month ASC, car_id DESC;